package com.myjob.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.myjob.dao.CompanyDao;
import com.myjob.dao.CountDao;
import com.myjob.dao.ReviewDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;
import com.myjob.data.ReviewData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;



@Controller
public class ListController {
	@Autowired
	CompanyDao companyService;
	@Autowired
	CountDao countService;
	@Autowired
	ReviewDao reviewService;

	String msg = "";
	String url = "";
	
	public static String savePathd = "/job/upload/";	//�������� �����
	
	//����Ʈ
	@RequestMapping("/job/list.o")
	public ModelAndView list(
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int count = companyService.getCount(searchValue);
		Action_Paging paging = new Action_Paging(count, 10, pages);
		List list = companyService.getArticles(paging.getBoard_starts(), paging.getBoard_ends(), searchValue);
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("count", count);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.addObject("paging", paging);
		mav.addObject("list", list);
		mav.setViewName("job/list");
		return mav;
	}
	//�󼼺���
	@RequestMapping("/job/view.o")
	public ModelAndView view(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@CookieValue(value="job_view", defaultValue="") String job_view,
			HttpServletResponse response
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		

		//��ȸ�� �߰�
		if(!job_view.contains(ActionTime.getDate()+"=="+member_no)) {
			countService.insert(ActionTime.getDate(), member_no);
			job_view = job_view+"//"+ActionTime.getDate()+"=="+member_no;
			Cookie cookie = new Cookie("job_view", job_view);
			response.addCookie(cookie);
		}
		System.out.println(job_view);
		
		//�����ϰ� ��ȸ��
		String[] dates = new String[6];
		int[] counts = new int[6];
		for(int i=0;i<6;i++) {
			dates[i] = ActionTime.lastDate(i);
			counts[i] = countService.getCount(dates[i], member_no);
			mav.addObject("dates"+i, dates[i]);
			mav.addObject("counts"+i, counts[i]);
		}
		
		
		CompanyData cdata = companyService.getArticle(member_no);
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/view");
		return mav;
	}
	//�������
	@RequestMapping("/job/edit.o")
	public ModelAndView edit(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		
		CompanyData cdata = companyService.getArticle(member_no);
		
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/edit");
		return mav;
	}
	//������� �����Ϸ�
	@RequestMapping("/job/edit_post.o")
	public ModelAndView edit_post(
			@ModelAttribute("cdata") CompanyData cdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			@RequestParam(value="files1", required=false) MultipartFile files1,
			@RequestParam(value="files2", required=false) MultipartFile files2,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		if(mdata.getNo() != cdata.getMember_no()) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		CompanyData cdata_tmp = companyService.getArticle(cdata.getMember_no());
		cdata.setFile1(cdata_tmp.getFile1());
		cdata.setFile2(cdata_tmp.getFile2());
		
		//���ε��۾�
		String savePaths=request.getRealPath(savePathd);	//������ġ ������
		String filename1 = files1.getOriginalFilename();
		if(!filename1.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//�̹� �����ϸ� ī��Ʈ ����
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename1);
			}while(files_tmp.exists());
			files1.transferTo(files_tmp);
			cdata.setFile1(files_tmp.getName());
		}
		String filename2 = files2.getOriginalFilename();
		if(!filename2.equals("")) {
			int cnt = 0;
			File files_tmp = null;
			//�̹� �����ϸ� ī��Ʈ ����
			do {
				cnt++;
				files_tmp = new File(savePaths+"/"+"o"+cnt+"o"+filename2);
			}while(files_tmp.exists());
			files2.transferTo(files_tmp);
			cdata.setFile2(files_tmp.getName());
		}
		
		companyService.update(cdata);
		
		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "���� �Ϸ�";
		url = "view.o?member_no="+cdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	//����
	@RequestMapping("/job/review.o")
	public ModelAndView review(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		CompanyData cdata = companyService.getArticle(member_no);

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/review");
		return mav;
	}
	//�����ۼ�
	@RequestMapping("/job/review_write.o")
	public ModelAndView review_write(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		CompanyData cdata = companyService.getArticle(member_no);

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/review_write");
		return mav;
	}
	//�����ۼ�
	@RequestMapping("/job/review_write_post.o")
	public ModelAndView review_write_post(
			@ModelAttribute("rdata") ReviewData rdata,
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		

		CompanyData cdata = companyService.getArticle(member_no);

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		
		
		
		
		mav.setViewName("job/post");
		return mav;
	}
}
