package net.mytour.controller;

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

import net.mytour.dao.Cookie_Dao;
import net.mytour.dao.List_Dao;
import net.mytour.dao.List_Reserve_Dao;
import net.mytour.dao.Member_Dao;
import net.mytour.dao.Notice_Dao;
import net.mytour.data.List_Data;
import net.mytour.data.List_Reserve_Data;
import net.mytour.data.Member_Data;
import net.mytour.data.Notice_Data;
import net.mytour.ext.Md5Enc;


@Controller
public class LoginController {
	@Autowired
	List_Reserve_Dao list_Reserve_Service;
	@Autowired
	List_Dao list_Service;
	@Autowired
	Notice_Dao notice_Service;
	@Autowired
	Member_Dao member_Service;
	@Autowired
	Cookie_Dao cookie_Service;
	
	String msg = "";
	String url = "";

	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);

	//로그인
	@RequestMapping("/tour/login.o")
	public ModelAndView login(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		String user_id = "";
		user_id = cookie_Service.getId(request);
		
		mav.addObject("user_id", user_id);
		mav.setViewName("tour/login");
		return mav;
	}
	//로그인 하기
	@RequestMapping("/tour/login_post.o")
	public ModelAndView login_post(
			@RequestParam(value="auto_ids", defaultValue="") String auto_ids,
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			HttpServletRequest request,
			HttpServletResponse response
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		if(user_id.equals("")) {
			msg = "아이디를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		//자동아이디 체크되었는지 확인
		int auto_id = 0;
		if(auto_ids != null)
			if(!auto_ids.equals(""))
				auto_id = 1;
		
		//아이디 쿠키
		if(auto_id == 1) cookie_Service.setId(user_id, response);	//쿠키 저장
		else cookie_Service.delId(response);	//쿠키 삭제


		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
    	
		int res = member_Service.getUserIdPwCount(user_id, user_pw);
		if(res != 0) {
			res = 1;
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_pw", user_pw);
		}else {
			msg = "아이디 또는 비밀번호를 확인해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		msg = "로그인 성공.";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//로그아웃
	@RequestMapping("/tour/logout.o")
	public ModelAndView logout(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		msg = "로그아웃 성공";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//회원수정
	@RequestMapping("/tour/login_edit.o")
	public ModelAndView login_edit(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		
		mav.setViewName("tour/login_edit");
		return mav;
	}
	//회원수정 완료
	@RequestMapping("/tour/login_edit_post.o")
	public ModelAndView login_edit_post(
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
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		
		if(member_info == null) {
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
		mdata.setNo(member_info.getNo());
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
		
		
		if(!user_pw.equals("none")) {
			session.setAttribute("user_id", member_info.getUser_id());
			session.setAttribute("user_pw", user_pw);
		}
		
		msg = "수정 성공";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	
	

	//아이디 찾기
	@RequestMapping("/tour/find_id.o")
	public ModelAndView find_id() throws SQLException {
		ModelAndView mav = new ModelAndView();

		
		mav.setViewName("tour/find_id");
		return mav;
	}
	//아이디 찾기
	@RequestMapping("/tour/find_id_post.o")
	public ModelAndView find_id_post(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
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
		
		Map map = new HashMap();
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		String user_id = "";
		user_id = member_Service.getFindId(name, phone1, phone2, phone3);
		if(user_id == null) user_id = "";
		

		mav.addObject("name", name);
		mav.addObject("phone1", phone1);
		mav.addObject("phone2", phone2);
		mav.addObject("phone3", phone3);
		mav.addObject("user_id", user_id);
		mav.setViewName("tour/find_id_post");
		return mav;
	}
	//비밀번호 찾기
	@RequestMapping("/tour/find_pw.o")
	public ModelAndView find_pw(
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		mav.addObject("name", name);
		mav.addObject("phone1", phone1);
		mav.addObject("phone2", phone2);
		mav.addObject("phone3", phone3);
		mav.addObject("user_id", user_id);
		mav.setViewName("tour/find_pw");
		return mav;
	}
	//비밀번호 찾기 완료
	@RequestMapping("/tour/find_pw_post.o")
	public ModelAndView find_pw_post(
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
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
		
		int tmp = member_Service.getFindPw(user_id, name, phone1, phone2, phone3, quest, answer);
		
		int res = 0;
		if(tmp == 0) res = 0;
		else res = 1;
		
		mav.addObject("name", name);
		mav.addObject("phone1", phone1);
		mav.addObject("phone2", phone2);
		mav.addObject("phone3", phone3);
		mav.addObject("user_id", user_id);
		mav.addObject("quest", quest);
		mav.addObject("answer", answer);
		mav.addObject("res", res);
		mav.setViewName("tour/find_pw_post");
		return mav;
	}
	//비밀번호 수정
	@RequestMapping("/tour/find_pw_change.o")
	public ModelAndView find_pw_change(
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			@RequestParam(value="user_pw2", defaultValue="") String user_pw2
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
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
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(user_pw2.equals("")) {
			msg = "비밀번호 확인을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(!user_pw2.equals(user_pw)) {
			msg = "비밀번호가 다릅니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Member_Data mdata = new Member_Data();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		mdata.setName(name);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		member_Service.changePw(mdata);
		
		
		
		msg = "비밀번호 변경이 완료되었습니다.";
		url = "login.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	
	
	
	
	
	
	
	
	
	//회원가입 동의
	@RequestMapping("/tour/join.o")
	public ModelAndView join() throws SQLException {
		ModelAndView mav = new ModelAndView();

		
		mav.setViewName("tour/join");
		return mav;
	}
	//회원가입 작성
	@RequestMapping("/tour/join_write.o")
	public ModelAndView join_write() throws SQLException {
		ModelAndView mav = new ModelAndView();

		
		mav.setViewName("tour/join_write");
		return mav;
	}
	//회원가입 작성완료
	@RequestMapping("/tour/join_write_post.o")
	public ModelAndView join_write_post(
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			@RequestParam(value="user_pw2", defaultValue="") String user_pw2,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="zipcode", defaultValue="") String zipcode,
			@RequestParam(value="addr", defaultValue="") String addr,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		if(user_id.equals("")) {
			msg = "아이디를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(user_pw2.equals("")) {
			msg = "비밀번호 확인을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(!user_pw2.equals(user_pw)) {
			msg = "비밀번호가 다릅니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(name.equals("")) {
			msg = "이름을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(email.equals("")) {
			msg = "이메일을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(addr.equals("")) {
			msg = "주소를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(quest == -1) {
			msg = "질문을 선택해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해 주세요.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		Member_Data mdata = new Member_Data();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		mdata.setName(name);
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		mdata.setDates(year+"-"+month+"-"+day);
		mdata.setOrders(2);
		
		member_Service.insert(mdata);
		
		mav.addObject("name", name);
		mav.setViewName("tour/join_write_post");
		return mav;
	}
	//회원가입 아이디 확인
	@RequestMapping("/tour/join_id_check.o")
	public ModelAndView join_id_check(
			@RequestParam(value="user_id", defaultValue="") String user_id
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		int result = 0;
		
		int tmp = member_Service.getUserIdCount(user_id);
		
		if(tmp == 0) result = 1;
		else result = 0;
		
		
		mav.addObject("result", result);
		mav.setViewName("tour/join_id_check");
		return mav;
	}
}
