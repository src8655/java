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
    
    
    //아이디 쿠키에서 불러오기
    public String getId(HttpServletRequest request) {
    	String cookieName = "min_tshop_user_id";	//쿠키이름
    	Cookie[] cookies = request.getCookies();	//쿠키를 모두 받고
    	boolean hasCookie = false;					//쿠키를 가졌는지?
    	int pos = 0;

    	//쿠키가 존재하면 위치를 알아내기 = pos
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//쿠키가 존재하면 true로
    			pos = i;							//위치 기억
    			break;
    		}
    	}
    	
    	
    	//쿠키가 없었으면 공백리턴 아니면 아이디 리턴
    	if(!hasCookie) return "";
    	else return cookies[pos].getValue();
    }
    //아이디 쿠키에 저장
    public void setId(String user_id, HttpServletResponse response) {
    	String cookieName = "min_tshop_user_id";		//쿠키이름
    	Cookie cookie = new Cookie(cookieName,user_id);	//새쿠키
		cookie.setMaxAge(60*60*24*30);					//30일 설정
		response.addCookie(cookie);						//쿠키추가
    }
    //아이디 쿠키 삭제
    public void delId(HttpServletResponse response) {
    	String cookieName = "min_tshop_user_id";		//쿠키이름
    	Cookie cookie = new Cookie(cookieName,"");	//새쿠키
		cookie.setMaxAge(0);					//30일 설정
		response.addCookie(cookie);						//쿠키추가
    }
    
    //게시판 조회수 중복방지
    public void view_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	List_DB manager = list_DB_Bean;

    	//한번 조회했다는 쿠키입력
    	String cookieName = "min_tshop_hit";		//쿠키이름
    	Cookie[] cookies = request.getCookies();	//쿠키를 모두 받고
    	boolean hasCookie = false;					//쿠키를 가졌는지?
    	int pos = 0;

    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//쿠키가 존재하면 true로
    			pos = i;							//위치 기억
    			break;
    		}
    	}

    	if(!hasCookie) {	//쿠키가 없었다면 새로 생성
    		Cookie cookie = new Cookie(cookieName,Integer.toString(no));		//새쿠키
    		cookie.setMaxAge(60*60*24);						//24시간 설정
    		response.addCookie(cookie);						//쿠키추가
    		
    		manager.addHit_M(no);		//조회수추가
    	}else{				//쿠키가 이미 있으면 기존거에 추가
    		String[] splt = cookies[pos].getValue().split("//");
    		boolean hasNo = false;							//이미 있는 쿠키에 현재 NO가 있는지 확인
    		for(int i=0;i<splt.length;i++)
    			if(splt[i].equals(Integer.toString(no))) {
    				hasNo = true;							//이미 있으면 true
    				break;
    			}
    		if(!hasNo) {									//쿠키에 존재하지 않을때만 작동
    			String tmp = cookies[pos].getValue()+"//"+no;	//기존에서 추가
    			Cookie cookie = new Cookie(cookieName,tmp);		//새쿠키
    			cookie.setMaxAge(60*60*24);						//24시간 설정
    			response.addCookie(cookie);						//쿠키추가

        		manager.addHit_M(no);		//조회수추가
    		}
    	}
    }
    
    
    
    //최근본게시글 기록
    public void viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	String cookieName = "min_tshop_viewed";		//쿠키이름
    	Cookie[] cookies = request.getCookies();	//쿠키를 모두 받고
    	boolean hasCookie = false;					//쿠키를 가졌는지?
    	int pos = 0;
    	List list = new ArrayList();

    	//쿠키꾸러미? 가 있을때
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//쿠키가 존재하면 true로
    			pos = i;							//위치 기억
    			break;
    		}
    	}

    	if(!hasCookie) {	//쿠키가 없었다면 새로 생성
    		Cookie cookie = new Cookie(cookieName,Integer.toString(no));		//새쿠키
    		cookie.setMaxAge(60*60*24);						//24시간 설정
    		response.addCookie(cookie);						//쿠키추가
    		
    	}else{				//쿠키가 이미 있으면 기존거에 추가
    		
    		//리스트로 찾아와서
    		String[] splt = cookies[pos].getValue().split("//");
    		for(int i=0;i<splt.length;i++) {
    			list.add(splt[i]);
    		}
    		//이미 존재하는no가 있다면 제거
    		list.remove(Integer.toString(no));
    		//이미 10개이면 오래된거 하나 없애기
    		if(list.size() >= 10) list.remove(0);
    		//그리고 새로 추가
    		list.add(Integer.toString(no));
    		
    		//한줄의 문자열로 변환
    		String tmp = "";
    		for(int i=0;i<list.size();i++) {
    			if(i != 0) tmp += "//";
    			tmp += list.get(i);
    		}
    		
    		//쿠키갱신
    		Cookie cookie = new Cookie(cookieName, tmp);	//새쿠키
    		cookie.setMaxAge(60*60*24);						//24시간 설정
    		response.addCookie(cookie);						//쿠키추가
    	}
    }
    //최근본게시글 기록 받기
    public List get_viewed_cookie(HttpServletRequest request, HttpServletResponse response) {
    	List list = new ArrayList();
    	
    	String cookieName = "min_tshop_viewed";		//쿠키이름
    	Cookie[] cookies = request.getCookies();	//쿠키를 모두 받고
    	boolean hasCookie = false;					//쿠키를 가졌는지?
    	int pos = 0;

    	//쿠키꾸러미? 가 있을때
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//쿠키가 존재하면 true로
    			pos = i;							//위치 기억
    			break;
    		}
    	}

    	if(hasCookie) {
    		//리스트로 찾아와서
    		String[] splt = cookies[pos].getValue().split("//");
    		for(int i=0;i<splt.length;i++) {
    			list.add(splt[i]);
    		}
    	}
    	
    	return list;
    }
    //최근본게시글 기록 하나 지우기
    public void del_viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response) {
    	String cookieName = "min_tshop_viewed";		//쿠키이름
    	Cookie[] cookies = request.getCookies();	//쿠키를 모두 받고
    	boolean hasCookie = false;					//쿠키를 가졌는지?
    	int pos = 0;
    	List list = new ArrayList();

    	//쿠키꾸러미? 가 있을때
    	if(cookies != null) {
    	for(int i=0;i<cookies.length;i++)
    		if(cookies[i].getName().equals(cookieName)) {
    			hasCookie = true;					//쿠키가 존재하면 true로
    			pos = i;							//위치 기억
    			break;
    		}
    	}

    	if(!hasCookie) {	//쿠키가 없었다면 새로 생성
    		Cookie cookie = new Cookie(cookieName,Integer.toString(no));		//새쿠키
    		cookie.setMaxAge(60*60*24);						//24시간 설정
    		response.addCookie(cookie);						//쿠키추가
    		
    	}else{				//쿠키가 이미 있으면 기존거에 추가
    		
    		//리스트로 찾아와서
    		String[] splt = cookies[pos].getValue().split("//");
    		for(int i=0;i<splt.length;i++) {
    			list.add(splt[i]);
    		}
    		//이미 존재하는no가 있다면 제거
    		list.remove(Integer.toString(no));
    		
    		//한줄의 문자열로 변환
    		String tmp = "";
    		for(int i=0;i<list.size();i++) {
    			if(i != 0) tmp += "//";
    			tmp += list.get(i);
    		}
    		
    		//쿠키갱신
    		Cookie cookie = new Cookie(cookieName, tmp);	//새쿠키
    		cookie.setMaxAge(60*60*24);						//24시간 설정
    		response.addCookie(cookie);						//쿠키추가
    	}
    }
	@Override
	public Map interceptors(HttpServletRequest request, HttpServletResponse response) {
		//최근본게시글
		List_DB ldb_tmp = list_DB_Bean;
		List viewedListAll = get_viewed_cookie(request, response);	//일단 쿠키에서 받고
		
		//최근본게시글이 존재하는 게시글인지 확인
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			int no = Integer.parseInt((String)viewedListAll.get(i));
			boolean isexist = ldb_tmp.existArticle_M(no);					//존재하는지 확인
				if(!isexist) del_viewed_cookie(no, request, response);	//존재하지 않으면 쿠키에서 제거
		}
		
		viewedListAll = get_viewed_cookie(request, response);		//쿠키에서 다시 받는다
		
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
		
		//최근본게시글 출력
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
