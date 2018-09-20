package shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


public class Sell_DB_Bean {
	private static Sell_DB_Bean instance = new Sell_DB_Bean();
	
    public static Sell_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    public boolean insert(Sell_Data_Bean sdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_SELL(GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES) "
									+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, sdata.getGuest_no());
			pstmt.setInt(2, sdata.getSellers_no());
			pstmt.setInt(3, sdata.getProduct_no());
			pstmt.setString(4, sdata.getProduct_name());
			pstmt.setInt(5, sdata.getCounts());
			pstmt.setInt(6, sdata.getMoney());
			pstmt.setInt(7, sdata.getShip_money());
			pstmt.setInt(8, sdata.getRmoney());
			pstmt.setString(9, sdata.getDates());
			pstmt.setString(10, sdata.getShip_dates());
			pstmt.setString(11, sdata.getShip_company());
			pstmt.setInt(12, sdata.getStatus());
			pstmt.setString(13, sdata.getAddr());
			pstmt.setString(14, sdata.getZipcode());
			pstmt.setString(15, sdata.getShip_memo());
			pstmt.setString(16, sdata.getName());
			pstmt.setString(17, sdata.getPhone1());
			pstmt.setString(18, sdata.getPhone2());
			pstmt.setString(19, sdata.getPhone3());
			pstmt.setString(20, sdata.getFile1());
			pstmt.setString(21, sdata.getTimes());
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
    
    //guestno�� ã��
    public List getArticles(int guest_no) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL where GUEST_NO=? order by NO desc");
			pstmt.setInt(1, guest_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Sell_Data_Bean sdata = new Sell_Data_Bean();
				sdata.setNo(rs.getInt("NO"));
				sdata.setGuest_no(rs.getInt("GUEST_NO"));
				sdata.setSellers_no(rs.getInt("SELLERS_NO"));
				sdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				sdata.setProduct_name(rs.getString("PRODUCT_NAME"));
				sdata.setCounts(rs.getInt("COUNTS"));
				sdata.setMoney(rs.getInt("MONEY"));
				sdata.setShip_money(rs.getInt("SHIP_MONEY"));
				sdata.setRmoney(rs.getInt("RMONEY"));
				sdata.setDates(rs.getString("DATES"));
				sdata.setShip_dates(rs.getString("SHIP_DATES"));
				sdata.setShip_company(rs.getString("SHIP_COMPANY"));
				sdata.setStatus(rs.getInt("STATUS"));
				sdata.setAddr(rs.getString("ADDR"));
				sdata.setZipcode(rs.getString("ZIPCODE"));
				sdata.setShip_memo(rs.getString("SHIP_MEMO"));
				sdata.setName(rs.getString("NAME"));
				sdata.setPhone1(rs.getString("PHONE1"));
				sdata.setPhone2(rs.getString("PHONE2"));
				sdata.setPhone3(rs.getString("PHONE3"));
				sdata.setFile1(rs.getString("FILE1"));
				sdata.setTimes(rs.getString("TIMES"));
				
				list.add(sdata);
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
    //times�� ã��
    public List getArticles(String times) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL where TIMES=? order by NO desc");
			pstmt.setString(1, times);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Sell_Data_Bean sdata = new Sell_Data_Bean();
				sdata.setNo(rs.getInt("NO"));
				sdata.setGuest_no(rs.getInt("GUEST_NO"));
				sdata.setSellers_no(rs.getInt("SELLERS_NO"));
				sdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				sdata.setProduct_name(rs.getString("PRODUCT_NAME"));
				sdata.setCounts(rs.getInt("COUNTS"));
				sdata.setMoney(rs.getInt("MONEY"));
				sdata.setShip_money(rs.getInt("SHIP_MONEY"));
				sdata.setRmoney(rs.getInt("RMONEY"));
				sdata.setDates(rs.getString("DATES"));
				sdata.setShip_dates(rs.getString("SHIP_DATES"));
				sdata.setShip_company(rs.getString("SHIP_COMPANY"));
				sdata.setStatus(rs.getInt("STATUS"));
				sdata.setAddr(rs.getString("ADDR"));
				sdata.setZipcode(rs.getString("ZIPCODE"));
				sdata.setShip_memo(rs.getString("SHIP_MEMO"));
				sdata.setName(rs.getString("NAME"));
				sdata.setPhone1(rs.getString("PHONE1"));
				sdata.setPhone2(rs.getString("PHONE2"));
				sdata.setPhone3(rs.getString("PHONE3"));
				sdata.setFile1(rs.getString("FILE1"));
				sdata.setTimes(rs.getString("TIMES"));
				
				list.add(sdata);
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
    public Sell_Data_Bean getArticle(int no) {
		Sell_Data_Bean sdata = new Sell_Data_Bean();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL where NO=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sdata.setNo(rs.getInt("NO"));
				sdata.setGuest_no(rs.getInt("GUEST_NO"));
				sdata.setSellers_no(rs.getInt("SELLERS_NO"));
				sdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				sdata.setProduct_name(rs.getString("PRODUCT_NAME"));
				sdata.setCounts(rs.getInt("COUNTS"));
				sdata.setMoney(rs.getInt("MONEY"));
				sdata.setShip_money(rs.getInt("SHIP_MONEY"));
				sdata.setRmoney(rs.getInt("RMONEY"));
				sdata.setDates(rs.getString("DATES"));
				sdata.setShip_dates(rs.getString("SHIP_DATES"));
				sdata.setShip_company(rs.getString("SHIP_COMPANY"));
				sdata.setStatus(rs.getInt("STATUS"));
				sdata.setAddr(rs.getString("ADDR"));
				sdata.setZipcode(rs.getString("ZIPCODE"));
				sdata.setShip_memo(rs.getString("SHIP_MEMO"));
				sdata.setName(rs.getString("NAME"));
				sdata.setPhone1(rs.getString("PHONE1"));
				sdata.setPhone2(rs.getString("PHONE2"));
				sdata.setPhone3(rs.getString("PHONE3"));
				sdata.setFile1(rs.getString("FILE1"));
				sdata.setTimes(rs.getString("TIMES"));
				
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
    	
    	return sdata;
    }
    
    
    //���� �׷��� ���� ���ϱ�
    public int group_count(String times) {
    	int count = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_SELL where TIMES=?");
			pstmt.setString(1, times);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
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
    	
    	return count;
    }
    
}
