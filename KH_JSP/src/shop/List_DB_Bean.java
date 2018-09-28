package shop;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;




public class List_DB_Bean {
	public static String savePathd = "/shop/upload/";	//�������� �����
	private static List_DB_Bean instance = new List_DB_Bean();
	
    public static List_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    
  //������ ���� (���н� false ����)
    public boolean insert(HttpServletRequest request, HttpSession session) {
    	
    	
    	
    	
    	MultipartRequest multi = null;
    	String savePaths=request.getRealPath(savePathd);	//������ġ ������
    	int sizeLimit = 30 * 1024 * 1024;						 	//30�ް� ����
    	String filename1 = null;	//file1�̸�
    	String filename2 = null;	//file2�̸�
    	String filename3 = null;	//file3�̸�
    	String filename4 = null;	//file4�̸�
    	String filename5 = null;	//file5�̸�
    	
    	

		//��¥ ��������
		Calendar cal = Calendar.getInstance();
		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

    	
    	try{
    		//request
    		multi=new MultipartRequest(request, savePaths, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());

    		filename1 = multi.getFilesystemName("file1");	//����1�̸�
    		filename2 = multi.getFilesystemName("file2");	//����2�̸�
    		filename3 = multi.getFilesystemName("file3");	//����2�̸�
    		filename4 = multi.getFilesystemName("file4");	//����2�̸�
    		filename5 = multi.getFilesystemName("file5");	//����2�̸�
    		
    		//����1�̸� �����۾�
    		if(filename1 != null) {
    			int cnt = 1;
    			File file1 = null;
    			
    			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
    			do {
    				filename1 = multi.getFilesystemName("file1");
	        		file1 = multi.getFile("file1");
	        		filename1 = date+"_"+cnt+"_"+filename1;
	        		cnt++;
    			}while(!file1.renameTo(new File(savePaths+"/"+filename1)));
    		}

    		//����2�̸� �����۾�
    		if(filename2 != null) {
    			int cnt = 1;
    			File file2 = null;
    			
    			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
    			do {
    				filename2 = multi.getFilesystemName("file2");
	        		file2 = multi.getFile("file2");
	        		filename2 = date+"_"+cnt+"_"+filename2;
	        		cnt++;
    			}while(!file2.renameTo(new File(savePaths+"/"+filename2)));
    		}
    		

    		//����3�̸� �����۾�
    		if(filename3 != null) {
    			int cnt = 1;
    			File file3 = null;
    			
    			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
    			do {
    				filename3 = multi.getFilesystemName("file3");
	        		file3 = multi.getFile("file3");
	        		filename3 = date+"_"+cnt+"_"+filename3;
	        		cnt++;
    			}while(!file3.renameTo(new File(savePaths+"/"+filename3)));
    		}
    		

    		//����2�̸� �����۾�
    		if(filename4 != null) {
    			int cnt = 1;
    			File file4 = null;
    			
    			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
    			do {
    				filename4 = multi.getFilesystemName("file4");
	        		file4 = multi.getFile("file4");
	        		filename4 = date+"_"+cnt+"_"+filename4;
	        		cnt++;
    			}while(!file4.renameTo(new File(savePaths+"/"+filename4)));
    		}
    		

    		//����2�̸� �����۾�
    		if(filename5 != null) {
    			int cnt = 1;
    			File file5 = null;
    			
    			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
    			do {
    				filename5 = multi.getFilesystemName("file5");
	        		file5 = multi.getFile("file5");
	        		filename5 = date+"_"+cnt+"_"+filename5;
	        		cnt++;
    			}while(!file5.renameTo(new File(savePaths+"/"+filename5)));
    		}
    		
    	} catch(Exception e) {
    		//������ �ʰ�
    		if(e.getMessage().indexOf("exceeds limit") > -1) return false;
    	}
    	
    	
    	

    	
    	
    	
    	
    	
    	
    	//null�϶�
    	if(multi.getParameter("category") == null)		return false;
    	if(multi.getParameter("name") == null)			return false;
    	if(multi.getParameter("money") == null) 		return false;
    	if(multi.getParameter("discount") == null)  	return false;
    	if(multi.getParameter("made") == null) 			return false;
    	if(multi.getParameter("ship_money") == null) 	return false;
    	if(multi.getParameter("ship_company") == null) 	return false;
    	if(multi.getParameter("seller") == null) 		return false;
    	//if(multi.getParameter("user_id") == null) 		return false;

    	//�����϶�
    	if(multi.getParameter("category").equals(""))		return false;
    	if(multi.getParameter("name").equals(""))			return false;
    	if(multi.getParameter("money").equals("")) 			return false;
    	if(multi.getParameter("discount").equals(""))  		return false;
    	if(multi.getParameter("made").equals("")) 			return false;
    	if(multi.getParameter("ship_money").equals("")) 	return false;
    	if(multi.getParameter("ship_company").equals("")) 	return false;
    	if(multi.getParameter("seller").equals("")) 		return false;
    	//if(multi.getParameter("user_id").equals("")) 		return false;
    	
    	
    	
    	

    	//////////////////////////////////////////////////////////////////////////////////
    	//���� Ȯ�� ������/////////////////////////////////////////////////////////////////////
    	//////////////////////////////////////////////////////////////////////////////////
    	
    	
    	
    	
    	
    	
    	
    	//������ ���
    	List_Data_Bean ldata = new List_Data_Bean();
    	ldata.setCategory(Integer.parseInt(multi.getParameter("category")));
    	ldata.setName(multi.getParameter("name"));
    	ldata.setMoney(Integer.parseInt(multi.getParameter("money")));
    	ldata.setDiscount(Integer.parseInt(multi.getParameter("discount")));
    	ldata.setMade(multi.getParameter("made"));
    	ldata.setShip_money(Integer.parseInt(multi.getParameter("ship_money")));
    	ldata.setShip_company(multi.getParameter("ship_company"));
    	ldata.setFile1(filename1);
    	ldata.setFile2(filename2);
    	ldata.setFile3(filename3);
    	ldata.setFile4(filename4);
    	ldata.setFile5(filename5);
    	ldata.setMemo(multi.getParameter("memo"));
    	//ldata.setUser_no(Integer.parseInt(multi.getParameter("user_no")));
    	ldata.setDates(date);
    	
    	//���ΰ��� ���
    	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
    	ldata.setRmoney(rmoney);
    	ldata.setSeller(Integer.parseInt(multi.getParameter("seller")));
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
			conn = getConnection();
				
			pstmt = conn.prepareStatement("insert into MIN_TSHOP_LIST(CATEGORY,NAME,MONEY,DISCOUNT,MADE,SHIP_MONEY,SHIP_COMPANY,FILE1,FILE2,FILE3,FILE4,FILE5,MEMO,USER_NO,HIT,BUY,DATES,RMONEY,SELLERS)"
						+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, ldata.getCategory());
			pstmt.setString(2, ldata.getName());
			pstmt.setInt(3, ldata.getMoney());
			pstmt.setInt(4, ldata.getDiscount());
			pstmt.setString(5, ldata.getMade());
			pstmt.setInt(6, ldata.getShip_money());
			pstmt.setString(7, ldata.getShip_company());
			pstmt.setString(8, ldata.getFile1());
			pstmt.setString(9, ldata.getFile2());
			pstmt.setString(10, ldata.getFile3());
			pstmt.setString(11, ldata.getFile4());
			pstmt.setString(12, ldata.getFile5());
			pstmt.setString(13, ldata.getMemo());
			pstmt.setInt(14, ldata.getUser_no());
			pstmt.setInt(15, ldata.getHit());
			pstmt.setInt(16, ldata.getBuy());
			pstmt.setString(17, ldata.getDates());
			pstmt.setInt(18, ldata.getRmoney());
			pstmt.setInt(19, ldata.getSeller());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    	
    	return true;
    }
    
