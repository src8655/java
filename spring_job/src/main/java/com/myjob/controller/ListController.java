package com.myjob.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.myjob.data.IncomeData;
import com.myjob.data.InterviewData;
import com.myjob.data.MemberData;
import com.myjob.data.RecruitData;
import com.myjob.data.RecruitListData;
import com.myjob.data.ReviewData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;
import com.myjob.ext.NumberFormat;



@Controller
public class ListController {
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
	
	public static String savePathd = "/job/upload/";	//파일저장 상대경로
	
	//리스트
	@RequestMapping("/job/list.o")
	public ModelAndView list(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		int count = companyService.getCount(searchValue, search, searchType, searchSort);
		Action_Paging paging = new Action_Paging(count, 10, pages);
		List list = companyService.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), searchValue, search, searchType, searchSort);
		
		for(int i=0;i<list.size();i++) {
			CompanyData tmp = (CompanyData)list.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars_p((int)((tmp.getAvg_stars()/5.0)*92.0));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			
			
			if((mdata != null && mdata.getFollow_list() != null) &&  mdata.getFollow_list().contains(Integer.toString(tmp.getMember_no())))
				tmp.setIsfollow(1);
			else tmp.setIsfollow(-1);
		}
		
		
		
		
		
		int count2 = recruitService.getCount(searchValue, search, searchType, searchSort, 1);
		Action_Paging paging2 = new Action_Paging(count2, 10, pages_rc);
		List list2 = recruitService.getArticles(paging2.getBoard_starts(), paging2.getBoard_ends(), searchValue, search, searchType, searchSort, 1);
		for(int i=0;i<list2.size();i++) {
			RecruitData tmp = (RecruitData)list2.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			tmp.setDday(ActionTime.dDay(tmp.getEnddates()));
		}
		mav.addObject("paging2", paging2);
		mav.addObject("list2", list2);
		mav.addObject("count2", count2);
		
		
		
		
		
		
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");


		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("count", count);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.setViewName("job/list");
		return mav;
	}
	//상세보기
	@RequestMapping("/job/view.o")
	public ModelAndView view(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@CookieValue(value="job_view", defaultValue="") String job_view,
			HttpServletResponse response,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		mav.addObject("count5", count5);

		//조회수 추가
		if(!job_view.contains(ActionTime.getDate()+"=="+member_no)) {
			countService.insert(ActionTime.getDate(), member_no);
			job_view = job_view+"//"+ActionTime.getDate()+"=="+member_no;
			Cookie cookie = new Cookie("job_view", job_view);
			response.addCookie(cookie);
		}
		
		//일주일간 조회수
		String[] dates = new String[6];
		int[] counts = new int[6];
		for(int i=0;i<6;i++) {
			dates[i] = ActionTime.lastDate(i);
			counts[i] = countService.getCount(dates[i], member_no);
			mav.addObject("dates"+i, dates[i]);
			mav.addObject("counts"+i, counts[i]);
		}
		
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("tab", 1);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/view");
		return mav;
	}
	//기업관리
	@RequestMapping("/job/edit.o")
	public ModelAndView edit(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		
		CompanyData cdata = companyService.getArticle(member_no);
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/edit");
		return mav;
	}
	//기업관리 수정완료
	@RequestMapping("/job/edit_post.o")
	public ModelAndView edit_post(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("cdata") CompanyData cdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		if(mdata.getNo() != cdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		CompanyData cdata_tmp = companyService.getArticle(cdata.getMember_no());
		cdata.setFile1(cdata_tmp.getFile1());
		cdata.setFile2(cdata_tmp.getFile2());
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		String filename1 = files1.getOriginalFilename();
		if(!filename1.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename1);
			}while(files_tmp.exists());
			files1.transferTo(files_tmp);
			cdata.setFile1(files_tmp.getName());
		}
		String filename2 = files2.getOriginalFilename();
		if(!filename2.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename2);
			}while(files_tmp.exists());
			files2.transferTo(files_tmp);
			cdata.setFile2(files_tmp.getName());
		}
		
		companyService.update(cdata);
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "수정 완료";
		url = "view.o?member_no="+cdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//리뷰
	@RequestMapping("/job/review.o")
	public ModelAndView review(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}

		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		mav.addObject("count5", count5);
		
		
		Action_Paging paging = new Action_Paging(count2, 3, pages_r);
		List list = reviewService.getArticles(member_no, paging.getBoard_starts(), paging.getBoard_ends());

		mav.addObject("paging", paging);
		mav.addObject("list", list);
		

		double stars = 0;
		int stars_bar = 0;
		double stars1 = 0;
		double stars2 = 0;
		double stars3 = 0;
		double stars4 = 0;
		double stars5 = 0;
		int stars_bar1 = 0;
		int stars_bar2 = 0;
		int stars_bar3 = 0;
		int stars_bar4 = 0;
		int stars_bar5 = 0;
		
		//총 별점
		if(count2 != 0) {
			ReviewData rdata = reviewService.getAllStars(member_no);
			stars = Math.floor((rdata.getStars()/(double)count2)*10.0)/10.0;
			stars_bar = (int)((stars/5.0)*68.0);
			stars1 = Math.floor((rdata.getStars1()/(double)count2)*10.0)/10.0;
			stars2 = Math.floor((rdata.getStars2()/(double)count2)*10.0)/10.0;
			stars3 = Math.floor((rdata.getStars3()/(double)count2)*10.0)/10.0;
			stars4 = Math.floor((rdata.getStars4()/(double)count2)*10.0)/10.0;
			stars5 = Math.floor((rdata.getStars5()/(double)count2)*10.0)/10.0;
			stars_bar1 = (int)Math.floor((stars1/5.0)*100.0);
			stars_bar2 = (int)Math.floor((stars2/5.0)*100.0);
			stars_bar3 = (int)Math.floor((stars3/5.0)*100.0);
			stars_bar4 = (int)Math.floor((stars4/5.0)*100.0);
			stars_bar5 = (int)Math.floor((stars5/5.0)*100.0);
		}
		mav.addObject("stars", stars);
		mav.addObject("stars_bar", stars_bar);
		mav.addObject("stars1", stars1);
		mav.addObject("stars2", stars2);
		mav.addObject("stars3", stars3);
		mav.addObject("stars4", stars4);
		mav.addObject("stars5", stars5);
		mav.addObject("stars_bar1", stars_bar1);
		mav.addObject("stars_bar2", stars_bar2);
		mav.addObject("stars_bar3", stars_bar3);
		mav.addObject("stars_bar4", stars_bar4);
		mav.addObject("stars_bar5", stars_bar5);
		
		
		

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("tab", 2);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/review");
		return mav;
	}
	//리뷰작성
	@RequestMapping("/job/review_write_post.o")
	public ModelAndView review_write_post(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("rdata") ReviewData rdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
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
		//이미 작성한 리뷰
		int tmp = reviewService.getMyCount(rdata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		rdata.setDates(ActionTime.getDate());
		rdata.setWriter_no(mdata.getNo());
		
		reviewService.insert(rdata);
		

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "작성 성공.";
		url = "review.o?member_no="+rdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	
	
	
	
	
	//연봉
	@RequestMapping("/job/income.o")
	public ModelAndView income(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		
		//리스트 개수
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		mav.addObject("count5", count5);
		
		//연봉 최대 최소 평균 순위 구하기
		int maxs = 0;
		int mins = 0;
		int avgs = 0;
		int rank = 0;
		Map map = incomeService.getMoneyMaxMin(member_no);
		maxs = (Integer)map.get("maxs")+500;
		mins = (Integer)map.get("mins")-500;
		avgs = (Integer)map.get("avgs");
		rank = incomeService.getRank(member_no);
		
		mav.addObject("maxs", NumberFormat.number_format(maxs));
		mav.addObject("mins", NumberFormat.number_format(mins));
		mav.addObject("avgs", NumberFormat.number_format(avgs));
		mav.addObject("rank", rank);
		
		
		
		
		List list = incomeService.getArticles(member_no);
		for(int i=0;i<list.size();i++) {
			IncomeData tmp = (IncomeData)list.get(i);
			tmp.setMoneys(NumberFormat.number_format(tmp.getMoney()));
			tmp.setBarline((int)(((((double)tmp.getMoney())-mins)/(((double)(maxs))-mins))*100.0));
		}
		
		mav.addObject("list", list);
		
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("tab", 3);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/income");
		return mav;
	}
	//연봉작성
	@RequestMapping("/job/income_write_post.o")
	public ModelAndView income_write(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("idata") IncomeData idata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
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
		//이미 작성한 리뷰
		int tmp = incomeService.getMyCount(idata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		idata.setWriter_no(mdata.getNo());
		idata.setDates(ActionTime.getDate());
		
		incomeService.insert(idata);
		

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "작성 성공.";
		url = "income.o?member_no="+idata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	
	
	
	

	//면접후기
	@RequestMapping("/job/interview.o")
	public ModelAndView interview(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		
		//리스트 개수
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		mav.addObject("count5", count5);
		
		Action_Paging paging = new Action_Paging(count4, 3, pages_r);
		List list = interviewService.getArticles(member_no, paging.getBoard_starts(), paging.getBoard_ends());
		
		mav.addObject("paging", paging);
		mav.addObject("list", list);

		
		
		//총 난이도
		double difficulty = 0;
		int difficultybar = 0;
		String difficultys = "";

		difficulty = interviewService.getDifficulty(member_no);
		difficultybar = (int)((difficulty/5.0)*100.0);
		if(((int)difficulty) < 2) difficultys = "<span style='color:#6fba1f;'>매우쉬움</span>";
		else if(((int)difficulty) < 3) difficultys = "<span style='color:#8ad43b;'>쉬움</span>";
		else if(((int)difficulty) < 4) difficultys = "<span style='color:#fb9f00;'>보통</span>";
		else if(((int)difficulty) < 5) difficultys = "<span style='color:#fb6400;'>어려움</span>";
		else if(((int)difficulty) < 6) difficultys = "<span style='color:#e62b0d;'>매우어려움</span>";

		mav.addObject("difficulty", difficulty);
		mav.addObject("difficultybar", difficultybar);
		mav.addObject("difficultys", difficultys);
		
		
		//총 지원경로
		int dir1 = interviewService.getInterviewdir(member_no, 1);
		int dir2 = interviewService.getInterviewdir(member_no, 2);
		int dir3 = interviewService.getInterviewdir(member_no, 3);
		int dir4 = interviewService.getInterviewdir(member_no, 4);
		int dir5 = interviewService.getInterviewdir(member_no, 5);
		int dir6 = interviewService.getInterviewdir(member_no, 6);
		double dirsum = dir1+dir2+dir3+dir4+dir5+dir6;
		double dirs1 = 0.0;
		double dirs2 = 0.0;
		double dirs3 = 0.0;
		double dirs4 = 0.0;
		double dirs5 = 0.0;
		double dirs6 = 0.0;
		if(dirsum != 0) {
			dirs1 = Math.round(dir1/dirsum*10.0)/10.0*100;
			dirs2 = Math.round(dir2/dirsum*10.0)/10.0*100;
			dirs3 = Math.round(dir3/dirsum*10.0)/10.0*100;
			dirs4 = Math.round(dir4/dirsum*10.0)/10.0*100;
			dirs5 = Math.round(dir5/dirsum*10.0)/10.0*100;
			dirs6 = Math.round(dir6/dirsum*10.0)/10.0*100;
		}
		mav.addObject("dirs1", dirs1);
		mav.addObject("dirs2", dirs2);
		mav.addObject("dirs3", dirs3);
		mav.addObject("dirs4", dirs4);
		mav.addObject("dirs5", dirs5);
		mav.addObject("dirs6", dirs6);
		
		
		int exsum = 0;
		int resultsum = 0;
		int[] ex = new int[3];
		int[] result = new int[3];
		for(int i=0;i<3;i++) {
			ex[i] = interviewService.getInterviewex(member_no, (i+1));
			result[i] = interviewService.getInterviewresult(member_no, (i+1));
			exsum += ex[i];
			resultsum += result[i];
		}
		for(int i=0;i<3;i++) {
			ex[i] = (int)Math.round(((((double)ex[i])/((double)exsum))*100.0));
			result[i] = (int)Math.round(((((double)result[i])/((double)resultsum))*100.0));
		}
		mav.addObject("ex", ex);
		mav.addObject("result", result);
		
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("tab", 4);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/interview");
		return mav;
	}
	//면접후기 작성완료
	@RequestMapping("/job/interview_write_post.o")
	public ModelAndView interview_write_post(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("itdata") InterviewData	itdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
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
		//이미 작성한 리뷰
		int tmp = interviewService.getMyCount(itdata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		itdata.setDates(ActionTime.getDate());
		itdata.setWriter_no(mdata.getNo());
		
		interviewService.insert(itdata);
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "작성 성공.";
		url = "interview.o?member_no="+itdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&pages_r="+pages_r+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//채용정보
	@RequestMapping("/job/recruit.o")
	public ModelAndView recruit(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		
		//리스트 개수
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		mav.addObject("count5", count5);
		
		
		Action_Paging paging = new Action_Paging(count5, 4, pages_r);
		List list = recruitService.getListArticles(paging.getBoard_starts(), paging.getBoard_ends(), member_no, 1);
		
		for(int i=0;i<list.size();i++) {
			RecruitData tmp = (RecruitData)list.get(i);
			tmp.setDday(ActionTime.dDay(tmp.getEnddates()));
			tmp.setKeywords(new ArrayList<String>(Arrays.asList(tmp.getKeyword().split(","))));
		}
		
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		
		
		
		
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("tab", 5);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/recruit");
		return mav;
	}
	//채용정보 작성완료
	@RequestMapping("/job/recruit_write_post.o")
	public ModelAndView recruit_write_post(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("rcdata") RecruitData rcdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getNo() != rcdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		rcdata.setDates(ActionTime.getDate());
		
		recruitService.insert(rcdata);
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "작성 성공.";
		url = "recruit.o?member_no="+rcdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc+"&pages_r="+pages_r;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//채용정보 보기
	@RequestMapping("/job/recruit_view.o")
	public ModelAndView recruit_view(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="recruit_no", defaultValue="-1") int recruit_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		
		
		//리스트 개수
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		mav.addObject("count5", count5);
		
		
		
		RecruitData rcdata = recruitService.getArticleNo(recruit_no);
		rcdata.setDday(ActionTime.dDay(rcdata.getEnddates()));
		mav.addObject("rcdata", rcdata);

		String memo1 = rcdata.getMemo1().replace("\n", "<br />");
		String memo2 = rcdata.getMemo2().replace("\n", "<br />");
		String memo3 = rcdata.getMemo3().replace("\n", "<br />");
		String memo4 = rcdata.getMemo4().replace("\n", "<br />");
		String memo5 = rcdata.getMemo5().replace("\n", "<br />");
		mav.addObject("memo1", memo1);
		mav.addObject("memo2", memo2);
		mav.addObject("memo3", memo3);
		mav.addObject("memo4", memo4);
		mav.addObject("memo5", memo5);

		List keyword = new ArrayList<String>(Arrays.asList(rcdata.getKeyword().split(",")));
		List contact = new ArrayList<String>(Arrays.asList(rcdata.getContact().split(",")));
		mav.addObject("keyword", keyword);
		mav.addObject("contact", contact);
		
		
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("recruit_no", recruit_no);
		mav.addObject("pages_rc", pages_rc);
		mav.addObject("searchType", searchType);
		mav.addObject("searchSort", searchSort);
		mav.addObject("search", search);
		mav.addObject("tab", 5);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/recruit_view");
		return mav;
	}
	//채용정보 수정완료
	@RequestMapping("/job/recruit_edit_post.o")
	public ModelAndView recruit_edit_post(
			@RequestParam(value="recruit_no", defaultValue="-1") int recruit_no,
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("rcdata") RecruitData rcdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		RecruitData rcdata_tmp = recruitService.getArticleNo(recruit_no);
		if(mdata.getNo() != rcdata_tmp.getMember_no()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getNo() != rcdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		rcdata.setNo(recruit_no);
		rcdata.setDates(ActionTime.getDate());
		
		
		recruitService.update(rcdata);


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "수정 성공.";
		url = "recruit_view.o?member_no="+rcdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc+"&pages_r="+pages_r+"&recruit_no="+recruit_no;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//채용정보 삭제
	@RequestMapping("/job/recruit_del.o")
	public ModelAndView recruit_del(
			@RequestParam(value="recruit_no", defaultValue="-1") int recruit_no,
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("rcdata") RecruitData rcdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		RecruitData rcdata_tmp = recruitService.getArticleNo(recruit_no);
		if(mdata.getNo() != rcdata_tmp.getMember_no()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getNo() != rcdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		
		recruitService.del(recruit_no);


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "삭제 성공.";
		url = "recruit.o?member_no="+rcdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc+"&pages_r="+pages_r;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//지원서 작성완료
	@RequestMapping("/job/recruit_add_post.o")
	public ModelAndView recruit_add_post(
			@RequestParam(value="pages_rc", defaultValue="1") int pages_rc,
			@ModelAttribute("rcldata") RecruitListData rcldata,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			@RequestParam(value="searchType", defaultValue="-1") int searchType,
			@RequestParam(value="searchSort", defaultValue="-1") int searchSort,
			@RequestParam(value="search", defaultValue="-1") int search,
			@ModelAttribute("rcdata") RecruitData rcdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
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
		
		
		
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		String filename1 = files1.getOriginalFilename();
		if(!filename1.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename1);
			}while(files_tmp.exists());
			files1.transferTo(files_tmp);
			rcldata.setFile1(files_tmp.getName());
		}
		String filename2 = files2.getOriginalFilename();
		if(!filename2.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename2);
			}while(files_tmp.exists());
			files2.transferTo(files_tmp);
			rcldata.setFile2(files_tmp.getName());
		}
		
		rcldata.setDates(ActionTime.getDate());
		rcldata.setWriter_no(mdata.getNo());
		
		
		recruitListService.insert(rcldata);
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "작성 완료";
		url = "recruit_view.o?member_no="+rcldata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&searchType="+searchType+"&searchSort="+searchSort+"&search="+search+"&pages_rc="+pages_rc+"&recruit_no="+rcldata.getRecruit_no();
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//view ajax
	
	//리뷰
	@RequestMapping("/job/review_ajax.o")
	@ResponseBody
	public Map review_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		

		int count2 = reviewService.getCount(member_no);
		map.put("count2", count2);
		
		
		Action_Paging paging = new Action_Paging(count2, 2, pages_r);
		List list = reviewService.getArticles(member_no, paging.getBoard_starts(), paging.getBoard_ends());

		map.put("paging", paging);
		map.put("list", list);
		

		double stars = 0;
		int stars_bar = 0;
		double stars1 = 0;
		double stars2 = 0;
		double stars3 = 0;
		double stars4 = 0;
		double stars5 = 0;
		int stars_bar1 = 0;
		int stars_bar2 = 0;
		int stars_bar3 = 0;
		int stars_bar4 = 0;
		int stars_bar5 = 0;
		
		//총 별점
		if(count2 != 0) {
			ReviewData rdata = reviewService.getAllStars(member_no);
			stars = Math.floor((rdata.getStars()/(double)count2)*10.0)/10.0;
			stars_bar = (int)((stars/5.0)*68.0);
			stars1 = Math.floor((rdata.getStars1()/(double)count2)*10.0)/10.0;
			stars2 = Math.floor((rdata.getStars2()/(double)count2)*10.0)/10.0;
			stars3 = Math.floor((rdata.getStars3()/(double)count2)*10.0)/10.0;
			stars4 = Math.floor((rdata.getStars4()/(double)count2)*10.0)/10.0;
			stars5 = Math.floor((rdata.getStars5()/(double)count2)*10.0)/10.0;
			stars_bar1 = (int)Math.floor((stars1/5.0)*100.0);
			stars_bar2 = (int)Math.floor((stars2/5.0)*100.0);
			stars_bar3 = (int)Math.floor((stars3/5.0)*100.0);
			stars_bar4 = (int)Math.floor((stars4/5.0)*100.0);
			stars_bar5 = (int)Math.floor((stars5/5.0)*100.0);
		}
		map.put("stars", stars);
		map.put("stars_bar", stars_bar);
		map.put("stars1", stars1);
		map.put("stars2", stars2);
		map.put("stars3", stars3);
		map.put("stars4", stars4);
		map.put("stars5", stars5);
		map.put("stars_bar1", stars_bar1);
		map.put("stars_bar2", stars_bar2);
		map.put("stars_bar3", stars_bar3);
		map.put("stars_bar4", stars_bar4);
		map.put("stars_bar5", stars_bar5);
		
		
		

		map.put("member_no", member_no);
		map.put("pages_r", pages_r);
		map.put("memberInfo", mdata);
		return map;
	}
	//리뷰작성
	@RequestMapping("/job/review_write_post_ajax.o")
	@ResponseBody
	public Map review_write_post_ajax(
			@ModelAttribute("rdata") ReviewData rdata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		//이미 작성한 리뷰
		int tmp = reviewService.getMyCount(rdata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "이미 작성한 리뷰입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		rdata.setDates(ActionTime.getDate());
		rdata.setWriter_no(mdata.getNo());
		
		reviewService.insert(rdata);

		map.put("result", true);
		return map;
	}
	//상세보기
	@RequestMapping("/job/view_ajax.o")
	@ResponseBody
	public Map view_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);

		//일주일간 조회수
		String[] dates = new String[6];
		int[] counts = new int[6];
		for(int i=0;i<6;i++) {
			dates[i] = ActionTime.lastDate(i);
			counts[i] = countService.getCount(dates[i], member_no);
			map.put("dates"+i, dates[i]);
			map.put("counts"+i, counts[i]);
		}
		
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		map.put("cdata", cdata);
		map.put("member_no", member_no);
		return map;
	}
	//연봉
	@RequestMapping("/job/income_ajax.o")
	@ResponseBody
	public Map income_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//리스트 개수
		int count3 = incomeService.getCount(member_no);
		map.put("count3", count3);
		
		//연봉 최대 최소 평균 순위 구하기
		int maxs = 0;
		int mins = 0;
		int avgs = 0;
		int rank = 0;
		Map maps = incomeService.getMoneyMaxMin(member_no);
		maxs = (Integer)maps.get("maxs")+500;
		mins = (Integer)maps.get("mins")-500;
		avgs = (Integer)maps.get("avgs");
		rank = incomeService.getRank(member_no);
		
		map.put("maxs", NumberFormat.number_format(maxs));
		map.put("mins", NumberFormat.number_format(mins));
		map.put("avgs", NumberFormat.number_format(avgs));
		map.put("rank", rank);
		
		
		
		
		List list = incomeService.getArticles(member_no);
		for(int i=0;i<list.size();i++) {
			IncomeData tmp = (IncomeData)list.get(i);
			tmp.setMoneys(NumberFormat.number_format(tmp.getMoney()));
			tmp.setBarline((int)(((((double)tmp.getMoney())-mins)/(((double)(maxs))-mins))*100.0));
		}
		
		map.put("list", list);
		
		


		map.put("member_no", member_no);
		return map;
	}
	//연봉작성
	@RequestMapping("/job/income_write_post_ajax.o")
	@ResponseBody
	public Map income_write_post_ajax(
			@ModelAttribute("idata") IncomeData idata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();

		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		//이미 작성한 리뷰
		int tmp = incomeService.getMyCount(idata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "이미 연봉정보를 작성하였습니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		idata.setWriter_no(mdata.getNo());
		idata.setDates(ActionTime.getDate());
		
		incomeService.insert(idata);
		

		map.put("result", true);
		return map;
	}

	//면접후기
	@RequestMapping("/job/interview_ajax.o")
	@ResponseBody
	public Map interview_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//리스트 개수
		int count4 = interviewService.getCount(member_no);
		map.put("count4", count4);
		
		Action_Paging paging = new Action_Paging(count4, 2, pages_r);
		List list = interviewService.getArticles(member_no, paging.getBoard_starts(), paging.getBoard_ends());
		
		map.put("paging", paging);
		map.put("list", list);

		
		
		//총 난이도
		double difficulty = 0;
		int difficultybar = 0;
		String difficultys = "";

		difficulty = interviewService.getDifficulty(member_no);
		difficultybar = (int)((difficulty/5.0)*100.0);
		if(((int)difficulty) < 2) difficultys = "<span style='color:#6fba1f;'>매우쉬움</span>";
		else if(((int)difficulty) < 3) difficultys = "<span style='color:#8ad43b;'>쉬움</span>";
		else if(((int)difficulty) < 4) difficultys = "<span style='color:#fb9f00;'>보통</span>";
		else if(((int)difficulty) < 5) difficultys = "<span style='color:#fb6400;'>어려움</span>";
		else if(((int)difficulty) < 6) difficultys = "<span style='color:#e62b0d;'>매우어려움</span>";

		map.put("difficulty", difficulty);
		map.put("difficultybar", difficultybar);
		map.put("difficultys", difficultys);
		
		
		//총 지원경로
		int dir1 = interviewService.getInterviewdir(member_no, 1);
		int dir2 = interviewService.getInterviewdir(member_no, 2);
		int dir3 = interviewService.getInterviewdir(member_no, 3);
		int dir4 = interviewService.getInterviewdir(member_no, 4);
		int dir5 = interviewService.getInterviewdir(member_no, 5);
		int dir6 = interviewService.getInterviewdir(member_no, 6);
		double dirsum = dir1+dir2+dir3+dir4+dir5+dir6;
		double dirs1 = 0.0;
		double dirs2 = 0.0;
		double dirs3 = 0.0;
		double dirs4 = 0.0;
		double dirs5 = 0.0;
		double dirs6 = 0.0;
		if(dirsum != 0) {
			dirs1 = Math.round(dir1/dirsum*10.0)/10.0*100;
			dirs2 = Math.round(dir2/dirsum*10.0)/10.0*100;
			dirs3 = Math.round(dir3/dirsum*10.0)/10.0*100;
			dirs4 = Math.round(dir4/dirsum*10.0)/10.0*100;
			dirs5 = Math.round(dir5/dirsum*10.0)/10.0*100;
			dirs6 = Math.round(dir6/dirsum*10.0)/10.0*100;
		}
		map.put("dirs1", dirs1);
		map.put("dirs2", dirs2);
		map.put("dirs3", dirs3);
		map.put("dirs4", dirs4);
		map.put("dirs5", dirs5);
		map.put("dirs6", dirs6);
		
		
		int exsum = 0;
		int resultsum = 0;
		int[] ex = new int[3];
		int[] result = new int[3];
		for(int i=0;i<3;i++) {
			ex[i] = interviewService.getInterviewex(member_no, (i+1));
			result[i] = interviewService.getInterviewresult(member_no, (i+1));
			exsum += ex[i];
			resultsum += result[i];
		}
		for(int i=0;i<3;i++) {
			ex[i] = (int)Math.round(((((double)ex[i])/((double)exsum))*100.0));
			result[i] = (int)Math.round(((((double)result[i])/((double)resultsum))*100.0));
		}
		map.put("ex", ex);
		map.put("result", result);
		
		

		map.put("member_no", member_no);
		map.put("pages_r", pages_r);
		return map;
	}
	//면접후기 작성완료
	@RequestMapping("/job/interview_write_post_ajax.o")
	@ResponseBody
	public Map interview_write_post_ajax(
			@ModelAttribute("itdata") InterviewData	itdata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		//이미 작성한 리뷰
		int tmp = interviewService.getMyCount(itdata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "이미 면접정보를 작성하였습니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		itdata.setDates(ActionTime.getDate());
		itdata.setWriter_no(mdata.getNo());
		
		interviewService.insert(itdata);

		map.put("result", true);
		return map;
	}
	//채용정보
	@RequestMapping("/job/recruit_ajax.o")
	@ResponseBody
	public Map recruit_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//리스트 개수
		int count5 = recruitService.getListCount(member_no, 1);
		map.put("count5", count5);
		
		
		Action_Paging paging = new Action_Paging(count5, 4, pages_r);
		List list = recruitService.getListArticles(paging.getBoard_starts(), paging.getBoard_ends(), member_no, 1);
		
		for(int i=0;i<list.size();i++) {
			RecruitData tmp = (RecruitData)list.get(i);
			tmp.setDday(ActionTime.dDay(tmp.getEnddates()));
			tmp.setKeywords(new ArrayList<String>(Arrays.asList(tmp.getKeyword().split(","))));
		}
		
		map.put("paging", paging);
		map.put("list", list);
		
		
		
		

		map.put("member_no", member_no);
		map.put("pages_r", pages_r);
		return map;
	}
	//채용정보 작성완료
	@RequestMapping("/job/recruit_write_post_ajax.o")
	@ResponseBody
	public Map recruit_write_post_ajax(
			@ModelAttribute("rcdata") RecruitData rcdata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getNo() != rcdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		rcdata.setDates(ActionTime.getDate());
		
		recruitService.insert(rcdata);
		


		map.put("result", true);
		return map;
	}
	//채용정보 보기
	@RequestMapping("/job/recruit_view_ajax.o")
	@ResponseBody
	public Map recruit_view_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="recruit_no", defaultValue="-1") int recruit_no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		int count5 = recruitService.getListCount(member_no, 1);
		map.put("count5", count5);
		
		
		
		RecruitData rcdata = recruitService.getArticleNo(recruit_no);
		rcdata.setDday(ActionTime.dDay(rcdata.getEnddates()));
		map.put("rcdata", rcdata);

		String memo1 = rcdata.getMemo1().replace("\n", "<br />");
		String memo2 = rcdata.getMemo2().replace("\n", "<br />");
		String memo3 = rcdata.getMemo3().replace("\n", "<br />");
		String memo4 = rcdata.getMemo4().replace("\n", "<br />");
		String memo5 = rcdata.getMemo5().replace("\n", "<br />");
		map.put("memo1", memo1);
		map.put("memo2", memo2);
		map.put("memo3", memo3);
		map.put("memo4", memo4);
		map.put("memo5", memo5);

		List keyword = new ArrayList<String>(Arrays.asList(rcdata.getKeyword().split(",")));
		List contact = new ArrayList<String>(Arrays.asList(rcdata.getContact().split(",")));
		map.put("keyword", keyword);
		map.put("contact", contact);
		
		
		

		map.put("recruit_no", recruit_no);
		return map;
	}
	//채용정보 수정완료
	@RequestMapping("/job/recruit_edit_post_ajax.o")
	@ResponseBody
	public Map recruit_edit_post_ajax(
			@RequestParam(value="recruit_no", defaultValue="-1") int recruit_no,
			@ModelAttribute("rcdata") RecruitData rcdata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		RecruitData rcdata_tmp = recruitService.getArticleNo(recruit_no);
		if(mdata.getNo() != rcdata_tmp.getMember_no()) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getNo() != rcdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		rcdata.setNo(recruit_no);
		rcdata.setDates(ActionTime.getDate());
		
		recruitService.update(rcdata);

		map.put("result", true);
		return map;
	}
	//채용정보 삭제
	@RequestMapping("/job/recruit_del_ajax.o")
	@ResponseBody
	public Map recruit_del_ajax(
			@RequestParam(value="recruit_no", defaultValue="-1") int recruit_no,
			@ModelAttribute("rcdata") RecruitData rcdata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		RecruitData rcdata_tmp = recruitService.getArticleNo(recruit_no);
		if(mdata.getNo() != rcdata_tmp.getMember_no()) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getNo() != rcdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		recruitService.del(recruit_no);

		map.put("msg", msg);
		map.put("result", true);
		return map;
	}
	//지원서 작성완료
	@RequestMapping("/job/recruit_add_post_ajax.o")
	@ResponseBody
	public Map recruit_add_post_ajax(
			@ModelAttribute("rcldata") RecruitListData rcldata,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		String filename1 = files1.getOriginalFilename();
		if(!filename1.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename1);
			}while(files_tmp.exists());
			files1.transferTo(files_tmp);
			rcldata.setFile1(files_tmp.getName());
		}
		String filename2 = files2.getOriginalFilename();
		if(!filename2.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename2);
			}while(files_tmp.exists());
			files2.transferTo(files_tmp);
			rcldata.setFile2(files_tmp.getName());
		}
		
		rcldata.setDates(ActionTime.getDate());
		rcldata.setWriter_no(mdata.getNo());
		
		
		recruitListService.insert(rcldata);

		map.put("result", true);
		return map;
	}

	//기업관리 수정완료
	@RequestMapping("/job/edit_post_ajax.o")
	@ResponseBody
	public Map edit_post_ajax(
			@ModelAttribute("cdata") CompanyData cdata,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		if(mdata.getNo() != cdata.getMember_no()) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		CompanyData cdata_tmp = companyService.getArticle(cdata.getMember_no());
		cdata.setFile1(cdata_tmp.getFile1());
		cdata.setFile2(cdata_tmp.getFile2());
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		String filename1 = files1.getOriginalFilename();
		if(!filename1.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename1);
			}while(files_tmp.exists());
			files1.transferTo(files_tmp);
			cdata.setFile1(files_tmp.getName());
		}
		String filename2 = files2.getOriginalFilename();
		if(!filename2.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename2);
			}while(files_tmp.exists());
			files2.transferTo(files_tmp);
			cdata.setFile2(files_tmp.getName());
		}
		
		companyService.update(cdata);

		map.put("result", true);
		return map;
	}
	//상세보기 헤더
	@RequestMapping("/job/view_header_ajax.o")
	@ResponseBody
	public Map view_header_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		int count2 = reviewService.getCount(member_no);
		map.put("count2", count2);
		int count3 = incomeService.getCount(member_no);
		map.put("count3", count3);
		int count4 = interviewService.getCount(member_no);
		map.put("count4", count4);
		int count5 = recruitService.getListCount(member_no, 1);
		map.put("count5", count5);

		
		
		CompanyData cdata = companyService.getArticle(member_no);
		cdata.setAvg_stars(Math.round(cdata.getAvg_stars()*10.0)/10.0);
		if(mdata != null) {
			if(mdata.getFollow_list().contains(Integer.toString(member_no)))
				cdata.setIsfollow(1);
			else cdata.setIsfollow(-1);
		}
		

		map.put("cdata", cdata);
		map.put("member_no", member_no);
		map.put("result", true);
		return map;
	}
}
