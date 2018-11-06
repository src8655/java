package tour;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.Reserve_Data;

public class Action_Admin extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		return SUCCESS;
	}
}