    //���� �� ��������(���۹�ȣ, ����ȣ, �˻�ī�װ�, �˻���, �������, Ư���Ǹ���(-1�̸� ��ü)) mypage���� ���°�
    public List getArticles(int start, int end, int searchs, String searchs_value, int length, int seller) {
    	List list = new ArrayList();
    	
    	
    	//�˻�
    	String wheres = " ";
    	if(searchs == -1) {
    		wheres = "where NAME like '%"+searchs_value+"%' ";
    		
    	}else {
    		wheres = "where CATEGORY="+searchs+" and NAME like '%"+searchs_value+"%' ";
    	}
    	if(seller != -1) wheres += " and SELLERS="+seller;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_LIST "+wheres+" order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			int cnt = 1;	//ī��Ʈ ������
			while(rs.next()) {
				List_Data_Bean bdb = new List_Data_Bean();
				bdb.setNo(rs.getInt("NO"));
				bdb.setCategory(Integer.parseInt(rs.getString("CATEGORY")));
				bdb.setName(rs.getString("NAME"));
				bdb.setMoney(rs.getInt("MONEY"));
				bdb.setDiscount(rs.getInt("DISCOUNT"));
				bdb.setMade(rs.getString("MADE"));
				bdb.setShip_money(rs.getInt("SHIP_MONEY"));
				bdb.setShip_company(rs.getString("SHIP_COMPANY"));
				bdb.setFile1(rs.getString("FILE1"));
				bdb.setFile2(rs.getString("FILE2"));
				bdb.setFile3(rs.getString("FILE3"));
				bdb.setFile4(rs.getString("FILE4"));
				bdb.setFile5(rs.getString("FILE5"));
				bdb.setUser_no(rs.getInt("USER_NO"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setBuy(rs.getInt("BUY"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setRmoney(rs.getInt("RMONEY"));
				bdb.setCnt(cnt);
				bdb.setSeller(rs.getInt("SELLERS"));
				//5�϶� 1�� �ʱ�ȭ
				if(cnt == 5) cnt = 0;
				cnt++;
				
				//���αݾ� ����
				bdb.setDiscount_money(bdb.getMoney()-bdb.getRmoney());

				//��ȭ ����
				bdb.setRmoneys(number_format(bdb.getRmoney()));
				bdb.setMoneys(number_format(bdb.getMoney()));
				bdb.setShip_moneys(number_format(bdb.getShip_money()));
				bdb.setDiscount_moneys(number_format(bdb.getDiscount_money()));
				
				//������ڼ�
				if(bdb.getName().length() > length) 
					bdb.setName(bdb.getName().substring(0, length));
				
				list.add(bdb);
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
    //���� �� ��������(���۹�ȣ, ����ȣ, �˻�ī�װ�, �˻���, �������, Ư���Ǹ���(-1�̸� ��ü), order�� 1 2 3 �� �ϳ�(����Ʈ,��õ,������))	list���� ���°� 
    public List getArticles(int start, int end, int searchs, String searchs_value, int length, int seller, int order) {
    	List list = new ArrayList();
    	
    	
    	//�˻�
    	String wheres = " ";
    	if(searchs == -1) {
    		wheres = "where NAME like '%"+searchs_value+"%' ";
    		
    	}else {
    		wheres = "where CATEGORY="+searchs+" and NAME like '%"+searchs_value+"%' ";
    	}
    	if(seller != -1) wheres += " and SELLERS="+seller;

    	//�⺻����
    	String orderbys = " order by NO desc";
    	
    	
    	if(order == 1) {
    		wheres += " and BUY>=10";		//�α� ����Ʈ����
    		orderbys = " order by BUY desc";
    	}
    	if(order == 2) {
    		wheres += " and HIT>=10";		//��õ
    		orderbys = " order by HIT desc";
    	}
    	if(order == 3) {
    		wheres += " and SHIP_MONEY=0";	//������
    	}
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TSHOP_LIST "+wheres+" "+orderbys+") a) where rnum>=? and rnum<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			int cnt = 1;	//ī��Ʈ ������
			while(rs.next()) {
				List_Data_Bean bdb = new List_Data_Bean();
				bdb.setNo(rs.getInt("NO"));
				bdb.setCategory(Integer.parseInt(rs.getString("CATEGORY")));
				bdb.setName(rs.getString("NAME"));
				bdb.setMoney(rs.getInt("MONEY"));
				bdb.setDiscount(rs.getInt("DISCOUNT"));
				bdb.setMade(rs.getString("MADE"));
				bdb.setShip_money(rs.getInt("SHIP_MONEY"));
				bdb.setShip_company(rs.getString("SHIP_COMPANY"));
				bdb.setFile1(rs.getString("FILE1"));
				bdb.setFile2(rs.getString("FILE2"));
				bdb.setFile3(rs.getString("FILE3"));
				bdb.setFile4(rs.getString("FILE4"));
				bdb.setFile5(rs.getString("FILE5"));
				bdb.setUser_no(rs.getInt("USER_NO"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setBuy(rs.getInt("BUY"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setRmoney(rs.getInt("RMONEY"));
				bdb.setCnt(cnt);
				bdb.setSeller(rs.getInt("SELLERS"));
				//5�϶� 1�� �ʱ�ȭ
				if(cnt == 5) cnt = 0;
				cnt++;
				
				//���αݾ� ����
				bdb.setDiscount_money(bdb.getMoney()-bdb.getRmoney());

				//��ȭ ����
				bdb.setRmoneys(number_format(bdb.getRmoney()));
				bdb.setMoneys(number_format(bdb.getMoney()));
				bdb.setShip_moneys(number_format(bdb.getShip_money()));
				bdb.setDiscount_moneys(number_format(bdb.getDiscount_money()));
				
				//������ڼ�
				if(bdb.getName().length() > length) 
					bdb.setName(bdb.getName().substring(0, length));
				
				list.add(bdb);
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
    
    
    //�˻��� ī��Ʈ mypage���� ���°�
    public int getCount(int searchs, String searchs_value, int seller) {
    	
    	
    	//�˻�
    	String wheres = " ";
    	if(searchs == -1) {
    		wheres = "where NAME like '%"+searchs_value+"%' ";
    		 
    	}else {
    		wheres = "where CATEGORY="+searchs+" and NAME like '%"+searchs_value+"%' ";
    		
    	}
    	if(seller != -1) wheres += " and SELLERS="+seller;
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_LIST "+wheres);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
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
    	
    	return 0;
    }

    //�˻��� ī��Ʈ list���� ���°� order�߰���
    public int getCount(int searchs, String searchs_value, int seller, int order) {
    	
    	
    	//�˻�
    	String wheres = " ";
    	if(searchs == -1) {
    		wheres = "where NAME like '%"+searchs_value+"%' ";
    		 
    	}else {
    		wheres = "where CATEGORY="+searchs+" and NAME like '%"+searchs_value+"%' ";
    		
    	}
    	if(seller != -1) wheres += " and SELLERS="+seller;
    	
    	if(order == 1) wheres += " and BUY>=10";		//�α� ����Ʈ����
    	if(order == 2) wheres += " and HIT>=10";		//��õ
    	if(order == 3) wheres += " and SHIP_MONEY=0";	//������
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TSHOP_LIST "+wheres);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
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
    	
    	return 0;
    }
    //�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
    //�� �� ��������
    public List_Data_Bean getArticle(int no) {
		List_Data_Bean bdb = new List_Data_Bean();
		
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TSHOP_LIST where NO=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bdb.setNo(rs.getInt("NO"));
				bdb.setCategory(Integer.parseInt(rs.getString("CATEGORY")));
				bdb.setName(rs.getString("NAME"));
				bdb.setMoney(rs.getInt("MONEY"));
				bdb.setDiscount(rs.getInt("DISCOUNT"));
				bdb.setMade(rs.getString("MADE"));
				bdb.setShip_money(rs.getInt("SHIP_MONEY"));
				bdb.setShip_company(rs.getString("SHIP_COMPANY"));
				bdb.setFile1(rs.getString("FILE1"));
				bdb.setFile2(rs.getString("FILE2"));
				bdb.setFile3(rs.getString("FILE3"));
				bdb.setFile4(rs.getString("FILE4"));
				bdb.setFile5(rs.getString("FILE5"));
				bdb.setMemo(rs.getString("MEMO"));
				bdb.setUser_no(rs.getInt("USER_NO"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setBuy(rs.getInt("BUY"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setRmoney(rs.getInt("RMONEY"));
				bdb.setSeller(rs.getInt("SELLERS"));
				

				//���αݾ� ����
				bdb.setDiscount_money(bdb.getMoney()-bdb.getRmoney());
				

				//��ȭ ����
				bdb.setRmoneys(number_format(bdb.getRmoney()));
				bdb.setMoneys(number_format(bdb.getMoney()));
				bdb.setShip_moneys(number_format(bdb.getShip_money()));
				bdb.setDiscount_moneys(number_format(bdb.getDiscount_money()));
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

		return bdb;
    }
    
    
    
    //�����ϱ�
    public boolean delete(int no, Member_Data_Bean mdata) {
    	List_Data_Bean ldata = getArticle(no);	//�Խñ����� ��������
    	
    	//�Խñ� ������ �ƴϸ� ����
    	if(ldata.getSeller() != mdata.getNo())
    		return false;
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("delete from MIN_TSHOP_LIST where NO=?");
			pstmt.setInt(1, ldata.getNo());
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
    
    
    
    
    
    
    
    
    

      //������ ���� (���н� false ����)
      public boolean update(HttpServletRequest request, HttpSession session) {
      	
      	
      	
      	
      	MultipartRequest multi = null;
      	String savePaths=request.getRealPath(savePathd);	//������ġ ������
      	int sizeLimit = 30 * 1024 * 1024;						 	//30�ް� ����
      	String filename1 = null;	//file1�̸�
      	String filename2 = null;	//file2�̸�
      	String filename3 = null;	//file3�̸�
      	String filename4 = null;	//file4�̸�
      	String filename5 = null;	//file5�̸�
      	
      	

  		//��¥ ��������
  		Calendar cal = Calendar.getInstance();
  		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

      	
      	try{
      		//request
      		multi=new MultipartRequest(request, savePaths, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());

      		filename1 = multi.getFilesystemName("file1");	//����1�̸�
      		filename2 = multi.getFilesystemName("file2");	//����2�̸�
      		filename3 = multi.getFilesystemName("file3");	//����2�̸�
      		filename4 = multi.getFilesystemName("file4");	//����2�̸�
      		filename5 = multi.getFilesystemName("file5");	//����2�̸�
      		
      		//����1�̸� �����۾�
      		if(filename1 != null) {
      			int cnt = 1;
      			File file1 = null;
      			
      			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
      			do {
      				filename1 = multi.getFilesystemName("file1");
  	        		file1 = multi.getFile("file1");
  	        		filename1 = date+"_"+cnt+"_"+filename1;
  	        		cnt++;
      			}while(!file1.renameTo(new File(savePaths+"/"+filename1)));
      		}

      		//����2�̸� �����۾�
      		if(filename2 != null) {
      			int cnt = 1;
      			File file2 = null;
      			
      			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
      			do {
      				filename2 = multi.getFilesystemName("file2");
  	        		file2 = multi.getFile("file2");
  	        		filename2 = date+"_"+cnt+"_"+filename2;
  	        		cnt++;
      			}while(!file2.renameTo(new File(savePaths+"/"+filename2)));
      		}
      		

      		//����3�̸� �����۾�
      		if(filename3 != null) {
      			int cnt = 1;
      			File file3 = null;
      			
      			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
      			do {
      				filename3 = multi.getFilesystemName("file3");
  	        		file3 = multi.getFile("file3");
  	        		filename3 = date+"_"+cnt+"_"+filename3;
  	        		cnt++;
      			}while(!file3.renameTo(new File(savePaths+"/"+filename3)));
      		}
      		

      		//����2�̸� �����۾�
      		if(filename4 != null) {
      			int cnt = 1;
      			File file4 = null;
      			
      			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
      			do {
      				filename4 = multi.getFilesystemName("file4");
  	        		file4 = multi.getFile("file4");
  	        		filename4 = date+"_"+cnt+"_"+filename4;
  	        		cnt++;
      			}while(!file4.renameTo(new File(savePaths+"/"+filename4)));
      		}
      		

      		//����2�̸� �����۾�
      		if(filename5 != null) {
      			int cnt = 1;
      			File file5 = null;
      			
      			//�̹� ������ ���ϸ��̸� ī��Ʈ 1�� �߰�
      			do {
      				filename5 = multi.getFilesystemName("file5");
  	        		file5 = multi.getFile("file5");
  	        		filename5 = date+"_"+cnt+"_"+filename5;
  	        		cnt++;
      			}while(!file5.renameTo(new File(savePaths+"/"+filename5)));
      		}
      		
      	} catch(Exception e) {
      		//������ �ʰ�
      		if(e.getMessage().indexOf("exceeds limit") > -1) return false;
      	}
      	
      	
      	

      	
      	
      	
      	
      	
      	
      	//null�϶�
      	if(multi.getParameter("no") == null)			return false;
      	if(multi.getParameter("category") == null)		return false;
      	if(multi.getParameter("name") == null)			return false;
      	if(multi.getParameter("money") == null) 		return false;
      	if(multi.getParameter("discount") == null)  	return false;
      	if(multi.getParameter("made") == null) 			return false;
      	if(multi.getParameter("ship_money") == null) 	return false;
      	if(multi.getParameter("ship_company") == null) 	return false;
      	if(multi.getParameter("seller") == null) 		return false;
      	//if(multi.getParameter("user_id") == null) 		return false;

      	//�����϶�
      	if(multi.getParameter("no").equals(""))				return false;
      	if(multi.getParameter("category").equals(""))		return false;
      	if(multi.getParameter("name").equals(""))			return false;
      	if(multi.getParameter("money").equals("")) 			return false;
      	if(multi.getParameter("discount").equals(""))  		return false;
      	if(multi.getParameter("made").equals("")) 			return false;
      	if(multi.getParameter("ship_money").equals("")) 	return false;
      	if(multi.getParameter("ship_company").equals("")) 	return false;
      	if(multi.getParameter("seller").equals("")) 		return false;
      	//if(multi.getParameter("user_id").equals("")) 		return false;
      	
      	
      	
      	

      	//////////////////////////////////////////////////////////////////////////////////
      	//���� Ȯ�� ������/////////////////////////////////////////////////////////////////////
      	//////////////////////////////////////////////////////////////////////////////////

      	
      	
      	
      	
      	
      	
      	//������ ���
      	List_Data_Bean ldata = new List_Data_Bean();
      	ldata.setNo(Integer.parseInt(multi.getParameter("no")));
      	ldata.setCategory(Integer.parseInt(multi.getParameter("category")));
      	ldata.setName(multi.getParameter("name"));
      	ldata.setMoney(Integer.parseInt(multi.getParameter("money")));
      	ldata.setDiscount(Integer.parseInt(multi.getParameter("discount")));
      	ldata.setMade(multi.getParameter("made"));
      	ldata.setShip_money(Integer.parseInt(multi.getParameter("ship_money")));
      	ldata.setShip_company(multi.getParameter("ship_company"));
      	ldata.setFile1(filename1);
      	ldata.setFile2(filename2);
      	ldata.setFile3(filename3);
      	ldata.setFile4(filename4);
      	ldata.setFile5(filename5);
      	ldata.setMemo(multi.getParameter("memo"));
      	//ldata.setUser_no(Integer.parseInt(multi.getParameter("user_no")));
      	ldata.setDates(date);
      	
      	//���ΰ��� ���
      	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
      	ldata.setRmoney(rmoney);
      	ldata.setSeller(Integer.parseInt(multi.getParameter("seller")));
      	
      	
      	Member_Data_Bean mdata = (Member_Data_Bean)request.getAttribute("member_info");

      	//�Խñ� ������ �ƴϸ� ����
    	if(ldata.getSeller() != mdata.getNo())
    		return false;
    	
    	
    	String file_tmp1 = "";
    	String file_tmp2 = "";
    	String file_tmp3 = "";
    	String file_tmp4 = "";
    	String file_tmp5 = "";
    	
    	//���� ��ɽ�
    	if(multi.getParameter("file_del1") != null) file_tmp1 = ",FILE1=''";
    	if(multi.getParameter("file_del2") != null) file_tmp2 = ",FILE2=''";
    	if(multi.getParameter("file_del3") != null) file_tmp3 = ",FILE3=''";
    	if(multi.getParameter("file_del4") != null) file_tmp4 = ",FILE4=''";
    	if(multi.getParameter("file_del5") != null) file_tmp5 = ",FILE5=''";
    	
    	
    	//file1�� �����ϸ� �Է�
    	if(filename1 != null) file_tmp1 = ",FILE1='"+filename1+"'";
    	if(filename2 != null) file_tmp2 = ",FILE2='"+filename2+"'";
    	if(filename3 != null) file_tmp3 = ",FILE3='"+filename3+"'";
    	if(filename4 != null) file_tmp4 = ",FILE4='"+filename4+"'";
    	if(filename5 != null) file_tmp5 = ",FILE5='"+filename5+"'";
      	
      	
      	
      	
      	Connection conn = null;
      	PreparedStatement pstmt = null;
      	try {
  			conn = getConnection();
  				
  			pstmt = conn.prepareStatement("update MIN_TSHOP_LIST set "
  					+ "CATEGORY=?,"
  					+ "NAME=?,"
  					+ "MONEY=?,"
  					+ "DISCOUNT=?,"
  					+ "MADE=?,"
  					+ "SHIP_MONEY=?,"
  					+ "SHIP_COMPANY=?,"
  					+ "MEMO=?,"
  					+ "RMONEY=?"
  					+ file_tmp1
  					+ file_tmp2
  					+ file_tmp3
  					+ file_tmp4
  					+ file_tmp5
  					+ " where NO=?");
  			pstmt.setInt(1, ldata.getCategory());
  			pstmt.setString(2, ldata.getName());
  			pstmt.setInt(3, ldata.getMoney());
  			pstmt.setInt(4, ldata.getDiscount());
  			pstmt.setString(5, ldata.getMade());
  			pstmt.setInt(6, ldata.getShip_money());
  			pstmt.setString(7, ldata.getShip_company());
  			pstmt.setString(8, ldata.getMemo());
  			pstmt.setInt(9, ldata.getRmoney());
  			pstmt.setInt(10, ldata.getNo());
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

      //buy ī��Ʈ�� �߰��ϱ�
      public boolean addBuy(int no) {
    	//no�� �ش��ϴ� �����͸� �����ͼ�
    	List_Data_Bean bdata = getArticle(no);
  		
    	//ī��Ʈ�߰�
    	bdata.setBuy(bdata.getBuy() + 1);
    	
      	Connection conn = null;
      	PreparedStatement pstmt = null;
      	
      	try {
  			conn = getConnection();
  			pstmt = conn.prepareStatement("update MIN_TSHOP_LIST set BUY=? where NO=?");
  			pstmt.setInt(1, bdata.getBuy());
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

      //hit ī��Ʈ�� �߰��ϱ�
      public boolean addHit(int no) {
    	//no�� �ش��ϴ� �����͸� �����ͼ�
    	List_Data_Bean bdata = getArticle(no);
  		
    	//ī��Ʈ�߰�
    	bdata.setHit(bdata.getHit() + 1);
    	
      	Connection conn = null;
      	PreparedStatement pstmt = null;
      	
      	try {
  			conn = getConnection();
  			pstmt = conn.prepareStatement("update MIN_TSHOP_LIST set HIT=? where NO=?");
  			pstmt.setInt(1, bdata.getHit());
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
}
