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

public class Faq_DB_Bean {
	private static Faq_DB_Bean instance = new Faq_DB_Bean();
	
    public static Faq_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
    }
    
    public boolean insert(Faq_Data_Bean fdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_FAQ(CATEGORY,SUBJECT,MEMO,DATES) "
									+"values(?,?,?,?)");
			pstmt.setInt(1, fdata.getCategory());
			pstmt.setString(2, fdata.getSubject());
			pstmt.setString(3, fdata.getMemo());
			pstmt.setString(4, fdata.getDates());
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
    public int count(int search, String search_value, int category) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int count = 0;
    	
    	String wheres = "";
    	if(search == 1) wheres = " where SUBJECT like '%"+search_value+"%'";
    	else if(search == 2) wheres = " where MEMO like '%"+search_value+"%'";
    	else if(search == 3) wheres = " where SUBJECT like '%"+search_value+"%' or MEMO like '%\"+search_value+\"%'";

    	if(category != -1) wheres = wheres+" and CATEGORY="+category;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_FAQ "+wheres);
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
    public List getArticles(int start, int end, int search, String search_value, int category) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	String wheres = "";
    	if(search == 1) wheres = " where SUBJECT like '%"+search_value+"%'";
    	else if(search == 2) wheres = " where MEMO like '%"+search_value+"%'";
    	else if(search == 3) wheres = " where SUBJECT like '%"+search_value+"%' or MEMO like '%\"+search_value+\"%'";
    	
    	if(category != -1) wheres = wheres+" and CATEGORY="+category;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_FAQ "+wheres+" order by NO desc) a) where rnum>=? and rnum<=?");
	    	pstmt.setInt(1, start);
	    	pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Faq_Data_Bean fdata = new Faq_Data_Bean();
				fdata.setNo(rs.getInt("NO"));
				fdata.setCategory(rs.getInt("CATEGORY"));
				fdata.setSubject(rs.getString("SUBJECT"));
				fdata.setMemo(rs.getString("MEMO"));
				fdata.setDates(rs.getString("DATES"));
				
				list.add(fdata);
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
    public Faq_Data_Bean getArticle(int no) {
		Faq_Data_Bean fdata = new Faq_Data_Bean();
		
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_FAQ where NO=?");
	    	pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				fdata.setNo(rs.getInt("NO"));
				fdata.setCategory(rs.getInt("CATEGORY"));
				fdata.setSubject(rs.getString("SUBJECT"));
				fdata.setMemo(rs.getString("MEMO"));
				fdata.setDates(rs.getString("DATES"));
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
    	
    	return fdata;
    }
    
    
    //삭제하기
    public boolean delete(int no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from MIN_TSHOP_FAQ where NO=?");
	    	pstmt.setInt(1, no);
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
    
    //수정하기
    public boolean update(Faq_Data_Bean fdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MIN_TSHOP_FAQ set "
					+ "CATEGORY=?,"
					+ "SUBJECT=?,"
					+ "MEMO=?,"
					+ "DATES=?"
					+ " where NO=?");
			pstmt.setInt(1, fdata.getCategory());
			pstmt.setString(2, fdata.getSubject());
			pstmt.setString(3, fdata.getMemo());
			pstmt.setString(4, fdata.getDates());
	    	pstmt.setInt(5, fdata.getNo());
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //카운트
    public int count_M(int search, String search_value, int category) throws SQLException {
    	Map map = new HashMap();
    	map.put("search", search);
    	map.put("search_value", search_value);
    	map.put("category", category);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (int)sqlmap.queryForObject("Faq_count", map);
    }
    //여러개 가져오기
    public List getArticles_M(int start, int end, int search, String search_value, int category) throws SQLException {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("search", search);
    	map.put("search_value", search_value);
    	map.put("category", category);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (List)sqlmap.queryForList("Faq_getArticles", map);
    }
    //입력하기
    public boolean insert_M(Faq_Data_Bean fdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.insert("Faq_insert", fdata);
    	
    	return true;
    }
    //하나만가져오기
    public Faq_Data_Bean getArticle_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (Faq_Data_Bean)sqlmap.queryForObject("Faq_getArticle", no);
    }
    //수정하기
    public boolean update_M(Faq_Data_Bean fdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Faq_update", fdata);
    	
    	return true;
    }
    //삭제하기
    public boolean delete_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.delete("Faq_delete", no);
    	
    	return true;
    }
}
