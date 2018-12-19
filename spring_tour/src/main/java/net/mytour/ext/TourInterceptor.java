package net.mytour.ext;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import net.mytour.dao.Cookie_Dao;
import net.mytour.dao.List_Dao;
import net.mytour.dao.List_Reserve_Dao;
import net.mytour.dao.Member_Dao;
import net.mytour.data.List_Data;
import net.mytour.data.List_Reserve_Data;
import net.mytour.data.Member_Data;



public class TourInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	Member_Dao member_Service;
	@Autowired
	List_Reserve_Dao list_Reserve_Service;
	@Autowired
	Cookie_Dao cookie_Service;
	@Autowired
	List_Dao list_Service;

	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		
		int level = 1;
		int basket_size = 0;
		Member_Data member_info = null;
		List viewed_list;
		List viewed_list_all;
		int viewed_list_cnt = 0;

		
		if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
    		member_info = member_Service.getArticle((String)session.getAttribute("user_id"), (String)session.getAttribute("user_pw"));
    	}else member_info = null;
		
		
		if(member_info != null) level = member_info.getOrders();
		
		
		
		if(session.getAttribute("basket") != null) {
			HashMap map = (HashMap)session.getAttribute("basket");
			basket_size = map.size();
		}
		
		
		
		
		
		Calendar cal = Calendar.getInstance();

		
		//실제로는 풀것
		
		//예약대기중인 상품예약 중에 출발날짜가 초과된 상품은 모두 제거
		List list = list_Reserve_Service.getArticlesCheck();
		for(int i=0;i<list.size();i++) {
			List_Reserve_Data rldata = (List_Reserve_Data)list.get(i);
			Long now =  cal.getTimeInMillis();
			Long st = Long.parseLong(rldata.getTimes());
			if(now >= st) {
				list_Reserve_Service.Reserve_del(rldata.getNo());
			}
		}
	
		
		
		
		
		
		
		//최근본상품가져오기
		//존재하지 않는것 삭제처리
		List list_viewd_no = cookie_Service.get_viewed_cookie(request, response);
		for(int i=list_viewd_no.size()-1;i>=0;i--) {
			if(((String)list_viewd_no.get(i)).equals("")) continue;
			int no = Integer.parseInt((String)list_viewd_no.get(i));
			int tmp = list_Service.getCountNo(no);
			if(tmp == 0) cookie_Service.del_viewed_cookie(no, request, response);
		}
		
		
		
		
		
		
		
		
		list_viewd_no = cookie_Service.get_viewed_cookie(request, response);
		viewed_list_all = new ArrayList();
		viewed_list = new ArrayList();
		int maxsize = 30;
		for(int i=list_viewd_no.size()-1;i>=0;i--) {
			List_Data ldata = (List_Data)list_Service.getArticle(Integer.parseInt((String)list_viewd_no.get(i)));
			if(ldata == null) continue;
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
			viewed_list_all.add(ldata);
		}
		if(viewed_list_all.size() >= 2) {
			viewed_list.add(viewed_list_all.get(0));
			viewed_list.add(viewed_list_all.get(1));
		}
		if(viewed_list_all.size() == 1) {
			viewed_list.add(viewed_list_all.get(0));
		}
		viewed_list_cnt = viewed_list_all.size();
		
		
		
		
		
		request.setAttribute("level", level);
		request.setAttribute("basket_size", basket_size);
		request.setAttribute("member_info", member_info);
		request.setAttribute("viewed_list", viewed_list);
		request.setAttribute("viewed_list_all", viewed_list_all);
		request.setAttribute("viewed_list_cnt", viewed_list_cnt);
		
		return super.preHandle(request, response, handler);
	}

}
