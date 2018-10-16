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
	//no�� ����
	int no = -1;
	int counts = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(counts == -1) {
			msg = "������ �Է��ϼ���.";
			return ERROR;
		}
		
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.put(no, counts);
		session.setAttribute("basket", map);
		
		msg = "���� ����.";
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
