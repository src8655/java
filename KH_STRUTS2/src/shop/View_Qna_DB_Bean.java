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

public class View_Qna_DB_Bean {
	private static View_Qna_DB_Bean instance = new View_Qna_DB_Bean();
	
    public static View_Qna_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	Context context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
    }
    
    public boolean insert(View_Qna_Data_Bean vqdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_VIEW_QNA(PRODUCT_NO,GUEST_NO,GUEST_ID,CATEGORY,MEMO,SECRET,DATES,ANSWER,ISANSWER,SELLERS_NO) "
									+"values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, vqdata.getProduct_no());
			pstmt.setInt(2, vqdata.getGuest_no());
			pstmt.setString(3, vqdata.getGuest_id());
			pstmt.setInt(4, vqdata.getCategory());
			pstmt.setString(5, vqdata.getMemo());
			pstmt.setInt(6, vqdata.getSecret());
			pstmt.setString(7, vqdata.getDates());
			pstmt.setString(8, vqdata.getAnswer());
			pstmt.setInt(9, vqdata.getIsanswer());
			pstmt.setInt(10, vqdata.getSellers_no());
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
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_VIEW_QNA where PRODUCT_NO=?");
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
    public List getArticles(int start, int end, int product_no, Member_Data_Bean mdata) {
    	List list = new ArrayList();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_VIEW_QNA where PRODUCT_NO=? order by NO desc) a) where rnum>=? and rnum<=?");
	    	pstmt.setInt(1, product_no);
	    	pstmt.setInt(2, start);
	    	pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				View_Qna_Data_Bean vqdata = new View_Qna_Data_Bean();
				vqdata.setNo(rs.getInt("NO"));
				vqdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				vqdata.setGuest_no(rs.getInt("GUEST_NO"));
				vqdata.setGuest_id(rs.getString("GUEST_ID"));
				vqdata.setCategory(rs.getInt("CATEGORY"));
				vqdata.setSecret(rs.getInt("SECRET"));
				vqdata.setDates(rs.getString("DATES"));
				vqdata.setAnswer(rs.getString("ANSWER"));
				vqdata.setIsanswer(rs.getInt("ISANSWER"));
				vqdata.setSellers_no(rs.getInt("SELLERS_NO"));

				
				
				
				vqdata.setSubject("비밀글 입니다.");
				vqdata.setMemo("비밀글 입니다.");
				vqdata.setAnswer("비밀글 입니다.");
				
				
				//비밀글이고
				if(vqdata.getSecret() == 1) {
					
					if(mdata != null) {
						//비로그인이면
						if(mdata.getNo() == vqdata.getGuest_no()) {
							vqdata.setMemo(rs.getString("MEMO"));
							String tmp = rs.getString("MEMO");
							if(tmp.length() <= 30) vqdata.setSubject(tmp);
							else vqdata.setSubject(tmp.substring(0, 30)+"...");
							vqdata.setAnswer(rs.getString("ANSWER"));
						}
						if(mdata.getNo() == vqdata.getSellers_no()) {
							vqdata.setMemo(rs.getString("MEMO"));
							String tmp = rs.getString("MEMO");
							if(tmp.length() <= 30) vqdata.setSubject(tmp);
							else vqdata.setSubject(tmp.substring(0, 30)+"...");
							vqdata.setAnswer(rs.getString("ANSWER"));
						}
					}
				}else {
					vqdata.setMemo(rs.getString("MEMO"));
					String tmp = rs.getString("MEMO");
					if(tmp.length() <= 30) vqdata.setSubject(tmp);
					else vqdata.setSubject(tmp.substring(0, 30)+"...");
					vqdata.setAnswer(rs.getString("ANSWER"));
				}
				
				
				list.add(vqdata);
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
    public View_Qna_Data_Bean getArticle(int no) {
		View_Qna_Data_Bean vqdata = new View_Qna_Data_Bean();
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_VIEW_QNA where NO=?");
	    	pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vqdata.setNo(rs.getInt("NO"));
				vqdata.setProduct_no(rs.getInt("PRODUCT_NO"));
				vqdata.setGuest_no(rs.getInt("GUEST_NO"));
				vqdata.setGuest_id(rs.getString("GUEST_ID"));
				vqdata.setCategory(rs.getInt("CATEGORY"));
				vqdata.setSecret(rs.getInt("SECRET"));
				vqdata.setDates(rs.getString("DATES"));
				vqdata.setAnswer(rs.getString("ANSWER"));
				vqdata.setIsanswer(rs.getInt("ISANSWER"));
				vqdata.setSellers_no(rs.getInt("SELLERS_NO"));


				vqdata.setMemo(rs.getString("MEMO"));
				String tmp = rs.getString("MEMO");
				if(tmp.length() <= 30) vqdata.setSubject(tmp);
				else vqdata.setSubject(tmp.substring(0, 30)+"...");
				
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
    	
    	return vqdata;
    }
    
    //삭제하기
    public boolean delete(int no) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("delete from MIN_TSHOP_VIEW_QNA where NO=?");
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
    
    //답변달기
    public boolean answer(View_Qna_Data_Bean vqdata) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("update MIN_TSHOP_VIEW_QNA set ANSWER=?, ISANSWER=? where NO=?");
			pstmt.setString(1, vqdata.getAnswer());
			pstmt.setInt(2, vqdata.getIsanswer());
	    	pstmt.setInt(3, vqdata.getNo());
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
}
