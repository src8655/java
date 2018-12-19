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
import net.mytour.ext.Number_Format;


@Controller
public class CustomerCenterController {
	@Autowired
	Notice_Dao notice_Service;
	@Autowired
	Qna_Dao qna_Service;

	String msg = "";
	String url = "";

	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);
	
	//공지사항
	@RequestMapping("/tour/notice.o")
	public ModelAndView notice(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		
		List list;
		Action_Paging paging;
		int board_cnt = 0;
		
		
		int tmp = notice_Service.getCount();
		paging = new Action_Paging(tmp, 10, pages);
		list = notice_Service.getArticles(paging.getBoard_starts(), paging.getBoard_ends());
		

		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("board_cnt", board_cnt);
		mav.addObject("pages", pages);
		mav.setViewName("tour/notice");
		return mav;
	}
	//공지사항 작성
	@RequestMapping("/tour/notice_write.o")
	public ModelAndView notice_write(
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		
		
		mav.addObject("pages", pages);
		mav.setViewName("tour/notice_write");
		return mav;
	}
	//공지사항 작성완료
	@RequestMapping("/tour/notice_write_post.o")
	public ModelAndView notice_write_post(
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="memo", defaultValue="") String memo,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		
		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;

		Notice_Data ndata = new Notice_Data();
		ndata.setSubject(subject);
		ndata.setMemo(memo);
		ndata.setDates(year+"-"+month+"-"+day);
		notice_Service.insert(ndata);
		
		msg = "작성 성공";
		url = "notice.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//공지사항 보기
	@RequestMapping("/tour/notice_view.o")
	public ModelAndView notice_view(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		

		Notice_Data ndata;
		ndata = notice_Service.getArticle(no);
		

		mav.addObject("ndata", ndata);
		mav.addObject("no", no);
		mav.addObject("pages", pages);
		mav.setViewName("tour/notice_view");
		return mav;
	}
	//공지사항 수정
	@RequestMapping("/tour/notice_edit.o")
	public ModelAndView notice_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		Notice_Data ndata;
		ndata = notice_Service.getArticle(no);

		mav.addObject("ndata", ndata);
		mav.addObject("no", no);
		mav.addObject("pages", pages);
		mav.setViewName("tour/notice_edit");
		return mav;
	}
	//공지사항 수정완료
	@RequestMapping("/tour/notice_edit_post.o")
	public ModelAndView notice_edit_post(
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="memo", defaultValue="") String memo,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
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
		Notice_Data ndata = new Notice_Data();
		ndata.setNo(no);
		ndata.setSubject(subject);
		ndata.setMemo(memo);
		ndata.setDates(year+"-"+month+"-"+day);
		notice_Service.update(ndata);
		
		msg = "수정 성공";
		url = "notice_view.o?no="+no+"&pages="+pages;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//공지사항 삭제
	@RequestMapping("/tour/notice_del.o")
	public ModelAndView notice_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Notice_Data ndata = new Notice_Data();
		ndata.setNo(no);
		notice_Service.delete(ndata);
		
		msg = "삭제 성공";
		url = "notice.o?pages="+pages;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	
	
	
	
	
	
	
	

	//문의게시판
	@RequestMapping("/tour/qna.o")
	public ModelAndView qna(
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		
		List list;
		Action_Paging paging;
		int board_cnt = 0;
		
		//관리자면 1 아니면 내NO
		int member_no = -1;
		if(member_info.getOrders() != 3) member_no = member_info.getNo();
		
		
		Map maps = new HashMap();
		maps.put("member_no", member_no);
		maps.put("status", status);
		int tmp = qna_Service.getCount(member_no, status);
		paging = new Action_Paging(tmp, 15, pages);
		list = qna_Service.getArticles(member_no, status, paging.getBoard_starts(), paging.getBoard_ends());

		mav.addObject("status", status);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("board_cnt", board_cnt);
		mav.addObject("pages", pages);
		mav.setViewName("tour/qna");
		return mav;
	}
	//문의게시판 작성
	@RequestMapping("/tour/qna_write.o")
	public ModelAndView qna_write(
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}

		mav.addObject("status", status);
		mav.addObject("pages", pages);
		mav.setViewName("tour/qna_write");
		return mav;
	}
	//문의게시판 작성완료
	@RequestMapping("/tour/qna_write_post.o")
	public ModelAndView qna_write_post(
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="quest", defaultValue="") String quest,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(subject.equals("")) {
			msg = "제목을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		Qna_Data qdata = new Qna_Data();
		qdata.setMember_no(member_info.getNo());
		qdata.setSubject(subject);
		qdata.setQuest(quest);
		qdata.setDates(year+"-"+month+"-"+day);
		
		qna_Service.insert(qdata);
		
		
		msg = "작성 성공";
		url = "qna.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//문의게시판 보기
	@RequestMapping("/tour/qna_view.o")
	public ModelAndView qna_view(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		Qna_Data qdata;
		qdata = qna_Service.getArticle(no);

		mav.addObject("qdata", qdata);
		mav.addObject("no", no);
		mav.addObject("status", status);
		mav.addObject("pages", pages);
		mav.setViewName("tour/qna_view");
		return mav;
	}
	//문의게시판 수정
	@RequestMapping("/tour/qna_edit.o")
	public ModelAndView qna_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		Qna_Data qdata;
		qdata = qna_Service.getArticle(no);

		mav.addObject("qdata", qdata);
		mav.addObject("no", no);
		mav.addObject("status", status);
		mav.addObject("pages", pages);
		mav.setViewName("tour/qna_edit");
		return mav;
	}
	//문의게시판 수정완료
	@RequestMapping("/tour/qna_edit_post.o")
	public ModelAndView qna_edit_post(
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="quest", defaultValue="") String quest,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		if(subject.equals("")) {
			msg = "제목을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Qna_Data qdatas = qna_Service.getArticle(no);
		
		if(qdatas.getMember_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		Qna_Data qdata = new Qna_Data();
		qdata.setNo(no);
		qdata.setSubject(subject);
		qdata.setQuest(quest);
		qdata.setDates(year+"-"+month+"-"+day);
		
		qna_Service.update(qdata);
		
		
		msg = "수정 성공";
		url = "qna_view.o?no="+no+"&pages="+pages+"&status="+status;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//문의게시판 삭제
	@RequestMapping("/tour/qna_del.o")
	public ModelAndView qna_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(level == 1) {
			msg = "로그인해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Qna_Data qdatas = qna_Service.getArticle(no);
		
		if(qdatas.getMember_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		qna_Service.delete(no);
		
		
		msg = "삭제 성공";
		url = "qna.o?no="+no+"&pages="+pages+"&status="+status;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//문의게시판 답변
	@RequestMapping("/tour/qna_answer.o")
	public ModelAndView qna_answer(
			@RequestParam(value="answer", defaultValue="") String answer,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Qna_Data qdata = new Qna_Data();
		qdata.setNo(no);
		qdata.setAnswer(answer);
		qdata.setIsanswer(1);
		qna_Service.answer(qdata);
		
		msg = "답변 성공";
		url = "qna_view.o?no="+no+"&pages="+pages+"&status="+status;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//문의게시판 답변삭제
	@RequestMapping("/tour/qna_answer_del.o")
	public ModelAndView qna_answer_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
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
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Qna_Data qdata = new Qna_Data();
		qdata.setNo(no);
		qna_Service.answerDel(qdata);
		
		msg = "답변삭제 성공";
		url = "qna_view.o?no="+no+"&pages="+pages+"&status="+status;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
}
