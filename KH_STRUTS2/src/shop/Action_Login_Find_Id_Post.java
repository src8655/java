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


public class Action_Login_Find_Id_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	String user_id = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			return ERROR;
		}
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		
		user_id = mdb.findId_M(name, phone1, phone2, phone3);
		
		if(user_id == null) user_id = "";
		
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
