package com.myjob.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.myjob.dao.CompanyDao;
import com.myjob.dao.CountDao;
import com.myjob.dao.IncomeDao;
import com.myjob.dao.InterviewDao;
import com.myjob.dao.RecruitDao;
import com.myjob.dao.RecruitListDao;
import com.myjob.dao.ReviewDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;
import com.myjob.data.RecruitData;
import com.myjob.data.RecruitListData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;
import com.myjob.ext.NumberFormat;



@Controller
public class JobController {
	@Autowired
	CompanyDao companyService;
	@Autowired
	CountDao countService;
	@Autowired
	ReviewDao reviewService;
	@Autowired
	IncomeDao incomeService;
	@Autowired
	InterviewDao interviewService;
	@Autowired
	RecruitDao recruitService;
	@Autowired
	RecruitListDao recruitListService;

	String msg = "";
	String url = "";
	public static String savePathd = "/job/upload/";	//파일저장 상대경로
	
	//메인
	@RequestMapping("/job/index.o")
	public ModelAndView index(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		
		
		/*
		
		
		String addr = 
				"http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncFullDown?serviceKey=jFL79fWz6XyUd8JQv2gMU4wH4H%2BSIRcFDrL5VLk5QiZaT7AbfjRT7BRLvf4oSSUG1%2FzWXLK3%2Fe96pQVZrw%2F9Mw%3D%3D&pageNo=1&numOfRows=10&_type=json";
			
			
			try {
				//위의 주소를 가지고 URL 객체를 생성
				URL url = new URL(addr);
				//URL객체를 가지고 HttpURLConnection 객체 만들기
				HttpURLConnection con = (
					HttpURLConnection)url.openConnection();
				//인증받기
				
				con.setConnectTimeout(20000);
				con.setUseCaches(false);
				//줄 단위 데이터 읽기
				BufferedReader br = 
					new BufferedReader(
						new InputStreamReader(
							con.getInputStream(), "UTF-8"));
				//문자열을 임시로 저장할 객체 만들기
				StringBuilder sb = new StringBuilder();
				while(true) {
					//한 줄의 데이터 읽기
					String line = br.readLine();
					//읽은 데이터가 없으면 반복문 종료
					if(line == null) {
						break;
					}
					//읽은 데이터가 있으면 sb에 추가
					sb.append(line);
				}
				//연결 해제
				br.close();
				con.disconnect();
				
				System.out.println(sb.toString());
				
				JSONObject obj = new JSONObject(sb.toString()).getJSONObject("response").getJSONObject("body").getJSONObject("items");
				//System.out.println(obj);
				JSONArray imsi = obj.getJSONArray("item");
				//System.out.println(imsi);
				JSONObject o = imsi.getJSONObject(0);
				String address = o.getString("dutyAddr");
				
				System.out.println(address);
			}catch(Exception e) {
				System.out.println("주소 가져오기 실패:" + e.getMessage());
			}
			
			*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		List list = companyService.getArticles(1, 5, "", -1, -1, -1);
		
		for(int i=0;i<list.size();i++) {
			CompanyData tmp = (CompanyData)list.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars_p((int)((tmp.getAvg_stars()/5.0)*92.0));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			
			if((mdata != null && mdata.getFollow_list() != null) && (mdata.getFollow_list().contains(Integer.toString(tmp.getMember_no()))))
				tmp.setIsfollow(1);
			else tmp.setIsfollow(-1);
		}
		mav.addObject("list", list);
		
		
		List list2 = recruitService.getArticles(1, 5, "", -1, -1, -1, 1);
		for(int i=0;i<list2.size();i++) {
			RecruitData tmp = (RecruitData)list2.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			tmp.setDday(ActionTime.dDay(tmp.getEnddates()));
		}
		mav.addObject("list2", list2);
		
		mav.setViewName("job/index");
		return mav;
	}
	
	
	
	
	
	//메인
	@RequestMapping("/job/test.o")
	public ModelAndView test() throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		
		
		
		mav.addObject("test", "err");
		
		String addr = 
				"http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncFullDown?serviceKey=jFL79fWz6XyUd8JQv2gMU4wH4H%2BSIRcFDrL5VLk5QiZaT7AbfjRT7BRLvf4oSSUG1%2FzWXLK3%2Fe96pQVZrw%2F9Mw%3D%3D&pageNo=1&numOfRows=10";
			
			
			try {
				//위의 주소를 가지고 URL 객체를 생성
				URL url = new URL(addr);
				//URL객체를 가지고 HttpURLConnection 객체 만들기
				HttpURLConnection con = (
					HttpURLConnection)url.openConnection();
				//인증받기
				
				con.setConnectTimeout(20000);
				con.setUseCaches(false);
				//줄 단위 데이터 읽기
				BufferedReader br = 
					new BufferedReader(
						new InputStreamReader(
							con.getInputStream(), "UTF-8"));
				//문자열을 임시로 저장할 객체 만들기
				StringBuilder sb = new StringBuilder();
				while(true) {
					//한 줄의 데이터 읽기
					String line = br.readLine();
					//읽은 데이터가 없으면 반복문 종료
					if(line == null) {
						break;
					}
					//읽은 데이터가 있으면 sb에 추가
					sb.append(line);
				}
				//연결 해제
				br.close();
				con.disconnect();
				
				mav.addObject("test", sb.toString());
			}catch(Exception e) {
				System.out.println("주소 가져오기 실패:" + e.getMessage());
			}
			
			
		
		mav.setViewName("test");
		return mav;
	}
		
	//다운로드
	@RequestMapping("/job/download.o")
	public ModelAndView down(@RequestParam("filename") String filename, HttpServletRequest request) {
		String savePaths = request.getRealPath(savePathd);
		System.out.println(savePaths);
		File file = new File(savePaths + "/" + filename);
		ModelAndView mav = new ModelAndView("down", "downloadfile", file);
		return mav;
	}
	
}
