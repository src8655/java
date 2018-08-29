package board2;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Addr_DB_Bean {
	private static Addr_DB_Bean instance = new Addr_DB_Bean();
    public static Addr_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    public List getArticles(String value) {
    	List list = new ArrayList();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TADDR where ADDR1 like ? or ADDR2 like ? or ADDR3 like ? or ADDR4 like ? order by NO asc");
			pstmt.setString(1, "%"+value+"%");
			pstmt.setString(2, "%"+value+"%");
			pstmt.setString(3, "%"+value+"%");
			pstmt.setString(4, "%"+value+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Addr_Data_Bean adb = new Addr_Data_Bean();
				adb.setNo(rs.getInt("NO"));
				adb.setZipcode(rs.getString("ZIPCODE"));
				adb.setAddr1(rs.getString("ADDR1"));
				adb.setAddr2(rs.getString("ADDR2"));
				adb.setAddr3(rs.getString("ADDR3"));
				adb.setAddr4(rs.getString("ADDR4"));
				list.add(adb);
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
    

}
