package net.mytour.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
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

import net.mytour.dao.List_Dao;
import net.mytour.dao.List_Reserve_Dao;
import net.mytour.dao.Member_Dao;
import net.mytour.dao.Notice_Dao;
import net.mytour.dao.Qna_Dao;
import net.mytour.dao.Reserve_Dao;
import net.mytour.dao.Review_Dao;
import net.mytour.data.List_Data;
import net.mytour.data.List_Reserve_Data;
import net.mytour.data.Member_Data;
import net.mytour.data.Notice_Data;
import net.mytour.data.Qna_Data;
import net.mytour.data.Reserve_Data;
import net.mytour.data.Review_Data;
import net.mytour.ext.Action_Paging;
import net.mytour.ext.Md5Enc;
import net.mytour.ext.Number_Format;


@Controller
public class AdminController {
	@Autowired
	List_Dao list_Service;
	@Autowired
	List_Reserve_Dao list_Reserve_Service;
	@Autowired
	Reserve_Dao reserve_Service;
	@Autowired
	Member_Dao member_Service;

	public String savePathd = "/tour/upload/";	//파일저장 상대경로
	
	String msg = "";
	String url = "";

	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);
	
	//관리자페이지
	@RequestMapping("/tour/admin.o")
	public ModelAndView admin(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		mav.setViewName("tour/admin");
		return mav;
	}
	//리스트
	@RequestMapping("/tour/admin_list.o")
	public ModelAndView admin_list(
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		Action_Paging paging;
		List list;
		
		int tmp = list_Service.getCount(category, searchs);
		paging = new Action_Paging(tmp, 10, pages);
		list = list_Service.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), category, searchs);
		

		mav.addObject("list", list);
		mav.addObject("paging", paging);
		
		
		
		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");

		mav.addObject("searchs_utf", searchs_utf);
		mav.addObject("searchs", searchs);
		mav.addObject("category", category);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_list");
		return mav;
	}
	//리스트 작성
	@RequestMapping("/tour/admin_list_write.o")
	public ModelAndView admin_list_write(
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");

		mav.addObject("searchs_utf", searchs_utf);
		mav.addObject("searchs", searchs);
		mav.addObject("category", category);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_list_write");
		return mav;
	}
	//리스트 작성완료
	@RequestMapping("/tour/admin_list_write_post.o")
	public ModelAndView admin_list_write(
			@RequestParam(value="file1", required=false) MultipartFile file1,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="city", defaultValue="") String city,
			@RequestParam(value="days", defaultValue="-1") int days,
			@RequestParam(value="air", defaultValue="") String air,
			@RequestParam(value="money", defaultValue="-1") int money,
			@RequestParam(value="memo1", defaultValue="") String memo1,
			@RequestParam(value="memo2", defaultValue="") String memo2,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		if(subject.equals("")) {
			msg = "상품명을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(city.equals("")) {
			msg = "여행도시를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(days == -1) {
			msg = "여행기간을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(air.equals("")) {
			msg = "비행편을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(money == -1) {
			msg = "금액을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(category == -1) {
			msg = "카테고리를 선택해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		
		String file1FileName = "";
		String filename = file1.getOriginalFilename();
		if(!filename.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename);
			}while(files_tmp.exists());
			file1.transferTo(files_tmp);
			file1FileName = files_tmp.getName();
		}
		
		List_Data ldata = new List_Data();
		ldata.setSubject(subject);
		ldata.setCity(city);
		ldata.setDays(days);
		ldata.setAir(air);
		ldata.setMoney(money);
		ldata.setMoneys(Number_Format.number_format(money));
		ldata.setMemo1(memo1);
		ldata.setMemo2(memo2);
		ldata.setCategory(category);
		ldata.setDates(year+"-"+month+"-"+day);
		ldata.setFile1(file1FileName);
		
		list_Service.insert(ldata);
		
		msg = "작성 성공.";
		url = "admin_list_write.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//예약작성
	@RequestMapping("/tour/admin_list_reserve_post.o")
	public ModelAndView admin_list_reserve_post(
			@RequestParam(value="list_no", defaultValue="-1") int list_no,
			@RequestParam(value="startdates", defaultValue="") String startdates,
			@RequestParam(value="enddates", defaultValue="") String enddates,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="max_cnts", defaultValue="0") int max_cnts,
			@RequestParam(value="money", defaultValue="0") int money,
			@RequestParam(value="special", defaultValue="0") int special,
			@RequestParam(value="endtimes", defaultValue="") String endtimes,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		

		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;

		List_Reserve_Data lrdata = new List_Reserve_Data();
		lrdata.setList_no(list_no);
		lrdata.setStartdates(startdates);
		lrdata.setEnddates(enddates);
		lrdata.setSubject(subject);
		lrdata.setMax_cnts(max_cnts);
		lrdata.setMoney(money);
		lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));
		if(special == 1) lrdata.setSpecial(1);
		else lrdata.setSpecial(0);
		lrdata.setDates(year+"-"+month+"-"+day);
		

		String[] spt = endtimes.split("T");
		if(spt.length != 2) {
			msg = "잘못된 마감일 형식입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		String[] split_time = spt[1].split(":");
		if(split_time.length != 2) {
			msg = "잘못된 마감일 형식입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		String[] split = spt[0].split("-");
		if(split.length != 3) {
			msg = "잘못된 마감일 형식입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//times
		int y = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int d = Integer.parseInt(split[2]);
		int hh = Integer.parseInt(split_time[0]);
		int mm = Integer.parseInt(split_time[1]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(y, m-1, d, hh, mm);
		lrdata.setTimes(Long.toString(calendar.getTimeInMillis()));
		
		list_Reserve_Service.insert(lrdata);

		
		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");
		
		
		msg = "작성 성공";
		url = "view.o?no="+list_no+"&category="+category+"&searchs="+searchs_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//리스트 수정
	@RequestMapping("/tour/admin_list_edit.o")
	public ModelAndView admin_list_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		List_Data ldata;
		ldata = list_Service.getArticle(no);

		mav.addObject("ldata", ldata);
		
		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");

		mav.addObject("searchs_utf", searchs_utf);
		mav.addObject("searchs", searchs);
		mav.addObject("category", category);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_list_edit");
		return mav;
	}
	//리스트 수정완료
	@RequestMapping("/tour/admin_list_edit_post.o")
	public ModelAndView admin_list_edit_post(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="file1", required=false) MultipartFile file1,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="city", defaultValue="") String city,
			@RequestParam(value="days", defaultValue="-1") int days,
			@RequestParam(value="air", defaultValue="") String air,
			@RequestParam(value="money", defaultValue="-1") int money,
			@RequestParam(value="memo1", defaultValue="") String memo1,
			@RequestParam(value="memo2", defaultValue="") String memo2,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="categorys", defaultValue="-1") int categorys,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		if(subject.equals("")) {
			msg = "상품명을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(city.equals("")) {
			msg = "여행도시를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(days == -1) {
			msg = "여행기간을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(air.equals("")) {
			msg = "비행편을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(money == -1) {
			msg = "금액을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(categorys == -1) {
			msg = "카테고리를 선택해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		List_Data ldatas = list_Service.getArticle(no);
		List_Data ldata = new List_Data();
		//기존파일명을 저장
		ldata.setFile1(ldatas.getFile1());
		
		
		
		
		
		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		
		String file1FileName = "";
		String filename = file1.getOriginalFilename();
		if(!filename.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//이미 존재하면 카운트 증가
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename);
			}while(files_tmp.exists());
			file1.transferTo(files_tmp);
			file1FileName = files_tmp.getName();
			ldata.setFile1(file1FileName);
		}
		
		ldata.setNo(no);
		ldata.setSubject(subject);
		ldata.setCity(city);
		ldata.setDays(days);
		ldata.setAir(air);
		ldata.setMoney(money);
		ldata.setMoneys(Number_Format.number_format(money));
		ldata.setMemo1(memo1);
		ldata.setMemo2(memo2);
		ldata.setCategory(categorys);
		ldata.setDates(year+"-"+month+"-"+day);
		
		list_Service.edit(ldata);
		
		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");
		
		msg = "수정 성공.";
		url = "admin_list.o?pages="+pages+"&category="+category+"&searchs="+searchs_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//리스트 삭제
	@RequestMapping("/tour/admin_list_del.o")
	public ModelAndView admin_list_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		list_Service.del(no);

		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");
		
		msg = "삭제 성공";
		url = "admin_list.o?pages="+pages+"&category="+category+"&searchs="+searchs_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//리스트 예약 삭제
	@RequestMapping("/tour/admin_list_reserve_del.o")
	public ModelAndView admin_list_reserve_del(
			@RequestParam(value="list_no", defaultValue="-1") int list_no,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="searchs", defaultValue="") String searchs,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		String searchs_utf = "";
		searchs_utf = URLEncoder.encode(searchs,"UTF-8");
		
		list_Reserve_Service.del(no);
		
		msg = "삭제 성공";
		url = "view.o?pages="+pages+"&category="+category+"&searchs="+searchs_utf+"&no="+list_no;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	
	
	
	
	
	
	//입금확인
	@RequestMapping("/tour/admin_reserve.o")
	public ModelAndView admin_reserve(
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		List list;
		Action_Paging paging;
		
		int tmp = reserve_Service.getCountAll(status);
		paging = new Action_Paging(tmp, 10, pages);
		list = reserve_Service.getArticlesAll(status, paging.getBoard_starts(), paging.getBoard_ends());
		

		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("status", status);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_reserve");
		return mav;
	}
	//입금확인 보기
	@RequestMapping("/tour/admin_reserve_view.o")
	public ModelAndView admin_reserve_view(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Reserve_Data rdata;
		rdata = reserve_Service.getArticle(no);
		

		mav.addObject("no", no);
		mav.addObject("rdata", rdata);
		mav.addObject("status", status);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_reserve_view");
		return mav;
	}
	//입금확인 완료
	@RequestMapping("/tour/admin_reserve_pay.o")
	public ModelAndView admin_reserve_pay(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		reserve_Service.setStatus(no, 2);
		
		msg = "입금확인 완료";
		url = "admin_reserve.o?pages="+pages+"&status="+status;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	
	
	
	
	
	
	
	
	

	//회원관리
	@RequestMapping("/tour/admin_member.o")
	public ModelAndView admin_member(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		Action_Paging paging;
		List list;
		
		
		int tmp = member_Service.getCount();
		paging = new Action_Paging(tmp, 10, pages);
		
		list = member_Service.getArticles(paging.getBoard_starts(), paging.getBoard_ends());
		

		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_member");
		return mav;
	}
	//회원관리 수정
	@RequestMapping("/tour/admin_member_edit.o")
	public ModelAndView admin_member_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		Member_Data mdata;
		mdata = member_Service.getArticleNo(no);
		

		mav.addObject("no", no);
		mav.addObject("mdata", mdata);
		mav.addObject("pages", pages);
		mav.setViewName("tour/admin_member_edit");
		return mav;
	}
	//회원관리 수정완료
	@RequestMapping("/tour/admin_member_edit_post.o")
	public ModelAndView admin_member_edit_post(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			@RequestParam(value="user_pw2", defaultValue="") String user_pw2,
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="zipcode", defaultValue="") String zipcode,
			@RequestParam(value="addr", defaultValue="") String addr,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(email.equals("")) {
			msg = "이메일을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(addr.equals("")) {
			msg = "주소를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(quest == -1) {
			msg = "질문을 선택해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(!user_pw.equals("") || !user_pw2.equals("")) {
			if(!user_pw.equals(user_pw2)) {
				msg = "비밀번호가 다릅니다.";
				mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
			}else user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		}else user_pw = "none";
		
		Member_Data mdata = new Member_Data();
		mdata.setNo(no);
		mdata.setName(name);
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		mdata.setUser_pw(user_pw);
		
		member_Service.changeInfo(mdata);
		
		msg = "수정 성공";
		url = "admin_member.o?pages="+pages;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//회원관리 삭제
	@RequestMapping("/tour/admin_member_del.o")
	public ModelAndView admin_member_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		member_Service.delete(no);
		
		msg = "삭제 성공";
		url = "admin_member.o?pages="+pages;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
}
