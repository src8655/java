package net.myshop.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.DecimalFormat;
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

import net.myshop.dao.Cookies;
import net.myshop.dao.Faq_DB;
import net.myshop.dao.List_DB;
import net.myshop.dao.Member_DB;
import net.myshop.dao.Qna_DB;
import net.myshop.dao.Sell_DB;
import net.myshop.dao.View_Qna_DB;
import net.myshop.dao.View_Review_DB;
import net.myshop.data.Faq_Data_Bean;
import net.myshop.data.List_Data_Bean;
import net.myshop.data.Member_Data_Bean;
import net.myshop.data.Qna_Data_Bean;
import net.myshop.data.Sell_Data_Bean;
import net.myshop.data.View_Qna_Data_Bean;
import net.myshop.data.View_Review_Data_Bean;
import net.myshop.ext.Action_Paging;

@Controller
public class CustomerCenterController {
	@Autowired
	List_DB list_DB_Bean;
	@Autowired
	Cookies cookie_Bean;
	@Autowired
	View_Qna_DB view_Qna_DB_Bean;
	@Autowired
	View_Review_DB view_Review_DB_Bean;
	@Autowired
	Member_DB member_DB_Bean;
	@Autowired
	Sell_DB sell_DB_Bean;
	@Autowired
	Qna_DB qna_DB_Bean;
	@Autowired
	Faq_DB faq_DB_Bean;
	
