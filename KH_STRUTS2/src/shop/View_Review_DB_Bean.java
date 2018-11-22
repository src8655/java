package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ibatis.sqlmap.client.SqlMapClient;

import config.FactoryService;

public class View_Review_DB_Bean {
	private static View_Review_DB_Bean instance = new View_Review_DB_Bean();
	
    public static View_Review_DB_Bean getInstance() {
        return instance;
    }
    /*
    private Connection getConnection() throws Exception {
    	Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
    }
    
    public boolean insert(View_Review_Data_Bean vrdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_VIEW_REVIEW(GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES,GUEST_ID) "
									+"values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, vrdata.getGuest_no());
			pstmt.setInt(2, vrdata.getProduct_no());
			pstmt.setInt(3, vrdata.getStars());
			pstmt.setString(4, vrdata.getReview1());
			pstmt.setString(5, vrdata.getReview2());
			pstmt.setString(6, vrdata.getMemo());
			pstmt.setString(7, vrdata.getDates());
			pstmt.setString(8, vrdata.getGuest_id());
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
    
    
    
    
    public int count(int product_no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int count = 0;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_VIEW_REVIEW where PRODUCT_NO=?");
			pstmt.setInt(1, product_no);
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
    public List getArticles(int start, int end, int product_no) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_VIEW_REVIEW where PRODUCT_NO=? order by NO desc) a) where rnum>=? and rnum<=?");
	    	pstmt.setInt(1, product_no);
	    	pstmt.setInt(2, start);
	    	pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				View_Review_Data_Bean vrdata = new View_Review_Data_Bean();
				vrdata.setGuest_no(rs.getInt("GUEST_NO"));
				vrdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				vrdata.setStars(rs.getInt("STARS"));
				vrdata.setReview1(rs.getString("REVIEW1"));
				vrdata.setReview2(rs.getString("REVIEW2"));
				vrdata.setMemo(rs.getString("MEMO"));
				vrdata.setDates(rs.getString("DATES"));
				vrdata.setGuest_id(rs.getString("GUEST_ID"));
				
				//별 개수를 저장
				vrdata.setStar_01(vrdata.getStars());
				vrdata.setStar_02(5-vrdata.getStars());
				
				list.add(vrdata);
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
    //하나만가져오기
    public View_Review_Data_Bean getArticle(int no) {
    	View_Review_Data_Bean vrdata = new View_Review_Data_Bean();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_VIEW_REVIEW where NO=?");
	    	pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vrdata.setGuest_no(rs.getInt("GUEST_NO"));
				vrdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				vrdata.setStars(rs.getInt("STARS"));
				vrdata.setReview1(rs.getString("REVIEW1"));
				vrdata.setReview2(rs.getString("REVIEW2"));
				vrdata.setMemo(rs.getString("MEMO"));
				vrdata.setDates(rs.getString("DATES"));
				vrdata.setGuest_id(rs.getString("GUEST_ID"));
				
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
    	
    	return vrdata;
    }
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //카운트
    public int count_M(int product_no) throws SQLException {
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		int count = (int)sqlmap.queryForObject("View_Review_count", product_no);
    	
    	return count;
    }
    //여러개 가져오기
    public List getArticles_M(int start, int end, int product_no) throws SQLException {
    	Map map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		map.put("product_no", product_no);
    	
		SqlMapClient sqlmap = FactoryService.getSqlmap();
    	List list = sqlmap.queryForList("View_Review_getArticles", map);
    	
    	for(int i=0;i<list.size();i++) {
			View_Review_Data_Bean vrdata = (View_Review_Data_Bean)list.get(i);
			
			//별 개수를 저장
			vrdata.setStar_01(vrdata.getStars());
			vrdata.setStar_02(5-vrdata.getStars());
    	}
    	
    	return list;
    }
    //입력하기
    public boolean insert_M(View_Review_Data_Bean vrdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.insert("View_Review_insert", vrdata);
    	
    	return true;
    }
    //하나만가져오기
    public View_Review_Data_Bean getArticle_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (View_Review_Data_Bean)sqlmap.queryForObject("View_Review_getArticle", no);
    }
}
