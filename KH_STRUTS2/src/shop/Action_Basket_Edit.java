package shop;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Basket_Edit extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	//no와 개수
	int no = -1;
	int counts = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(counts == -1) {
			msg = "개수를 입력하세요.";
			return ERROR;
		}
		
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.put(no, counts);
		session.setAttribute("basket", map);
		
		msg = "수정 성공.";
		url = "basket.o";
		return SUCCESS;
	}

	public void setNo(int no) {
		this.no = no;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
}
