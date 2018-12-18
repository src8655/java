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
public class JoinController {
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
	
	//회원가입
	@RequestMapping("/shop/join.o")
	public ModelAndView join() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/join");
		
		return mav;
	}
	//회원가입 작성
	@RequestMapping("/shop/join_write.o")
	public ModelAndView join_write(
			@RequestParam(value="order", defaultValue="-1") int order
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/join_write");
		mav.addObject("order", order);
		
		return mav;
	}
	//회원가입 완료
	@RequestMapping("/shop/join_write_post.o")
	public ModelAndView join_write_post(
			@RequestParam(value="order", defaultValue="-1") int order,
			@RequestParam(value="company_number", defaultValue="") String company_number,
			@RequestParam(value="bank", defaultValue="") String bank,
			@RequestParam(value="bank_num", defaultValue="") String bank_num,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			@RequestParam(value="user_pw2", defaultValue="") String user_pw2,
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="zipcode", defaultValue="") String zipcode,
			@RequestParam(value="addr", defaultValue="") String addr,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(order == 2 && company_number.equals("")) {
			msg = "사업자등록번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(order == 2 && bank.equals("")) {
			msg = "입금은행을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(order == 2 && bank_num.equals("")) {
			msg = "계좌번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(name.equals("")) {
			msg = "이름을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(user_id.equals("")) {
			msg = "아이디를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(user_pw2.equals("")) {
			msg = "비밀번호 확인을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(!user_pw.equals(user_pw2)) {
			msg = "비밀번호가 다릅니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(email.equals("")) {
			msg = "이메일을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(addr.equals("")) {
			msg = "주소를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(quest == -1) {
			msg = "질문을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		int count = member_DB_Bean.selectId_M(user_id);
		if(count != 0) {
			msg = "이미 존재하는 아이디입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_id(user_id);
		mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setOrders(order);
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		int res = 0;	//1성공 0실패
		if(member_DB_Bean.insert_M(mdata)) res = 1;
		
		
		
		mav.setViewName("shop/join_write_post");
		mav.addObject("order", order);
		mav.addObject("name", name);
		mav.addObject("res", res);
		
		return mav;
	}
	//아이디확인
	@RequestMapping("/shop/join_id_check.o")
	public ModelAndView join_id_check(
			@RequestParam(value="user_id", defaultValue="") String user_id,
			@RequestParam(value="result", defaultValue="0") String result
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/join_id_check");
		
		int count = member_DB_Bean.selectId_M(user_id);
		//성공시 1 실패시 0
		if(count == 0) result = "1";
	       	
		mav.addObject("user_id", user_id);
		mav.addObject("result", result);
		
		return mav;
	}
	//아이디확인
	@RequestMapping("/shop/join_agree.o")
	public ModelAndView join_agree(
			@RequestParam(value="order", defaultValue="-1") int order
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/join_agree");
		
		mav.addObject("order", order);
		
		return mav;
	}
	//수정하기
	@RequestMapping("/shop/join_edit.o")
	public ModelAndView join_edit(
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/join_edit");
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		return mav;
	}

	//수정하기
	@RequestMapping("/shop/join_edit_post.o")
	public ModelAndView join_edit_post(
			@RequestParam(value="company_number", defaultValue="") String company_number,
			@RequestParam(value="bank", defaultValue="") String bank,
			@RequestParam(value="bank_num", defaultValue="") String bank_num,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="user_id", defaultValue="") String user_id,
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
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info.getOrders() == 2 && company_number.equals("")) {
			msg = "사업자등록번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(member_info.getOrders() == 2 && bank.equals("")) {
			msg = "입금은행을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(member_info.getOrders() == 2 && bank_num.equals("")) {
			msg = "계좌번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(name.equals("")) {
			msg = "이름을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(!user_pw.equals(user_pw2) && (!user_pw.equals("") || !user_pw2.equals(""))) {
			msg = "비밀번호가 다릅니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(email.equals("")) {
			msg = "이메일을 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(addr.equals("")) {
			msg = "주소를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		if(quest == -1) {
			msg = "질문을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_id(member_info.getUser_id());
		if(!user_pw.equals("") || !user_pw2.equals(""))
			mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		else mdata.setUser_pw("");
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setOrders(member_info.getOrders());
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		mdata.setNo(member_info.getNo());
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		int res = 0;	//1성공 0실패
		if(member_DB_Bean.update_M(mdata)) res = 1;

		if(res == 1) {
			//비밀번호 수정이 있을때 재로그인
			if(!user_pw.equals("") || !user_pw2.equals("")) {
				HttpSession session = request.getSession();
				session.setAttribute("user_pw", mdata.getUser_pw());
			}
			
			msg = "수정 성공.";
			url = "index.o";
			mav.setViewName("shop/post");
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			return mav;
		}else{
			msg = "수정 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
}
