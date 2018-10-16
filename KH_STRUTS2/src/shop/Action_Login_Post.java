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


public class Action_Login_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	private String auto_ids = "";

	String user_id = "";
	String user_pw = "";
	
	@Override
	public String execute() throws Exception {
		super.run();

		

		if(user_id.equals("")) {
			msg = "���̵� �Է��ϼ���.";
			
			return ERROR;
		}
		if(user_pw.equals("")) {
			msg = "��й�ȣ�� �Է��ϼ���.";
			
			return ERROR;
		}
		
		//�ڵ����̵� üũ�Ǿ����� Ȯ��
		int auto_id = 0;
		if(auto_ids != null)
			if(!auto_ids.equals(""))
				auto_id = 1;
		
		//���̵� ��Ű
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		if(auto_id == 1) cmanager.setId(user_id, response);	//��Ű ����
		else cmanager.delId(response);	//��Ű ����

		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(user_pw);
    	//��ȣȭ
    	mdata.setUser_pw(Md5Enc.getEncMD5(mdata.getUser_pw().getBytes()));
    	
		int res = 0;
		if(mdb.login_M(mdata)) {
			res = 1;
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getUser_pw());
		}
		
		if(res == 0) {
			msg = "���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.";
			
			return ERROR;
		}
		
		msg = "�α��� ����.";
		url = "index.o";
		
		return SUCCESS;
	}

	public void setAuto_ids(String auto_ids) {
		this.auto_ids = auto_ids;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	
}
