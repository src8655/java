package tour;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.Member_Data;

public class Action_Join extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	//write_post
	private String user_id = "";
	private String user_pw = "";
	private String user_pw2 = "";
	private String name = "";
	private String email = "";
	private String zipcode = "";
	private String addr = "";
	private String phone1 = "";
	private String phone2 = "";
	private String phone3 = "";
	private int quest = -1;
	private String answer = "";
	
	//id_check
	//String user_id = "";
	int result = 0;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String write() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String write_post() throws Exception {
		super.run();
		
		if(user_id.equals("")) {
			msg = "아이디를 입력해 주세요.";
			return ERROR;
		}
		if(user_pw.equals("")) {
			msg = "비밀번호를 입력해 주세요.";
			return ERROR;
		}
		if(user_pw2.equals("")) {
			msg = "비밀번호 확인을 입력해 주세요.";
			return ERROR;
		}
		if(!user_pw2.equals(user_pw)) {
			msg = "비밀번호가 다릅니다.";
			return ERROR;
		}
		if(name.equals("")) {
			msg = "이름을 입력해 주세요.";
			return ERROR;
		}
		if(email.equals("")) {
			msg = "이메일을 입력해 주세요.";
			return ERROR;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력해 주세요.";
			return ERROR;
		}
		if(addr.equals("")) {
			msg = "주소를 입력해 주세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력해 주세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력해 주세요.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력해 주세요.";
			return ERROR;
		}
		if(quest == -1) {
			msg = "질문을 선택해 주세요.";
			return ERROR;
		}
		if(answer.equals("")) {
			msg = "답변을 입력해 주세요.";
			return ERROR;
		}
		
		Member_Data mdata = new Member_Data();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		mdata.setName(name);
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		mdata.setDates(year+"-"+month+"-"+day);
		mdata.setOrders(2);
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.insert("Member_insert", mdata);
		
		
		return SUCCESS;
	}
	public String id_check() throws Exception {
		super.run();
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		int tmp = (int)sqlmap.queryForObject("Member_getUserIdCount", user_id);
		
		if(tmp == 0) result = 1;
		else result = 0;
		
		
		return SUCCESS;
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
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
