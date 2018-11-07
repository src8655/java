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


public class Action_Login extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	private String user_id = "";	//�������̵�
	
	//post
	private String auto_ids = "";
	//String user_id = "";
	
	//find_pw
	String user_pw = "";
	//String user_id = "";
	String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	
	//find_pw_post
	/*String user_id = "";
	String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";*/
	int quest = -1;
	String answer = "";
	int res = 0;
	
	//find_pw_change
	/*String user_id = "";
	String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	int quest = -1;
	String answer = "";
	String user_pw = "";*/
	String user_pw2 = "";
	
	//find_id_post
	/*String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	String user_id = "";*/
	
	@Override
	public String execute() throws Exception {
		super.run();
		//��Ű����
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		user_id = cmanager.getId(request);	//��Ű���� ���̵� �޾ƿ´�
		
		return SUCCESS;
	}
	public String post() throws Exception {
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
	public String find_pw() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String find_pw_post() throws Exception {
		super.run();
		
		if(user_id.equals("")) {
			msg = "���̵� �Է����ּ���.";
			return ERROR;
		}if(name.equals("")) {
			msg = "�̸��� �Է����ּ���.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(quest == -1) {
			msg = "������ �������ּ���.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			return ERROR;
		}
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		if(mdb.findPw_M(user_id, name, phone1, phone2, phone3, quest, answer)) {
			res = 1;
		}

		return SUCCESS;
	}
	public String find_pw_change() throws Exception {
		super.run();
		if(user_id.equals("")) {
			msg = "���̵� �Է����ּ���.";
			return ERROR;
		}if(name.equals("")) {
			msg = "�̸��� �Է����ּ���.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(phone3.equals("�޴���ȭ�� �Է����ּ���.")) {
			msg = "";
			return ERROR;
		}
		if(quest == -1) {
			msg = "������ �������ּ���.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			return ERROR;
		}
		if(user_pw.equals("")) {
			msg = "��й�ȣ�� �Է����ּ���.";
			return ERROR;
		}
		if(user_pw2.equals("")) {
			msg = "��й�ȣȮ���� �Է����ּ���.";
			return ERROR;
		}
		if(!user_pw.equals(user_pw2)) {
			msg = "��й�ȣ�� �ٸ��ϴ�.";
			return ERROR;
		}
		
		//��ȣȭ
		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		
		int res = 0;
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		if(mdb.changePw_M(user_id, name, phone1, phone2, phone3, quest, answer, user_pw))
			res = 1;
		
		if(res == 1) {
			msg = "��й�ȣ ���� ����.";
			url = "login.o";
			return SUCCESS;
		}else {
			msg = "��й�ȣ ���� ����.";
			return ERROR;
		}
	}
	public String find_id() throws Exception {
		super.run();
		
		
		
		return SUCCESS;
	}
	public String find_id_post() throws Exception {
		super.run();
		if(name.equals("")) {
			msg = "�̸��� �Է����ּ���.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "�޴���ȭ�� �Է����ּ���.";
			return ERROR;
		}
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		
		user_id = mdb.findId_M(name, phone1, phone2, phone3);
		
		if(user_id == null) user_id = "";
		
		return SUCCESS;
	}
	public String logout() throws Exception {
		super.run();
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		msg = "�α׾ƿ� ����";
		url = "index.o";
		
		return SUCCESS;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAuto_ids() {
		return auto_ids;
	}
	public void setAuto_ids(String auto_ids) {
		this.auto_ids = auto_ids;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public int getQuest() {
		return quest;
	}
	public void setQuest(int quest) {
		this.quest = quest;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	
}
