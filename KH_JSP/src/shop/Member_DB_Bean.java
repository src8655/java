package shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_MEMBER(NAME,USER_ID,USER_PW,EMAIL,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,COMPANY_NUMBER,ORDERS,BANK,BANK_NUM) "
									+"values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			pstmt.setString(12, mdata.getBank());
			pstmt.setString(13, mdata.getBank_num());
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
    public List getArticles(int start, int end) {
    	List list = new ArrayList();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_MEMBER order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member_Data_Bean mdata = new Member_Data_Bean();
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
				mdata.setBank(rs.getString("BANK"));
				mdata.setBank_num(rs.getString("BANK_NUM"));
				
				list.add(mdata);
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
    //회원정보 하나 가져오기
    public Member_Data_Bean getArticle(int no) {
    	Member_Data_Bean mdata = new Member_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_MEMBER where NO=?");
			pstmt.setInt(1, no);
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
				mdata.setBank(rs.getString("BANK"));
				mdata.setBank_num(rs.getString("BANK_NUM"));
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
    //총 회원의 수 
    public int count() {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_MEMBER");
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
				mdata.setBank(rs.getString("BANK"));
				mdata.setBank_num(rs.getString("BANK_NUM"));
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
    
    public boolean update(Member_Data_Bean mdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			String wheres = "";
			if(!mdata.getUser_pw().equals("")) wheres = ",USER_PW='"+mdata.getUser_pw()+"'";
			
			pstmt = conn.prepareStatement("update MIN_TSHOP_MEMBER set "
					+ "ORDERS=?,"
					+ "COMPANY_NUMBER=?,"
					+ "NAME=?,"
					+ "EMAIL=?,"
					+ "ZIPCODE=?,"
					+ "ADDR=?,"
					+ "PHONE1=?,"
					+ "PHONE2=?,"
					+ "PHONE3=?,"
					+ "BANK=?,"
					+ "BANK_NUM=?"+wheres
					+ " where NO=?");
			pstmt.setInt(1, mdata.getOrders());
			pstmt.setString(2, mdata.getCompany_number());
			pstmt.setString(3, mdata.getName());
			pstmt.setString(4, mdata.getEmail());
			pstmt.setString(5, mdata.getZipcode());
			pstmt.setString(6, mdata.getAddr());
			pstmt.setString(7, mdata.getPhone1());
			pstmt.setString(8, mdata.getPhone2());
			pstmt.setString(9, mdata.getPhone3());
			pstmt.setString(10, mdata.getBank());
			pstmt.setString(11, mdata.getBank_num());
			pstmt.setInt(12, mdata.getNo());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return true;
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
