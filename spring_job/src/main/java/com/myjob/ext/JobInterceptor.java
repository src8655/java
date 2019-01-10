package com.myjob.ext;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.myjob.dao.MemberDao;
import com.myjob.data.MemberData;



public class JobInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	MemberDao memberService;

	MemberData memberInfo = null;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		String job_email = (String)session.getAttribute("job_email");
		String job_password = (String)session.getAttribute("job_password");
		if(job_email == null) job_email = "";
		if(job_password == null) job_password = "";
		memberInfo = memberService.login(job_email, job_password);
		
		if(memberInfo != null) {
			if( memberInfo.getFollow() == null || memberInfo.getFollow().equals(""))
				memberInfo.setFollow_list(new ArrayList());
			else
				memberInfo.setFollow_list(new ArrayList(Arrays.asList(memberInfo.getFollow().split(","))));
		}
		
		//로그인아이디 저장된것 불러오기
		String save_id_auths = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			int pos = -1;
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("save_id_auth"))
					pos = i;
			}
			if(pos != -1) {
				save_id_auths = cookies[pos].getValue();
			}
		}
		request.setAttribute("save_id_auths", save_id_auths);
		
		//member_no가 있으면 view에 있는것을 표시
		int member_no = -1;
		if(request.getParameter("member_no") != null && !request.getParameter("member_no").equals(""))
			member_no = Integer.parseInt(request.getParameter("member_no"));
		request.setAttribute("member_no", member_no);
		
		//recruit_no가 있으면 recruit_view에 있는것을 표시
		int recruit_no = -1;
		if(request.getParameter("recruit_no") != null && !request.getParameter("recruit_no").equals(""))
			recruit_no = Integer.parseInt(request.getParameter("recruit_no"));
		request.setAttribute("recruit_no", recruit_no);
		
		int mypage = -1;
		if(request.getParameter("mypage") != null && !request.getParameter("mypage").equals(""))
			mypage = Integer.parseInt(request.getParameter("mypage"));
		request.setAttribute("mypage", mypage);
		
		request.setAttribute("memberInfo", memberInfo);
		return super.preHandle(request, response, handler);
	}

}
