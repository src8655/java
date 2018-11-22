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


public class Sell_DB_Bean {
	private static Sell_DB_Bean instance = new Sell_DB_Bean();
	
    public static Sell_DB_Bean getInstance() {
        return instance;
    }
    /*
    private Connection getConnection() throws Exception {
    	Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
    }
    
    public boolean insert(Sell_Data_Bean sdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_SELL(GUEST_NO,SELLERS_NO,PRODUCT_NO,PRODUCT_NAME,COUNTS,MONEY,SHIP_MONEY,RMONEY,DATES,SHIP_DATES,SHIP_COMPANY,STATUS,ADDR,ZIPCODE,SHIP_MEMO,NAME,PHONE1,PHONE2,PHONE3,FILE1,TIMES,HASREVIEW) "
									+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
			pstmt.setInt(22, sdata.getHasreview());
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
    
    //guestno로 찾기
    public List getArticles(int start, int end, int guest_no) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			//pstmt = conn.prepareStatement("select * from MIN_TSHOP_SELL where GUEST_NO=? order by NO desc");
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_SELL where GUEST_NO=? order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setInt(1, guest_no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
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
				sdata.setShip_num(rs.getString("SHIP_NUM"));
				sdata.setHasreview(rs.getInt("HASREVIEW"));
				
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
    //guestno로 sell 총 개수 찾기
    public int count(int guest_no) {
    	int count = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_SELL where GUEST_NO=?");
			pstmt.setInt(1, guest_no);
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
    //sellersno와 status로 찾기 status가 -1일시 배송완료를 제외하고 모두 보기
    public List getArticles2(int start, int end, int sellers_no, int status) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	String wheres = " and STATUS=?";
    	if(status == -1)
    		wheres = " and STATUS!=?";
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_SELL where SELLERS_NO=? "+wheres+" order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setInt(1, sellers_no);
			if(status != -1) 
				pstmt.setInt(2, status);
			else
				pstmt.setInt(2, 5);
			pstmt.setInt(3, start);
			pstmt.setInt(4, end);
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
				sdata.setShip_num(rs.getString("SHIP_NUM"));
				sdata.setHasreview(rs.getInt("HASREVIEW"));
				

				//금액형태로 바꾸기
				sdata.setMoneys(number_format(sdata.getMoney()));
				sdata.setShip_moneys(number_format(sdata.getShip_money()));
				sdata.setRmoneys(number_format(sdata.getRmoney()));
				sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
				
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
    //sellersno와 status로 개수 찾기 status가 -1일시 배송완료를 제외하고 모두 보기(카운트)
    public int count2(int sellers_no, int status) {
    	int count = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	String wheres = " and STATUS=?";
    	if(status == -1)
    		wheres = " and STATUS!=?";
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_SELL where SELLERS_NO=? "+wheres);
			pstmt.setInt(1, sellers_no);
			if(status != -1) 
				pstmt.setInt(2, status);
			else
				pstmt.setInt(2, 5);
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
    //times로 찾기
    public List getArticles3(String times) {
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
				sdata.setShip_num(rs.getString("SHIP_NUM"));
				sdata.setHasreview(rs.getInt("HASREVIEW"));
				
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
				sdata.setShip_num(rs.getString("SHIP_NUM"));
				sdata.setHasreview(rs.getInt("HASREVIEW"));
				
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
    
    
    //같은 그룹의 개수 구하기
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
    //같은 페이지에 같은 그룹의 개수 구하기
    public int group_count(int start, int end, String times, int guest_no) {
    	int count = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from (select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_SELL where GUEST_NO=? order by NO desc) a) where rnum>=? and rnum<=?) where TIMES=?");
			pstmt.setInt(1, guest_no);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setString(4, times);
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
    
    //구매자 no와 상태값에 따른 카운트 구하기
    public int guest_sell_count(int guest_no, int status) {
    	int count = 0;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_SELL where GUEST_NO=? and STATUS=?");
			pstmt.setInt(1, guest_no);
			pstmt.setInt(2, status);
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
    

    //times로 상태 일괄 바꾸기
    public boolean changeStatus(String times, int status) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//상품의 상태변경
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL set STATUS=? where TIMES=?");
			pstmt.setInt(1, status);
			pstmt.setString(2, times);
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
    //no로 상태 바꾸기
    public boolean changeStatus(int no, int status) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//상품의 상태변경
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL set STATUS=? where NO=?");
			pstmt.setInt(1, status);
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
    //no로 배송중상태로 바꾸기
    public boolean changeShipStatus(int no, String ship_num) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//상태변경
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL set STATUS=?, SHIP_NUM=? where NO=?");
			pstmt.setInt(1, 4);
			pstmt.setString(2, ship_num);
			pstmt.setInt(3, no);
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
    
    //주문취소하기 (sdata = 삭제할 데이터)
    public boolean delete(Sell_Data_Bean sdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			

			Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
			int count = group_count(sdata.getTimes());		//같은 그룹에 있는 sell이 몇개인지 확인
			if(count == 1) sgdb.delete(sdata.getTimes());	//하나이면 (현재 셀밖에 없으면) 그룹을 그냥 삭제
			else sgdb.delete_sell(sdata);					//여러개이면 기존 그룹에서 현재 sell의 금액을 빼기만함
			
			//현재 sell 데이터 삭제
			pstmt = conn.prepareStatement("delete from MIN_TSHOP_SELL where NO=?");
			pstmt.setInt(1, sdata.getNo());
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
    //리뷰작성완료(hasreview = 1)로 변경
    public boolean updateReview(int no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();				//여러개이면 기존 그룹에서 현재 sell의 금액을 빼기만함
			
			//현재 sell 데이터 삭제
			pstmt = conn.prepareStatement("update MIN_TSHOP_SELL set HASREVIEW=? where NO=?");
			pstmt.setInt(1, 1);
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
    
*/
	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //sellersno와 status로 찾기 status가 -1일시 배송완료를 제외하고 모두 보기
    public List getArticles2_M(int start, int end, int sellers_no, int status) throws SQLException {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("sellers_no", sellers_no);
    	map.put("status", status);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
		List list = sqlmap.queryForList("Sell_getArticles2", map);
    	
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
			sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
		}
    	
