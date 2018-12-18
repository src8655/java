package net.myshop.controller;

import java.io.File;
import java.io.IOException;
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

import net.myshop.dao.List_DB;

@Controller
public class ShopController {
	@Autowired
	List_DB list_DB_Bean;

	//리스트
	@RequestMapping("/shop/index.o")
	public ModelAndView index() throws SQLException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/index");
		
		
		List best_list;
		List best_list_1;
		List best_list_2;
		List best_list_3;
		List best_list_4;
		List best_list_5;
		List best_list_6;
		List best_list_7;
		List best_list_8;

		List list_1;
		List list_2;
		List list_3;
		List list_4;
		List list_5;
		List list_6;
		List list_7;
		List list_8;
		
		best_list = list_DB_Bean.getArticles_M(1, 6, -1, "", 8, -1, 1);
		best_list_1 = list_DB_Bean.getArticles_M(1, 6, 1, "", 8, -1, 1);
		best_list_2 = list_DB_Bean.getArticles_M(1, 6, 2, "", 8, -1, 1);
		best_list_3 = list_DB_Bean.getArticles_M(1, 6, 3, "", 8, -1, 1);
		best_list_4 = list_DB_Bean.getArticles_M(1, 6, 4, "", 8, -1, 1);
		best_list_5 = list_DB_Bean.getArticles_M(1, 6, 5, "", 8, -1, 1);
		best_list_6 = list_DB_Bean.getArticles_M(1, 6, 6, "", 8, -1, 1);
		best_list_7 = list_DB_Bean.getArticles_M(1, 6, 7, "", 8, -1, 1);
		best_list_8 = list_DB_Bean.getArticles_M(1, 6, 8, "", 8, -1, 1);

		
		list_1 = list_DB_Bean.getArticles_M(1, 5, 1, "", 10, -1, -1);
		list_2 = list_DB_Bean.getArticles_M(1, 5, 2, "", 10, -1, -1);
		list_3 = list_DB_Bean.getArticles_M(1, 5, 3, "", 10, -1, -1);
		list_4 = list_DB_Bean.getArticles_M(1, 5, 4, "", 10, -1, -1);
		list_5 = list_DB_Bean.getArticles_M(1, 5, 5, "", 10, -1, -1);
		list_6 = list_DB_Bean.getArticles_M(1, 5, 6, "", 10, -1, -1);
		list_7 = list_DB_Bean.getArticles_M(1, 5, 7, "", 10, -1, -1);
		list_8 = list_DB_Bean.getArticles_M(1, 5, 8, "", 10, -1, -1);
		

		mav.addObject("best_list", best_list);
		mav.addObject("best_list_1", best_list_1);
		mav.addObject("best_list_2", best_list_2);
		mav.addObject("best_list_3", best_list_3);
		mav.addObject("best_list_4", best_list_4);
		mav.addObject("best_list_5", best_list_5);
		mav.addObject("best_list_6", best_list_6);
		mav.addObject("best_list_7", best_list_7);
		mav.addObject("best_list_8", best_list_8);

		mav.addObject("list_1", list_1);
		mav.addObject("list_2", list_2);
		mav.addObject("list_3", list_3);
		mav.addObject("list_4", list_4);
		mav.addObject("list_5", list_5);
		mav.addObject("list_6", list_6);
		mav.addObject("list_7", list_7);
		mav.addObject("list_8", list_8);
		
		return mav;
	}
	
	//리스트
	@RequestMapping("/shop/sitemap.o")
	public ModelAndView sitemap() throws SQLException {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/sitemap");
		return mav;
	}
}
