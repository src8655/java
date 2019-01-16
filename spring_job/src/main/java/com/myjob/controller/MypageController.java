package com.myjob.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
import com.myjob.dao.MemberDao;
import com.myjob.dao.RecruitDao;
import com.myjob.dao.RecruitListDao;
import com.myjob.dao.ReportDao;
import com.myjob.dao.ReviewDao;
import com.myjob.data.CompanyData;
import com.myjob.data.InterviewData;
import com.myjob.data.MemberData;
import com.myjob.data.RecruitData;
import com.myjob.data.RecruitListData;
import com.myjob.data.ReportData;
import com.myjob.data.ReviewData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;
import com.myjob.ext.Md5Enc;
import com.myjob.ext.NumberFormat;



@Controller
public class MypageController {
	@Autowired
	MemberDao memberService;
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
	@Autowired
	ReportDao reportService;

	String msg = "";
	String url = "";
	
	//일반회원 마이페이지
	@RequestMapping("/job/mypage.o")
	public ModelAndView mypage(
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="pages", defaultValue="1") int pages,
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		mav.addObject("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		int count = companyService.getFollowsCount(mdata.getFollow());
		Action_Paging paging = new Action_Paging(count, 10, pages);
		List list = companyService.getFollows(mdata.getFollow(), paging.getBoard_starts(), paging.getBoard_ends());
		
		for(int i=0;i<list.size();i++) {
			CompanyData tmp = (CompanyData)list.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars_p((int)((tmp.getAvg_stars()/5.0)*92.0));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			
			if((mdata != null && mdata.getFollow_list() != null) && (mdata.getFollow_list().contains(Integer.toString(tmp.getMember_no()))))
				tmp.setIsfollow(1);
			else tmp.setIsfollow(-1);
		}
		mav.addObject("count", count);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		
		
		
		
		int count2 = recruitService.getMyCount(mdata.getNo());
		Action_Paging paging2 = new Action_Paging(count2, 10, pages_r);
		List list2 = recruitService.getMyArticles(mdata.getNo(), paging2.getBoard_starts(), paging2.getBoard_ends());
		for(int i=0;i<list2.size();i++) {
			RecruitData tmp = (RecruitData)list2.get(i);
			tmp.setAvg_moneys(NumberFormat.number_format(tmp.getAvg_money()));
			tmp.setAvg_stars(Math.round(tmp.getAvg_stars()*10.0)/10.0);
			tmp.setDday(ActionTime.dDay(tmp.getEnddates()));
		}
		mav.addObject("paging2", paging2);
		mav.addObject("list2", list2);
		mav.addObject("count2", count2);
		
		
		
		
		

		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.setViewName("job/mypage");
		return mav;
	}
	
	
	
	
	
	

	//관리자페이지
	@RequestMapping("/job/adminpage.o")
	public ModelAndView adminpage(
			HttpServletRequest request
			) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		mav.addObject("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		
		
		
		mav.setViewName("job/adminpage");
		return mav;
	}
	//관리자페이지
	@RequestMapping("/job/adminpage_member.o")
	public ModelAndView adminpage_member(
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="adminSearch", defaultValue="1") int adminSearch,
			@RequestParam(value="adminSearchV", defaultValue="") String adminSearchV,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		mav.addObject("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		
		int count = memberService.adminGetCount(adminSearch, adminSearchV);
		Action_Paging paging = new Action_Paging(count, 10, pages_r);
		List list = memberService.adminGetArticles(adminSearch, adminSearchV, paging.getBoard_starts(), paging.getBoard_ends());

		mav.addObject("count", count);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		
		
		String adminSearchV_utf = URLEncoder.encode(adminSearchV,"UTF-8");

		mav.addObject("pages_r", pages_r);
		mav.addObject("adminSearch", adminSearch);
		mav.addObject("adminSearchV", adminSearchV);
		mav.addObject("adminSearchV_utf", adminSearchV_utf);
		mav.setViewName("job/adminpage_member");
		return mav;
	}
	
	
	
	
	
	
	

	//관리페이지 회원 상세보기
	@RequestMapping("/job/adminpage_member_edit_show_ajax.o")
	@ResponseBody
	public Map adminpage_member_edit_show_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		MemberData memberInfo = memberService.adminGetArticle(no);
		
		

