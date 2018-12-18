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
import net.myshop.dao.List_DB;
import net.myshop.dao.Member_DB;
import net.myshop.dao.View_Qna_DB;
import net.myshop.dao.View_Review_DB;
import net.myshop.data.List_Data_Bean;
import net.myshop.data.Member_Data_Bean;
import net.myshop.ext.Action_Paging;
import net.myshop.ext.Md5Enc;

@Controller
public class LoginController {
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

	String msg = "";
	String url = "";
	
	//로그인
	@RequestMapping("/shop/login.o")
	public ModelAndView login(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/login");
		
		String user_id = "";
		//쿠키설정
		user_id = cookie_Bean.getId(request);	//쿠키에서 아이디를 받아온다
		
		mav.addObject("user_id", user_id);
		
		return mav;
	}
	//로그인하기
	@RequestMapping("/shop/login_post.o")
	public ModelAndView login_post(
			@RequestParam(value="auto_ids", defaultValue="") String auto_ids,
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			HttpServletRequest request,
			HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		
		
		
		if(user_id.equals("")) {
			msg = "아이디를 입력하세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력하세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		//자동아이디 체크되었는지 확인
		int auto_id = 0;
		if(auto_ids != null)
			if(!auto_ids.equals(""))
				auto_id = 1;
		
		//아이디 쿠키
		if(auto_id == 1) cookie_Bean.setId(user_id, response);	//쿠키 저장
		else cookie_Bean.delId(response);	//쿠키 삭제

		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(user_pw);
    	//암호화
    	mdata.setUser_pw(Md5Enc.getEncMD5(mdata.getUser_pw().getBytes()));
    	
		int res = 0;
		if(member_DB_Bean.login_M(mdata)) {
			res = 1;
			HttpSession session = request.getSession();
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getUser_pw());
		}
		
		if(res == 0) {
			msg = "아이디 또는 비밀번호를 확인해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		msg = "로그인 성공.";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//로그아웃
	@RequestMapping("/shop/logout.o")
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		msg = "로그아웃 성공";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//아이디찾기
	@RequestMapping("/shop/login_find_id.o")
	public ModelAndView login_find_id() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("shop/login_find_id");
		return mav;
	}
	//아이디찾기
	@RequestMapping("/shop/login_find_id_post.o")
	public ModelAndView login_find_id_post(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone1.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone2.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone3.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		String user_id = member_DB_Bean.findId_M(name, phone1, phone2, phone3);
		
		if(user_id == null) user_id = "";

		mav.addObject("name", name);
		mav.addObject("phone1", phone1);
		mav.addObject("phone2", phone2);
		mav.addObject("phone3", phone3);
		mav.addObject("user_id", user_id);
		
		mav.setViewName("shop/login_find_id_post");
		return mav;
	}
	//비밀번호찾기
	@RequestMapping("/shop/login_find_pw.o")
	public ModelAndView login_find_pw(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="user_id", defaultValue="") String user_id
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.addObject("phone1", phone1);
		mav.addObject("phone2", phone2);
		mav.addObject("phone3", phone3);
		mav.addObject("user_id", user_id);
		mav.setViewName("shop/login_find_pw");
		return mav;
	}
	//비밀번호찾기
	@RequestMapping("/shop/login_find_pw_post.o")
	public ModelAndView login_find_pw_post(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone1.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone2.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone3.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(quest == -1) {
			msg = "질문을 선택해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		int res = 0;
		if(member_DB_Bean.findPw_M(user_id, name, phone1, phone2, phone3, quest, answer)) {
			res = 1;
		}

		mav.addObject("name", name);
		mav.addObject("phone1", phone1);
		mav.addObject("phone2", phone2);
		mav.addObject("phone3", phone3);
		mav.addObject("user_id", user_id);
		mav.addObject("quest", quest);
		mav.addObject("answer", answer);
		mav.addObject("res", res);
		
		mav.setViewName("shop/login_find_pw_post");
		return mav;
	}
	//비밀번호변경
	@RequestMapping("/shop/login_find_pw_change.o")
	public ModelAndView login_find_pw_change(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			@RequestParam(value="user_pw2", defaultValue="") String user_pw2
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone1.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone2.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone3.equals("휴대전화를 입력해주세요.")) {
			msg = "";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(quest == -1) {
			msg = "질문을 선택해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(user_pw2.equals("")) {
			msg = "비밀번호확인을 입력해주세요.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(!user_pw.equals(user_pw2)) {
			msg = "비밀번호가 다릅니다.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		//암호화
		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		
		int res = 0;
		if(member_DB_Bean.changePw_M(user_id, name, phone1, phone2, phone3, quest, answer, user_pw))
			res = 1;
		
		if(res == 1) {
			msg = "비밀번호 변경 성공.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else {
			msg = "비밀번호 변경 실패.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
	}
}
