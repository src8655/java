package com.myjob.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
import com.myjob.dao.IncomeDao;
import com.myjob.dao.InterviewDao;
import com.myjob.dao.ReviewDao;
import com.myjob.data.CompanyData;
import com.myjob.data.IncomeData;
import com.myjob.data.InterviewData;
import com.myjob.data.MemberData;
import com.myjob.data.ReviewData;
import com.myjob.ext.ActionTime;
import com.myjob.ext.Action_Paging;
import com.myjob.ext.NumberFormat;



@Controller
public class ListController {
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
		

		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);

		//��ȸ�� �߰�
		if(!job_view.contains(ActionTime.getDate()+"=="+member_no)) {
			countService.insert(ActionTime.getDate(), member_no);
			job_view = job_view+"//"+ActionTime.getDate()+"=="+member_no;
			Cookie cookie = new Cookie("job_view", job_view);
			response.addCookie(cookie);
		}
		
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

		mav.addObject("tab", 1);
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

		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		
		
		Action_Paging paging = new Action_Paging(count2, 3, pages_r);
		List list = reviewService.getArticles(member_no, paging.getBoard_starts(), paging.getBoard_ends());

		mav.addObject("paging", paging);
		mav.addObject("list", list);
		

		double stars = 0;
		double stars1 = 0;
		double stars2 = 0;
		double stars3 = 0;
		double stars4 = 0;
		double stars5 = 0;
		int stars_bar1 = 0;
		int stars_bar2 = 0;
		int stars_bar3 = 0;
		int stars_bar4 = 0;
		int stars_bar5 = 0;
		
		//�� ����
		if(count2 != 0) {
			ReviewData rdata = reviewService.getAllStars(member_no);
			stars = Math.floor((rdata.getStars()/(double)count2)*10.0)/10.0;
			stars1 = Math.floor((rdata.getStars1()/(double)count2)*10.0)/10.0;
			stars2 = Math.floor((rdata.getStars2()/(double)count2)*10.0)/10.0;
			stars3 = Math.floor((rdata.getStars3()/(double)count2)*10.0)/10.0;
			stars4 = Math.floor((rdata.getStars4()/(double)count2)*10.0)/10.0;
			stars5 = Math.floor((rdata.getStars5()/(double)count2)*10.0)/10.0;
			stars_bar1 = (int)Math.floor((stars1/5.0)*100.0);
			stars_bar2 = (int)Math.floor((stars2/5.0)*100.0);
			stars_bar3 = (int)Math.floor((stars3/5.0)*100.0);
			stars_bar4 = (int)Math.floor((stars4/5.0)*100.0);
			stars_bar5 = (int)Math.floor((stars5/5.0)*100.0);
		}
		mav.addObject("stars", stars);
		mav.addObject("stars1", stars1);
		mav.addObject("stars2", stars2);
		mav.addObject("stars3", stars3);
		mav.addObject("stars4", stars4);
		mav.addObject("stars5", stars5);
		mav.addObject("stars_bar1", stars_bar1);
		mav.addObject("stars_bar2", stars_bar2);
		mav.addObject("stars_bar3", stars_bar3);
		mav.addObject("stars_bar4", stars_bar4);
		mav.addObject("stars_bar5", stars_bar5);
		
		
		

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("tab", 2);
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
	@RequestMapping("/job/review_write_post.o")
	public ModelAndView review_write_post(
			@ModelAttribute("rdata") ReviewData rdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//��α���
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		//�̹� �ۼ��� ����
		int tmp = reviewService.getMyCount(rdata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		rdata.setDates(ActionTime.getDate());
		rdata.setWriter_no(mdata.getNo());
		
		reviewService.insert(rdata);
		

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "�ۼ� ����.";
		url = "review.o?member_no="+rdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	
	
	
	
	
	//����
	@RequestMapping("/job/income.o")
	public ModelAndView income(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		CompanyData cdata = companyService.getArticle(member_no);
		
		//����Ʈ ����
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		
		//���� �ִ� �ּ� ��� ���� ���ϱ�
		int maxs = 0;
		int mins = 0;
		int avgs = 0;
		int rank = 0;
		Map map = incomeService.getMoneyMaxMin(member_no);
		maxs = (Integer)map.get("maxs")+500;
		mins = (Integer)map.get("mins")-500;
		avgs = (Integer)map.get("avgs");
		rank = incomeService.getRank(member_no);
		
		mav.addObject("maxs", NumberFormat.number_format(maxs));
		mav.addObject("mins", NumberFormat.number_format(mins));
		mav.addObject("avgs", NumberFormat.number_format(avgs));
		mav.addObject("rank", rank);
		
		
		
		
		List list = incomeService.getArticles(member_no);
		for(int i=0;i<list.size();i++) {
			IncomeData tmp = (IncomeData)list.get(i);
			tmp.setMoneys(NumberFormat.number_format(tmp.getMoney()));
			tmp.setBarline((int)(((((double)tmp.getMoney())-mins)/(((double)(maxs))-mins))*100.0));
		}
		
		mav.addObject("list", list);
		
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("tab", 3);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/income");
		return mav;
	}
	//�����ۼ�
	@RequestMapping("/job/income_write_post.o")
	public ModelAndView income_write(
			@ModelAttribute("idata") IncomeData idata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();

		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//��α���
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		//�̹� �ۼ��� ����
		int tmp = incomeService.getMyCount(idata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		idata.setWriter_no(mdata.getNo());
		idata.setDates(ActionTime.getDate());
		
		incomeService.insert(idata);
		

		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "�ۼ� ����.";
		url = "income.o?member_no="+idata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
	
	
	
	

	//�����ı�
	@RequestMapping("/job/interview.o")
	public ModelAndView interview(
			@RequestParam(value="member_no", defaultValue="-1") int member_no,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		CompanyData cdata = companyService.getArticle(member_no);
		
		//����Ʈ ����
		int count2 = reviewService.getCount(member_no);
		mav.addObject("count2", count2);
		int count3 = incomeService.getCount(member_no);
		mav.addObject("count3", count3);
		int count4 = interviewService.getCount(member_no);
		mav.addObject("count4", count4);
		
		Action_Paging paging = new Action_Paging(count4, 3, pages_r);
		List list = interviewService.getArticles(member_no, paging.getBoard_starts(), paging.getBoard_ends());
		
		mav.addObject("paging", paging);
		mav.addObject("list", list);

		
		
		//�� ���̵�
		double difficulty = 0;
		int difficultybar = 0;
		String difficultys = "";

		difficulty = interviewService.getDifficulty(member_no);
		difficultybar = (int)((difficulty/5.0)*100.0);
		if(((int)difficulty) < 2) difficultys = "<span style='color:#6fba1f;'>�ſ콬��</span>";
		else if(((int)difficulty) < 3) difficultys = "<span style='color:#8ad43b;'>����</span>";
		else if(((int)difficulty) < 4) difficultys = "<span style='color:#fb9f00;'>����</span>";
		else if(((int)difficulty) < 5) difficultys = "<span style='color:#fb6400;'>�����</span>";
		else if(((int)difficulty) < 6) difficultys = "<span style='color:#e62b0d;'>�ſ�����</span>";

		mav.addObject("difficulty", difficulty);
		mav.addObject("difficultybar", difficultybar);
		mav.addObject("difficultys", difficultys);
		
		
		//�� �������
		int dir1 = interviewService.getInterviewdir(member_no, 1);
		int dir2 = interviewService.getInterviewdir(member_no, 2);
		int dir3 = interviewService.getInterviewdir(member_no, 3);
		int dir4 = interviewService.getInterviewdir(member_no, 4);
		int dir5 = interviewService.getInterviewdir(member_no, 5);
		int dir6 = interviewService.getInterviewdir(member_no, 6);
		double dirsum = dir1+dir2+dir3+dir4+dir5+dir6;
		double dirs1 = 0.0;
		double dirs2 = 0.0;
		double dirs3 = 0.0;
		double dirs4 = 0.0;
		double dirs5 = 0.0;
		double dirs6 = 0.0;
		if(dirsum != 0) {
			dirs1 = Math.round(dir1/dirsum*10.0)/10.0*100;
			dirs2 = Math.round(dir2/dirsum*10.0)/10.0*100;
			dirs3 = Math.round(dir3/dirsum*10.0)/10.0*100;
			dirs4 = Math.round(dir4/dirsum*10.0)/10.0*100;
			dirs5 = Math.round(dir5/dirsum*10.0)/10.0*100;
			dirs6 = Math.round(dir6/dirsum*10.0)/10.0*100;
		}
		mav.addObject("dirs1", dirs1);
		mav.addObject("dirs2", dirs2);
		mav.addObject("dirs3", dirs3);
		mav.addObject("dirs4", dirs4);
		mav.addObject("dirs5", dirs5);
		mav.addObject("dirs6", dirs6);
		
		
		int exsum = 0;
		int resultsum = 0;
		int[] ex = new int[3];
		int[] result = new int[3];
		for(int i=0;i<3;i++) {
			ex[i] = interviewService.getInterviewex(member_no, (i+1));
			result[i] = interviewService.getInterviewresult(member_no, (i+1));
			exsum += ex[i];
			resultsum += result[i];
		}
		for(int i=0;i<3;i++) {
			ex[i] = (int)Math.round(((((double)ex[i])/((double)exsum))*100.0));
			result[i] = (int)Math.round(((((double)result[i])/((double)resultsum))*100.0));
		}
		mav.addObject("ex", ex);
		mav.addObject("result", result);
		
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		mav.addObject("tab", 4);
		mav.addObject("cdata", cdata);
		mav.addObject("member_no", member_no);
		mav.addObject("pages", pages);
		mav.addObject("pages_r", pages_r);
		mav.addObject("searchValue", searchValue);
		mav.addObject("searchValue_utf", searchValue_utf);
		mav.setViewName("job/interview");
		return mav;
	}
	//�����ı� �ۼ��Ϸ�
	@RequestMapping("/job/interview_write_post.o")
	public ModelAndView interview_write_post(
			@ModelAttribute("itdata") InterviewData	itdata,
			@RequestParam(value="pages", defaultValue="1") int pages,
			@RequestParam(value="pages_r", defaultValue="1") int pages_r,
			@RequestParam(value="searchValue", defaultValue="") String searchValue,
			HttpServletRequest request
			) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MemberData mdata = (MemberData)request.getAttribute("memberInfo");
		
		//��α���
		if(mdata == null) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		if(mdata.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		//�̹� �ۼ��� ����
		int tmp = interviewService.getMyCount(itdata.getMember_no(), mdata.getNo());
		if(tmp != 0) {
			msg = "�߸��� �����Դϴ�.";
			mav.addObject("msg", msg);
			mav.setViewName("job/error");
			return mav;
		}
		
		itdata.setDates(ActionTime.getDate());
		itdata.setWriter_no(mdata.getNo());
		
		interviewService.insert(itdata);
		


		String searchValue_utf = URLEncoder.encode(searchValue,"UTF-8");

		msg = "�ۼ� ����.";
		url = "interview.o?member_no="+itdata.getMember_no()+"&pages="+pages+"&searchValue="+searchValue_utf+"&pages_r="+pages_r;
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		mav.setViewName("job/post");
		return mav;
	}
}