package com.myjob.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.myjob.dao.ReportDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;
import com.myjob.ext.Md5Enc;
import com.myjob.service.IncomeService;
import com.myjob.service.InterviewService;
import com.myjob.service.RecruitListService;
import com.myjob.service.RecruitService;
import com.myjob.service.ReviewService;
import com.myjob.ext.ActionTime;

import oracle.net.aso.MD5;




@Controller
public class LoginController {
	@Autowired
	MemberDao memberService;
	@Autowired
	CompanyDao companyService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	IncomeService incomeService;
	@Autowired
	InterviewService interviewService;
	@Autowired
	RecruitService recruitService;
	@Autowired
	RecruitListService recruitListService;
	@Autowired
	ReportDao reportService;

	String msg = "";
	String url = "";
	
	//�α���
	@RequestMapping("/job/login.o")
	public ModelAndView login(
			@CookieValue(value="save_id_auth", defaultValue="") String save_id_auth
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("save_id_auth", save_id_auth);
		mav.setViewName("job/login");
		return mav;
	}
	//�α��� üũ ajax
	@RequestMapping("/job/login_check_ajax.o")
	@ResponseBody
	public Map login_check_ajax(
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="password", defaultValue="") String password
			) throws Exception {
		Map map = new HashMap();
		
		password = Md5Enc.getEncMD5(password.getBytes());
		
		if(!memberService.existLogin(email, password)) {
			map.put("msg", "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
			map.put("result", false);
			return map;
		}
		map.put("result", true);
		return map;
	}
	//�α���
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
		
		msg = "�α��� ����";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//�α׾ƿ�
	@RequestMapping("/job/logout.o")
	public ModelAndView logout(
			HttpSession session
			) throws SQLException {
		ModelAndView mav = new ModelAndView();

		session.setAttribute("job_email", "");
		session.setAttribute("job_password", "");
		
		msg = "�α׾ƿ� ����";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//ȸ������
	@RequestMapping("/job/join.o")
	public ModelAndView join() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("job/join");
		return mav;
	}
	//ȸ������
	@RequestMapping("/job/login_edit.o")
	public ModelAndView login_edit(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		//��α���
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		
		mav.setViewName("job/login_edit");
		return mav;
	}
	//ȸ������ �Ϸ�
	@RequestMapping("/job/login_edit_post.o")
	public ModelAndView login_edit_post(
			@ModelAttribute("mdata") MemberData mdata,
			HttpSession session,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		MemberData memberInfo = (MemberData)request.getAttribute("memberInfo");
		//��α���
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		if(!mdata.getPassword().equals("")) {
			if(!mdata.getPassword().equals(mdata.getPassword2())) {
				msg = "��й�ȣ�� �ٸ��ϴ�.";
				mav.addObject("msg", msg);
				mav.setViewName("job/error");
				return mav;
			}else {
				mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));
				session.setAttribute("job_password", mdata.getPassword());
			}
		}else {
			mdata.setPassword("-1");
		}
		mdata.setNo(memberInfo.getNo());
		
		memberService.update(mdata);
		
		
		msg = "ȸ������ ����";
		url = "index.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//ȸ������ �Ϸ�
	@RequestMapping("/job/join_post.o")
	public ModelAndView join_post(
			@ModelAttribute("mdata") MemberData mdata
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		if(mdata.getOrders() == 1) {	//����ȸ��
			mdata.setCompany("");
			mdata.setCompany_cate(-1);
			mdata.setCompany_num("");
		}
		
		
		mdata.setDates(ActionTime.getDate());
		
		//��ȣȭ
		mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));
		memberService.insert(mdata);
		
		if(mdata.getOrders() == 2) {	//���ȸ��
			//���θ��� ��������� ��������
			MemberData mdata_tmp = memberService.login(mdata.getEmail(), mdata.getPassword());
			//ȸ������ �߰�
			CompanyData cdata = new CompanyData();
			cdata.setMember_no(mdata_tmp.getNo());
			companyService.insert(cdata);
		}
		
		
		
		msg = "ȸ������ ����";
		url = "login.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//�̸��� üũ ajax
	@RequestMapping("/job/join_email_check_ajax.o")
	@ResponseBody
	public Map join_email_check_ajax(@ModelAttribute("mdata") MemberData mdata) throws Exception {
		Map map = new HashMap();
		if(mdata.getEmail().equals("") || mdata.getEmail() == null) {
			map.put("msg", "�̸����� �Է����ּ���.");
			map.put("result", false);
			return map;
		}
		if(mdata.getEmail().length() < 5 || !mdata.getEmail().contains("@") || mdata.getEmail().split("@").length < 2) {
			map.put("msg", "�߸��� �̸��� �����Դϴ�.");
			map.put("result", false);
			return map;
		}
		if(memberService.existEmail(mdata)) {
			map.put("msg", "�̹� �����ϴ� �̸����Դϴ�.");
			map.put("result", false);
			return map;
		}
		
		map.put("msg", "����� �� �ִ� �̸����Դϴ�.");
		map.put("result", true);
		return map;
	}

	//�ȷο� ajax
	@RequestMapping("/job/follow_ajax.o")
	@ResponseBody
	public Map follow_ajax(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		if(member_no == -1) {
			map.put("msg", "�߸��� �����Դϴ�");
			map.put("result", -1);
			return map;
		}
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		if(mdata == null) {
			map.put("msg", "�α��� ���ּ���.");
			map.put("result", -1);
			return map;
		}
		
		
		ArrayList<String> list;
		String member_nos = Integer.toString(member_no);
		
		if(mdata.getFollow() == null || mdata.getFollow().equals("")) list = new ArrayList<String>();
		else list = new ArrayList<String>(Arrays.asList(mdata.getFollow().split(",")));
		
		if(list.contains(member_nos)) {
			list.remove(member_nos);
			String tmp = "";
			for(int i=0;i<list.size();i++) {
				if(i != 0) tmp += ",";
				tmp += (String)list.get(i);
			}
			memberService.followUpdate(tmp, mdata.getNo());
			map.put("msg", "�����Ǿ����ϴ�.");
			map.put("result", 1);
			return map;
		}else {
			list.add(member_nos);
			String tmp = "";
			for(int i=0;i<list.size();i++) {
				if(i != 0) tmp += ",";
				tmp += (String)list.get(i);
			}
			memberService.followUpdate(tmp, mdata.getNo());
			map.put("msg", "��ϵǾ����ϴ�.");
			map.put("result", 2);
			return map;
		}
	}

	
	
	
	
	
	//�α��� ajax
	@RequestMapping("/job/login_post_ajax.o")
	@ResponseBody
	public Map login_post_ajax(
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="password", defaultValue="") String password,
			@RequestParam(value="save_id", defaultValue="-1") int save_id,
			@RequestParam(value="kakao", defaultValue="-1") int kakao,
			@RequestParam(value="name", defaultValue="") String name,
			HttpSession session,
			HttpServletResponse response
			) throws SQLException {
		Map map = new HashMap();
		
		password = Md5Enc.getEncMD5(password.getBytes());
		
		map.put("kakao", kakao);
		
		//īī�� �α����϶� & ���۵� ���� ���
		if(kakao == 1 || kakao == 2) {
			//īī�� ȸ���� ������ ���� ����
			email = Md5Enc.getEncMD5(email.getBytes());
			if(!memberService.existLogin(email, password)) {
				MemberData mdata = new MemberData();
				mdata.setEmail(email);
				mdata.setPassword(password);
				mdata.setName(name);
				mdata.setOrders(1);
				mdata.setDates(ActionTime.getDate());
				mdata.setKakao(kakao);
				memberService.insert(mdata);
			}
		}
		
		
		
		
		

		session.setAttribute("job_email", email);
		session.setAttribute("job_password", password);
		
		if(kakao == -1) {
		if(save_id == 1) {
			Cookie cookie = new Cookie("save_id_auth", email);
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("save_id_auth", "");
			response.addCookie(cookie);
		}
		}else {
			Cookie cookie = new Cookie("save_id_auth", "");
			response.addCookie(cookie);
		}
		
		//�α������� ��������
		String job_email = (String)session.getAttribute("job_email");
		String job_password = (String)session.getAttribute("job_password");
		if(job_email == null) job_email = "";
		if(job_password == null) job_password = "";
		
		MemberData mdata = memberService.login(job_email, job_password);
		map.put("memberInfo", mdata);
		
		
		//�ȷο� ����Ʈ
		ArrayList<String> list;
		if(mdata.getFollow() == null || mdata.getFollow().equals("")) list = new ArrayList<String>();
		else list = new ArrayList<String>(Arrays.asList(mdata.getFollow().split(",")));
		map.put("list", list);
		
		
		map.put("result", true);
		return map;
	}
	//�α׾ƿ� ajax
	@RequestMapping("/job/logout_ajax.o")
	@ResponseBody
	public Map logout_ajax(
			HttpSession session
			) throws SQLException {
		Map map = new HashMap();

		session.setAttribute("job_email", "");
		session.setAttribute("job_password", "");
		
		map.put("result", true);
		return map;
	}
	//ȸ������ �Ϸ�
	@RequestMapping("/job/join_post_ajax.o")
	@ResponseBody
	public Map join_post_ajax(
			@ModelAttribute("mdata") MemberData mdata
			) throws SQLException {
		Map map = new HashMap();
		
		if(mdata.getOrders() == 1) {	//����ȸ��
			mdata.setCompany("");
			mdata.setCompany_cate(-1);
			mdata.setCompany_num("");
		}
		
		
		mdata.setDates(ActionTime.getDate());
		
		//��ȣȭ
		mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));
		memberService.insert(mdata);
		
		if(mdata.getOrders() == 2) {	//���ȸ��
			//���θ��� ��������� ��������
			MemberData mdata_tmp = memberService.login(mdata.getEmail(), mdata.getPassword());
			//ȸ������ �߰�
			CompanyData cdata = new CompanyData();
			cdata.setMember_no(mdata_tmp.getNo());
			companyService.insert(cdata);
		}
		
		

		map.put("result", true);
		return map;
	}
	//�α������� ��������
	@RequestMapping("/job/login_info_ajax.o")
	@ResponseBody
	public Map login_info_ajax(
			HttpServletRequest request
			) throws SQLException {
		Map map = new HashMap();

		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		map.put("memberInfo", mdata);
		
		return map;
	}
	//ȸ������ �Ϸ�
	@RequestMapping("/job/login_edit_post_ajax.o")
	@ResponseBody
	public Map login_edit_post_ajax(
			@ModelAttribute("mdata") MemberData mdata,
			HttpSession session,
			HttpServletRequest request
			) throws SQLException {
		Map map = new HashMap();
		
		MemberData memberInfo = (MemberData)request.getAttribute("memberInfo");
		
		//��α���
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		if(!mdata.getPassword().equals("")) {
			if(!mdata.getPassword().equals(mdata.getPassword2())) {
				msg = "��й�ȣ�� �ٸ��ϴ�.";
				map.put("msg", msg);
				map.put("result", false);
				return map;
			}else {
				mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));
				session.setAttribute("job_password", mdata.getPassword());
			}
		}else {
			mdata.setPassword("-1");
		}
		mdata.setNo(memberInfo.getNo());
		
		memberService.update(mdata);
		
		String job_email = (String)session.getAttribute("job_email");
		String job_password = (String)session.getAttribute("job_password");
		if(job_email == null) job_email = "";
		if(job_password == null) job_password = "";
		memberInfo = memberService.login(job_email, job_password);

		map.put("memberInfo", memberInfo);
		request.setAttribute("memberInfo", memberInfo);

		
		int member_no = (Integer)request.getAttribute("member_no");
		map.put("member_no", member_no);
		
		
		map.put("result", true);
		return map;
	}
	

	//�̸��� ã��
	@RequestMapping("/job/email_find_ajax.o")
	@ResponseBody
	public Map email_find_ajax(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			HttpServletRequest request
			) throws SQLException {
		Map map = new HashMap();

		int count = memberService.findEmailCount(name, phone1, phone2, phone3);
		if(count == 0) {
			map.put("result", false);
			return map;
		}else {
			MemberData mdata = memberService.findEmail(name, phone1, phone2, phone3);
			map.put("email", mdata.getEmail());
			map.put("result", true);
			return map;
		}
	}
	//��й�ȣ ã��
	@RequestMapping("/job/pw_find_ajax.o")
	@ResponseBody
	public Map pw_find_ajax(
			@ModelAttribute("mdata") MemberData mdata,
			HttpServletRequest request
			) throws SQLException {
		Map map = new HashMap();

		int count = memberService.findPwCount(mdata);
		if(count == 0) {
			map.put("result", false);
			return map;
		}else {
			map.put("result", true);
			return map;
		}
	}
	//��й�ȣ ����
	@RequestMapping("/job/pw_change_ajax.o")
	@ResponseBody
	public Map pw_change_ajax(
			@ModelAttribute("mdata") MemberData mdata,
			HttpServletRequest request
			) throws SQLException {
		Map map = new HashMap();
		
		if(mdata.getPassword() == null) {
			msg = "�߸��� �����Դϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getPassword().equals("")) {
			msg = "�߸��� �����Դϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(!mdata.getPassword().equals(mdata.getPassword2())) {
			msg = "��й�ȣ�� �ٸ��ϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));

		MemberData tmp = memberService.changePwKakao(mdata);
		if(tmp.getKakao() == 1) {
			msg = "īī������ȸ���� ������ �� �����ϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(tmp.getKakao() == 2) {
			msg = "���۰���ȸ���� ������ �� �����ϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		memberService.changePw(mdata);
		
		
		
		map.put("result", true);
		return map;
	}
	//ȸ��Ż��
	@RequestMapping("/job/login_exit_ajax.o")
	@ResponseBody
	public Map login_exit_ajax(
			@RequestParam(value="password", defaultValue="") String password,
			@RequestParam(value="password2", defaultValue="") String password2,
			HttpServletRequest request
			) throws SQLException {
		Map map = new HashMap();

		if(password == null) {
			msg = "��й�ȣ�� �Է����ּ���.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(password2 == null) {
			msg = "��й�ȣ2�� �Է����ּ���.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(password.equals("")) {
			msg = "��й�ȣ�� �Է����ּ���.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(password2.equals("")) {
			msg = "��й�ȣ2�� �Է����ּ���.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(!password.equals(password2)) {
			msg = "��й�ȣ�� �ٸ��ϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		MemberData memberInfo = (MemberData)request.getAttribute("memberInfo");
		
		if(memberInfo == null) {
			msg = "�߸��� �����Դϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		if(!memberInfo.getPassword().equals(Md5Enc.getEncMD5(password.getBytes()))) {
			msg = "�߸��� ��й�ȣ�Դϴ�.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		
		memberService.deleteUser(memberInfo);
		companyService.deleteUser(memberInfo);
		reviewService.deleteUser(memberInfo);
		incomeService.deleteUser(memberInfo);
		interviewService.deleteUser(memberInfo);
		recruitService.deleteUser(memberInfo);
		recruitListService.deleteUser(memberInfo);
		reportService.deleteUser(memberInfo);
		
		
		
		map.put("result", true);
		return map;
	}
}
