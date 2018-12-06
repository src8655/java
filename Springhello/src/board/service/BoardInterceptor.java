package board.service;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

public class BoardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//����
		String language = "kr";
		if(request.getParameter("lang") != null) {
			if(!request.getParameter("lang").equals(""))
				language = request.getParameter("lang");
			request.setAttribute("lang", language = request.getParameter("lang"));	//request�� ����
		}
		Locale locale = new Locale(language);
		LocaleResolver localeResolver = RequestContextUtils
				.getLocaleResolver(request);
		localeResolver.setLocale(request, response, locale);
		
		
		
		//lang���� �Ķ���Ͱ� �����
		String[] querystring_split = null;
		String querystring = "?";
		if(request.getQueryString() != null) {
			querystring_split = request.getQueryString().split("&");
			querystring = "?";
		}else if(request.getParameter("querystring") != null) {
			querystring_split = request.getParameter("querystring").split("&");
			querystring = "";
		}
		
		if(querystring_split != null) {
		boolean isfirst = true;
			for(int i=0;i<querystring_split.length;i++)
				if(!querystring_split[i].split("=")[0].equals("lang")) {
				if(isfirst) isfirst = false;
				else querystring += "&";
				querystring += querystring_split[i];
			}
		}
		request.setAttribute("querystring", querystring);	//����
		
		return super.preHandle(request, response, handler);
	}

}
