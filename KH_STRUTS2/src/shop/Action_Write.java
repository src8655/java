package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Write extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {

	@Override
	public String execute() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}

}
