package board2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Comment_DB_Bean {
	private static Comment_DB_Bean instance = new Comment_DB_Bean();
    public static Comment_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    public void insert(Comment_Data_Bean cdb) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			
			
			
			if(cdb.getRt_no() == 1) {
				//날짜 가져오기
				Calendar cal = Calendar.getInstance();
				String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

				pstmt = conn.prepareStatement("insert into MIN_TBOARD_COMMENT(NAME, PASSWORD, MEMO, DATA_NO, DATES, RT_NO, DELETES)"
							+" values(?,?,?,?,?,?,?)");
				pstmt.setString(1, cdb.getName());
				pstmt.setString(2, cdb.getPasswords());
				pstmt.setString(3, cdb.getMemo());
				pstmt.setInt(4, cdb.getData_no());
				pstmt.setString(5, date);
				pstmt.setInt(6, 1);
				pstmt.setInt(7, cdb.getDeletes());
				pstmt.executeUpdate();
				
			}else {

				pstmt = conn.prepareStatement("select * from MIN_TBOARD_COMMENT where rt_no=? order by no desc");
				pstmt.setInt(1, cdb.getRt_no());
				rs = pstmt.executeQuery();
				
				int rt_no_count = cdb.getRt_no();	//답글이 없으면 기준no
				
				if(rs.next()) 
					rt_no_count = rs.getInt("NO");	//가장 마지막에 있는 답글을 받아옴
				rt_no_count++;
				
				
				

				
				//날짜 가져오기
				Calendar cal = Calendar.getInstance();
				String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

				pstmt = conn.prepareStatement("insert into MIN_TBOARD_COMMENT(NAME, PASSWORD, MEMO, DATA_NO, DATES, RT_NO, NO, DELETES)"
							+" values(?,?,?,?,?,?,?,?)");
				pstmt.setString(1, cdb.getName());
				pstmt.setString(2, cdb.getPasswords());
				pstmt.setString(3, cdb.getMemo());
				pstmt.setInt(4, cdb.getData_no());
				pstmt.setString(5, date);
				pstmt.setInt(6, cdb.getRt_no());
				pstmt.setInt(7, rt_no_count);
				pstmt.setInt(8, cdb.getDeletes());
				pstmt.executeUpdate();
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    }
    public int getCount(String data_no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_COMMENT where DATA_NO=?");
			pstmt.setString(1, data_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return 0;
    }
    public List getArticles(int data_no) {
    	List list = new ArrayList();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TBOARD_COMMENT where DATA_NO=? order by NO asc");
			pstmt.setInt(1, data_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Comment_Data_Bean bdb = new Comment_Data_Bean();
				bdb.setName(rs.getString("NAME"));
				bdb.setPasswords(rs.getString("PASSWORD"));
				bdb.setMemo(rs.getString("MEMO"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setNo(rs.getInt("NO"));
				bdb.setData_no(rs.getInt("DATA_NO"));
				bdb.setRt_no(rs.getInt("RT_NO"));
				bdb.setDeletes(rs.getInt("DELETES"));
				list.add(bdb);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}

		return list;
    }

    
    //한 줄 가져오기
    public Comment_Data_Bean getArticle(int no) {
    	Comment_Data_Bean cdb = new Comment_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TBOARD_COMMENT where no=? order by NO desc");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cdb.setName(rs.getString("NAME"));
				cdb.setPasswords(rs.getString("PASSWORD"));
				cdb.setMemo(rs.getString("MEMO"));
				cdb.setDates(rs.getString("DATES"));
				cdb.setNo(rs.getInt("NO"));
				cdb.setDeletes(rs.getInt("DELETES"));
				cdb.setRt_no(rs.getInt("RT_NO"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}

		return cdb;
    }
    
    
    //삭제하기
    public boolean delete(int no, String passwords) {
    	Comment_Data_Bean bdata = getArticle(no);	//게시글정보 가져오기
    	
    	boolean results = false;
    	
    	//비밀번호가 다를때 종료
    	if(!bdata.getPasswords().equals(passwords))
    		return results;
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			
			
			//내가 답글이면 
			if(bdata.getRt_no() != 1) {
				//나랑 같은 답글이 몇개인지 확인
				int cnt_sub = 1;
				pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_COMMENT where rt_no=?");
				pstmt.setInt(1, bdata.getRt_no());
				rs = pstmt.executeQuery();
				if(rs.next()) cnt_sub = rs.getInt(1);
				
				//부모가 삭제된 상태인지 확인
				int deletes = 1;
				int parents = 0;
				pstmt = conn.prepareStatement("select * from MIN_TBOARD_COMMENT where no=?");
				pstmt.setInt(1, bdata.getRt_no());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					deletes = rs.getInt("DELETES");
				}
				
				//답글이 나밖에 없고 && 부모가 삭제된 상태면 부모도 삭제
				if(cnt_sub == 1 && deletes == 2) {
					
					//부모도 삭제
					pstmt = conn.prepareStatement("delete from MIN_TBOARD_COMMENT where no=?");
					pstmt.setInt(1, bdata.getRt_no());
					pstmt.executeUpdate();
				}
				//나를 삭제
				pstmt = conn.prepareStatement("delete from MIN_TBOARD_COMMENT where no=?");
				pstmt.setInt(1, bdata.getNo());
				pstmt.executeUpdate();
			}else {	//내가 답글이 아니면
				
				//답글이 있는지 확인
				pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_COMMENT where rt_no=?");
				pstmt.setInt(1, bdata.getNo());
				rs = pstmt.executeQuery();
				
				int rt_no_count = 0;
				
				if(rs.next()) 
					rt_no_count = rs.getInt(1);	//답글을 개수를 받아옴
				
				
				//답글이 없으면 그냥 삭제
				if(rt_no_count == 0) {
					pstmt = conn.prepareStatement("delete from MIN_TBOARD_COMMENT where no=?");
					pstmt.setInt(1, no);
					pstmt.executeUpdate();
				}else {	//답글이 있으면 업데이트
					pstmt = conn.prepareStatement("update MIN_TBOARD_COMMENT set "
							+ "NAME=?,"
							+ "PASSWORD=?,"
							+ "MEMO=?,"
							+ "DATES=?,"
							+ "DELETES=? where no=?");
					pstmt.setString(1, "-");
					pstmt.setString(2, "");
					pstmt.setString(3, "삭제된 댓글입니다.");
					pstmt.setString(4, "-");
					pstmt.setInt(5, 2);
					pstmt.setInt(6, no);
					pstmt.executeUpdate();
				}
				
			}
			Board_DB_Bean bd = Board_DB_Bean.getInstance();
			bd.updateComment(no);
			
			results = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	
    	return results;
    }

}
