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
import net.mytour.dao.Notice_Dao;
import net.mytour.dao.Reserve_Dao;
import net.mytour.dao.Review_Dao;
import net.mytour.data.List_Data;
import net.mytour.data.List_Reserve_Data;
import net.mytour.data.Member_Data;
import net.mytour.data.Notice_Data;
import net.mytour.data.Reserve_Data;
import net.mytour.data.Review_Data;
import net.mytour.ext.Action_Paging;
import net.mytour.ext.Number_Format;


@Controller
public class MypageController {
	@Autowired
	List_Reserve_Dao list_Reserve_Service;
	@Autowired
	Reserve_Dao reserve_Service;
	@Autowired
	List_Dao list_Service;
	@Autowired
	Notice_Dao notice_Service;
	@Autowired
	Review_Dao review_Service;

	String msg = "";
	String url = "";

	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);
	
	//����
	@RequestMapping("/tour/reserve.o")
	public ModelAndView reserve(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		List_Reserve_Data lrdata;
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		
		
		if(session.getAttribute("basket") == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		HashMap map = (HashMap)session.getAttribute("basket");
				
		lrdata = (List_Reserve_Data) list_Reserve_Service.getArticle(no);

		//���� �ְ�
		lrdata.setChoice_cnts((Integer)map.get(no));
				
		//������ŭ �ݾ׺���
		lrdata.setMoney(lrdata.getMoney()*lrdata.getChoice_cnts());
		lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));

		mav.addObject("no", no);
		mav.addObject("lrdata", lrdata);
		mav.setViewName("tour/reserve");
		return mav;
	}
	//����Ϸ�
	@RequestMapping("/tour/reserve_post.o")
	public ModelAndView reserve_post(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		//��¥ ����
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		List_Reserve_Data lrdata;
		Reserve_Data rdata;
		String bank = "";
		String bank_num = "";
		
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		
		if(session.getAttribute("basket") == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		HashMap map = (HashMap)session.getAttribute("basket");
		
		lrdata = (List_Reserve_Data) list_Reserve_Service.getArticle(no);

		//���� �ְ�
		lrdata.setChoice_cnts((Integer)map.get(no));
				
		//������ŭ �ݾ׺���
		lrdata.setMoney(lrdata.getMoney()*lrdata.getChoice_cnts());
		lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));
		
		
		
		
		/////////////////
		//������� �����κ�
		/////////////////
		bank = "����";
		bank_num = "";
		Random rand = new Random();
		int tmp1 = rand.nextInt(90000)+10000;
		int tmp2 = rand.nextInt(90)+10;
		int tmp3 = rand.nextInt(9000000)+10000000;
		bank_num = tmp1+"-"+tmp2+"-"+tmp3;
		
		rdata = new Reserve_Data();
		rdata.setList_no(lrdata.getList_no());
		rdata.setList_reserve_no(lrdata.getNo());
		rdata.setMoney(lrdata.getMoney());
		rdata.setMoneys(lrdata.getMoneys());
		rdata.setCnts(lrdata.getChoice_cnts());
		rdata.setStatus(1);
		rdata.setMember_no(member_info.getNo());
		rdata.setDates(year+"-"+month+"-"+day);
		rdata.setBank(bank);
		rdata.setBank_num(bank_num);
		
		
		reserve_Service.insert(rdata);
		list_Reserve_Service.setIsreserve(lrdata.getNo(), 1);
		
		//��ٱ��Ͽ��� ����
		map.remove(lrdata.getNo());
		session.setAttribute("basket", map);
		

		mav.addObject("no", no);
		mav.addObject("bank", bank);
		mav.addObject("bank_num", bank_num);
		mav.addObject("rdata", rdata);
		mav.addObject("lrdata", lrdata);
		mav.setViewName("tour/reserve_post");
		return mav;
	}
	
	
	
	
	
	//����Ȯ��
	@RequestMapping("/tour/mypage.o")
	public ModelAndView mypage(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		//��¥ ����
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		
		int process1 = 0;
		int process2 = 0;
		int process3 = 0;
		int process4 = 0;
		List list;
		Action_Paging paging;
		
		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		
		
		
		//���� ���� ����
		process1 = reserve_Service.getStatusCount(member_info.getNo(), 1);
		process2 = reserve_Service.getStatusCount(member_info.getNo(), 2);
		process3 = reserve_Service.getStatusCount(member_info.getNo(), 3);
		process4 = reserve_Service.getStatusCount(member_info.getNo(), 4);

		int total = reserve_Service.getCount(member_info.getNo());
		paging = new Action_Paging(total, 5, pages);
		
		list = reserve_Service.getArticles(member_info.getNo(), paging.getBoard_starts(), paging.getBoard_ends());
		
		
		for(int i=0;i<list.size();i++) {
			Reserve_Data ldata = (Reserve_Data)list.get(i);
			if(ldata.getStatus() != 1) continue;			//�Աݴ���߻��¾ƴϸ� �Ѿ
			long tmp_now = cal.getTimeInMillis()/1000;
			long tmp_after = Long.parseLong(ldata.getTimes())/1000;
			long tmp_result = tmp_after - tmp_now;
			
			//�ð��� ����
			ldata.setTimes_tmp(Long.toString(tmp_result));
		}
		
		
		
		//�����δ� Ǯ��
		
		//�Աݴ�����ε� ����� �ʰ����¸� ���ó��
		for(int i=0;i<list.size();i++) {
			Reserve_Data rdata = (Reserve_Data)list.get(i);
			//������� ���ó�¥ �̻��̸� ��ҺҰ���
			Long now = cal.getTimeInMillis();
			Long st = Long.parseLong(rdata.getTimes());
			if(now >= st && rdata.getStatus() == 1) {
				//���� ��ҷ� ����
				Map map2 = new HashMap();
				map2.put("no", rdata.getNo());
				map2.put("status", 4);
				reserve_Service.setStatus(rdata.getNo(), 4);
				rdata.setStatus(4);
			}
		}
		

		mav.addObject("process1", process1);
		mav.addObject("process2", process2);
		mav.addObject("process3", process3);
		mav.addObject("process4", process4);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("pages", pages);
		mav.setViewName("tour/mypage");
		return mav;
	}
	//����Ȯ�� ����
	@RequestMapping("/tour/mypage_view.o")
	public ModelAndView mypage_view(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		//��¥ ����
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		Reserve_Data rdata;
		
		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		rdata = reserve_Service.getArticle(no);
		
		if(rdata.getStatus() == 1) {
			long tmp_now = cal.getTimeInMillis()/1000;
			long tmp_after = Long.parseLong(rdata.getTimes())/1000;
			long tmp_result = tmp_after - tmp_now;
			
			//�ð��� ����
			rdata.setTimes_tmp(Long.toString(tmp_result));
		}
		
		//�� �Խñ��� �ƴϸ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		

		mav.addObject("rdata", rdata);
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.setViewName("tour/mypage_view");
		return mav;
	}
	//����Ȯ�� ����
	@RequestMapping("/tour/mypage_review.o")
	public ModelAndView mypage_review(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		//��¥ ����
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		Reserve_Data rdata;
		
		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		rdata = reserve_Service.getArticle(no);
		
		//�ԱݿϷ� ���°� �ƴҶ�
		if(rdata.getStatus() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		//������ �ƴҶ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		

		mav.addObject("rdata", rdata);
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.setViewName("tour/mypage_review");
		return mav;
	}
	//����Ȯ�� ����Ϸ�
	@RequestMapping("/tour/mypage_review_post.o")
	public ModelAndView mypage_review_post(
			@RequestParam(value="stars", defaultValue="") int stars,
			@RequestParam(value="memo", defaultValue="") String memo,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		//��¥ ����
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;

		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Reserve_Data rdata = reserve_Service.getArticle(no);
		
		//�ԱݿϷ� ���°� �ƴҶ�
		if(rdata.getStatus() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		//������ �ƴҶ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		Review_Data rvdata = new Review_Data();
		rvdata.setList_no(rdata.getList_no());
		rvdata.setStars(stars);
		rvdata.setMemo(memo);
		rvdata.setMember_no(member_info.getNo());
		String user_id = "";
		if(member_info.getUser_id().length() < 3)
			user_id = member_info.getUser_id().substring(0, 1)+"***";
		else
			user_id = member_info.getUser_id().substring(0, 3)+"***";
		rvdata.setUser_id(user_id);
		rvdata.setDates(year+"-"+month+"-"+day);
		
		
		//�Է�
		review_Service.insert(rvdata);
		
		
		//���� ����Ϸ�� �ٲ�
		reserve_Service.setStatus(rdata.getNo(), 3);
		
		
		//���� ī��Ʈ �߰�
		int tmps = list_Service.getBuy(rdata.getList_no());
		tmps++;
		list_Service.setBuy(tmps, rdata.getList_no());
		
		int res = 0;
		res = 1;
		
		
		mav.addObject("pages", pages);
		mav.addObject("no", no);
		mav.addObject("res", res);
		mav.setViewName("tour/mypage_review_post");
		return mav;
	}
	//����Ȯ�� ����Ϸ�
	@RequestMapping("/tour/mypage_cancel.o")
	public ModelAndView mypage_cancel(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		Member_Data member_info = (Member_Data)request.getAttribute("member_info");
		int level = (Integer)request.getAttribute("level");
		
		//��¥ ����
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;

		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("tour/post");
			return mav;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		
		Reserve_Data rdata = reserve_Service.getArticle(no);
		
		//�� �Խñ��� �ƴϸ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		//���°� �̹� ��һ����̰ų� ����Ϸ� �����̸�
		if(rdata.getStatus() == 3 || rdata.getStatus() == 4) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}

		//������� ���ó�¥ �̻��̸� ��ҺҰ���
		Long now = cal.getTimeInMillis();
		Long st = Long.parseLong(rdata.getTimes());
		if(now >= st) {
			msg = "��߳�¥�� �ʰ��Ǿ����ϴ�.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//���� ��ҷ� ����
		reserve_Service.setStatus(rdata.getNo(), 4);
		
		//��ǰ���� ���󺹱�
		list_Reserve_Service.setIsreserve(rdata.getList_reserve_no(), 0);
		
		msg = "��� ����";
		url = "mypage.o?pages="+pages;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
}
