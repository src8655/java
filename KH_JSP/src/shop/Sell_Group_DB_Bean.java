package shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;


public class Sell_Group_DB_Bean {
	private static Sell_Group_DB_Bean instance = new Sell_Group_DB_Bean();
	
    public static Sell_Group_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    public boolean insert(Sell_Group_Data_Bean sgdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_SELL_GROUP(MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO) "
									+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, sgdata.getMoney());
			pstmt.setInt(2, sgdata.getShip_money());
			pstmt.setInt(3, sgdata.getRmoney());
			pstmt.setString(4, sgdata.getBank());
			pstmt.setString(5, sgdata.getBank_num());
			pstmt.setString(6, sgdata.getName());
			pstmt.setString(7, sgdata.getZipcode());
			pstmt.setString(8, sgdata.getAddr());
			pstmt.setString(9, sgdata.getPhone1());
			pstmt.setString(10, sgdata.getPhone2());
			pstmt.setString(11, sgdata.getPhone3());
			pstmt.setString(12, sgdata.getShip_memo());
			pstmt.setString(13, sgdata.getTimes());
			pstmt.setString(14, sgdata.getDates());
			pstmt.setInt(15, sgdata.getGuest_no());
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
    public List getArticles(int guest_no) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL_GROUP where GUEST_NO=?");
			pstmt.setInt(1, guest_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Sell_Group_Data_Bean sgdata = new Sell_Group_Data_Bean();
				sgdata.setNo(rs.getInt("NO"));
				sgdata.setMoney(rs.getInt("MONEY"));
				sgdata.setShip_money(rs.getInt("SHIP_MONEY"));
				sgdata.setRmoney(rs.getInt("RMONEY"));
				sgdata.setBank(rs.getString("BANK"));
				sgdata.setBank_num(rs.getString("BANK_NUM"));
				sgdata.setName(rs.getString("NAME"));
				sgdata.setZipcode(rs.getString("ZIPCODE"));
				sgdata.setAddr(rs.getString("ADDR"));
				sgdata.setPhone1(rs.getString("PHONE1"));
				sgdata.setPhone2(rs.getString("PHONE2"));
				sgdata.setPhone3(rs.getString("PHONE3"));
				sgdata.setShip_memo(rs.getString("SHIP_MEMO"));
				sgdata.setTimes(rs.getString("TIMES"));
				sgdata.setDates(rs.getString("DATES"));
				sgdata.setGuest_no(rs.getInt("GUEST_NO"));
				
				list.add(sgdata);
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
    public Sell_Group_Data_Bean getArticle(String times) {
		Sell_Group_Data_Bean sgdata = new Sell_Group_Data_Bean();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL_GROUP where TIMES=?");
			pstmt.setString(1, times);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				sgdata.setNo(rs.getInt("NO"));
				sgdata.setMoney(rs.getInt("MONEY"));
				sgdata.setShip_money(rs.getInt("SHIP_MONEY"));
				sgdata.setRmoney(rs.getInt("RMONEY"));
				sgdata.setBank(rs.getString("BANK"));
				sgdata.setBank_num(rs.getString("BANK_NUM"));
				sgdata.setName(rs.getString("NAME"));
				sgdata.setZipcode(rs.getString("ZIPCODE"));
				sgdata.setAddr(rs.getString("ADDR"));
				sgdata.setPhone1(rs.getString("PHONE1"));
				sgdata.setPhone2(rs.getString("PHONE2"));
				sgdata.setPhone3(rs.getString("PHONE3"));
				sgdata.setShip_memo(rs.getString("SHIP_MEMO"));
				sgdata.setTimes(rs.getString("TIMES"));
				sgdata.setDates(rs.getString("DATES"));
				sgdata.setGuest_no(rs.getInt("GUEST_NO"));
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
    	
    	return sgdata;
    }
}
