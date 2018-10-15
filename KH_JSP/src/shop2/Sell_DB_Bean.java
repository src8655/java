package shop2;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


public class Sell_DB_Bean {
	private static Sell_DB_Bean instance = new Sell_DB_Bean();
	
    public static Sell_DB_Bean getInstance() {
        return instance;
    }
    
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
    
    //guestno�� ã��
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
    //guestno�� sell �� ���� ã��
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
    //sellersno�� status�� ã�� status�� -1�Ͻ� ��ۿϷḦ �����ϰ� ��� ����
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
				

				//�ݾ����·� �ٲٱ�
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
    //sellersno�� status�� ���� ã�� status�� -1�Ͻ� ��ۿϷḦ �����ϰ� ��� ����(ī��Ʈ)
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
    //���� �������� ���� �׷��� ���� ���ϱ�
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
    
    //������ no�� ���°��� ���� ī��Ʈ ���ϱ�
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
    

    //times�� ���� �ϰ� �ٲٱ�
    public boolean changeStatus(String times, int status) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//��ǰ�� ���º���
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
    //no�� ���� �ٲٱ�
    public boolean changeStatus(int no, int status) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//��ǰ�� ���º���
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
    //no�� ����߻��·� �ٲٱ�
    public boolean changeShipStatus(int no, String ship_num) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//���º���
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
    
    //�ֹ�����ϱ� (sdata = ������ ������)
    public boolean delete(Sell_Data_Bean sdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			

			Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
			int count = group_count(sdata.getTimes());		//���� �׷쿡 �ִ� sell�� ����� Ȯ��
			if(count == 1) sgdb.delete(sdata.getTimes());	//�ϳ��̸� (���� ���ۿ� ������) �׷��� �׳� ����
			else sgdb.delete_sell(sdata);					//�������̸� ���� �׷쿡�� ���� sell�� �ݾ��� ���⸸��
			
			//���� sell ������ ����
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
    //�����ۼ��Ϸ�(hasreview = 1)�� ����
    public boolean updateReview(int no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();				//�������̸� ���� �׷쿡�� ���� sell�� �ݾ��� ���⸸��
			
			//���� sell ������ ����
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
    

	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
