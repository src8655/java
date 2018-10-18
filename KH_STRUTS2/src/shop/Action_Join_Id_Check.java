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


public class Action_Join_Id_Check extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String user_id = "";
	String result = "0";	//결과코드
	
	@Override
	public String execute() throws Exception {
		super.run();

		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		int count = mdb.selectId_M(user_id);


		//성공시 1 실패시 0
		if(count == 0) result = "1";
		
		return SUCCESS;
	}
	public String getResult() {
		return result;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


}
