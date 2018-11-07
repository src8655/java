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
	private String user_id = "";	//유저아이디
	
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
		//쿠키설정
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		user_id = cmanager.getId(request);	//쿠키에서 아이디를 받아온다
		
		return SUCCESS;
	}
	public String post() throws Exception {
		super.run();

		

		if(user_id.equals("")) {
			msg = "아이디를 입력하세요.";
			
			return ERROR;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력하세요.";
			
			return ERROR;
		}
		
		//자동아이디 체크되었는지 확인
		int auto_id = 0;
		if(auto_ids != null)
			if(!auto_ids.equals(""))
				auto_id = 1;
		
		//아이디 쿠키
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		if(auto_id == 1) cmanager.setId(user_id, response);	//쿠키 저장
		else cmanager.delId(response);	//쿠키 삭제

		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(user_pw);
    	//암호화
    	mdata.setUser_pw(Md5Enc.getEncMD5(mdata.getUser_pw().getBytes()));
    	
		int res = 0;
		if(mdb.login_M(mdata)) {
			res = 1;
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getUser_pw());
		}
		
		if(res == 0) {
			msg = "아이디 또는 비밀번호를 확인해주세요.";
			
			return ERROR;
		}
		
		msg = "로그인 성공.";
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
		if(phone3.equals("")) {
			msg = "휴대전화를 입력해주세요.";
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
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		if(mdb.findPw_M(user_id, name, phone1, phone2, phone3, quest, answer)) {
			res = 1;
		}

		return SUCCESS;
	}
	public String find_pw_change() throws Exception {
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
	public String find_id() throws Exception {
		super.run();
		
		
		
		return SUCCESS;
	}
	public String find_id_post() throws Exception {
		super.run();
		if(name.equals("")) {
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
		if(phone3.equals("")) {
			msg = "휴대전화를 입력해주세요.";
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
		
		msg = "로그아웃 성공";
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
