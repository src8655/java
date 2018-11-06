package tour;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

public class Action_Admin_Member extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list;
	
	//edit
	int no = -1;
	Member_Data mdata;
	
	//edit_post
	//int no = -1;
	String name = "";
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
	
	//del
	//int no = -1;

	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		int tmp = (int)sqlmap.queryForObject("Member_getCount");
		paging = new Action_Paging(tmp, 10, pages);
		Map map = new HashMap();
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		
		list = (List)sqlmap.queryForList("Member_getArticles", map);
		
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		mdata = (Member_Data)sqlmap.queryForObject("Member_getArticleNo", no);
		
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(no == -1) {
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
		mdata.setNo(no);
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
		
		msg = "수정 성공";
		url = "admin_member.o?pages="+pages+"&searchs="+searchs_utf;
		
		return SUCCESS;
	}
	public String del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("no", no);
		sqlmap.delete("Member_delete", map);
		
		msg = "삭제 성공";
		url = "admin_member.o?pages="+pages+"&searchs="+searchs_utf;
		
		return SUCCESS;
	}
	
	public Action_Paging getPaging() {
		return paging;
	}

	public List getList() {
		return list;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Member_Data getMdata() {
		return mdata;
	}
	public void setMdata(Member_Data mdata) {
		this.mdata = mdata;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public void setList(List list) {
		this.list = list;
	}

}
