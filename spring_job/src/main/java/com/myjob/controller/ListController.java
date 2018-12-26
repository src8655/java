package com.myjob.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
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
import com.myjob.dao.ReviewDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;
import com.myjob.data.ReviewData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;



@Controller
public class ListController {
	@Autowired
	CompanyDao companyService;
	@Autowired
	CountDao countService;
	@Autowired
	ReviewDao reviewService;

	String msg = "";
	String url = "";
	
	public static String savePathd = "/job/upload/";	//파일저장 상대경로
	
	//리스트
	@RequestMapping("/job/list.o")
	public ModelAndView list(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int count = companyService.getCount(searchValue);
		Action_Paging paging = new Action_Paging(count, 10, pages);
		List list = companyService.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), searchValue);
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

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
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@CookieValue(value="job_view", defaultValue="") String job_view,
			HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		

		//조회수 추가
		if(!job_view.contains(ActionTime.getDate()+"=="+member_no)) {
			countService.insert(ActionTime.getDate(), member_no);
			job_view = job_view+"//"+ActionTime.getDate()+"=="+member_no;
			Cookie cookie = new Cookie("job_view", job_view);
			response.addCookie(cookie);
		}
		System.out.println(job_view);
		
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
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

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
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		
		CompanyData cdata = companyService.getArticle(member_no);
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

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
		url = "view.o?member_no="+cdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//리뷰
	@RequestMapping("/job/review.o")
	public ModelAndView review(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		CompanyData cdata = companyService.getArticle(member_no);

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

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
	@RequestMapping("/job/review_write.o")
	public ModelAndView review_write(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		CompanyData cdata = companyService.getArticle(member_no);

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/review_write");
		return mav;
	}
	//리뷰작성
	@RequestMapping("/job/review_write_post.o")
	public ModelAndView review_write_post(
			@ModelAttribute("rdata") ReviewData rdata,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		

		CompanyData cdata = companyService.getArticle(member_no);

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		
		
		
		
		mav.setViewName("job/post");
		return mav;
	}
}
