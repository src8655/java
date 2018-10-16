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


public class Action_Login extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	private String user_id = "";	//�������̵�
	
	@Override
	public String execute() throws Exception {
		super.run();
		//��Ű����
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		user_id = cmanager.getId(request);	//��Ű���� ���̵� �޾ƿ´�
		
		return SUCCESS;
	}
	public String getUser_id() {
		return user_id;
	}
	
}
