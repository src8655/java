package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Logout extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {

	
	@Override
	public String execute() throws Exception {
		super.run();
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		msg = "로그아웃 성공";
		url = "index.o";
		
		return SUCCESS;
	}
	
}
