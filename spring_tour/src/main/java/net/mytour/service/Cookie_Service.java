package net.mytour.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.Cookie_Dao;
import net.mytour.dao.List_Dao;

@Service
public class Cookie_Service implements Cookie_Dao {
	@Autowired
	List_Dao list_Service;
   
    //���̵� ��Ű���� �ҷ�����
    public String getId(HttpServletRequest request) {
    	String cookieName = "min_tour_user_id";	//��Ű�̸�
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
    	String cookieName = "min_tour_user_id";		//��Ű�̸�
    	Cookie cookie = new Cookie(cookieName,user_id);	//����Ű
		cookie.setMaxAge(60*60*24*30);					//30�� ����
		response.addCookie(cookie);						//��Ű�߰�
    }
    //���̵� ��Ű ����
    public void delId(HttpServletResponse response) {
    	String cookieName = "min_tour_user_id";		//��Ű�̸�
    	Cookie cookie = new Cookie(cookieName,"");	//����Ű
		cookie.setMaxAge(0);					//30�� ����
		response.addCookie(cookie);						//��Ű�߰�
    }
    
    
    //�Խ��� ��ȸ�� �ߺ�����
    public void view_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	//���� ������ ��ȸ�� ũ��
    	int hit = 0;
    	hit = list_Service.getHit(no);
    	hit++;

		

    	//�ѹ� ��ȸ�ߴٴ� ��Ű�Է�
    	String cookieName = "min_tour_hit";			//��Ű�̸�
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
    		Cookie cookie = new Cookie(cookieName,Integer.toString(no));		//����Ű
    		cookie.setMaxAge(60*60*24);						//24�ð� ����
    		response.addCookie(cookie);						//��Ű�߰�
    		
    		list_Service.setHit(no, hit);	//��ȸ�� �߰�
    	}else{				//��Ű�� �̹� ������ �����ſ� �߰�
    		String[] splt = cookies[pos].getValue().split("//");
    		boolean hasNo = false;							//�̹� �ִ� ��Ű�� ���� NO�� �ִ��� Ȯ��
    		for(int i=0;i<splt.length;i++)
    			if(splt[i].equals(Integer.toString(no))) {
    				hasNo = true;							//�̹� ������ true
    				break;
    			}
    		if(!hasNo) {									//��Ű�� �������� �������� �۵�
    			String tmp = cookies[pos].getValue()+"//"+no;	//�������� �߰�
    			Cookie cookie = new Cookie(cookieName,tmp);		//����Ű
    			cookie.setMaxAge(60*60*24);						//24�ð� ����
    			response.addCookie(cookie);						//��Ű�߰�

    			list_Service.setHit(no, hit);	//��ȸ�� �߰�
    		}
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
  //�ֱٺ��Խñ� ���
    public void viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	String cookieName = "min_tour_viewed";		//��Ű�̸�
    	Cookie[] cookies = request.getCookies();	//��Ű�� ��� �ް�
    	boolean hasCookie = false;					//��Ű�� ��������?
    	int pos = 0;
    	List list = new ArrayList();

    	//��Ű�ٷ���? �� ������
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//��Ű�� �����ϸ� true��
    			pos = i;							//��ġ ���
    			break;
    		}
    	}

    	if(!hasCookie) {	//��Ű�� �����ٸ� ���� ����
    		Cookie cookie = new Cookie(cookieName,Integer.toString(no));		//����Ű
    		cookie.setMaxAge(60*60*24);						//24�ð� ����
    		response.addCookie(cookie);						//��Ű�߰�
    		
    	}else{				//��Ű�� �̹� ������ �����ſ� �߰�
    		
    		//����Ʈ�� ã�ƿͼ�
    		String[] splt = cookies[pos].getValue().split("//");
    		for(int i=0;i<splt.length;i++) {
    			list.add(splt[i]);
    		}
    		//�̹� �����ϴ�no�� �ִٸ� ����
    		list.remove(Integer.toString(no));
    		//�̹� 10���̸� �����Ȱ� �ϳ� ���ֱ�
    		if(list.size() >= 10) list.remove(0);
    		//�׸��� ���� �߰�
    		list.add(Integer.toString(no));
    		
    		//������ ���ڿ��� ��ȯ
    		String tmp = "";
    		for(int i=0;i<list.size();i++) {
    			if(i != 0) tmp += "//";
    			tmp += list.get(i);
    		}
    		
    		//��Ű����
    		Cookie cookie = new Cookie(cookieName, tmp);	//����Ű
    		cookie.setMaxAge(60*60*24);						//24�ð� ����
    		response.addCookie(cookie);						//��Ű�߰�
    	}
    }
    //�ֱٺ��Խñ� ��� �ޱ�
    public List get_viewed_cookie(HttpServletRequest request, HttpServletResponse response) {
    	List list = new ArrayList();
    	
    	String cookieName = "min_tour_viewed";		//��Ű�̸�
    	Cookie[] cookies = request.getCookies();	//��Ű�� ��� �ް�
    	boolean hasCookie = false;					//��Ű�� ��������?
    	int pos = 0;

    	//��Ű�ٷ���? �� ������
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//��Ű�� �����ϸ� true��
    			pos = i;							//��ġ ���
    			break;
    		}
    	}

    	if(hasCookie) {
    		//����Ʈ�� ã�ƿͼ�
    		String[] splt = cookies[pos].getValue().split("//");
    		for(int i=0;i<splt.length;i++) {
    			list.add(splt[i]);
    		}
    	}
    	
    	return list;
    }
    //�ֱٺ��Խñ� ��� �ϳ� �����
    public void del_viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	String cookieName = "min_tour_viewed";		//��Ű�̸�
    	Cookie[] cookies = request.getCookies();	//��Ű�� ��� �ް�
    	boolean hasCookie = false;					//��Ű�� ��������?
    	int pos = 0;
    	List list = new ArrayList();

    	//��Ű�ٷ���? �� ������
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//��Ű�� �����ϸ� true��
    			pos = i;							//��ġ ���
    			break;
    		}
    	}

    	if(!hasCookie) {	//��Ű�� �����ٸ� ���� ����
    		Cookie cookie = new Cookie(cookieName,Integer.toString(no));		//����Ű
    		cookie.setMaxAge(60*60*24);						//24�ð� ����
    		response.addCookie(cookie);						//��Ű�߰�
    		
    	}else{				//��Ű�� �̹� ������ �����ſ� �߰�
    		
    		//����Ʈ�� ã�ƿͼ�
    		String[] splt = cookies[pos].getValue().split("//");
    		for(int i=0;i<splt.length;i++) {
    			list.add(splt[i]);
    		}
    		//�̹� �����ϴ�no�� �ִٸ� ����
    		list.remove(Integer.toString(no));
    		
    		//������ ���ڿ��� ��ȯ
    		String tmp = "";
    		for(int i=0;i<list.size();i++) {
    			if(i != 0) tmp += "//";
    			tmp += list.get(i);
    		}
    		
    		//��Ű����
    		Cookie cookie = new Cookie(cookieName, tmp);	//����Ű
    		cookie.setMaxAge(60*60*24);						//24�ð� ����
    		response.addCookie(cookie);						//��Ű�߰�
    	}
    }
    
}
