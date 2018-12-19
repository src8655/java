package net.mytour.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import net.mytour.dao.Cookie_Dao;
import net.mytour.dao.List_Dao;
import net.mytour.dao.List_Reserve_Dao;
import net.mytour.dao.Notice_Dao;
import net.mytour.dao.Review_Dao;
import net.mytour.data.List_Data;
import net.mytour.data.List_Reserve_Data;
import net.mytour.data.Notice_Data;
import net.mytour.ext.Action_Paging;


@Controller
public class ListController {
	@Autowired
	List_Reserve_Dao list_Reserve_Service;
	@Autowired
	List_Dao list_Service;
	@Autowired
	Notice_Dao notice_Service;
	@Autowired
	Cookie_Dao cookie_Service;
	@Autowired
	Review_Dao review_Service;
	
	String msg = "";
	String url = "";

	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);

	//리스트
	@RequestMapping("/tour/list.o")
	public ModelAndView list(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="searchs", defaultValue="") String searchs
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		Action_Paging paging;
		List list = new ArrayList();
		int cnt = 0;
		
		int count = list_Service.getCount(category, searchs);
		paging = new Action_Paging(count, 6, pages);
		
		list = list_Service.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), category, searchs);
		
		//글자 사이즈 바꾸기
		int maxsize = 22;
		for(int i=0;i<list.size();i++) {
			List_Data ldata = (List_Data)list.get(i);
			if(ldata.getSubject().length() > maxsize)
				ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		
		String searchs_utf = "";
		try {
			searchs_utf = URLEncoder.encode(searchs,"UTF-8");
		} catch (UnsupportedEncodingException e) { }

		mav.addObject("pages", pages);
		mav.addObject("category", category);
		mav.addObject("searchs", searchs);
		mav.addObject("searchs_utf", searchs_utf);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("cnt", cnt);
		mav.setViewName("tour/list");
		return mav;
	}
	//리스트 상세검색
	@RequestMapping("/tour/list_s.o")
	public ModelAndView list_s(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="startdates", defaultValue="") String startdates,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="days", defaultValue="0") int days,
			@RequestParam(value="money", defaultValue="0") int money
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List list;
		Action_Paging paging;
		String subject_utf = "";
		subject_utf = URLEncoder.encode(subject,"UTF-8");
		
		
		int tmp = list_Reserve_Service.getCountAll(startdates, days, category, money, subject);
		paging = new Action_Paging(tmp, 2, pages);
		
		list = list_Reserve_Service.getArticlesAll(startdates, days, category, money, subject, paging.getBoard_starts(), paging.getBoard_ends());
		
		for(int i=0;i<list.size();i++) {
			List_Reserve_Data lrdata = (List_Reserve_Data)list.get(i);
			long tmp_now = cal.getTimeInMillis()/1000;
			long tmp_after = Long.parseLong(lrdata.getTimes())/1000;
			long tmp_result = tmp_after - tmp_now;
			
			//시간차 저장
			lrdata.setTimes_tmp(Long.toString(tmp_result));
		}

		mav.addObject("pages", pages);
		mav.addObject("category", category);
		mav.addObject("startdates", startdates);
		mav.addObject("subject", subject);
		mav.addObject("subject_utf", subject_utf);
		mav.addObject("days", days);
		mav.addObject("money", money);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.setViewName("tour/list_s");
		return mav;
	}
	//리스트 상세검색
	@RequestMapping("/tour/view.o")
	public ModelAndView view(
			@RequestParam(value="pages_rv", defaultValue="1") int pages_rv,
			@RequestParam(value="tab", defaultValue="1") int tab,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");

		List_Data ldata;
		List list;
		List list_review;
		Action_Paging paging;

		
		ldata = list_Service.getArticle(no);
		list = list_Reserve_Service.getArticles(no);
		
		//조회수 처리
		cookie_Service.view_cookie(no, request, response);
		
		//최근본상품 처리
		cookie_Service.viewed_cookie(no, request, response);
		
		
		
		int tmp = review_Service.getCount(no);
		paging = new Action_Paging(tmp, 10, pages_rv);
		
		list_review = review_Service.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), no);
		
		
		for(int i=0;i<list.size();i++) {
			List_Reserve_Data lrdata = (List_Reserve_Data)list.get(i);
			long tmp_now = cal.getTimeInMillis()/1000;
			long tmp_after = Long.parseLong(lrdata.getTimes())/1000;
			long tmp_result = tmp_after - tmp_now;
			
			//시간차 저장
			lrdata.setTimes_tmp(Long.toString(tmp_result));
		}
		

		mav.addObject("ldata", ldata);
		mav.addObject("list", list);
		mav.addObject("list_review", list_review);
		mav.addObject("paging", paging);
		
		mav.addObject("pages_rv", pages_rv);
		mav.addObject("tab", tab);
		mav.addObject("no", no);
		mav.addObject("pages", pages);
		mav.addObject("category", category);
		mav.addObject("searchs", searchs);
		mav.addObject("searchs_utf", searchs_utf);
		mav.setViewName("tour/view");
		return mav;
	}
}
