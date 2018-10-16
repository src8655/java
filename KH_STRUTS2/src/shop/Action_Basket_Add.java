package shop;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Basket_Add extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	int counts = -1;
	int res = 1;
	

	@Override
	public String execute() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(counts < 1) {
			msg = "개수를 입력하세요.";
			return ERROR;
		}
		
		//최초 입력
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, counts);
			session.setAttribute("basket", map);		//no=counts 형태로 저장
		}else {
			//최초입력이 아닐때
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, counts);
			session.setAttribute("basket", map);	//     //를 구분자로 씀
		}
		
		
		if(res == 1) {
			msg = "추가성공";
			url = "basket.o";
			return SUCCESS;
		}
		
		if(res == 0) {
			msg = "추가실패";
			return ERROR;
		}
		return SUCCESS;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

}
