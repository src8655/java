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
	//�з�(-1 �̸� ��κ���(��ۿϷ�� ����))
	String cate = "-1";
	Action_Paging paging;
	List list;

	@Override
	public String execute() throws Exception {
		super.run();
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
					
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		paging = new Action_Paging(sdb.count2_M(member_info.getNo(), Integer.parseInt(cate)), 10, Integer.parseInt(pages));
		
		//����Ʈ ��������
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
