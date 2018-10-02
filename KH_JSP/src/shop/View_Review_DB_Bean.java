package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class View_Review_DB_Bean {
	private static View_Review_DB_Bean instance = new View_Review_DB_Bean();
	
    public static View_Review_DB_Bean getInstance() {
        return instance;
    }
    
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
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_VIEW_REVIEW(GUEST_NO,PRODUCT_NO,STARS,REVIEW1,REVIEW2,MEMO,DATES) "
									+"values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, vrdata.getGuest_no());
			pstmt.setInt(2, vrdata.getProduct_no());
			pstmt.setInt(3, vrdata.getStars());
			pstmt.setString(4, vrdata.getReview1());
			pstmt.setString(5, vrdata.getReview2());
			pstmt.setString(6, vrdata.getMemo());
			pstmt.setString(7, vrdata.getDates());
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
}
