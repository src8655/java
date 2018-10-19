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

public class Action_Mypage_Admin_Member_Edit extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	Member_Data_Bean mdata;
	
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
		
		mdata = mdb.getArticle_M(no);
		
		
		return SUCCESS;
	}
	
	public void setNo(int no) {
		this.no = no;
	}
	public Member_Data_Bean getMdata() {
		return mdata;
	}
}
