package com.myjob.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.myjob.dao.CompanyDao;
import com.myjob.dao.CountDao;
import com.myjob.dao.IncomeDao;
import com.myjob.dao.InterviewDao;
import com.myjob.dao.RecruitDao;
import com.myjob.dao.RecruitListDao;
import com.myjob.dao.ReviewDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;
import com.myjob.data.RecruitData;
import com.myjob.data.RecruitListData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;
import com.myjob.ext.NumberFormat;



@Controller
public class MypageController {
	@Autowired
	CompanyDao companyService;
	@Autowired
	CountDao countService;
	@Autowired
	ReviewDao reviewService;
	@Autowired
	IncomeDao incomeService;
	@Autowired
	InterviewDao interviewService;
	@Autowired
	RecruitDao recruitService;
	@Autowired
	RecruitListDao recruitListService;

	String msg = "";
	String url = "";
	
	//일반회원 마이페이지
	@RequestMapping("/job/mypage.o")
	public ModelAndView mypage(
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		mav.addObject("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		int count = companyService.getFollowsCount(mdata.getFollow());
		Action_Paging paging = new Action_Paging(count, 10, pages);
		List list = companyService.getFollows(mdata.getFollow(), paging.getBoard_starts(), paging.getBoard_ends());
		
		for(int i=0;i<list.size();i++) {
			CompanyData tmp = (CompanyData)list.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars_p((int)((tmp.getAvg_stars()/5.0)*92.0));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			
			if((mdata != null && mdata.getFollow_list() != null) && (mdata.getFollow_list().contains(Integer.toString(tmp.getMember_no()))))
				tmp.setIsfollow(1);
			else tmp.setIsfollow(-1);
		}
		mav.addObject("count", count);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		
		
		
		
		int count2 = recruitService.getMyCount(mdata.getNo());
		Action_Paging paging2 = new Action_Paging(count2, 10, pages_r);
		List list2 = recruitService.getMyArticles(mdata.getNo(), paging2.getBoard_starts(), paging2.getBoard_ends());
		for(int i=0;i<list2.size();i++) {
			RecruitData tmp = (RecruitData)list2.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			tmp.setDday(ActionTime.dDay(tmp.getEnddates()));
		}
		mav.addObject("paging2", paging2);
		mav.addObject("list2", list2);
		mav.addObject("count2", count2);
		
		
		
		
		

		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.setViewName("job/mypage");
		return mav;
	}
	
	
}
