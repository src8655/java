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
import net.mytour.data.List_Data;
import net.mytour.data.List_Reserve_Data;
import net.mytour.data.Notice_Data;
import net.mytour.ext.Number_Format;


@Controller
public class TourController {
	@Autowired
	List_Reserve_Dao list_Reserve_Service;
	@Autowired
	List_Dao list_Service;
	@Autowired
	Notice_Dao notice_Service;

	String msg = "";
	String url = "";

	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);
	
	//메인
	@RequestMapping("/tour/index.o")
	public ModelAndView index() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		List list_special;
		List list_hit;
		List list_hit1;
		List list_hit2;
		List list_hit3;
		List list_hit4;
		List list_hit5;
		List list_hit6;
		List list_hit7;
		List list_buy;
		List_Data ldata_hot = null;
		List list_notice;
		
		
		
		
		list_special = list_Reserve_Service.getArticlesMain(5);
		
		//글자 사이즈 바꾸기
		int maxsize = 9;
		for(int i=0;i<list_special.size();i++) {
			List_Reserve_Data lrdata = (List_Reserve_Data)list_special.get(i);
			if(lrdata.getSubject().length() > maxsize)
				lrdata.setSubject(lrdata.getSubject().substring(0, maxsize)+"...");
			String[] tmp = lrdata.getStartdates().split("-");
			if(tmp.length >= 3) lrdata.setStartdates(tmp[1]+"/"+tmp[2]);
		}
		
		list_hit = list_Service.getArticlesHit(0, 4, -1);
		list_hit1 = list_Service.getArticlesHit(0, 4, 1);
		list_hit2 = list_Service.getArticlesHit(0, 4, 2);
		list_hit3 = list_Service.getArticlesHit(0, 4, 3);
		list_hit4 = list_Service.getArticlesHit(0, 4, 4);
		list_hit5 = list_Service.getArticlesHit(0, 4, 5);
		list_hit6 = list_Service.getArticlesHit(0, 4, 6);
		list_hit7 = list_Service.getArticlesHit(0, 4, 7);
		
		maxsize = 15;
		for(int i=0;i<list_hit.size();i++) {
			List_Data ldata = (List_Data)list_hit.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit1.size();i++) {
			List_Data ldata = (List_Data)list_hit1.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit2.size();i++) {
			List_Data ldata = (List_Data)list_hit2.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit3.size();i++) {
			List_Data ldata = (List_Data)list_hit3.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit4.size();i++) {
			List_Data ldata = (List_Data)list_hit4.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit5.size();i++) {
			List_Data ldata = (List_Data)list_hit5.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit6.size();i++) {
			List_Data ldata = (List_Data)list_hit6.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		for(int i=0;i<list_hit7.size();i++) {
			List_Data ldata = (List_Data)list_hit7.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		
		list_buy = list_Service.getArticlesBuy(0, 4);

		for(int i=0;i<list_buy.size();i++) {
			List_Data ldata = (List_Data)list_buy.get(i);
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
		}
		
		
		List list_tmp = list_Service.getArticleHot();
		if(list_tmp.size()>=1) ldata_hot = (List_Data)list_tmp.get(0);
		if(ldata_hot == null) ldata_hot = new List_Data();
		
		
		list_notice = notice_Service.getArticlesMain(0, 5);
		
		maxsize = 16;
		for(int i=0;i<list_notice.size();i++) {
			Notice_Data ndata = (Notice_Data)list_notice.get(i);
			if(ndata.getSubject().length() > maxsize) ndata.setSubject(ndata.getSubject().substring(0, maxsize)+"...");
		}
		
		mav.addObject("list_special", list_special);
		mav.addObject("list_hit", list_hit);
		mav.addObject("list_hit1", list_hit1);
		mav.addObject("list_hit2", list_hit2);
		mav.addObject("list_hit3", list_hit3);
		mav.addObject("list_hit4", list_hit4);
		mav.addObject("list_hit5", list_hit5);
		mav.addObject("list_hit6", list_hit6);
		mav.addObject("list_hit7", list_hit7);
		mav.addObject("list_buy", list_buy);
		mav.addObject("ldata_hot", ldata_hot);
		mav.addObject("list_notice", list_notice);
		mav.setViewName("tour/index");
		return mav;
	}
	//상품바구니
	@RequestMapping("/tour/basket.o")
	public ModelAndView basket(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		//날짜 편집
		String year = Integer.toString(years);
		String month = Integer.toString(months);
		String day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		
		List list;
		int isEmpty = 0;
		
		list = new ArrayList();
		
		if(session.getAttribute("basket") == null) {
			isEmpty = 1;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (Integer) it.next();
				
				List_Reserve_Data lrdata = (List_Reserve_Data) list_Reserve_Service.getArticle(key);
				
				//삭제된 경우
				if(lrdata == null) {
					HashMap maps = (HashMap)session.getAttribute("basket");
					maps.remove(key);
					session.setAttribute("basket", map);
					continue;
				}
				//이미 예약된경우
				if(lrdata.getIsreserve() == 1) {
					HashMap maps = (HashMap)session.getAttribute("basket");
					maps.remove(key);
					session.setAttribute("basket", map);
					continue;
				}
			}
		}
		
		if(session.getAttribute("basket") == null) {
			isEmpty = 1;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (Integer) it.next();
				
				List_Reserve_Data lrdata = (List_Reserve_Data) list_Reserve_Service.getArticle(key);
				
				//갯수 넣고
				lrdata.setChoice_cnts((Integer)map.get(key));
				
				//갯수만큼 금액변경
				lrdata.setMoney(lrdata.getMoney()*lrdata.getChoice_cnts());
				lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));

				long tmp_now = cal.getTimeInMillis()/1000;
				long tmp_after = Long.parseLong(lrdata.getTimes())/1000;
				long tmp_result = tmp_after - tmp_now;
				
				//시간차 저장
				lrdata.setTimes_tmp(Long.toString(tmp_result));
				
				list.add(lrdata);
			}
		}


		mav.addObject("list", list);
		mav.addObject("isEmpty", isEmpty);
		mav.setViewName("tour/basket");
		return mav;
	}
	//상품바구니 수정
	@RequestMapping("/tour/basket_edit.o")
	public ModelAndView basket_edit(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="max_cnts", defaultValue="-1") int max_cnts,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//최초입력이 아닐때
		HashMap map = (HashMap)session.getAttribute("basket");
		map.put(no, max_cnts);
		session.setAttribute("basket", map);
		
		msg = "변경 성공";
		url = "basket.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//상품바구니 삭제
	@RequestMapping("/tour/basket_del.o")
	public ModelAndView basket_del(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="max_cnts", defaultValue="-1") int max_cnts,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//최초입력이 아닐때
		HashMap map = (HashMap)session.getAttribute("basket");
		map.remove(no);
		session.setAttribute("basket", map);
		
		msg = "삭제 성공";
		url = "basket.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//상품바구니 추가
	@RequestMapping("/tour/basket_add.o")
	public ModelAndView basket_add(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="max_cnts", defaultValue="-1") int max_cnts,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("tour/error");return mav;
		}
		
		//최초 입력
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, max_cnts);
			session.setAttribute("basket", map);
		}else {
			//최초입력이 아닐때
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, max_cnts);
			session.setAttribute("basket", map);
		}
		
		msg = "추가 성공";
		url = "basket.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("tour/post");
		return mav;
	}
	//agree_popup
	@RequestMapping("/tour/agree_popup.o")
	public ModelAndView agree_popup() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("tour/agree_popup");
		return mav;
	}
}
