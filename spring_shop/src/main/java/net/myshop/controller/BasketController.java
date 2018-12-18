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
import net.myshop.dao.View_Qna_DB;
import net.myshop.dao.View_Review_DB;
import net.myshop.data.List_Data_Bean;
import net.myshop.data.Member_Data_Bean;
import net.myshop.data.Sell_Data_Bean;
import net.myshop.data.View_Qna_Data_Bean;
import net.myshop.data.View_Review_Data_Bean;
import net.myshop.ext.Action_Paging;

@Controller
public class BasketController {
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
	
	
	//장바구니
	@RequestMapping("/shop/basket.o")
	public ModelAndView basket(
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
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
		
		list = new ArrayList();

		HttpSession session = request.getSession();

		if(session.getAttribute("basket") == null) {
			isEmpty = 1;
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
		
		
		

		mav.addObject("list", list);
		mav.addObject("total_moneys", total_moneys);
		mav.addObject("total_discount_moneys", total_discount_moneys);
		mav.addObject("total_ship_moneys", total_ship_moneys);
		mav.addObject("total_rmoneys", total_rmoneys);
		mav.setViewName("shop/basket");
		return mav;
	}
	//장바구니 수정
	@RequestMapping("/shop/basket_edit.o")
	public ModelAndView view_qna_answer(
			@RequestParam(value="counts", defaultValue="1") int counts,
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("counts", counts);
		mav.addObject("no", no);

		HttpSession session = request.getSession();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(counts == -1) {
			msg = "개수를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.put(no, counts);
		session.setAttribute("basket", map);
		
		msg = "수정 성공.";
		url = "basket.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//장바구니 삭제
	@RequestMapping("/shop/basket_delete.o")
	public ModelAndView basket_delete(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("no", no);

		HttpSession session = request.getSession();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.remove(no);
		session.setAttribute("basket", map);
		

		msg = "삭제 성공";
		url = "basket.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//장바구니 추가
	@RequestMapping("/shop/basket_add.o")
	public ModelAndView basket_add(
			@RequestParam(value="counts", defaultValue="1") int counts,
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		if(counts < 1) {
			msg = "개수를 입력하세요.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//최초 입력
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, counts);
			session.setAttribute("basket", map);		//no=counts 형태로 저장
		}else {
			//최초입력이 아닐때
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, counts);
			session.setAttribute("basket", map);	//     //를 구분자로 씀
		}
		
		msg = "추가성공";
		url = "basket.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
