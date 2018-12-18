package net.myshop.service;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.myshop.dao.List_DB;
import net.myshop.data.List_Data_Bean;
import net.myshop.dao.Cookies;

@Service
public class Cookie_Bean implements Cookies {
	@Autowired
	List_DB list_DB_Bean;
    
    
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
    
    //�Խ��� ��ȸ�� �ߺ�����
    public void view_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	List_DB manager = list_DB_Bean;

    	//�ѹ� ��ȸ�ߴٴ� ��Ű�Է�
    	String cookieName = "min_tshop_hit";		//��Ű�̸�
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
    		
    		manager.addHit_M(no);		//��ȸ���߰�
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

        		manager.addHit_M(no);		//��ȸ���߰�
    		}
    	}
    }
    
    
    
    //�ֱٺ��Խñ� ���
    public void viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	String cookieName = "min_tshop_viewed";		//��Ű�̸�
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
    	
    	String cookieName = "min_tshop_viewed";		//��Ű�̸�
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
    	String cookieName = "min_tshop_viewed";		//��Ű�̸�
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
	@Override
	public Map interceptors(HttpServletRequest request, HttpServletResponse response) {
		//�ֱٺ��Խñ�
		List_DB ldb_tmp = list_DB_Bean;
		List viewedListAll = get_viewed_cookie(request, response);	//�ϴ� ��Ű���� �ް�
		
		//�ֱٺ��Խñ��� �����ϴ� �Խñ����� Ȯ��
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			int no = Integer.parseInt((String)viewedListAll.get(i));
			boolean isexist = ldb_tmp.existArticle_M(no);					//�����ϴ��� Ȯ��
				if(!isexist) del_viewed_cookie(no, request, response);	//�������� ������ ��Ű���� ����
		}
		
		viewedListAll = get_viewed_cookie(request, response);		//��Ű���� �ٽ� �޴´�
		
		List viewedList = new ArrayList();
		if(viewedListAll.size() > 2) {
			viewedList.add(viewedListAll.get(viewedListAll.size()-2));
			viewedList.add(viewedListAll.get(viewedListAll.size()-1));
		}else viewedList = viewedListAll;
		
		List rviewedListAll;
		List rviewedList;
		int rviewed_count;
		
		rviewedListAll = new ArrayList();
		rviewedList = new ArrayList();
		
		//�ֱٺ��Խñ� ���
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle_M(Integer.parseInt((String)viewedListAll.get(i)));
			rviewedListAll.add(ldata);
		}
		for(int i=viewedList.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle_M(Integer.parseInt((String)viewedList.get(i)));
			rviewedList.add(ldata);
		}
		rviewed_count = rviewedListAll.size();
		
		Map map = new HashMap();
		map.put("rviewedListAll", rviewedListAll);
		map.put("rviewedList", rviewedList);
		map.put("rviewed_count", rviewed_count);
		return map;
	}
}
