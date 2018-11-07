package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

import javafx.scene.shape.Arc;

public class Action_Mypage_Admin_Member extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list;
	
	//edit
	int no = -1;
	Member_Data_Bean mdata;
	
	//edit_post
	//int no = -1;
	int orders = -1;
	String company_number = "";
	String name = "";
	String user_pw = "";
	String user_pw2 = "";
	String email = "";
	String zipcode = "";
	String addr = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	String bank = "";
	String bank_num = "";
	int quest = -1;
	String answer = "";
	int res = 0;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		paging = new Action_Paging(mdb.count_M(), 10, Integer.parseInt(pages));

		list = mdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends());	//리스트받아오기
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		
		mdata = mdb.getArticle_M(no);
		
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		

		if(quest == -1) {
			msg = "질문을 입력해주세요.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			return ERROR;
		}
		
		
		
		//만약 비밀번호 둘중 하나라도 적혀있으면
		if(!user_pw.equals("") || !user_pw2.equals("")) {
			if(!user_pw.equals(user_pw2)) {
				//두 값이 다르면 경고
				msg = "비밀번호가 다릅니다.";
				return ERROR;
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
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		
		
		if(mdb.update_M(mdata)) res = 1;
		
		
		if(res == 1) {
			msg = "수정 성공.";
			url = "mypage_admin_member.o?pages="+pages;
			return SUCCESS;
		}else{
			msg = "수정 실패.";
			return ERROR;
		}
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public List getList() {
		return list;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Member_Data_Bean getMdata() {
		return mdata;
	}
	public void setMdata(Member_Data_Bean mdata) {
		this.mdata = mdata;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getCompany_number() {
		return company_number;
	}
	public void setCompany_number(String company_number) {
		this.company_number = company_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBank_num() {
		return bank_num;
	}
	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
	public int getQuest() {
		return quest;
	}
	public void setQuest(int quest) {
		this.quest = quest;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public void setList(List list) {
		this.list = list;
	}

}
