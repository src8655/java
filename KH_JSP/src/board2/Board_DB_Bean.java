package board2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Board_DB_Bean {
	private static Board_DB_Bean instance = new Board_DB_Bean();
    public static Board_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    public void insert(Board_Data_Bean bdb) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//날짜 가져오기
			Calendar cal = Calendar.getInstance();
			String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

			pstmt = conn.prepareStatement("insert into MIN_TBOARD_DATA(SUBJECT, MEMO, NAME, PASSWORD, DATES, HIT, ID, COMMENTS)"
						+" values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, bdb.getSubject());
			pstmt.setString(2, bdb.getMemo());
			pstmt.setString(3, bdb.getName());
			pstmt.setString(4, bdb.getPasswords());
			pstmt.setString(5, date);
			pstmt.setInt(6, 0);
			pstmt.setString(7, bdb.getId());
			pstmt.setInt(8, 0);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    }
    public int getCount(String id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_DATA where id=?");
			pstmt.setString(1, id);
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
    
    //여러 줄 가져오기
    public List getArticles(int start, int end, String id) {
    	List list = new ArrayList();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			//pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where id=? order by NO desc");
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TBOARD_DATA where id=? order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			//
			while(rs.next()) {
				Board_Data_Bean bdb = new Board_Data_Bean();
				bdb.setSubject(rs.getString("SUBJECT"));
				bdb.setName(rs.getString("NAME"));
				bdb.setPasswords(rs.getString("PASSWORD"));
				//bdb.setMemo(rs.getString("MEMO"));
				bdb.setId(rs.getString("ID"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setNo(rs.getInt("NO"));
				bdb.setComments(rs.getInt("COMMENTS"));
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
    public Board_Data_Bean getArticle(int no) {
    	Board_Data_Bean bdb = new Board_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where no=? order by NO desc");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bdb.setSubject(rs.getString("SUBJECT"));
				bdb.setName(rs.getString("NAME"));
				bdb.setPasswords(rs.getString("PASSWORD"));
				bdb.setMemo(rs.getString("MEMO"));
				bdb.setId(rs.getString("ID"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setNo(rs.getInt("NO"));
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

		return bdb;
    }
    
    //조회수카운트 추가
    public void updateHit(int no) {
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		
		try {
			conn = getConnection();
			

	    	//조회수카운트 정보 가져오기
			pstmt = conn.prepareStatement("select HIT from MIN_TBOARD_DATA where NO=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			int hit = 0;
			if(rs.next()) 
				hit = rs.getInt(1);
			
			
			//조회수카운트 +1
			hit++;
			
			//수정
			pstmt = conn.prepareStatement("update MIN_TBOARD_DATA set HIT=? where NO=?");
			pstmt.setInt(1, hit);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			
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
    
    //댓글카운트 갱신
    public void updateComment(int no) {
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		
		try {
			conn = getConnection();
			

	    	//댓글카운트 정보 가져오기
			pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_COMMENT where data_no=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			int comments = 0;
			if(rs.next()) 
				comments = rs.getInt(1);
			
			
			
			//수정
			pstmt = conn.prepareStatement("update MIN_TBOARD_DATA set COMMENTS=? where NO=?");
			pstmt.setInt(1, comments);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			
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
    
    //삭제하기
    public boolean delete(int no, String passwords) {
    	Board_Data_Bean bdata = getArticle(no);	//게시글정보 가져오기
    	
    	//비밀번호가 다를때 종료
    	if(!bdata.getPasswords().equals(passwords))
    		return false;
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//날짜 가져오기
			Calendar cal = Calendar.getInstance();
			String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

			pstmt = conn.prepareStatement("delete from MIN_TBOARD_DATA where no=?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return false;
    }
    
    //수정하기
    public boolean update(Board_Data_Bean bd, int no) {
    	Board_Data_Bean bdata = getArticle(no);	//게시글정보 가져오기
    	
    	//비밀번호가 다를때 종료
    	if(!bdata.getPasswords().equals(bd.getPasswords()))
    		return false;
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//날짜 가져오기
			Calendar cal = Calendar.getInstance();
			String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

			pstmt = conn.prepareStatement("update MIN_TBOARD_DATA set SUBJECT=?,NAME=?,MEMO=? where NO=?");
			pstmt.setString(1, bd.getSubject());
			pstmt.setString(2, bd.getName());
			pstmt.setString(3, bd.getMemo());
			pstmt.setInt(4, no);
			pstmt.executeUpdate();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return false;
    }

}
