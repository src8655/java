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

public class Action_Join_Edit_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String company_number = "";
	String bank = "";
	String bank_num = "";
	String name = "";
	String user_id = "";
	String user_pw = "";
	String user_pw2 = "";
	String email = "";
	String zipcode = "";
	String addr = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	int quest = -1;
	String answer = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info.getOrders() == 2 && company_number.equals("")) {
			msg = "����ڵ�Ϲ�ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(member_info.getOrders() == 2 && bank.equals("")) {
			msg = "�Ա������� �Է��ϼ���.";
			return ERROR;
		}
		if(member_info.getOrders() == 2 && bank_num.equals("")) {
			msg = "���¹�ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(name.equals("")) {
			msg = "�̸��� �Է��ϼ���.";
			return ERROR;
		}
		if(!user_pw.equals(user_pw2) && (!user_pw.equals("") || !user_pw2.equals(""))) {
			msg = "��й�ȣ�� �ٸ��ϴ�.";
			return ERROR;
		}
		if(email.equals("")) {
			msg = "�̸����� �Է��ϼ���.";
			return ERROR;
		}
		if(zipcode.equals("")) {
			msg = "�����ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(addr.equals("")) {
			msg = "�ּҸ� �Է��ϼ���.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "��ȭ��ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "��ȭ��ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "��ȭ��ȣ�� �Է��ϼ���.";
			return ERROR;
		}

		if(quest == -1) {
			msg = "������ �Է����ּ���.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "�亯�� �Է����ּ���.";
			return ERROR;
		}
		
		
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setCompany_number(company_number);
		mdata.setName(name);
		mdata.setUser_id(member_info.getUser_id());
		if(!user_pw.equals("") || !user_pw2.equals(""))
			mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		else mdata.setUser_pw("");
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setOrders(member_info.getOrders());
		mdata.setBank(bank);
		mdata.setBank_num(bank_num);
		mdata.setNo(member_info.getNo());
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		int res = 0;	//1���� 0����
		if(mdb.update_M(mdata)) res = 1;

		if(res == 1) {
			//��й�ȣ ������ ������ ��α���
			if(!user_pw.equals("") || !user_pw2.equals("")) {
				session.setAttribute("user_pw", mdata.getUser_pw());
			}
			
			msg = "���� ����.";
			url = "index.o";
			return SUCCESS;
		}else{
			msg = "���� ����.";
			return ERROR;
		}
	}

	public void setCompany_number(String company_number) {
		this.company_number = company_number;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public void setQuest(int quest) {
		this.quest = quest;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


}
