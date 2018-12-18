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

@Controller
public class BuysController {
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
	
	
	//구매
	@RequestMapping("/shop/buys.o")
	public ModelAndView buys(
			@RequestParam(value="order", defaultValue="-1") int order,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="counts", defaultValue="-1") int counts,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		HttpSession session = request.getSession();
	
		
		List list;
		int isEmpty = 0;		//0이면 안비어있음 1이면 비어있음
		
		//총 금액 계산
		int total_money = 0;
		int total_discount_money = 0;
		int total_ship_money = 0;
		int total_rmoney = 0;
		
		//총 금액의 통화
		String total_moneys = "";
		String total_discount_moneys = "";
		String total_ship_moneys = "";
		String total_rmoneys = "";
		

		//총 금액의 통화 - 포인트
		String total_rmoneys_point = "";
		
		//멤버의 포인트의 통화
		String member_points = "";
		


		
		
		if(member_info == null) {
			msg = "로그인후 이용해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() == 2) {
			msg = "판매자는 구입할 수 없습니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		list = new ArrayList();
		isEmpty = 0;		//0이면 안비어있음 1이면 비어있음
		
		//총 금액 계산
		total_money = 0;
		total_discount_money = 0;
		total_ship_money = 0;
		total_rmoney = 0;
		
		//총 금액의 통화
		total_moneys = "";
		total_discount_moneys = "";
		total_ship_moneys = "";
		total_rmoneys = "";
		

		//총 금액의 통화 - 포인트
		total_rmoneys_point = "";
		
		//멤버의 포인트의 통화
		member_points = number_format(member_info.getPoint());
		

		//order 가 1이면 일반구입, 2면 장바구니구입 3이면 장바구니에서 일반구입
		if(order == 1 || order == 3) {
			List_Data_Bean ldata = list_DB_Bean.getArticle_M(no);
			
			//갯수 넣고
			ldata.setBasket_cnt(counts);
			//갯수만큼 금액변경
			ldata.setMoney(ldata.getMoney()*ldata.getBasket_cnt());
			ldata.setRmoney(ldata.getRmoney()*ldata.getBasket_cnt());
			ldata.setDiscount_money(ldata.getDiscount_money()*ldata.getBasket_cnt());
			
			//통화형식
			ldata.setRmoneys(number_format(ldata.getRmoney()));
			ldata.setMoneys(number_format(ldata.getMoney()));
			ldata.setShip_moneys(number_format(ldata.getShip_money()));
			ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
			
			
			//총 금액
			total_money += ldata.getMoney();
			total_discount_money += ldata.getDiscount_money();
			total_ship_money += ldata.getShip_money();
			total_rmoney += ldata.getRmoney()+ldata.getShip_money();
			
			
			
			list.add(ldata);
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (Integer) it.next();
				List_Data_Bean ldata = list_DB_Bean.getArticle_M(key);
				
				//갯수 넣고
				ldata.setBasket_cnt((Integer)map.get(key));
				//갯수만큼 금액변경
				ldata.setMoney(ldata.getMoney()*ldata.getBasket_cnt());
				ldata.setRmoney(ldata.getRmoney()*ldata.getBasket_cnt());
				ldata.setDiscount_money(ldata.getDiscount_money()*ldata.getBasket_cnt());
				
				//통화형식
				ldata.setRmoneys(number_format(ldata.getRmoney()));
				ldata.setMoneys(number_format(ldata.getMoney()));
				ldata.setShip_moneys(number_format(ldata.getShip_money()));
				ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
				
				
				//총 금액
				total_money += ldata.getMoney();
				total_discount_money += ldata.getDiscount_money();
				total_ship_money += ldata.getShip_money();
				total_rmoney += ldata.getRmoney()+ldata.getShip_money();
				
				list.add(ldata);
			}
		}
		
		//총 금액을 통화로 변경
		total_moneys = number_format(total_money);
		total_discount_moneys = number_format(total_discount_money);
		total_ship_moneys = number_format(total_ship_money);
		total_rmoneys = number_format(total_rmoney);
		

		//총 금액을 통화로 변경 - 포인트
		total_rmoneys_point = number_format(total_rmoney - member_info.getPoint());
		
		
		
		//세션에 저장해서 구입완료창으로 전달
		session.setAttribute("list", list);
		
		mav.addObject("total_moneys", total_moneys);
		mav.addObject("total_discount_moneys", total_discount_moneys);
		mav.addObject("total_ship_moneys", total_ship_moneys);
		mav.addObject("total_rmoneys", total_rmoneys);

		mav.addObject("total_rmoneys_point", total_rmoneys_point);
		mav.addObject("member_points", member_points);

		mav.addObject("list", list);
		mav.addObject("isEmpty", isEmpty);

		mav.addObject("total_money", total_money);
		mav.addObject("total_discount_money", total_discount_money);
		mav.addObject("total_ship_money", total_ship_money);
		mav.addObject("total_rmoney", total_rmoney);
		mav.addObject("order", order);
		
