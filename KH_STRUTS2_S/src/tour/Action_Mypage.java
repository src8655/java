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
import tour.data.List_Reserve_Data;
import tour.data.Reserve_Data;
import tour.data.Review_Data;

public class Action_Mypage extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int process1 = 0;
	int process2 = 0;
	int process3 = 0;
	int process4 = 0;
	List list;
	Action_Paging paging;
	
	//view
	int no = -1;
	Reserve_Data rdata;

	//review
	//int no = -1;
	//Reserve_Data rdata;
	
	//review_post
	//int no = -1;
	int stars = 0;
	String memo = "";
	int res = 0;
	
	//cancel
	//int no = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		

		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		
		
		
		//���� ���� ����
		Map map = new HashMap();
		map.put("member_no", member_info.getNo());
		map.put("status", 1);
		process1 = (int)sqlmap.queryForObject("Reserve_getStatusCount", map);
		map.put("status", 2);
		process2 = (int)sqlmap.queryForObject("Reserve_getStatusCount", map);
		map.put("status", 3);
		process3 = (int)sqlmap.queryForObject("Reserve_getStatusCount", map);
		map.put("status", 4);
		process4 = (int)sqlmap.queryForObject("Reserve_getStatusCount", map);
		
		map.clear();
		map.put("member_no", member_info.getNo());
		int total = (int)sqlmap.queryForObject("Reserve_getCount", map);
		paging = new Action_Paging(total, 5, pages);
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		list = (List)sqlmap.queryForList("Reserve_getArticles", map);
		
		//�����δ� Ǯ��
		/*
		//�Աݴ�����ε� ����� �ʰ����¸� ���ó��
		for(int i=0;i<list.size();i++) {
			Reserve_Data rdata = (Reserve_Data)list.get(i);
			//������� ���ó�¥ �̻��̸� ��ҺҰ���
			Long now = cal.getTimeInMillis();
			Long st = Long.parseLong(rdata.getTimes());
			if(now >= st && rdata.getStatus() == 1) {
				//���� ��ҷ� ����
				Map map2 = new HashMap();
				map2.put("no", rdata.getNo());
				map2.put("status", 4);
				sqlmap.update("Reserve_setStatus", map2);
				rdata.setStatus(4);
			}
		}*/
		
		return SUCCESS;
	}
	public String view() throws Exception {
		super.run();
		

		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		
		rdata = (Reserve_Data)sqlmap.queryForObject("Reserve_getArticle", no);
		
		//�� �Խñ��� �ƴϸ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		return SUCCESS;
	}
	public String review() throws Exception {
		super.run();
		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		rdata = (Reserve_Data)sqlmap.queryForObject("Reserve_getArticle", no);
		
		//�ԱݿϷ� ���°� �ƴҶ�
		if(rdata.getStatus() != 2) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		//������ �ƴҶ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		return SUCCESS;
	}
	public String review_post() throws Exception {
		super.run();
		
		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Reserve_Data rdata = (Reserve_Data)sqlmap.queryForObject("Reserve_getArticle", no);
		
		//�ԱݿϷ� ���°� �ƴҶ�
		if(rdata.getStatus() != 2) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		//������ �ƴҶ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		Review_Data rvdata = new Review_Data();
		rvdata.setList_no(rdata.getList_no());
		rvdata.setStars(stars);
		rvdata.setMemo(memo);
		rvdata.setMember_no(member_info.getNo());
		String user_id = "";
		if(member_info.getUser_id().length() < 3)
			user_id = member_info.getUser_id().substring(0, 1)+"***";
		else
			user_id = member_info.getUser_id().substring(0, 3)+"***";
		rvdata.setUser_id(user_id);
		rvdata.setDates(year+"-"+month+"-"+day);
		
		
		//�Է�
		sqlmap.insert("Review_insert", rvdata);
		
		
		//���� ����Ϸ�� �ٲ�
		Map map = new HashMap();
		map.put("no", rdata.getNo());
		map.put("status", 3);
		sqlmap.update("Reserve_setStatus", map);
		
		
		//���� ī��Ʈ �߰�
		int tmps = (int)sqlmap.queryForObject("List_getBuy", rdata.getList_no());
		tmps++;
		map.clear();
		map.put("buy", tmps);
		map.put("no", rdata.getList_no());
		sqlmap.update("List_setBuy", map);
		
		
		res = 1;
		
		return SUCCESS;
	}
	public String cancel() throws Exception {
		super.run();
		

		if(level != 2) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Reserve_Data rdata = (Reserve_Data)sqlmap.queryForObject("Reserve_getArticle", no);
		
		//�� �Խñ��� �ƴϸ�
		if(rdata.getMember_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		//���°� �̹� ��һ����̰ų� ����Ϸ� �����̸�
		if(rdata.getStatus() == 3 || rdata.getStatus() == 4) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//������� ���ó�¥ �̻��̸� ��ҺҰ���
		Long now = cal.getTimeInMillis();
		Long st = Long.parseLong(rdata.getTimes());
		if(now >= st) {
			msg = "��߳�¥�� �ʰ��Ǿ����ϴ�.";
			return ERROR;
		}
		
		//���� ��ҷ� ����
		Map map = new HashMap();
		map.put("no", rdata.getNo());
		map.put("status", 4);
		sqlmap.update("Reserve_setStatus", map);
		
		//��ǰ���� ���󺹱�
		map.clear();
		map.put("no", rdata.getList_reserve_no());
		map.put("isreserve", 0);
		sqlmap.update("List_Reserve_setIsreserve", map);
		
		msg = "��� ����";
		url = "mypage.o?pages="+pages;
		return SUCCESS;
	}
	public int getProcess1() {
		return process1;
	}
	public void setProcess1(int process1) {
		this.process1 = process1;
	}
	public int getProcess2() {
		return process2;
	}
	public void setProcess2(int process2) {
		this.process2 = process2;
	}
	public int getProcess3() {
		return process3;
	}
	public void setProcess3(int process3) {
		this.process3 = process3;
	}
	public int getProcess4() {
		return process4;
	}
	public void setProcess4(int process4) {
		this.process4 = process4;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public Action_Paging getPaging() {
		return paging;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Reserve_Data getRdata() {
		return rdata;
	}
	public void setRdata(Reserve_Data rdata) {
		this.rdata = rdata;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}

}
