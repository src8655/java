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

@Controller
public class ListController {
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

	public static String savePathd = "/shop/upload/";	//파일저장 상대경로
	
	String msg = "";
	String url = "";
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH)+1;
	public int day = cal.get(Calendar.DATE);
	

	//리스트
	@RequestMapping("/shop/list.o")
	public ModelAndView list(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchs", defaultValue="-1") int searchs,
			@RequestParam(value="searchs_value", defaultValue="") String searchs_value,
			@RequestParam(value="p_search_value", defaultValue="") String p_search_value,
			@RequestParam(value="order", defaultValue="-1") int order
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/list");
		
		Action_Paging paging = new Action_Paging(list_DB_Bean.getCount_M(searchs, searchs_value, -1, order), 20, pages);

		List list = list_DB_Bean.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), searchs, searchs_value, 10, -1, order);	//리스트받아오기
		
		
		//url인코딩한 값을 저장
		String searchs_values = URLEncoder.encode(searchs_value,"UTF-8");
		
		

		mav.addObject("list", list);
		mav.addObject("pages_int", pages);
		mav.addObject("pages", pages);
		mav.addObject("paging", paging);
		mav.addObject("searchs", searchs);
		mav.addObject("searchs_value", searchs_value);
		mav.addObject("order", order);
		mav.addObject("searchs_values", searchs_values);
		
		return mav;
	}
	//작성
	@RequestMapping("/shop/write.o")
	public ModelAndView write(
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("shop/write");
		return mav;
	}
	//작성완료
	@RequestMapping("/shop/write_post.o")
	public ModelAndView write_post(
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="money", defaultValue="0") int money,
			@RequestParam(value="discount", defaultValue="0") int discount,
			@RequestParam(value="made", defaultValue="") String made,
			@RequestParam(value="ship_money", defaultValue="0") int ship_money,
			@RequestParam(value="ship_company", defaultValue="") String ship_company,
			@RequestParam(value="sellers", defaultValue="-1") int sellers,
			@RequestParam(value="memo", defaultValue="") String memo,
			@RequestParam(value="files", required=false) MultipartFile[] files,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		
		String[] filenames = new String[files.length];
		for(int i=0;i<files.length;i++) {
			filenames[i] = "";
			String filename = files[i].getOriginalFilename();
			if(!filename.equals("")) {
				int cnt = 0;
				File files_tmp = null;
				//이미 존재하면 카운트 증가
				do {
					cnt++;
					files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename);
				}while(files_tmp.exists());
				files[i].transferTo(files_tmp);
				filenames[i] = files_tmp.getName();
			}
		}
		
		List_Data_Bean ldata = new List_Data_Bean();
		ldata.setCategory(category);
		ldata.setName(name);
		ldata.setMoney(money);
		ldata.setDiscount(discount);
		ldata.setMade(made);
		ldata.setShip_money(ship_money);
		ldata.setShip_company(ship_company);
		ldata.setSellers(member_info.getNo());
		ldata.setMemo(memo);

		if(!filenames[0].equals("")) ldata.setFile1(filenames[0]);
		if(!filenames[1].equals("")) ldata.setFile2(filenames[1]);
		if(!filenames[2].equals("")) ldata.setFile3(filenames[2]);
		if(!filenames[3].equals("")) ldata.setFile4(filenames[3]);
		if(!filenames[4].equals("")) ldata.setFile5(filenames[4]);
		ldata.setDates(year+"-"+month+"-"+day);
    	
    	//할인가격 계산
    	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
    	ldata.setRmoney(rmoney);
		
    	list_DB_Bean.insert_M(ldata);
    	
		msg = "작성 성공";
		url = "write.o";
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("shop/post");
		return mav;
	}
	//수정
	@RequestMapping("/shop/edit.o")
	public ModelAndView edit(
			@RequestParam(value="no", defaultValue="-1") int no
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int ship_company = 1;
		List_Data_Bean ldata;
		
		ldata = list_DB_Bean.getArticle_M(no);
		
		if(ldata.getShip_company().equals("CJ대한통운")) ship_company = 1;
		if(ldata.getShip_company().equals("우체국택배")) ship_company = 2;
		if(ldata.getShip_company().equals("한진택배")) ship_company = 3;
		if(ldata.getShip_company().equals("로젠택배")) ship_company = 4;
		if(ldata.getShip_company().equals("CVSnet편의점")) ship_company = 5;
		

		mav.addObject("no", no);
		mav.addObject("ldata", ldata);
		mav.addObject("ship_company", ship_company);
		mav.setViewName("shop/edit");
		return mav;
	}
	//수정완료
	@RequestMapping("/shop/edit_post.o")
	public ModelAndView edit_post(
			@RequestParam(value="no", defaultValue="-1") int no,
			@RequestParam(value="file_del1", defaultValue="-1") int file_del1,
			@RequestParam(value="file_del2", defaultValue="-1") int file_del2,
			@RequestParam(value="file_del3", defaultValue="-1") int file_del3,
			@RequestParam(value="file_del4", defaultValue="-1") int file_del4,
			@RequestParam(value="file_del5", defaultValue="-1") int file_del5,
			@RequestParam(value="category", defaultValue="-1") int category,
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="money", defaultValue="0") int money,
			@RequestParam(value="discount", defaultValue="0") int discount,
			@RequestParam(value="made", defaultValue="") String made,
			@RequestParam(value="ship_money", defaultValue="0") int ship_money,
			@RequestParam(value="ship_company", defaultValue="") String ship_company,
			@RequestParam(value="sellers", defaultValue="-1") int sellers,
			@RequestParam(value="memo", defaultValue="") String memo,
			@RequestParam(value="files", required=false) MultipartFile[] files,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		//내 게시글이 아니면 에러
		List_Data_Bean ldatas = list_DB_Bean.getArticle_M(no);
		if(ldatas.getSellers() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//업로드작업
		String savePaths=request.getRealPath(savePathd);	//저장위치 절대경로
		
		String[] filenames = new String[files.length];
		for(int i=0;i<files.length;i++) {
			filenames[i] = "";
			String filename = files[i].getOriginalFilename();
			if(!filename.equals("")) {
				int cnt = 0;
				File files_tmp = null;
				//이미 존재하면 카운트 증가
				do {
					cnt++;
					files_tmp = new File(savePaths+"/"+"("+cnt+")"+filename);
				}while(files_tmp.exists());
				files[i].transferTo(files_tmp);
				filenames[i] = files_tmp.getName();
			}
		}
		
		List_Data_Bean ldata = new List_Data_Bean();
		ldata.setCategory(category);
		ldata.setName(name);
		ldata.setMoney(money);
		ldata.setDiscount(discount);
		ldata.setMade(made);
		ldata.setShip_money(ship_money);
		ldata.setShip_company(ship_company);
		ldata.setSellers(member_info.getNo());
		ldata.setMemo(memo);

		
		ldata.setDates(year+"-"+month+"-"+day);
    	
    	//할인가격 계산
    	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
    	ldata.setRmoney(rmoney);
		
    	//삭제 명령시
    	if(file_del1 == 1) ldata.setFile1(""); else ldata.setFile1(ldatas.getFile1());
    	if(file_del2 == 1) ldata.setFile2(""); else ldata.setFile2(ldatas.getFile2());
    	if(file_del3 == 1) ldata.setFile3(""); else ldata.setFile3(ldatas.getFile3());
    	if(file_del4 == 1) ldata.setFile4(""); else ldata.setFile4(ldatas.getFile4());
    	if(file_del5 == 1) ldata.setFile5(""); else ldata.setFile5(ldatas.getFile5());
		
    	if(!filenames[0].equals("")) ldata.setFile1(filenames[0]);
		if(!filenames[1].equals("")) ldata.setFile2(filenames[1]);
		if(!filenames[2].equals("")) ldata.setFile3(filenames[2]);
		if(!filenames[3].equals("")) ldata.setFile4(filenames[3]);
		if(!filenames[4].equals("")) ldata.setFile5(filenames[4]);
		
		ldata.setNo(ldatas.getNo());
		
		//1이면 성공 0이면 실패
		int res = 0;
		if(list_DB_Bean.update_M(ldata)) res = 1;
		
		if(res == 1) {
			msg = "수정 성공.";
			url = "mypage_list.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "수정 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	//삭제
	@RequestMapping("/shop/del.o")
	public ModelAndView del(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		Member_Data_Bean member_info = (Member_Data_Bean)request.getAttribute("member_info");
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//내 게시글인지 확인
		List_Data_Bean ldata = list_DB_Bean.getArticle_M(no);
		if(ldata.getSellers() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
		
		//1이면 성공 0이면 실패
		int res = 0;
		if(list_DB_Bean.delete_M(no)) res = 1;
		
		if(res == 1) {
			msg = "삭제 성공.";
			url = "mypage_list.o";
			mav.addObject("msg", msg);
			mav.addObject("url", url);
			mav.setViewName("shop/post");
			return mav;
		}else{
			msg = "삭제 실패.";
			mav.addObject("msg", msg);mav.setViewName("shop/post2");return mav;
		}
	}
	
}
