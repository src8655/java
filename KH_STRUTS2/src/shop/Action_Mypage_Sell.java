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

public class Action_Mypage_Sell extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	//분류(-1 이면 모두보기(배송완료는 제외))
	String cate = "-1";
	Action_Paging paging;
	List list;

	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
					
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), Integer.parseInt(cate)), 10, Integer.parseInt(pages));
		
		//리스트 가져오기
		list = sdb.getArticles2_M(paging.getBoard_starts(), paging.getBoard_ends(), member_info.getNo(), Integer.parseInt(cate));

		
		
		return SUCCESS;
	}

	public Action_Paging getPaging() {
		return paging;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}


}
