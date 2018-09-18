package shop;

import java.sql.*;

import javax.servlet.http.HttpSession;


public class Member_DB_Bean {
	private static Member_DB_Bean instance = new Member_DB_Bean();
	
    public static Member_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    public boolean insert(Member_Data_Bean mdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_MEMBER(NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS) "
									+"values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, mdata.getName());
			pstmt.setString(2, mdata.getUser_id());
			pstmt.setString(3, mdata.getUser_pw());
			pstmt.setString(4, mdata.getEmail());
			pstmt.setString(5, mdata.getZipcode());
			pstmt.setString(6, mdata.getAddr());
			pstmt.setString(7, mdata.getPhone1());
			pstmt.setString(8, mdata.getPhone2());
			pstmt.setString(9, mdata.getPhone3());
			pstmt.setString(10, mdata.getCompany_number());
			pstmt.setInt(11, mdata.getOrders());
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
    
    //id로 몇명의 회원이 있는지 확인
    public int selectId(String user_id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_MEMBER where USER_ID=?");
			pstmt.setString(1, user_id);
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
    
    //로그인하기
    public boolean login(Member_Data_Bean mdata) {
    	if(mdata.getUser_id() == null || mdata.getUser_pw() == null) return false;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	int cnt = 0;
    	
    	
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_MEMBER where USER_ID=? and USER_PW=?");
			pstmt.setString(1, mdata.getUser_id());
			pstmt.setString(2, mdata.getUser_pw());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt =  rs.getInt(1);
			}
			
			if(cnt == 0) return false;
			else return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	
    	return false;
    }
    
  //로그인 정보 가져오기
    public Member_Data_Bean login_info(String user_id, String user_pw) {
    	Member_Data_Bean mdata = new Member_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_MEMBER where USER_ID=? and USER_PW=?");
			pstmt.setString(1, user_id);
			pstmt.setString(2, user_pw);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mdata.setNo(rs.getInt("NO"));
				mdata.setName(rs.getString("NAME"));
				mdata.setUser_id(rs.getString("USER_ID"));
				mdata.setUser_pw(rs.getString("USER_PW"));
				mdata.setEmail(rs.getString("EMAIL"));
				mdata.setZipcode(rs.getString("ZIPCODE"));
				mdata.setAddr(rs.getString("ADDR"));
				mdata.setPhone1(rs.getString("PHONE1"));
				mdata.setPhone2(rs.getString("PHONE2"));
				mdata.setPhone3(rs.getString("PHONE3"));
				mdata.setCompany_number(rs.getString("COMPANY_NUMBER"));
				mdata.setOrders(rs.getInt("ORDERS"));
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
    

    //세션을 보고 로그인시 정보 가져오기
    public Member_Data_Bean getLogin(HttpSession session) {
    	Member_Data_Bean member_info = null;
    	if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
    		member_info = getInstance().login_info((String)session.getAttribute("user_id"), (String)session.getAttribute("user_pw"));
    	}
    	
    	return member_info;
    }
}
