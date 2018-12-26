package com.myjob.controller;

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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import com.myjob.dao.MemberDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;
import com.myjob.ext.Md5Enc;
import com.myjob.ext.ActionTime;

import oracle.net.aso.MD5;




@Controller
public class LoginController {
	@Autowired
	MemberDao memberService;
	@Autowired
	CompanyDao companyService;

	String msg = "";
	String url = "";
	
	//로그인
	@RequestMapping("/job/login.o")
	public ModelAndView login(
			@CookieValue(value="save_id_auth", defaultValue="") String save_id_auth
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("save_id_auth", save_id_auth);
		mav.setViewName("job/login");
		return mav;
	}
	//로그인 체크 ajax
	@RequestMapping("/job/login_check_ajax.o")
	@ResponseBody
	public Map login_check_ajax(
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="password", defaultValue="") String password
			) throws Exception {
		Map map = new HashMap();
		
		password = Md5Enc.getEncMD5(password.getBytes());
		
		if(!memberService.existLogin(email, password)) {
			map.put("msg", "아이디 또는 비밀번호를 확인해주세요.");
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		return map;
	}
	//로그인
	@RequestMapping("/job/login_post.o")
	public ModelAndView login_post(
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="password", defaultValue="") String password,
			@RequestParam(value="save_id", defaultValue="-1") int save_id,
			HttpSession session,
			HttpServletResponse response
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		password = Md5Enc.getEncMD5(password.getBytes());

		session.setAttribute("job_email", email);
		session.setAttribute("job_password", password);
		
		if(save_id == 1) {
			Cookie cookie = new Cookie("save_id_auth", email);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("save_id_auth", "");
			response.addCookie(cookie);
		}
		
		msg = "로그인 성공";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//로그아웃
	@RequestMapping("/job/logout.o")
	public ModelAndView logout(
			HttpSession session
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		session.setAttribute("job_email", "");
		session.setAttribute("job_password", "");
		
		msg = "로그아웃 성공";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//회원가입
	@RequestMapping("/job/join.o")
	public ModelAndView join() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("job/join");
		return mav;
	}
	//회원가입 완료
	@RequestMapping("/job/join_post.o")
	public ModelAndView join_post(
			@ModelAttribute("mdata") MemberData mdata
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		if(mdata.getOrders() == 1) {	//개인회원
			mdata.setCompany("");
			mdata.setCompany_cate(-1);
			mdata.setCompany_num("");
		}
		
		
		mdata.setDates(ActionTime.getDate());
		
		//암호화
		mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));
		memberService.insert(mdata);
		
		if(mdata.getOrders() == 2) {	//기업회원
			//새로만든 멤버데이터 가져오기
			MemberData mdata_tmp = memberService.login(mdata.getEmail(), mdata.getPassword());
			//회사정보 추가
			CompanyData cdata = new CompanyData();
			cdata.setMember_no(mdata_tmp.getNo());
			companyService.insert(cdata);
		}
		
		
		
		msg = "회원가입 성공";
		url = "login.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//이메일 체크 ajax
	@RequestMapping("/job/join_email_check_ajax.o")
	@ResponseBody
	public Map join_email_check_ajax(@ModelAttribute("mdata") MemberData mdata) throws Exception {
		Map map = new HashMap();
		if(mdata.getEmail().equals("") || mdata.getEmail() == null) {
			map.put("msg", "이메일을 입력해주세요.");
			map.put("result", false);
			return map;
		}
		if(mdata.getEmail().length() < 5 || !mdata.getEmail().contains("@") || mdata.getEmail().split("@").length < 2) {
			map.put("msg", "잘못된 이메일 형식입니다.");
			map.put("result", false);
			return map;
		}
		if(memberService.existEmail(mdata)) {
			map.put("msg", "이미 존재하는 이메일입니다.");
			map.put("result", false);
			return map;
		}
		
		map.put("msg", "사용할 수 있는 이메일입니다.");
		map.put("result", true);
		return map;
	}
}
