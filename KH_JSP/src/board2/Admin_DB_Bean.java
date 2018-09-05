package board2;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Admin_DB_Bean {
	private static Admin_DB_Bean instance = new Admin_DB_Bean();
    public static Admin_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
        
    //한 줄 가져오기
    public Admin_Data_Bean getArticle(String id) {
    	Admin_Data_Bean adata = new Admin_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TADMIN where id=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				adata.setNo(rs.getInt("NO"));
				adata.setId(rs.getString("ID"));
				adata.setTitle(rs.getString("TITLE"));
				adata.setSitemap(rs.getString("SITEMAP"));
				adata.setSubmenu(rs.getString("SUBMENU"));
				adata.setLev(rs.getInt("LEV"));
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

		return adata;
    }
    
}