		mav.setViewName("shop/buys");
		return mav;
	}
	//구매완료
	@RequestMapping("/shop/buys_post.o")
	public ModelAndView buys_post(
			@RequestParam(value="order", defaultValue="-1") int order,
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="counts", defaultValue="-1") int counts,
			@RequestParam(value="point_num", defaultValue="0") int point_num,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="zipcode", defaultValue="") String zipcode,
			@RequestParam(value="addr", defaultValue="") String addr,
			@RequestParam(value="phone1", defaultValue="") String phone1,
			@RequestParam(value="phone2", defaultValue="") String phone2,
			@RequestParam(value="phone3", defaultValue="") String phone3,
			@RequestParam(value="ship_memo", defaultValue="") String ship_memo,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("counts", counts);
		mav.addObject("no", no);

		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		HttpSession session = request.getSession();
		
		
		
		//총 금액 계산
		int total_money = 0;
		int total_discount_money = 0;
		int total_ship_money = 0;
		int total_rmoney = 0;
		int total_point = 0;
		
		//총 금액의 통화
		String total_moneys = "";
		String total_discount_moneys = "";
		String total_ship_moneys = "";
		String total_rmoneys = "";
		String total_points = "";
		
		String totals = "";	//배송비+금액

		List list;

		String admin_bank = "";
		String admin_bank_num = "";
		
		
		
		
		
		if(name.equals("")) {
			msg = "이름을 입력하세요.";
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

		
		
		//포인트사용 적용
		if(point_num != 0) {
			total_point = point_num;
			
			//포인트가 부족하면 잘못된 접근
			if(member_info.getPoint() < point_num) {
				msg = "포인트가 부족합니다.";
				mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
			}
			//포인트를 초기화
			member_DB_Bean.setPoint_M(member_info.getNo(), member_info.getPoint() - point_num);
		}
				
		
		
		
		
		list = (List)session.getAttribute("list");
		
		//총금액 구하는부분
		for(int i=0;i<list.size();i++) {
			List_Data_Bean ldata = (List_Data_Bean)list.get(i);
			
			//총 금액
			total_money += ldata.getMoney();
			total_discount_money += ldata.getDiscount_money();
			total_ship_money += ldata.getShip_money();
			total_rmoney += ldata.getRmoney();
		}
		
		
		
		
		
		
		/////////////////
		//가상계좌 생성부분
		/////////////////
		admin_bank = "농협";
		admin_bank_num = "";
		Random rand = new Random();
		int tmp1 = rand.nextInt(90000)+10000;
		int tmp2 = rand.nextInt(90)+10;
		int tmp3 = rand.nextInt(9000000)+10000000;
		admin_bank_num = tmp1+"-"+tmp2+"-"+tmp3;
		
		
		
		
		
		//유일한 값 생성
		String times = "";
		Sell_Group_Data_Bean sgdatas = null;
		do {
			cal = Calendar.getInstance();
			times = cal.getTimeInMillis()+"slsl"+member_info.getNo();
			sgdatas = sell_Group_DB_Bean.getArticle_M(times);
		}while(sgdatas != null);
		
		
		
		//그룹을 먼저 만들어 db에 입력
		Sell_Group_Data_Bean sgdata = new Sell_Group_Data_Bean();
		sgdata.setMoney(total_money);
		sgdata.setShip_money(total_ship_money);
		sgdata.setRmoney(total_rmoney);
		sgdata.setBank(admin_bank);
		sgdata.setBank_num(admin_bank_num);
		sgdata.setName(name);
		sgdata.setZipcode(zipcode);
		sgdata.setAddr(addr);
		sgdata.setPhone1(phone1);
		sgdata.setPhone2(phone2);
		sgdata.setPhone3(phone3);
		sgdata.setShip_memo(ship_memo);
		sgdata.setDates(year+"-"+month+"-"+day);
		sgdata.setTimes(times);
		sgdata.setGuest_no(member_info.getNo());
		sgdata.setStatus(1);
		sgdata.setPoint(total_point);
		
		sell_Group_DB_Bean.insert_M(sgdata);

		for(int i=0;i<list.size();i++) {
			List_Data_Bean ldata = (List_Data_Bean)list.get(i);
			Sell_Data_Bean sdata = new Sell_Data_Bean();
			sdata.setGuest_no(member_info.getNo());
			sdata.setSellers_no(ldata.getSellers());
			sdata.setProduct_no(ldata.getNo());
			sdata.setProduct_name(ldata.getName());
			sdata.setCounts(ldata.getBasket_cnt());
			sdata.setMoney(ldata.getMoney());
			sdata.setShip_money(ldata.getShip_money());
			sdata.setRmoney(ldata.getRmoney());
			sdata.setDates(year+"-"+month+"-"+day);
			sdata.setShip_company(ldata.getShip_company());
			sdata.setStatus(1);
			sdata.setAddr(addr);
			sdata.setZipcode(zipcode);
			sdata.setShip_memo(ship_memo);
			sdata.setName(name);
			sdata.setPhone1(phone1);
			sdata.setPhone2(phone2);
			sdata.setPhone3(phone3);
			sdata.setFile1(ldata.getFile1());
			//그룹과 같은 유일한 값 저장
			sdata.setTimes(sgdata.getTimes());
			
			
			sell_DB_Bean.insert_M(sdata);
			
			//장바구니 하나 구매시
			if(order == 3) {
				HashMap map = (HashMap)session.getAttribute("basket");
				map.remove(sdata.getProduct_no());
				session.setAttribute("basket", map);
			}
		}
		
		//총 금액을 통화로 변경
		total_moneys = number_format(total_money);
		total_discount_moneys = number_format(total_discount_money);
		total_ship_moneys = number_format(total_ship_money);
		total_rmoneys = number_format(total_rmoney);
		total_points = number_format(total_point);
		totals = number_format(total_ship_money+total_rmoney-total_point);
		
		//장바구니 구매시
		if(order == 2) session.setAttribute("basket", null);

		mav.addObject("order", order);
		mav.addObject("admin_bank", admin_bank);
		mav.addObject("admin_bank_num", admin_bank_num);
		mav.addObject("totals", totals);
		mav.setViewName("shop/buys_post");
		return mav;
	}
	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