	String msg = "";
	String url = "";
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH)+1;
	public int day = cal.get(Calendar.DATE);
	
	
	//고객센터
	@RequestMapping("/shop/customer_center.o")
	public ModelAndView customer_center(
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		mav.setViewName("shop/customer_center");
		return mav;
	}
	//qna
	@RequestMapping("/shop/customer_center_qna.o")
	public ModelAndView customer_center_qna(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		Action_Paging paging;
		List list = null;
		
		//관리자면 -1 회원이면 회원번호
		if(member_info.getOrders() == 3) paging = new Action_Paging(qna_DB_Bean.count_M(-1), 10, pages);	//관리자일때
		else paging = new Action_Paging(qna_DB_Bean.count_M(member_info.getNo()), 10, pages);			//아닐때
		

		//리스트받아오기
		if(member_info.getOrders() == 3) list = qna_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), 25, -1);
		else list = qna_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), 25, member_info.getNo());

		mav.addObject("list", list);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.addObject("paging", paging);
		mav.setViewName("shop/customer_center_qna");
		return mav;
	}
	//qna 작성
	@RequestMapping("/shop/customer_center_qna_write.o")
	public ModelAndView customer_center_qna_write(
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		mav.setViewName("shop/customer_center_qna_write");
		return mav;
	}
	//qna 작성완료
	@RequestMapping("/shop/customer_center_qna_write_post.o")
	public ModelAndView customer_center_qna_write_post(
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="memo", defaultValue="") String memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		if(category == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(subject.equals("")) {
			msg = "문의제목을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(memo.equals("")) {
			msg = "문의내용을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setCategory(category);
		qdata.setSubject(subject);
		qdata.setMemo(memo);
		qdata.setDates(year+"-"+month+"-"+day);
		qdata.setGuest_no(member_info.getNo());
		
		
		int res = 0;
		if(qna_DB_Bean.insert_M(qdata)) res = 1;
		
		if(res == 1) {
			msg = "작성 완료.";
			url = "customer_center_qna.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "작성실패";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//qna 보기
	@RequestMapping("/shop/customer_center_qna_view.o")
	public ModelAndView customer_center_qna_view(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		Qna_Data_Bean qdata;
		qdata = qna_DB_Bean.getArticle_M(no);
		
		//관리자도아닌데
		if(member_info.getOrders() != 3)
			if(qdata.getGuest_no() != member_info.getNo()) {
				//내 자료가 아닌걸 보면 안됨
				msg = "잘못된 접근입니다.";
				mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
			}

		mav.addObject("qdata", qdata);
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.setViewName("shop/customer_center_qna_view");
		return mav;
	}
	//qna 수정
	@RequestMapping("/shop/customer_center_qna_edit.o")
	public ModelAndView customer_center_qna_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		Qna_Data_Bean qdata = qna_DB_Bean.getArticle_M(no);
		
		//내 게시글이 아니면
		if(qdata.getGuest_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		mav.addObject("qdata", qdata);
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.setViewName("shop/customer_center_qna_edit");
		return mav;
	}
	//qna 수정완료
	@RequestMapping("/shop/customer_center_qna_edit_post.o")
	public ModelAndView customer_center_qna_edit_post(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="memo", defaultValue="") String memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(category == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(subject.equals("")) {
			msg = "문의제목을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(memo.equals("")) {
			msg = "문의내용을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setNo(no);
		qdata.setCategory(category);
		qdata.setSubject(subject);
		qdata.setMemo(memo);
		qdata.setDates(year+"-"+month+"-"+day);
		qdata.setGuest_no(member_info.getNo());
		
		
		int res = 0;
		if(qna_DB_Bean.update_M(qdata)) res = 1;

		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		if(res == 1) {
			msg = "수정 완료";
			url = "customer_center_qna.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "수정 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//qna 삭제
	@RequestMapping("/shop/customer_center_qna_del.o")
	public ModelAndView customer_center_qna_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		
		
		int res = 0;
		if(qna_DB_Bean.delete_M(no)) res = 1;
		
		
		if(res == 1) {
			msg = "삭제 완료";
			url = "customer_center_qna.o?pages="+pages;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else {
			msg = "삭제 실패";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}

	//qna 답변
	@RequestMapping("/shop/customer_center_qna_answer.o")
	public ModelAndView customer_center_qna_answer(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="answer", defaultValue="") String answer,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(answer.equals("")) {
			msg = "문의답변을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setNo(no);
		qdata.setIsanswer(1);
		qdata.setAnswer(answer);
		
		
		int res = 0;
		if(qna_DB_Bean.answer_M(qdata)) res = 1;
		
		
		
		if(res == 1) {
			msg = "답변작성 완료.";
			url = "customer_center_qna_view.o?no="+no+"&pages="+pages;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "답변작성 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//qna 답변 삭제
	@RequestMapping("/shop/customer_center_qna_answer_del.o")
	public ModelAndView customer_center_qna_answer_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		int res = 0;
		if(qna_DB_Bean.answerDel_M(no)) res = 1;
		
		if(res == 1) {
			msg = "답변삭제 완료";
			url = "customer_center_qna_view.o?pages="+pages+"&no="+no;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "답변삭제 실패";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//faq

	
	
	
	
	
	

	//faq
	@RequestMapping("/shop/customer_center_faq.o")
	public ModelAndView customer_center_faq(
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="p_search", defaultValue="1") int p_search,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		Action_Paging paging;
		paging = new Action_Paging(faq_DB_Bean.count_M(p_search, p_search_value, category), 10, pages);
		
		List list;
		int board_cnt = 0;
		list = faq_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), p_search, p_search_value, category);
		
		String p_search_values = URLEncoder.encode(p_search_value,"UTF-8");
		

		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("board_cnt", board_cnt);
		mav.addObject("category", category);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.addObject("p_search_value", p_search_value);
		mav.addObject("p_search", p_search);
		mav.addObject("p_search_values", p_search_values);
		mav.setViewName("shop/customer_center_faq");
		return mav;
	}
	//faq 작성
	@RequestMapping("/shop/customer_center_faq_write.o")
	public ModelAndView customer_center_faq_write(
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="p_search", defaultValue="1") int p_search,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}

		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		String p_search_values = URLEncoder.encode(p_search_value,"UTF-8");

		mav.addObject("category", category);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.addObject("p_search_value", p_search_value);
		mav.addObject("p_search", p_search);
		mav.addObject("p_search_values", p_search_values);
		mav.setViewName("shop/customer_center_faq_write");
		return mav;
	}
	//faq 작성완료
	@RequestMapping("/shop/customer_center_faq_write_post.o")
	public ModelAndView customer_center_faq_write_post(
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="memo", defaultValue="") String memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		

		if(category == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(subject.equals("")) {
			msg = "제목을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(memo.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		Faq_Data_Bean fdata = new Faq_Data_Bean();
		fdata.setCategory(category);
		fdata.setSubject(subject);
		fdata.setMemo(memo);
		fdata.setDates(year+"-"+month+"-"+day);
		
		
		int res = 0;
		if(faq_DB_Bean.insert_M(fdata)) res = 1;
		
		
		if(res == 1) {
			msg = "작성 완료.";
			url = "customer_center_faq.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "작성 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//faq 수정
	@RequestMapping("/shop/customer_center_faq_edit.o")
	public ModelAndView customer_center_faq_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="p_search", defaultValue="1") int p_search,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		Faq_Data_Bean fdata = faq_DB_Bean.getArticle_M(no);
		

		mav.addObject("fdata", fdata);
		
		
		
		String p_search_values = URLEncoder.encode(p_search_value,"UTF-8");

		mav.addObject("no", no);
		mav.addObject("category", category);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.addObject("p_search_value", p_search_value);
		mav.addObject("p_search", p_search);
		mav.addObject("p_search_values", p_search_values);
		mav.setViewName("shop/customer_center_faq_edit");
		return mav;
	}
	//faq 수정완료
	@RequestMapping("/shop/customer_center_faq_edit_post.o")
	public ModelAndView customer_center_faq_edit_post(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="categorys", defaultValue="-1") int categorys,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="p_search", defaultValue="1") int p_search,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			@RequestParam(value="subject", defaultValue="") String subject,
			@RequestParam(value="memo", defaultValue="") String memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(category == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(subject.equals("")) {
			msg = "제목을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(memo.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		Faq_Data_Bean fdata = new Faq_Data_Bean();
		fdata.setNo(no);
		fdata.setCategory(category);
		fdata.setSubject(subject);
		fdata.setMemo(memo);
		fdata.setDates(year+"-"+month+"-"+day);
		
		
		int res = 0;
		if(faq_DB_Bean.update_M(fdata)) res = 1;
		
		String p_search_values = URLEncoder.encode(p_search_value,"UTF-8");
		
		if(res == 1) {
			msg = "수정 완료.";
			url = "customer_center_faq.o?pages="+pages+"&category="+categorys+"&p_search="+p_search+"&p_search_value="+p_search_values;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "수정 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//faq 삭제
	@RequestMapping("/shop/customer_center_faq_del.o")
	public ModelAndView customer_center_faq_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="p_search", defaultValue="1") int p_search,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		
		
		int res = 0;
		if(faq_DB_Bean.delete_M(no)) res = 1;
		
		String p_search_values = URLEncoder.encode(p_search_value,"UTF-8");
		
		if(res == 1) {
			msg = "삭제 완료.";
			url = "customer_center_faq.o?pages="+pages+"&category="+category+"&p_search="+p_search+"&p_search_value="+p_search_values;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else {
			msg = "삭제 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	
	
	
	
	
}