    	return list;
    }
    //sellersno와 status로 개수 찾기 status가 -1일시 배송완료를 제외하고 모두 보기(카운트)
    public int count2_M(int sellers_no, int status) throws SQLException {
    	Map map = new HashMap();
    	map.put("sellers_no", sellers_no);
    	map.put("status", status);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
		int count = (int)sqlmap.queryForObject("Sell_count2", map);
    	
    	return count;
    }
    //no로 상태 바꾸기
    public boolean changeStatus_M(int no, int status) throws SQLException {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("status", status);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.update("Sell_changeStatus", map);
    	
    	return true;
    }
    //no로 배송중상태로 바꾸기
    public boolean changeShipStatus_M(int no, String ship_num) throws SQLException {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("ship_num", ship_num);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.update("Sell_changeShipStatus", map);
    	
    	return true;
    }
    //입력하기
    public boolean insert_M(Sell_Data_Bean sdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.insert("Sell_insert", sdata);
    	
    	return true;
    }
    //guestno로 찾기
    public List getArticles_M(int start, int end, int guest_no) throws SQLException {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("guest_no", guest_no);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
		List list = sqlmap.queryForList("Sell_getArticles", map);
    	
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
			sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
		}
    	
    	return list;
    }
    //구매자 no와 상태값에 따른 카운트 구하기
    public int guest_sell_count_M(int guest_no, int status) throws SQLException {
    	Map map = new HashMap();
    	map.put("guest_no", guest_no);
    	map.put("status", status);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	int count = (int)sqlmap.queryForObject("Sell_guest_sell_count", map);
    	
    	return count;
    }
    //guestno로 sell 총 개수 찾기
    public int count_M(int guest_no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	int count = (int)sqlmap.queryForObject("Sell_count", guest_no);
    	
    	return count;
    }
    //times로 찾기
    public List getArticles3_M(String times) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (List)sqlmap.queryForList("Sell_getArticles3", times);
    }
    //하나가져오기
    public Sell_Data_Bean getArticle_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (Sell_Data_Bean)sqlmap.queryForObject("Sell_getArticle", no);
    }
    //주문취소하기 (sdata = 삭제할 데이터)
    public boolean delete_M(Sell_Data_Bean sdata) throws SQLException {
    	Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		int count = group_count_M(sdata.getTimes());		//같은 그룹에 있는 sell이 몇개인지 확인
		if(count == 1) sgdb.delete_M(sdata.getTimes());	//하나이면 (현재 셀밖에 없으면) 그룹을 그냥 삭제
		else sgdb.delete_sell_M(sdata);					//여러개이면 기존 그룹에서 현재 sell의 금액을 빼기만함
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.delete("Sell_delete", sdata.getNo());
		
    	return true;
    }
    //같은 그룹의 개수 구하기
    public int group_count_M(String times) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	int count = (int) sqlmap.queryForObject("Sell_group_count", times);
    	
    	return count;
    }
    //리뷰작성완료(hasreview = 1)로 변경
    public boolean updateReview_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Sell_updateReview", no);
    	
    	return true;
    }
    public boolean changeStatus_M(String times, int status) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	Map map = new HashMap();
    	map.put("times", times);
    	map.put("status", status);
    	sqlmap.update("Sell_changeStatus2", map);
    	
    	return true;
    }
  //같은 페이지에 같은 그룹의 개수 구하기
    public int group_count_M2(int start, int end, String times, int guest_no) throws SQLException {
    	int count = 0;
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("times", times);
    	map.put("guest_no", guest_no);
    	
    	count = (int)sqlmap.queryForObject("Sell_group_count2", map);
    	
    	return count;
    }
    
}
