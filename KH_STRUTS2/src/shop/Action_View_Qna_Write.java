package shop;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_View_Qna_Write extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	String sellers_no = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSellers_no() {
		return sellers_no;
	}

	public void setSellers_no(String sellers_no) {
		this.sellers_no = sellers_no;
	}

}
