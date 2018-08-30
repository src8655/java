package board2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Member_DB_Bean {
	private static Member_DB_Bean instance = new Member_DB_Bean();
    public static Member_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    //데이터 삽입
    public void insert(Member_Data_Bean mdb) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("insert into MIN_TMEMBER(USER_ID, PASSWORD, NAME, ADDR, ADDR_CODE, PHONE1, PHONE2, PHONE3, EMAIL, BIRTHY, BIRTHM, BIRTHD)"
						+" values(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, mdb.getUser_id());
			pstmt.setString(2, mdb.getPasswords());
			pstmt.setString(3, mdb.getName());
			pstmt.setString(4, mdb.getAddr());
			pstmt.setString(5, mdb.getAddr_code());
			pstmt.setString(6, mdb.getPhone1());
			pstmt.setString(7, mdb.getPhone2());
			pstmt.setString(8, mdb.getPhone3());
			pstmt.setString(9, mdb.getEmail());
			pstmt.setString(10, mdb.getBirthy());
			pstmt.setString(11, mdb.getBirthm());
			pstmt.setString(12, mdb.getBirthd());
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
    
    //같은 아이디의 개수 출력
    public int selectId(String user_id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	int count = 0;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select count(*) from MIN_TMEMBER where USER_ID=?");
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return count;
    }
    
    //로그인 가능여부
    public boolean login(String user_id, String passwords) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	int count = 0;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select count(*) from MIN_TMEMBER where USER_ID=? and PASSWORD=?");
			pstmt.setString(1, user_id);
			pstmt.setString(2, passwords);
			rs = pstmt.executeQuery();
			
			if(rs.next()) count = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	if(count == 0)
    		return false;
    	else
    		return true;
    }
    
    
    //회원정보 하나
    public Member_Data_Bean getArticle(int no) {
    	Member_Data_Bean mdata = new Member_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from MIN_TMEMBER where NO=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdata.setNo(rs.getInt("NO"));
				mdata.setUser_id(rs.getString("USER_ID"));
				mdata.setPasswords(rs.getString("PASSWORD"));
				mdata.setName(rs.getString("NAME"));
				mdata.setAddr(rs.getString("ADDR"));
				mdata.setAddr_code(rs.getString("ADDR_CODE"));
				mdata.setPhone1(rs.getString("PHONE1"));
				mdata.setPhone2(rs.getString("PHONE2"));
				mdata.setPhone3(rs.getString("PHONE3"));
				mdata.setEmail(rs.getString("EMAIL"));
				mdata.setBirthy(rs.getString("BIRTHY"));
				mdata.setBirthm(rs.getString("BIRTHM"));
				mdata.setBirthd(rs.getString("BIRTHD"));
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
    	
    	return mdata;
    }
    
    
    //로그인 정보 가져오기
    public Member_Data_Bean login_info(String user_id, String passwords) {
    	Member_Data_Bean mdata = new Member_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from MIN_TMEMBER where USER_ID=? and PASSWORD=?");
			pstmt.setString(1, user_id);
			pstmt.setString(2, passwords);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdata.setNo(rs.getInt("NO"));
				mdata.setUser_id(rs.getString("USER_ID"));
				mdata.setPasswords(rs.getString("PASSWORD"));
				mdata.setName(rs.getString("NAME"));
				mdata.setAddr(rs.getString("ADDR"));
				mdata.setAddr_code(rs.getString("ADDR_CODE"));
				mdata.setPhone1(rs.getString("PHONE1"));
				mdata.setPhone2(rs.getString("PHONE2"));
				mdata.setPhone3(rs.getString("PHONE3"));
				mdata.setEmail(rs.getString("EMAIL"));
				mdata.setBirthy(rs.getString("BIRTHY"));
				mdata.setBirthm(rs.getString("BIRTHM"));
				mdata.setBirthd(rs.getString("BIRTHD"));
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
    	
    	return mdata;
    }
    
    
    //정보수정
    public boolean update(Member_Data_Bean mdb, int no) {
    	Member_Data_Bean mdata = getArticle(no);	//게시글정보 가져오기
    	
    	//비밀번호가 다를때 종료
    	if(!mdata.getPasswords().equals(mdb.getPasswords()))
    		return false;
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("update MIN_TMEMBER"
					+ " set"
					+ " NAME=?, ADDR=?, ADDR_CODE=?, PHONE1=?, PHONE2=?, PHONE3=?, EMAIL=?, BIRTHY=?, BIRTHM=?, BIRTHD=?"
					+ " where NO=?");
			pstmt.setString(1, mdb.getName());
			pstmt.setString(2, mdb.getAddr());
			pstmt.setString(3, mdb.getAddr_code());
			pstmt.setString(4, mdb.getPhone1());
			pstmt.setString(5, mdb.getPhone2());
			pstmt.setString(6, mdb.getPhone3());
			pstmt.setString(7, mdb.getEmail());
			pstmt.setString(8, mdb.getBirthy());
			pstmt.setString(9, mdb.getBirthm());
			pstmt.setString(10, mdb.getBirthd());
			pstmt.setInt(11, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return true;
    }

}
