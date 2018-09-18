package shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cookie_Bean {
	private static Cookie_Bean instance = new Cookie_Bean();
    public static Cookie_Bean getInstance() {
        return instance;
    }
    
    private Connection getConnection() throws Exception {
    	String jdbcDriver = "jdbc:apache:commons:dbcp:/pool";        
    	return DriverManager.getConnection(jdbcDriver);
    }
    
    //���̵� ��Ű���� �ҷ�����
    public String getId(HttpServletRequest request) {
    	String cookieName = "min_tshop_user_id";	//��Ű�̸�
    	Cookie[] cookies = request.getCookies();	//��Ű�� ��� �ް�
    	boolean hasCookie = false;					//��Ű�� ��������?
    	int pos = 0;

    	//��Ű�� �����ϸ� ��ġ�� �˾Ƴ��� = pos
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//��Ű�� �����ϸ� true��
    			pos = i;							//��ġ ���
    			break;
    		}
    	}
    	
    	
    	//��Ű�� �������� ���鸮�� �ƴϸ� ���̵� ����
    	if(!hasCookie) return "";
    	else return cookies[pos].getValue();
    }
    //���̵� ��Ű�� ����
    public void setId(String user_id, HttpServletResponse response) {
    	String cookieName = "min_tshop_user_id";		//��Ű�̸�
    	Cookie cookie = new Cookie(cookieName,user_id);	//����Ű
		cookie.setMaxAge(60*60*24*30);					//30�� ����
		response.addCookie(cookie);						//��Ű�߰�
    }
    //���̵� ��Ű ����
    public void delId(HttpServletResponse response) {
    	String cookieName = "min_tshop_user_id";		//��Ű�̸�
    	Cookie cookie = new Cookie(cookieName,"");	//����Ű
		cookie.setMaxAge(0);					//30�� ����
		response.addCookie(cookie);						//��Ű�߰�
    }
    /*
    //�Խ��� ��ȸ�� �ߺ�����
    public void view_cookie(String no, HttpServletRequest request, HttpServletResponse response) {
    	Board_DB_Bean manager = Board_DB_Bean.getInstance();

    	//�ѹ� ��ȸ�ߴٴ� ��Ű�Է�
    	String cookieName = "min_tboard_hit";		//��Ű�̸�
    	Cookie[] cookies = request.getCookies();	//��Ű�� ��� �ް�
    	boolean hasCookie = false;					//��Ű�� ��������?
    	int pos = 0;

    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//��Ű�� �����ϸ� true��
    			pos = i;							//��ġ ���
    			break;
    		}
    	}

    	if(!hasCookie) {	//��Ű�� �����ٸ� ���� ����
    		Cookie cookie = new Cookie(cookieName,no);		//����Ű
    		cookie.setMaxAge(60*60*24);						//24�ð� ����
    		response.addCookie(cookie);						//��Ű�߰�
    		
    		manager.updateHit(Integer.parseInt(no));		//��ȸ���߰�
    	}else{				//��Ű�� �̹� ������ �����ſ� �߰�
    		String[] splt = cookies[pos].getValue().split("//");
    		boolean hasNo = false;							//�̹� �ִ� ��Ű�� ���� NO�� �ִ��� Ȯ��
    		for(int i=0;i<splt.length;i++)
    			if(splt[i].equals(no)) {
    				hasNo = true;							//�̹� ������ true
    				break;
    			}
    		if(!hasNo) {									//��Ű�� �������� �������� �۵�
    			String tmp = cookies[pos].getValue()+"//"+no;	//�������� �߰�
    			Cookie cookie = new Cookie(cookieName,tmp);		//����Ű
    			cookie.setMaxAge(60*60*24);						//24�ð� ����
    			response.addCookie(cookie);						//��Ű�߰�
    			
    			manager.updateHit(Integer.parseInt(no));		//��ȸ���߰�
    		}
    	}
    }*/

}
