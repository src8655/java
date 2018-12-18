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
	
	//�α���
	@RequestMapping("/shop/login.o")
	public ModelAndView login(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/login");
		
		String user_id = "";
		//��Ű����
		user_id = cookie_Bean.getId(request);	//��Ű���� ���̵� �޾ƿ´�
		
		mav.addObject("user_id", user_id);
		
		return mav;
	}
	//�α����ϱ�
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
			msg = "���̵� �Է��ϼ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(user_pw.equals("")) {
			msg = "��й�ȣ�� �Է��ϼ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		//�ڵ����̵� üũ�Ǿ����� Ȯ��
		int auto_id = 0;
		if(auto_ids != null)
			if(!auto_ids.equals(""))
				auto_id = 1;
		
		//���̵� ��Ű
		if(auto_id == 1) cookie_Bean.setId(user_id, response);	//��Ű ����
		else cookie_Bean.delId(response);	//��Ű ����

		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(user_pw);
    	//��ȣȭ
    	mdata.setUser_pw(Md5Enc.getEncMD5(mdata.getUser_pw().getBytes()));
    	
		int res = 0;
		if(member_DB_Bean.login_M(mdata)) {
			res = 1;
			HttpSession session = request.getSession();
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getUser_pw());
		}
		
		if(res == 0) {
			msg = "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		msg = "�α��� ����.";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//�α׾ƿ�
	@RequestMapping("/shop/logout.o")
	public ModelAndView logout(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		msg = "�α׾ƿ� ����";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//���̵�ã��
	@RequestMapping("/shop/login_find_id.o")
	public ModelAndView login_find_id() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("shop/login_find_id");
		return mav;
	}
	//���̵�ã��
	@RequestMapping("/shop/login_find_id_post.o")
	public ModelAndView login_find_id_post(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		if(name.equals("")) {
			msg = "�̸��� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone1.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone2.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone3.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
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
	//��й�ȣã��
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
	//��й�ȣã��
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
			msg = "���̵� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(name.equals("")) {
			msg = "�̸��� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone1.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone2.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone3.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(quest == -1) {
			msg = "������ �������ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(answer.equals("")) {
			msg = "�亯�� �Է����ּ���.";
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
	//��й�ȣ����
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
			msg = "���̵� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}if(name.equals("")) {
			msg = "�̸��� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone1.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone2.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(phone3.equals("�޴���ȭ�� �Է����ּ���.")) {
			msg = "";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(quest == -1) {
			msg = "������ �������ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(answer.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(user_pw.equals("")) {
			msg = "��й�ȣ�� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(user_pw2.equals("")) {
			msg = "��й�ȣȮ���� �Է����ּ���.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		if(!user_pw.equals(user_pw2)) {
			msg = "��й�ȣ�� �ٸ��ϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
		
		//��ȣȭ
		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		
		int res = 0;
		if(member_DB_Bean.changePw_M(user_id, name, phone1, phone2, phone3, quest, answer, user_pw))
			res = 1;
		
		if(res == 1) {
			msg = "��й�ȣ ���� ����.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else {
			msg = "��й�ȣ ���� ����.";
			mav.addObject("msg", msg);
			mav.setViewName("shop/post2");
			return mav;
		}
	}
}
