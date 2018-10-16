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


public class Action_Login_Find_Pw_Change extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String user_id = "";
	String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	int quest = -1;
	String answer = "";
	String user_pw = "";
	String user_pw2 = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			return ERROR;
		}if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "휴대전화를 입력해주세요.";
			return ERROR;
		}
		if(phone3.equals("휴대전화를 입력해주세요.")) {
			msg = "";
			return ERROR;
		}
		if(quest == -1) {
			msg = "질문을 선택해주세요.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해주세요.";
			return ERROR;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력해주세요.";
			return ERROR;
		}
		if(user_pw2.equals("")) {
			msg = "비밀번호확인을 입력해주세요.";
			return ERROR;
		}
		if(!user_pw.equals(user_pw2)) {
			msg = "비밀번호가 다릅니다.";
			return ERROR;
		}
		
		//암호화
		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		
		int res = 0;
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		if(mdb.changePw_M(user_id, name, phone1, phone2, phone3, quest, answer, user_pw))
			res = 1;
		
		if(res == 1) {
			msg = "비밀번호 변경 성공.";
			url = "login.o";
			return SUCCESS;
		}else {
			msg = "비밀번호 변경 실패.";
			return ERROR;
		}
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}

}