		map.put("memberInfo", memberInfo);
		map.put("result", true);
		return map;
	}
	//관리페이지 회원 수정완료
	@RequestMapping("/job/adminpage_member_edit_ajax.o")
	@ResponseBody
	public Map adminpage_member_edit_ajax(
			@ModelAttribute("mdata") MemberData mdata,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData memberInfo = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(memberInfo == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(memberInfo.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		MemberData mdata_tmp = memberService.adminGetArticle(mdata.getNo());
		
		//비밀번호가 입력되었는지 확인
		if(mdata.getPassword() != null) {
			if(!mdata.getPassword().equals("")) {
				if(mdata.getPassword2() == null) {
					msg = "비밀번호2를 입력해주세요.";
					map.put("msg", msg);
					map.put("result", false);
					return map;
				}else if(mdata.getPassword2().equals("")) {
					msg = "비밀번호2를 입력해주세요.";
					map.put("msg", msg);
					map.put("result", false);
					return map;
				}else if(!mdata.getPassword().equals(mdata.getPassword2())) {
					msg = "비밀번호가 다릅니다.";
					map.put("msg", msg);
					map.put("result", false);
					return map;
				}else {
					mdata.setPassword(Md5Enc.getEncMD5(mdata.getPassword().getBytes()));
				}
			}else {
				mdata.setPassword(mdata_tmp.getPassword());
			}
		}else {
			mdata.setPassword(mdata_tmp.getPassword());
		}
		
		memberService.adminUpdate(mdata);

		map.put("result", true);
		return map;
	}
	//관리페이지 회원 삭제
	@RequestMapping("/job/adminpage_member_del_ajax.o")
	@ResponseBody
	public Map adminpage_member_del_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		MemberData memberInfo = new MemberData();
		memberInfo.setNo(no);
		
		memberService.deleteUser(memberInfo);
		companyService.deleteUser(memberInfo);
		reviewService.deleteUser(memberInfo);
		incomeService.deleteUser(memberInfo);
		interviewService.deleteUser(memberInfo);
		recruitService.deleteUser(memberInfo);
		recruitListService.deleteUser(memberInfo);
		
		map.put("result", true);
		return map;
	}
	
	
	
	
	
	
	
	
	
	

	//관리자페이지 신고
	@RequestMapping("/job/adminpage_report_r.o")
	public ModelAndView adminpage_report_r(
			@RequestParam(value="tab", defaultValue="1") int tab,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		mav.addObject("memberInfo", mdata);
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		
		int count = reportService.getCount(tab);
		Action_Paging paging = new Action_Paging(count, 10, pages_r);
		List list = reportService.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), tab);
		
		for(int i=0;i<list.size();i++) {
			ReportData rpdata = (ReportData)list.get(i);
			MemberData mdata_tmp = memberService.adminGetArticle(rpdata.getWriter_no());
			rpdata.setMdata(mdata_tmp);
			if(mdata_tmp == null) rpdata.setMdata(new MemberData());
		}

		mav.addObject("count", count);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		
		

		mav.addObject("tab", tab);
		mav.addObject("pages_r", pages_r);
		mav.setViewName("job/adminpage_report_r");
		return mav;
	}

	//관리페이지 리뷰신고 상세보기
	@RequestMapping("/job/adminpage_review_r_show_ajax.o")
	@ResponseBody
	public Map adminpage_review_r_show_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		ReportData rpdata = reportService.getArticle(no, 1);
		rpdata.setAvg_stars_p((int)((rpdata.getAvg_stars()/5.0)*92.0));
		map.put("rpdata", rpdata);
		ReviewData rdata = reviewService.getArticleNo(rpdata.getTab_no());
		map.put("rdata", rdata);
		
		

		map.put("result", true);
		return map;
	}
	//관리페이지 리뷰신고 삭제
	@RequestMapping("/job/adminpage_report_r_del_ajax.o")
	@ResponseBody
	public Map adminpage_report_r_del_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		ReportData rpdata = reportService.getArticle(no, 1);
		reviewService.delete(rpdata.getTab_no());					//리뷰삭제
		reportService.delete(rpdata.getTab_no(), rpdata.getTab());	//같은 리뷰를 신고한 리스트 모두 삭제
		
		

		map.put("result", true);
		return map;
	}
	//관리페이지 리뷰신고 취소
	@RequestMapping("/job/adminpage_report_r_cancel_ajax.o")
	@ResponseBody
	public Map adminpage_report_r_cancel_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		ReportData rpdata = reportService.getArticle(no, 1);
		reportService.deleteNo(rpdata.getNo());
		
		

		map.put("result", true);
		return map;
	}
	
	
	

	//관리페이지 면접후기신고 상세보기
	@RequestMapping("/job/adminpage_review_i_show_ajax.o")
	@ResponseBody
	public Map adminpage_review_i_show_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		ReportData rpdata = reportService.getArticle(no, 2);
		rpdata.setAvg_stars_p((int)((rpdata.getAvg_stars()/5.0)*92.0));
		map.put("rpdata", rpdata);
		InterviewData itdata = interviewService.getArticleNo(rpdata.getTab_no());
		map.put("itdata", itdata);
		
		

		map.put("result", true);
		return map;
	}
	//관리페이지 리뷰신고 삭제
	@RequestMapping("/job/adminpage_report_i_del_ajax.o")
	@ResponseBody
	public Map adminpage_report_i_del_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		ReportData rpdata = reportService.getArticle(no, 2);
		interviewService.delete(rpdata.getTab_no());				//면접후기 삭제
		reportService.delete(rpdata.getTab_no(), rpdata.getTab());	//같은 면접후기를 신고한 리스트 모두 삭제
		

		map.put("result", true);
		return map;
	}
	//관리페이지 면접후기신고 취소
	@RequestMapping("/job/adminpage_report_i_cancel_ajax.o")
	@ResponseBody
	public Map adminpage_report_i_cancel_ajax(
			@RequestParam(value="no", defaultValue="-1") int no,
			HttpServletRequest request
			) throws Exception {
		Map map = new HashMap();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//비로그인
		if(mdata == null) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		if(mdata.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
		
		
		
		ReportData rpdata = reportService.getArticle(no, 2);
		reportService.deleteNo(rpdata.getNo());
		
		

		map.put("result", true);
		return map;
	}
	
	
}
