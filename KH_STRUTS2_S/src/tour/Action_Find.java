package tour;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.Member_Data;

public class Action_Find extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	//id_post
	String user_id = "";
	String name = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	
	//pw
	//String user_id = "";
	//String name = "";
	//String phone1 = "";
	//String phone2 = "";
	//String phone3 = "";
	
	
	//pw_post
	//String user_id = "";
	//String name = "";
	//String phone1 = "";
	//String phone2 = "";
	//String phone3 = "";
	int quest = -1;
	String answer = "";
	int res = 0;
	
	//pw_change
	//String user_id = "";
	//String name = "";
	//String phone1 = "";
	//String phone2 = "";
	//String phone3 = "";
	//int quest = -1;
	//String answer = "";
	String user_pw = "";
	String user_pw2 = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String id_post() throws Exception {
		super.run();
		
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		user_id = (String)sqlmap.queryForObject("Member_getFindId", map);
		if(user_id == null) user_id = "";
		
		return SUCCESS;
	}
	public String pw() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String pw_post() throws Exception {
		super.run();

		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			return ERROR;
		}
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력해주세요.";
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
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		map.put("quest", quest);
		map.put("answer", answer);
		int tmp = (int)sqlmap.queryForObject("Member_getFindPw", map);
		
		
		if(tmp == 0) res = 0;
		else res = 1;
		
		return SUCCESS;
	}
	public String pw_change() throws Exception {
		super.run();
		if(user_id.equals("")) {
			msg = "아이디를 입력해주세요.";
			return ERROR;
		}
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력해주세요.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력해주세요.";
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
			msg = "비밀번호 확인을 입력해주세요.";
			return ERROR;
		}
		if(!user_pw2.equals(user_pw)) {
			msg = "비밀번호가 다릅니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Member_Data mdata = new Member_Data();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(Md5Enc.getEncMD5(user_pw.getBytes()));
		mdata.setName(name);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		
		sqlmap.update("Member_changePw", mdata);
		
		
		
		msg = "비밀번호 변경이 완료되었습니다.";
		url = "login.o";
		
		return SUCCESS;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
}
