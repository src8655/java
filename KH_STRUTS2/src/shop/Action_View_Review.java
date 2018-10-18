package shop;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_View_Review extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	int product_no = -1;
	List_Data_Bean ldata;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldata = ldb.getArticle_M(product_no);
		
		return SUCCESS;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public List_Data_Bean getLdata() {
		return ldata;
	}

	public void setLdata(List_Data_Bean ldata) {
		this.ldata = ldata;
	}

}
