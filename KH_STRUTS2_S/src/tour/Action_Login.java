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

public class Action_Login extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String user_id = "";
	
	//post
	private String auto_ids = "";
	//String user_id = "";
	String user_pw = "";

	//edit_post
	String name = "";
	//String user_pw = "";
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
		
		Cookie_Bean cb = Cookie_Bean.getInstance();
		user_id = cb.getId(request);
		
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


		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
    	
		int res = (int)sqlmap.queryForObject("Member_getUserIdPwCount", map);
		if(res != 0) {
			res = 1;
			session.setAttribute("user_id", user_id);
			session.setAttribute("user_pw", user_pw);
		}else {
			msg = "아이디 또는 비밀번호를 확인해주세요.";
			
			return ERROR;
		}
		
		msg = "로그인 성공.";
		url = "index.o";
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		if(name.equals("")) {
			msg = "이름을 입력해주세요.";
			return ERROR;
		}
		if(email.equals("")) {
			msg = "이메일을 입력해주세요.";
			return ERROR;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력해주세요.";
			return ERROR;
		}
		if(addr.equals("")) {
			msg = "주소를 입력해주세요.";
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
		if(!user_pw.equals("") || !user_pw2.equals("")) {
			if(!user_pw.equals(user_pw2)) {
				msg = "비밀번호가 다릅니다.";
				return ERROR;
			}else user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		}else user_pw = "none";
		
		Member_Data mdata = new Member_Data();
		mdata.setNo(member_info.getNo());
		mdata.setName(name);
		mdata.setEmail(email);
		mdata.setZipcode(zipcode);
		mdata.setAddr(addr);
		mdata.setPhone1(phone1);
		mdata.setPhone2(phone2);
		mdata.setPhone3(phone3);
		mdata.setQuest(quest);
		mdata.setAnswer(answer);
		mdata.setUser_pw(user_pw);
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.update("Member_changeInfo", mdata);
		
		if(!user_pw.equals("none")) {
			session.setAttribute("user_id", member_info.getUser_id());
			session.setAttribute("user_pw", user_pw);
		}
		
		msg = "수정 성공";
		url = "index.o";
		
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

	public String getUser_pw2() {
		return user_pw2;
	}

	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
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

}
