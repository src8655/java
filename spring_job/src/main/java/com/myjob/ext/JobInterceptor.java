package com.myjob.ext;

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
		
		request.setAttribute("memberInfo", memberInfo);
		return super.preHandle(request, response, handler);
	}

}
