package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Edit extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	int ship_company = 1;
	List_Data_Bean ldata;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldata = ldb.getArticle_M(no);
		
		if(ldata.getShip_company().equals("CJ�������")) ship_company = 1;
		if(ldata.getShip_company().equals("��ü���ù�")) ship_company = 2;
		if(ldata.getShip_company().equals("�����ù�")) ship_company = 3;
		if(ldata.getShip_company().equals("�����ù�")) ship_company = 4;
		if(ldata.getShip_company().equals("CVSnet������")) ship_company = 5;
		
		
		return SUCCESS;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getShip_company() {
		return ship_company;
	}

	public void setShip_company(int ship_company) {
		this.ship_company = ship_company;
	}

	public List_Data_Bean getLdata() {
		return ldata;
	}

	public void setLdata(List_Data_Bean ldata) {
		this.ldata = ldata;
	}

}
