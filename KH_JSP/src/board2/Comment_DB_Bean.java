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
    	
    	try {
			conn = getConnection();
			
			//날짜 가져오기
			Calendar cal = Calendar.getInstance();
			String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

			pstmt = conn.prepareStatement("insert into MIN_TBOARD_COMMENT(NAME, PASSWORD, MEMO, DATA_NO, DATES)"
						+" values(?,?,?,?,?)");
			pstmt.setString(1, cdb.getName());
			pstmt.setString(2, cdb.getPasswords());
			pstmt.setString(3, cdb.getMemo());
			pstmt.setInt(4, cdb.getData_no());
			pstmt.setString(5, date);
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
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("delete from MIN_TBOARD_COMMENT where no=?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			
			
			results = true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	
    	return results;
    }

}
