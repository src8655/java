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
import net.myshop.dao.List_DB;
import net.myshop.dao.Member_DB;
import net.myshop.dao.Sell_DB;
import net.myshop.dao.Sell_Group;
import net.myshop.dao.View_Qna_DB;
import net.myshop.dao.View_Review_DB;
import net.myshop.data.List_Data_Bean;
import net.myshop.data.Member_Data_Bean;
import net.myshop.data.Sell_Data_Bean;
import net.myshop.data.Sell_Group_Data_Bean;
import net.myshop.data.View_Qna_Data_Bean;
import net.myshop.data.View_Review_Data_Bean;
import net.myshop.ext.Action_Paging;
import net.myshop.ext.Md5Enc;

@Controller
public class MypageController {
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
	Sell_Group sell_Group_DB_Bean;
	
	String msg = "";
	String url = "";
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH)+1;
	public int day = cal.get(Calendar.DATE);
	
	
	//mypage
	@RequestMapping("/shop/mypage.o")
	public ModelAndView mypage(
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		mav.setViewName("shop/mypage");
		return mav;
	}
	//mypage sell
	@RequestMapping("/shop/mypage_sell.o")
	public ModelAndView mypage_sell(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="cate", defaultValue="-1") int cate,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		Action_Paging paging;
		paging = new Action_Paging(sell_DB_Bean.count2_M(member_info.getNo(), cate), 10, pages);
		
		List list;
		//����Ʈ ��������
		list = sell_DB_Bean.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), cate);

		

		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("cate", cate);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_sell");
		return mav;
	}
	//mypage sell post
	@RequestMapping("/shop/mypage_sell_post.o")
	public ModelAndView mypage_sell_post(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="status", defaultValue="-1") int status,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="cate", defaultValue="-1") int cate,
			@RequestParam(value="ship_num", defaultValue="") String ship_num,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		
		
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		

		//���º���
		int res = 0;
		
		//�ԱݿϷ�(2)�����̸�
		if(status == 2) {
			if(sell_DB_Bean.changeStatus_M(no, 3)) res = 1;
		}
		//����غ���(3)�����̸�
		if(status == 3) {
			//������ȣ�� ������ ���
			if(ship_num.equals("")) {
				msg = "������ȣ�� �Է����ּ���.";
				mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
			}
			if(sell_DB_Bean.changeShipStatus_M(no, ship_num)) res = 1;
		}
		
		if(res == 1) {
			msg = "���� �Ϸ�.";
			url = "mypage_sell.o?pages="+pages+"&cate="+cate;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "���� ����.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//mypage sell end
	@RequestMapping("/shop/mypage_sell_end.o")
	public ModelAndView mypage_sell_end(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		Action_Paging paging;
		List list;
		
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		paging = new Action_Paging(sell_DB_Bean.count2_M(member_info.getNo(), 5), 10, pages);

		//����Ʈ ��������
		list = sell_DB_Bean.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), 5);

		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_sell_end");
		return mav;
	}
	//mypage list
	@RequestMapping("/shop/mypage_list.o")
	public ModelAndView mypage_list(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchs", defaultValue="-1") int searchs,
			@RequestParam(value="searchs_value", defaultValue="") String searchs_value,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		
		Action_Paging paging;
		List list;
		
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		paging = new Action_Paging(list_DB_Bean.getCount_M(searchs, searchs_value, member_info.getNo(), -1), 20, pages);


		list = list_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), searchs, searchs_value, 10, member_info.getNo(), -1);	//����Ʈ�޾ƿ���

		String searchs_values = URLEncoder.encode(searchs_value,"UTF-8");

		mav.addObject("searchs_values", searchs_values);
		mav.addObject("searchs_value", searchs_value);
		mav.addObject("searchs", searchs);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_list");
		return mav;
	}
	//mypage guest
	@RequestMapping("/shop/mypage_guest.o")
	public ModelAndView mypage_guest(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		Action_Paging paging;
		List list;

		int process1;
		int process2;
		int process3;
		int process4;
		int process5;
		

		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		paging = new Action_Paging(sell_DB_Bean.count_M(member_info.getNo()), 7, pages);
		
		list = sell_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo());
		
		//�ߺ��Ȱ� ī��Ʈ
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//���ο�� ������ ���� �׷��� ������ŭ rowspan���� ����
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sell_DB_Bean.group_count_M2(paging.getBoard_starts(), paging.getBoard_ends(), sdata.getTimes(), sdata.getGuest_no()));
			tmp = sdata.getTimes();
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		
		//���������ֹ� ����
		process1 = sell_DB_Bean.guest_sell_count_M(member_info.getNo(), 1);
		process2 = sell_DB_Bean.guest_sell_count_M(member_info.getNo(), 2);
		process3 = sell_DB_Bean.guest_sell_count_M(member_info.getNo(), 3);
		process4 = sell_DB_Bean.guest_sell_count_M(member_info.getNo(), 4);
		process5 = sell_DB_Bean.guest_sell_count_M(member_info.getNo(), 5);
		
		
		
		mav.addObject("process1", process1);
		mav.addObject("process2", process2);
		mav.addObject("process3", process3);
		mav.addObject("process4", process4);
		mav.addObject("process5", process5);
		mav.addObject("list", list);
		mav.addObject("paging", paging);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_guest");
		return mav;
	}
	//mypage guest view
	@RequestMapping("/shop/mypage_guest_view.o")
	public ModelAndView mypage_guest_view(
			@RequestParam(value="times", defaultValue="") String times,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		Sell_Group_Data_Bean sgdata;
		List list;
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		sgdata = sell_Group_DB_Bean.getArticle_M(times);
		
		//�ݾ����·� �ٲٱ�
		sgdata.setMoneys(number_format(sgdata.getMoney()));
		sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
		sgdata.setRmoneys(number_format(sgdata.getRmoney()));
		sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
		sgdata.setPoints(number_format(sgdata.getPoint()));
		
		//����κ�
		list = sell_DB_Bean.getArticles3_M(sgdata.getTimes());
		
		//�ߺ��Ȱ� ī��Ʈ
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//���ο�� ������ ���� �׷��� ������ŭ rowspan���� ����
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sell_DB_Bean.group_count_M(sdata.getTimes()));
			tmp = sdata.getTimes();
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		mav.addObject("sgdata", sgdata);
		mav.addObject("list", list);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_guest_view");
		return mav;
	}
	//mypage guest ���
	@RequestMapping("/shop/mypage_guest_post2.o")
	public ModelAndView mypage_guest_post2(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//�������� Ȯ��
		Sell_Data_Bean sdata = sell_DB_Bean.getArticle_M(no);
		
		//�������ƴϸ�
		if(member_info.getNo() != sdata.getGuest_no()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		//���°� �Աݴ������ �ƴϸ�
		if(sdata.getStatus() != 1) {
			msg = "�Աݴ���� ���¿����� ��Ұ� �����մϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//����Ʈ ����� �׷����� �ƴ��� Ȯ��
		Sell_Group_Data_Bean sgdata = sell_Group_DB_Bean.getArticle_M(sdata.getTimes());
		if(sgdata.getPoint() != 0) {
			//����Ʈ �����ֱ�
			member_DB_Bean.setPoint_M(member_info.getNo(), member_info.getPoint() + sgdata.getPoint());
			sell_Group_DB_Bean.setPoint_M(sgdata.getNo(), 0);
		}
		
		int res = 0;
		if(sell_DB_Bean.delete_M(sdata)) res = 1;
		
		if(res == 1) {
			msg = "��� ����.";
			url = "mypage_guest.o?pages="+pages;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "��� ����.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//mypage guest ����Ȯ��
	@RequestMapping("/shop/mypage_guest_post1.o")
	public ModelAndView mypage_guest_post1(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//�������� Ȯ��
		Sell_Data_Bean sdata = sell_DB_Bean.getArticle_M(no);
		
		//�������ƴϸ�
		if(member_info.getNo() != sdata.getGuest_no()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		//���¸� ��ۿϷ�� ����
		int res = 0;
		if(sell_DB_Bean.changeStatus_M(no, 5)) {
			res = 1;
			
			//����Ȯ�� �Ϸ� �� ���� �ش� ��ǰ�� ���� ī��Ʈ�� �߰���
			list_DB_Bean.addBuy_M(sdata.getProduct_no());
			
			//����Ȯ���� ȸ�� ����Ʈ�� ���űݾ��� 3% ����
			member_DB_Bean.setPoint_M(member_info.getNo(), member_info.getPoint() + (int)(((double)sdata.getRmoney())*(3.0/100.0)));
		}
		
		if(res == 1) {
			msg = "����Ȯ�� ����.";
			url = "mypage_guest.o?pages="+pages;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "����Ȯ�� ����.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
	}
	//mypage admin
	@RequestMapping("/shop/mypage_admin.o")
	public ModelAndView mypage_admin(
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}

		mav.setViewName("shop/mypage_admin");
		return mav;
	}
	//mypage admin �Ա�Ȯ��
	@RequestMapping("/shop/mypage_admin_payment.o")
	public ModelAndView mypage_admin_payment(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		List list;
		//�Աݴ������� ����Ʈ��������
		list = sell_Group_DB_Bean.getPayArticles_M(1);

		mav.addObject("list", list);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_admin_payment");
		return mav;
	}
	//mypage admin �Ա�Ȯ�οϷ�
	@RequestMapping("/shop/mypage_admin_payment_post.o")
	public ModelAndView mypage_admin_payment_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="times", defaultValue="") String times,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		int res = 0;
		
		//���¸� �ԱݿϷ�� ����
		if(sell_Group_DB_Bean.changeStatus_M(times, 2)) res = 1;
		
		sell_DB_Bean.changeStatus_M(times, 2);
		
		if(res == 1) {
			msg = "�Ա�Ȯ�� �Ϸ�.";
			url = "mypage_admin_payment.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "�Ա�Ȯ�� ����.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//mypage admin ȸ������
	@RequestMapping("/shop/mypage_admin_member.o")
	public ModelAndView mypage_admin_member(
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		Action_Paging paging;
		List list;
		
		
		paging = new Action_Paging(member_DB_Bean.count_M(), 10, pages);

		list = member_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends());	//����Ʈ�޾ƿ���
		

		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_admin_member");
		return mav;
	}
	//mypage admin ȸ������
	@RequestMapping("/shop/mypage_admin_member_edit.o")
	public ModelAndView mypage_admin_member_edit(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		Member_Data_Bean mdata;
		
		mdata = member_DB_Bean.getArticle_M(no);
		

		mav.addObject("no", no);
		mav.addObject("mdata", mdata);
		mav.addObject("pages", pages);
		mav.addObject("pages_int", Integer.toString(pages));
		mav.setViewName("shop/mypage_admin_member_edit");
		return mav;
	}
	
	//mypage admin ȸ�������Ϸ�
	@RequestMapping("/shop/mypage_admin_member_edit_post.o")
	public ModelAndView mypage_admin_member_edit_post(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="orders", defaultValue="-1") int orders,
			@RequestParam(value="company_number", defaultValue="") String company_number,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="user_pw", defaultValue="") String user_pw,
			@RequestParam(value="user_pw2", defaultValue="") String user_pw2,
			@RequestParam(value="email", defaultValue="") String email,
			@RequestParam(value="zipcode", defaultValue="") String zipcode,
			@RequestParam(value="addr", defaultValue="") String addr,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="bank", defaultValue="") String bank,
			@RequestParam(value="bank_num", defaultValue="") String bank_num,
			@RequestParam(value="quest", defaultValue="-1") int quest,
			@RequestParam(value="answer", defaultValue="") String answer,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 3) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		if(quest == -1) {
			msg = "������ �Է����ּ���.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(answer.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//���� ��й�ȣ ���� �ϳ��� ����������
		if(!user_pw.equals("") || !user_pw2.equals("")) {
			if(!user_pw.equals(user_pw2)) {
				//�� ���� �ٸ��� ���
				msg = "��й�ȣ�� �ٸ��ϴ�.";
				mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
			}
			user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		}
		
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setNo(no);
		mdata.setOrders(orders);
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_pw(user_pw);
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		int res = 0;
		if(member_DB_Bean.update_M(mdata)) res = 1;
		
		if(res == 1) {
			msg = "���� ����.";
			url = "mypage_admin_member.o?pages="+pages;
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "���� ����.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
