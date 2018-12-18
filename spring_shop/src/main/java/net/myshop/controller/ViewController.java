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

import net.myshop.dao.Cookies;
import net.myshop.dao.List_DB;
import net.myshop.dao.Member_DB;
import net.myshop.dao.Sell_DB;
import net.myshop.dao.View_Qna_DB;
import net.myshop.dao.View_Review_DB;
import net.myshop.data.List_Data_Bean;
import net.myshop.data.Member_Data_Bean;
import net.myshop.data.Sell_Data_Bean;
import net.myshop.data.View_Qna_Data_Bean;
import net.myshop.data.View_Review_Data_Bean;
import net.myshop.ext.Action_Paging;

@Controller
public class ViewController {
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
	
	String msg = "";
	String url = "";
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH)+1;
	public int day = cal.get(Calendar.DATE);
	
	//보기
	@RequestMapping("/shop/view.o")
	public ModelAndView view(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchs", defaultValue="-1") int searchs,
			@RequestParam(value="searchs_value", defaultValue="") String searchs_value,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="tab", defaultValue="1") int tab,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/view");
		
		
		
		
		//멤버가져오기
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		int member_orders = -1;
		
		List_Data_Bean ldata = list_DB_Bean.getArticle_M(no);
		
		if(no != -1) {
			cookie_Bean.view_cookie(no, request, response);		//조회수 중복방지 쿠키작업
			cookie_Bean.viewed_cookie(no, request, response);	//최근본게시글 쿠키작업
		}
		
		Action_Paging paging = new Action_Paging(view_Qna_DB_Bean.count_M(no), 10, pages);	//페이징 만들기
		List list = view_Qna_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), no, member_info);	//리스트받아오기

		
		//회원종류
		if(member_info != null)
			member_orders = member_info.getOrders();
		
		
		//비회원은 가상의 회원데이터 만들기
		//(null 참조 에러 방지)
		Member_Data_Bean mdata = null;
		if(member_info == null) 
			mdata = new Member_Data_Bean();
		else
			mdata = member_info;
		
		
		Action_Paging review_paging = new Action_Paging(view_Review_DB_Bean.count_M(no), 10, pages);	//페이징 만들기
		List review_list = view_Review_DB_Bean.getArticles_M(review_paging.getBoard_starts(), review_paging.getBoard_ends(), no);	//리스트받아오기
		
		
		//판매자정보 가져오기
		Member_Data_Bean sellers = member_DB_Bean.getArticle_M(ldata.getSellers());
		
		
		
		

		mav.addObject("ldata", ldata);
		mav.addObject("tab", tab);
		mav.addObject("no", no);
		
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("member_info", member_info);
		mav.addObject("member_orders", member_orders);
		mav.addObject("mdata", mdata);
		mav.addObject("review_paging", review_paging);
		mav.addObject("review_list", review_list);
		mav.addObject("sellers", sellers);
		
		mav.addObject("list", list);
		mav.addObject("pages_int", pages);
		mav.addObject("pages", pages);
		
		//url인코딩한 값을 저장
		String searchs_values = URLEncoder.encode(searchs_value,"UTF-8");
		String p_search_values = URLEncoder.encode(p_search_value,"UTF-8");
		mav.addObject("searchs_values", searchs_values);
		mav.addObject("p_search_values", p_search_values);
		mav.addObject("searchs", searchs);
		mav.addObject("searchs_value", searchs_value);
		mav.addObject("paging", paging);
		
		return mav;
	}
	//review
	@RequestMapping("/shop/view_review.o")
	public ModelAndView view_review(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="product_no", defaultValue="-1") int product_no
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		
		List_Data_Bean ldata = list_DB_Bean.getArticle_M(product_no);
		

		mav.addObject("ldata", ldata);
		mav.addObject("product_no", product_no);
		mav.setViewName("shop/view_review");
		return mav;
	}
	//review_post
	@RequestMapping("/shop/view_review_post.o")
	public ModelAndView view_review_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="product_no", defaultValue="-1") int product_no,
			@RequestParam(value="stars", defaultValue="-1") int stars,
			@RequestParam(value="review1", defaultValue="") String review1,
			@RequestParam(value="review2", defaultValue="") String review2,
			@RequestParam(value="memo", defaultValue="") String memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//회원인지
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		//잘못된 접근 막기
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(product_no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(stars == -1) {
			msg = "상품평가를 선택해주세요";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(review1.equals("")) {
			msg = "만족도평가를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(review2.equals("")) {
			msg = "만족도평가를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(memo.equals("")) {
			msg = "내용을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//구매내역이 존재하는지 확인
		Sell_Data_Bean sdata = sell_DB_Bean.getArticle_M(no);
		
		//내 구매내역이 아니면
		if(sdata.getGuest_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		//이미 리뷰가 존재하면
		if(sdata.getHasreview() != 0) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//반숨긴 아이디
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		View_Review_Data_Bean vrdata = new View_Review_Data_Bean();
		vrdata.setDates(year+"-"+month+"-"+day);
		vrdata.setGuest_no(member_info.getNo());
		vrdata.setMemo(memo);
		vrdata.setProduct_no(product_no);
		vrdata.setReview1(review1);
		vrdata.setReview2(review2);
		vrdata.setStars(stars);
		vrdata.setGuest_id(guest_id);
		
		
		int res = 0;
		if(view_Review_DB_Bean.insert_M(vrdata)) {
			sell_DB_Bean.updateReview_M(no);	//구매내역에 리뷰가 작성되었다는것을 적용
			res = 1;
		}
		
		mav.addObject("res", res);
		mav.setViewName("shop/view_review_post");
		return mav;
	}
	//qna_write
	@RequestMapping("/shop/view_qna_write.o")
	public ModelAndView view_qna_write(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="sellers_no", defaultValue="") String sellers_no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);

		mav.addObject("sellers_no", sellers_no);
		mav.setViewName("shop/view_qna_write");
		return mav;
	}
	//qna_write_post
	@RequestMapping("/shop/view_qna_write_post.o")
	public ModelAndView view_qna_write_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="product_no", defaultValue="-1") int product_no,
			@RequestParam(value="sellers_no2", defaultValue="-1") int sellers_no2,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="memo", defaultValue="") String memo,
			@RequestParam(value="secret", defaultValue="0") int secret,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//회원인지
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		//잘못된 접근 막기
		if(product_no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(sellers_no2 == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//내용을 입력했는지
		if(category == -1) {
			msg = "분류를 선택해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(memo.equals("")) {
			msg = "내용을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		int guest_no = member_info.getNo();
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		
		//데이터를 빈즈에 담음
		View_Qna_Data_Bean vqdata = new View_Qna_Data_Bean();
		vqdata.setProduct_no(product_no);
		vqdata.setSellers_no(sellers_no2);
		vqdata.setCategory(category);
		vqdata.setMemo(memo);
		vqdata.setSecret(secret);
		vqdata.setGuest_no(guest_no);
		vqdata.setGuest_id(guest_id);
		vqdata.setDates(year+"-"+month+"-"+day);
		
		int res = 0;
		if(view_Qna_DB_Bean.insert_M(vqdata)) res = 1;
		

		mav.addObject("product_no", product_no);
		mav.addObject("res", res);
		mav.setViewName("shop/view_qna_write_post");
		return mav;
	}
	//qna_del
	@RequestMapping("/shop/view_qna_del.o")
	public ModelAndView view_qna_del(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="product_no", defaultValue="-1") int product_no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");

		//회원인지
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		//잘못된 접근 막기
		if(product_no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		View_Qna_Data_Bean vqdata = view_Qna_DB_Bean.getArticle_M(no);
		
		//내 회원번호하고 게시글의 회원번호하고 다르면
		if(vqdata.getGuest_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		
		//삭제
		
		int res = 0;
		if(view_Qna_DB_Bean.delete_M(no)) res = 1;
		
		if(res == 1) {
			msg = "삭제 성공.";
			url = "view.o?no="+product_no+"&tab=3&pages="+pages;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "삭제 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//qna_answer
	@RequestMapping("/shop/view_qna_answer.o")
	public ModelAndView view_qna_answer(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="product_no", defaultValue="") String product_no
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);

		mav.addObject("product_no", product_no);
		mav.setViewName("shop/view_qna_answer");
		return mav;
	}
	
	//qna_answer_post
	@RequestMapping("/shop/view_qna_answer_post.o")
	public ModelAndView view_qna_answer_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="product_no", defaultValue="-1") int product_no,
			@RequestParam(value="memo", defaultValue="") String memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//회원인지
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		//잘못된 접근 막기
		if(product_no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		View_Qna_Data_Bean vqdata =  view_Qna_DB_Bean.getArticle_M(no);
		
		//답변자가 아니면
		if(vqdata.getSellers_no() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		vqdata = new View_Qna_Data_Bean();
		vqdata.setNo(no);
		vqdata.setAnswer(memo);
		vqdata.setIsanswer(1);
		
		int res = 0;
		if(view_Qna_DB_Bean.answer_M(vqdata)) res = 1;

		mav.addObject("product_no", product_no);
		mav.addObject("res", res);
		mav.setViewName("shop/view_qna_answer_post");
		return mav;
	}
		
}
