package board2;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Board_DB_Bean {
	public static String savePath = "/board2/upload/";	//�������� �����
	private static Board_DB_Bean instance = new Board_DB_Bean();
    public static Board_DB_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    //������ ���� (���н� false ����)
    public boolean insert(HttpServletRequest request, HttpSession session) {
    	
    	
    	
    	
    	MultipartRequest multi = null;
    	String savePaths=request.getRealPath(savePath);	//������ġ ������
    	int sizeLimit = 10 * 1024 * 1024;						 	//10�ް� ����
    	String filename1 = null;	//file1�̸�
    	String filename2 = null;	//file2�̸�
    	

		//��¥ ��������
		Calendar cal = Calendar.getInstance();
		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

    	
    	try{
    		//request
    		multi=new MultipartRequest(request, savePaths, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());

    		filename1 = multi.getFilesystemName("file1");	//����1�̸�
    		filename2 = multi.getFilesystemName("file2");	//����2�̸�
    		
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
    		
    	} catch(Exception e) {
    		//������ �ʰ�
    		if(e.getMessage().indexOf("exceeds limit") > -1) return false;
    	}
    	
    	
    	
    	
    	

    	//���� �Խ��� ���� Ȯ��
    	Admin_DB_Bean admin_manager = Admin_DB_Bean.getInstance();
    	Admin_Data_Bean adata = admin_manager.getArticle(multi.getParameter("id"));
    	int lev = adata.getLev();
    	int lev2 = 1;	//1:��ȸ�� 2:ȸ�� 3:������ 4:�Խ��Ǿƴ�
    	
    	//�α����� ���� Ȯ��
    	Member_Data_Bean member_info = null;
    	if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
    		Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
    		member_info = mem_db.login_info((String)session.getAttribute("user_id"), (String)session.getAttribute("user_pw"));
    		lev2 = member_info.getLev();
    	}
    	
    	if(lev > lev2) return false; 
    	
    	
    	
    	
    	
    	
    	//null�϶�
    	if(multi.getParameter("subject") == null)	return false;
    	if(multi.getParameter("subject") == null)	return false;
    	if(multi.getParameter("name") == null) 		return false;
    	if(multi.getParameter("passwords") == null) return false;
    	if(multi.getParameter("memo") == null) 		return false;

    	//�����϶�
    	if(multi.getParameter("subject").equals(""))	return false;
    	if(multi.getParameter("name").equals("")) 		return false;
    	if(multi.getParameter("passwords").equals("")) 	return false;
    	if(multi.getParameter("memo").equals("")) 		return false;
    	
    	//������ ���
    	Board_Data_Bean bdb = new Board_Data_Bean();
    	bdb.setSubject(multi.getParameter("subject"));
    	bdb.setName(multi.getParameter("name"));
    	bdb.setPasswords(multi.getParameter("passwords"));
    	bdb.setMemo(multi.getParameter("memo"));
    	bdb.setId(multi.getParameter("id"));
    	bdb.setRt_no(Integer.parseInt(multi.getParameter("rt_no")));
    	bdb.setFile1(filename1);
    	bdb.setFile2(filename2);
    	
    	//��ȣȭ
    	bdb.setPasswords(Md5Enc.getEncMD5(bdb.getPasswords().getBytes()));
    	
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	try {
			conn = getConnection();
			
			if(bdb.getRt_no() == 1) {
				pstmt = conn.prepareStatement("insert into MIN_TBOARD_DATA(SUBJECT, MEMO, NAME, PASSWORD, DATES, HIT, ID, COMMENTS, FILE1, FILE2)"
							+" values(?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1, bdb.getSubject());
				pstmt.setString(2, bdb.getMemo());
				pstmt.setString(3, bdb.getName());
				pstmt.setString(4, bdb.getPasswords());
				pstmt.setString(5, date);
				pstmt.setInt(6, 0);
				pstmt.setString(7, bdb.getId());
				pstmt.setInt(8, 0);
				pstmt.setString(9, bdb.getFile1());
				pstmt.setString(10, bdb.getFile2());
				pstmt.executeUpdate();
			}else {
				pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where rt_no=? order by no asc");
				pstmt.setInt(1, bdb.getRt_no());
				rs = pstmt.executeQuery();
				
				int rt_no_count = bdb.getRt_no();	//����� ������ ����no
				
				if(rs.next()) 
					rt_no_count = rs.getInt("NO");	//���� �������� �ִ� ����� �޾ƿ�
				rt_no_count--;
				
				pstmt = conn.prepareStatement("insert into MIN_TBOARD_DATA(NO, SUBJECT, MEMO, NAME, PASSWORD, DATES, HIT, ID, COMMENTS, RT_NO, FILE1, FILE2)"
						+" values(?,?,?,?,?,?,?,?,?,?,?,?)");
				pstmt.setInt(1, rt_no_count);
				pstmt.setString(2, bdb.getSubject());
				pstmt.setString(3, bdb.getMemo());
				pstmt.setString(4, bdb.getName());
				pstmt.setString(5, bdb.getPasswords());
				pstmt.setString(6, date);
				pstmt.setInt(7, 0);
				pstmt.setString(8, bdb.getId());
				pstmt.setInt(9, 0);
				pstmt.setInt(10, bdb.getRt_no());
				pstmt.setString(11, bdb.getFile1());
				pstmt.setString(12, bdb.getFile2());
				pstmt.executeUpdate();
			}
			
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
    public int getCount(String id) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_DATA where id=?");
			pstmt.setString(1, id);
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
    
    //�˻��� ī��Ʈ
    public int getCount(String id, String searchs, String searchs_value) {
    	//�˻�
    	String wheres = " ";
    	if(!searchs.equals("") && !searchs_value.equals("")) {
    		if(searchs.equals("subject_memo")) wheres = " and (subject like '%"+searchs_value+"%' or memo like '%"+searchs_value+"%') ";
    		else wheres = " and "+searchs+" like '%"+searchs_value+"%' ";
        }
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_DATA where id=?"+wheres);
			pstmt.setString(1, id);
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
    
    //���� �� ��������
    public List getArticles(int start, int end, String id, String searchs, String searchs_value) {
    	List list = new ArrayList();
    	
    	//�˻�
    	String wheres = " ";
    	if(!searchs.equals("") && !searchs_value.equals("")) {
    		if(searchs.equals("subject_memo")) wheres = " and (subject like '%"+searchs_value+"%' or memo like '%"+searchs_value+"%') ";
    		else wheres = " and "+searchs+" like '%"+searchs_value+"%' ";
        }
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			//pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where id=? order by NO desc");
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TBOARD_DATA where id=?"+wheres+"order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setString(1, id);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			//
			while(rs.next()) {
				Board_Data_Bean bdb = new Board_Data_Bean();
				bdb.setSubject(rs.getString("SUBJECT"));
				bdb.setName(rs.getString("NAME"));
				bdb.setPasswords(rs.getString("PASSWORD"));
				//bdb.setMemo(rs.getString("MEMO"));
				bdb.setId(rs.getString("ID"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setNo(rs.getInt("NO"));
				bdb.setComments(rs.getInt("COMMENTS"));
				bdb.setRt_no(rs.getInt("RT_NO"));
				bdb.setFile1(rs.getString("FILE1"));
				bdb.setFile2(rs.getString("FILE2"));
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
    
    //�� �� ��������
    public Board_Data_Bean getArticle(int no) {
    	Board_Data_Bean bdb = new Board_Data_Bean();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where no=? order by NO desc");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bdb.setSubject(rs.getString("SUBJECT"));
				bdb.setName(rs.getString("NAME"));
				bdb.setPasswords(rs.getString("PASSWORD"));
				bdb.setMemo(rs.getString("MEMO"));
				bdb.setId(rs.getString("ID"));
				bdb.setHit(rs.getInt("HIT"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setNo(rs.getInt("NO"));
				bdb.setRt_no(rs.getInt("RT_NO"));
				bdb.setFile1(rs.getString("FILE1"));
				bdb.setFile2(rs.getString("FILE2"));
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
    
    //��ȸ��ī��Ʈ �߰�
    public void updateHit(int no) {
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		
		try {
			conn = getConnection();
			

	    	//��ȸ��ī��Ʈ ���� ��������
			pstmt = conn.prepareStatement("select HIT from MIN_TBOARD_DATA where NO=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			int hit = 0;
			if(rs.next()) 
				hit = rs.getInt(1);
			
			
			//��ȸ��ī��Ʈ +1
			hit++;
			
			//����
			pstmt = conn.prepareStatement("update MIN_TBOARD_DATA set HIT=? where NO=?");
			pstmt.setInt(1, hit);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    }
    
    //���ī��Ʈ ����
    public void updateComment(int no) {
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		
		try {
			conn = getConnection();
			

	    	//���ī��Ʈ ���� ��������
			pstmt = conn.prepareStatement("select count(*) from MIN_TBOARD_COMMENT where data_no=?");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			int comments = 0;
			if(rs.next()) 
				comments = rs.getInt(1);
			
			
			
			//����
			pstmt = conn.prepareStatement("update MIN_TBOARD_DATA set COMMENTS=? where NO=?");
			pstmt.setInt(1, comments);
			pstmt.setInt(2, no);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {}
		}
    }
    
    //�����ϱ�
    public boolean delete(int no, String passwords) {
    	Board_Data_Bean bdata = getArticle(no);	//�Խñ����� ��������
    	
    	//��й�ȣ�� �ٸ��� ����
    	if(!bdata.getPasswords().equals(passwords))
    		return false;
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			//��¥ ��������
			Calendar cal = Calendar.getInstance();
			String date = cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE);

			pstmt = conn.prepareStatement("delete from MIN_TBOARD_DATA where no=?");
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
    
    //�����ϱ�
    public boolean update(HttpServletRequest request) {
    	MultipartRequest multi = null;
    	String savePaths=request.getRealPath(savePath);	//������ġ ������
    	int sizeLimit = 10 * 1024 * 1024;						 	//10�ް� ����
    	String filename1 = null;	//file1�̸�
    	String filename2 = null;	//file2�̸�
    	

		//��¥ ��������
		Calendar cal = Calendar.getInstance();
		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

    	
    	try{
    		//request
    		multi=new MultipartRequest(request, savePaths, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());

    		filename1 = multi.getFilesystemName("file1");	//����1�̸�
    		filename2 = multi.getFilesystemName("file2");	//����2�̸�
    		
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
    		
    	} catch(Exception e) {
    		//������ �ʰ�
    		if(e.getMessage().indexOf("exceeds limit") > -1) return false;
    	}
    	
    	
    	
    	
    	
    	
    	//null�϶�
    	if(multi.getParameter("subject") == null)	return false;
    	if(multi.getParameter("name") == null) 		return false;
    	if(multi.getParameter("passwords") == null) return false;
    	if(multi.getParameter("memo") == null) 		return false;

    	//�����϶�
    	if(multi.getParameter("subject").equals(""))	return false;
    	if(multi.getParameter("name").equals("")) 		return false;
    	if(multi.getParameter("passwords").equals("")) 	return false;
    	if(multi.getParameter("memo").equals("")) 		return false;
    	
    	//������ ���
    	Board_Data_Bean bdb = new Board_Data_Bean();
    	bdb.setSubject(multi.getParameter("subject"));
    	bdb.setName(multi.getParameter("name"));
    	bdb.setPasswords(multi.getParameter("passwords"));
    	bdb.setMemo(multi.getParameter("memo"));
    	bdb.setFile1(filename1);
    	bdb.setFile2(filename2);
    	bdb.setNo(Integer.parseInt(multi.getParameter("no")));
    	
    	//��ȣȭ
    	bdb.setPasswords(Md5Enc.getEncMD5(bdb.getPasswords().getBytes()));
    	
    	
    	
    	
    	Board_Data_Bean bdata = getArticle(bdb.getNo());	//�Խñ����� ��������
    	
    	//��й�ȣ�� �ٸ��� ����
    	if(!bdata.getPasswords().equals(bdb.getPasswords()))
    		return false;

    	
    	String file_tmp1 = "";
    	String file_tmp2 = "";
    	
    	//���� ��ɽ�
    	if(multi.getParameter("file1_del") != null) file_tmp1 = ",FILE1=''";
    	if(multi.getParameter("file2_del") != null) file_tmp2 = ",FILE2=''";
    	
    	
    	//file1�� �����ϸ�
    	if(filename1 != null) file_tmp1 = ",FILE1='"+filename1+"'";
    	

    	//file2�� �����ϸ�
    	if(filename2 != null) file_tmp2 = ",FILE2='"+filename2+"'";
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	
    	try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement("update MIN_TBOARD_DATA set SUBJECT=?,NAME=?,MEMO=?"+file_tmp1+file_tmp2+" where NO=?");
			pstmt.setString(1, bdb.getSubject());
			pstmt.setString(2, bdb.getName());
			pstmt.setString(3, bdb.getMemo());
			pstmt.setInt(4, bdb.getNo());
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

    
    
    //�ֱٰԽù�
    public List getArticles2(int start, int end) {
    	List list = new ArrayList();
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = getConnection();
			//pstmt = conn.prepareStatement("select * from MIN_TBOARD_DATA where id=? order by NO desc");ssssssssssssssssssssssssssss
			pstmt = conn.prepareStatement("select * from (select rownum as rnum,a.* from (select * from MIN_TBOARD_DATA order by NO desc) a) where rnum>=? and rnum<=?");
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			//
			while(rs.next()) {
				Board_Data_Bean bdb = new Board_Data_Bean();
				
				
				//Ÿ��Ʋ ��������
				Connection conn2 = null;
		    	PreparedStatement pstmt2 = null;
		    	ResultSet rs2 = null;
		    	
		    	conn2 = getConnection();
		    	
		    	pstmt2 = conn2.prepareStatement("select * from MIN_TADMIN where id=?");
				pstmt2.setString(1, rs.getString("ID"));
				rs2 = pstmt2.executeQuery();
				if(rs2.next()) bdb.setName(rs2.getString("TITLE"));

				rs2.close();///////////////////////////////////////////////////////////
				pstmt2.close();
				conn2.close();
				
				bdb.setSubject(rs.getString("SUBJECT"));
				bdb.setDates(rs.getString("DATES"));
				bdb.setId(rs.getString("ID"));
				bdb.setNo(rs.getInt("NO"));
				bdb.setComments(rs.getInt("COMMENTS"));
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
}
