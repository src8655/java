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

public class Qna_DB_Bean {
	private static Qna_DB_Bean instance = new Qna_DB_Bean();
	
    public static Qna_DB_Bean getInstance() {
        return instance;
    }
    /*
    private Connection getConnection() throws Exception {
    	Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
    }
    
    public boolean insert(Qna_Data_Bean qdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_QNA(SUBJECT,MEMO,ANSWER,ISANSWER,DATES,GUEST_NO,CATEGORY) "
									+"values(?,?,?,?,?,?,?)");
			pstmt.setString(1, qdata.getSubject());
			pstmt.setString(2, qdata.getMemo());
			pstmt.setString(3, qdata.getAnswer());
			pstmt.setInt(4, qdata.getIsanswer());
			pstmt.setString(5, qdata.getDates());
			pstmt.setInt(6, qdata.getGuest_no());
			pstmt.setInt(7, qdata.getCategory());
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
    public int count(int guest_no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int count = 0;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_QNA where GUEST_NO=?");
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
    public List getArticles(int start, int end, int guest_no, int length) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_QNA where GUEST_NO=? order by NO desc) a) where rnum>=? and rnum<=?");
	    	pstmt.setInt(1, guest_no);
	    	pstmt.setInt(2, start);
	    	pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Qna_Data_Bean qdata = new Qna_Data_Bean();
				qdata.setNo(rs.getInt("NO"));
				qdata.setSubject(rs.getString("SUBJECT"));
				qdata.setMemo(rs.getString("MEMO"));
				qdata.setAnswer(rs.getString("ANSWER"));
				qdata.setIsanswer(rs.getInt("ISANSWER"));
				qdata.setDates(rs.getString("DATES"));
				qdata.setGuest_no(rs.getInt("GUEST_NO"));
				qdata.setCategory(rs.getInt("CATEGORY"));
				
				if(qdata.getSubject().length() > length)
					qdata.setSubject(qdata.getSubject().substring(1, length));

				list.add(qdata);
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
    public Qna_Data_Bean getArticle(int no) {
		Qna_Data_Bean qdata = new Qna_Data_Bean();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_QNA where NO=?");
	    	pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				qdata.setNo(rs.getInt("NO"));
				qdata.setSubject(rs.getString("SUBJECT"));
				qdata.setMemo(rs.getString("MEMO"));
				qdata.setAnswer(rs.getString("ANSWER"));
				qdata.setIsanswer(rs.getInt("ISANSWER"));
				qdata.setDates(rs.getString("DATES"));
				qdata.setGuest_no(rs.getInt("GUEST_NO"));
				qdata.setCategory(rs.getInt("CATEGORY"));

				qdata.setMemos(qdata.getMemo().replaceAll("\n", "<br />"));
				if(qdata.getAnswer() != null) qdata.setAnswers(qdata.getAnswer().replaceAll("\n", "<br />"));
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
    	
    	return qdata;
    }
    //관리자일때 미답변만 보기
    public List getArticles(int start, int end, int length, boolean isanswer) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_QNA order by NO desc) a) where rnum>=? and rnum<=?");
	    	pstmt.setInt(1, start);
	    	pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Qna_Data_Bean qdata = new Qna_Data_Bean();
				qdata.setNo(rs.getInt("NO"));
				qdata.setSubject(rs.getString("SUBJECT"));
				qdata.setMemo(rs.getString("MEMO"));
				qdata.setAnswer(rs.getString("ANSWER"));
				qdata.setIsanswer(rs.getInt("ISANSWER"));
				qdata.setDates(rs.getString("DATES"));
				qdata.setGuest_no(rs.getInt("GUEST_NO"));
				qdata.setCategory(rs.getInt("CATEGORY"));
				
				//글자수 자르기
				if(qdata.getSubject().length() > length)
					qdata.setSubject(qdata.getSubject().substring(1, length));

				list.add(qdata);
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
    public int count() {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int count = 0;
    	
    	try {
			conn = getConnection();
			
			//pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_QNA where ISANSWER=?");
			//pstmt.setInt(1, 0);
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_QNA");
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
    
    
    
    //삭제하기
    public boolean delete(int no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from MIN_TSHOP_QNA where NO=?");
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
    public boolean update(Qna_Data_Bean qdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MIN_TSHOP_QNA set "
					+ "SUBJECT=?,"
					+ "MEMO=?,"
					+ "ANSWER=?,"
					+ "ISANSWER=?,"
					+ "DATES=?,"
					+ "GUEST_NO=?,"
					+ "CATEGORY=?"
					+ " where NO=?");
			pstmt.setString(1, qdata.getSubject());
			pstmt.setString(2, qdata.getMemo());
			pstmt.setString(3, qdata.getAnswer());
			pstmt.setInt(4, qdata.getIsanswer());
			pstmt.setString(5, qdata.getDates());
			pstmt.setInt(6, qdata.getGuest_no());
			pstmt.setInt(7, qdata.getCategory());
	    	pstmt.setInt(8, qdata.getNo());
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
    
    //답변달기
    public boolean answer(Qna_Data_Bean qdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MIN_TSHOP_QNA set ANSWER=?, ISANSWER=? where NO=?");
			pstmt.setString(1, qdata.getAnswer());
			pstmt.setInt(2, qdata.getIsanswer());
	    	pstmt.setInt(3, qdata.getNo());
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
    
    //답변삭제
    public boolean answerDel(int no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MIN_TSHOP_QNA set ANSWER=?, ISANSWER=? where NO=?");
			pstmt.setString(1, "");
			pstmt.setInt(2, 0);
	    	pstmt.setInt(3, no);
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
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //카운트 관리자면 -1 회원이면 회원번호
    public int count_M(int guest_no) throws SQLException {
    	Map map = new HashMap();
    	map.put("guest_no", guest_no);
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (int)sqlmap.queryForObject("Qna_count", map);
    }
    //여러개 가져오기 관리자면 -1 회원이면 회원번호
    public List getArticles_M(int start, int end, int length, int guest_no) throws SQLException {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("length", length);
    	map.put("guest_no", guest_no);
    	
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	List list = sqlmap.queryForList("Qna_getArticles", map);
    	for(int i=0;i<list.size();i++) {
    		Qna_Data_Bean qdata = (Qna_Data_Bean)list.get(i);
    		if(qdata.getSubject().length() > length)
				qdata.setSubject(qdata.getSubject().substring(1, length));
    	}
    	
    	return list;
    }
    //입력하기
    public boolean insert_M(Qna_Data_Bean qdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.insert("Qna_insert", qdata);
    	
    	return true;
    }
    //하나만가져오기
    public Qna_Data_Bean getArticle_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	return (Qna_Data_Bean)sqlmap.queryForObject("Qna_getArticle", no);
    }
    //수정하기
    public boolean update_M(Qna_Data_Bean qdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Qna_update", qdata);
    	
    	return true;
    }
    //삭제하기
    public boolean delete_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.delete("Qna_delete", no);
    	
    	return true;
    }
    //답변달기
    public boolean answer_M(Qna_Data_Bean qdata) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Qna_answer", qdata);
    	
    	return true;
    }
    //답변삭제
    public boolean answerDel_M(int no) throws SQLException {
    	SqlMapClient sqlmap = FactoryService.getSqlmap();
    	sqlmap.update("Qna_answerDel", no);

    	return true;
    }
}
