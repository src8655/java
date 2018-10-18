package shop;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.FactoryService;


public class Sell_Group_DB_Bean {
	private static Sell_Group_DB_Bean instance = new Sell_Group_DB_Bean();
	
    public static Sell_Group_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
    }
    
    public boolean insert(Sell_Group_Data_Bean sgdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_SELL_GROUP(MONEY,SHIP_MONEY,RMONEY,BANK,BANK_NUM,NAME,ZIPCODE,ADDR,PHONE1,PHONE2,PHONE3,SHIP_MEMO,TIMES,DATES,GUEST_NO,STATUS,POINT) "
									+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			pstmt.setInt(16, sgdata.getStatus());
			pstmt.setInt(17, sgdata.getPoint());
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
				sgdata.setStatus(rs.getInt("STATUS"));
				sgdata.setPoint(rs.getInt("POINT"));
				
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
				sgdata.setStatus(rs.getInt("STATUS"));
				sgdata.setPoint(rs.getInt("POINT"));
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
    
    
    
    //입금확인용//입금대기 상태(1)의 주문그룹만 조회
    public List getPayArticles(int status) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL_GROUP where STATUS=?");
			pstmt.setInt(1, status);
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
				sgdata.setStatus(rs.getInt("STATUS"));
				sgdata.setPoint(rs.getInt("POINT"));
				
				//금액형태로 바꾸기
				sgdata.setMoneys(number_format(sgdata.getMoney()));
				sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
				sgdata.setRmoneys(number_format(sgdata.getRmoney()));
				sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
				sgdata.setPoints(number_format(sgdata.getPoint()));
				
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
    
    
    //상태 바꾸기
    public boolean changeStatus(String times, int status) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			
			//그룹의 상태변경
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL_GROUP set STATUS=? where TIMES=?");
			pstmt.setInt(1, status);
			pstmt.setString(2, times);
			pstmt.executeUpdate();
			
			//상품의 상태변경
			Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
			sdb.changeStatus(times, status);
			
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
    //주문취소하기 그룹에 속한 sell이 없으면 그룹삭제
    public boolean delete(String times) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();

			/*
			//삭제한 그룹에 포인트가 있으면 멤버에게 돌려주기
			Sell_Group_Data_Bean sgdata = getArticle(times);
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			Member_Data_Bean mdata = mdb.getArticle(sgdata.getGuest_no());
			mdb.setPoint(mdata.getNo(), mdata.getPoint()+sgdata.getPoint());
			*/
			
			//times가 같은 group을 제거
			pstmt = conn.prepareStatement("delete from MIN_TSHOP_SELL_GROUP where TIMES=?");
			pstmt.setString(1, times);
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
    //주문취소하기 group에서 금액을 뺌
    public boolean delete_sell(Sell_Data_Bean sdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	//그룹의 정보를 가져옴
    	Sell_Group_Data_Bean sgdata = getArticle(sdata.getTimes());
    	
    	//sell의 금액을 group에서 뺌
    	sgdata.setMoney(sgdata.getMoney() - sdata.getMoney());
    	sgdata.setShip_money(sgdata.getShip_money() - sdata.getShip_money());
    	sgdata.setRmoney(sgdata.getRmoney() - sdata.getRmoney());
    	
    	try {
			conn = getConnection();

			//times가 같은 group을 제거
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL_GROUP set MONEY=?, SHIP_MONEY=?, RMONEY=? where TIMES=?");
			pstmt.setInt(1, sgdata.getMoney());
			pstmt.setInt(2, sgdata.getShip_money());
			pstmt.setInt(3, sgdata.getRmoney());
			pstmt.setString(4, sgdata.getTimes());
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
    
    //포인트 변경
    public boolean setPoint(int no, int point) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			
			//그룹의 상태변경
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL_GROUP set POINT=? where NO=?");
			pstmt.setInt(1, point);
			pstmt.setInt(2, no);
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

	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //입력하기
    public boolean insert_M(Sell_Group_Data_Bean sgdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.insert("Sell_Group_insert", sgdata);
    	
    	return true;
    }
    //times로 하나 찾기
    public Sell_Group_Data_Bean getArticle_M(String times) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (Sell_Group_Data_Bean)sqlmap.queryForObject("Sell_Group_getArticle", times);
    }
    //포인트 변경
    public boolean setPoint_M(int no, int point) throws SQLException {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("point", point);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Sell_Group_setPoint", map);
    	
    	return true;
    }
    //주문취소하기 그룹에 속한 sell이 없으면 그룹삭제
    public boolean delete_M(String times) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.delete("Sell_Group_delete", times);
    	
    	
    	return true;
    }
    //주문취소하기 group에서 금액을 뺌
    public boolean delete_sell_M(Sell_Data_Bean sdata) throws SQLException {
    	//그룹의 정보를 가져옴
    	Sell_Group_Data_Bean sgdata = getArticle_M(sdata.getTimes());
    	
    	//sell의 금액을 group에서 뺌
    	sgdata.setMoney(sgdata.getMoney() - sdata.getMoney());
    	sgdata.setShip_money(sgdata.getShip_money() - sdata.getShip_money());
    	sgdata.setRmoney(sgdata.getRmoney() - sdata.getRmoney());
    	
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Sell_Group_delete_sell", sgdata);
    	
    	return true;
    }
}
