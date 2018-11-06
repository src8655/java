package tour;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.*;

public class Action_Reserve extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int no = -1;
	List_Reserve_Data lrdata;
	
	//post
	//int no = -1;
	//List_Reserve_Data lrdata;
	Reserve_Data rdata;
	String bank = "";
	String bank_num = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		
		if(level != 2) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		
		if(session.getAttribute("basket") == null) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		HashMap map = (HashMap)session.getAttribute("basket");
				
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		lrdata = (List_Reserve_Data) sqlmap.queryForObject("List_Reserve_getArticle", no);

		//갯수 넣고
		lrdata.setChoice_cnts((int)map.get(no));
				
		//갯수만큼 금액변경
		lrdata.setMoney(lrdata.getMoney()*lrdata.getChoice_cnts());
		lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));
		
		return SUCCESS;
	}
	public String post() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		if(level != 2) {
			msg = "로그인해주세요.";
			url = "login.o";
			return LOGIN;
		}
		
		if(session.getAttribute("basket") == null) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		HashMap map = (HashMap)session.getAttribute("basket");
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		lrdata = (List_Reserve_Data) sqlmap.queryForObject("List_Reserve_getArticle", no);

		//갯수 넣고
		lrdata.setChoice_cnts((int)map.get(no));
				
		//갯수만큼 금액변경
		lrdata.setMoney(lrdata.getMoney()*lrdata.getChoice_cnts());
		lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));
		
		
		
		
		/////////////////
		//가상계좌 생성부분
		/////////////////
		bank = "농협";
		bank_num = "";
		Random rand = new Random();
		int tmp1 = rand.nextInt(90000)+10000;
		int tmp2 = rand.nextInt(90)+10;
		int tmp3 = rand.nextInt(9000000)+10000000;
		bank_num = tmp1+"-"+tmp2+"-"+tmp3;
		
		
		
		
		rdata = new Reserve_Data();
		rdata.setList_no(lrdata.getList_no());
		rdata.setList_reserve_no(lrdata.getNo());
		rdata.setMoney(lrdata.getMoney());
		rdata.setMoneys(lrdata.getMoneys());
		rdata.setCnts(lrdata.getChoice_cnts());
		rdata.setStatus(1);
		rdata.setMember_no(member_info.getNo());
		rdata.setDates(year+"-"+month+"-"+day);
		rdata.setBank(bank);
		rdata.setBank_num(bank_num);
		
		
		sqlmap.insert("Reserve_insert",rdata);
		Map maps = new HashMap();
		maps.put("no", lrdata.getNo());
		maps.put("isreserve", 1);
		sqlmap.update("List_Reserve_setIsreserve", maps);
		
		//장바구니에서 삭제
		map.remove(lrdata.getNo());
		session.setAttribute("basket", map);
		
		

		
		
		
		return SUCCESS;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public List_Reserve_Data getLrdata() {
		return lrdata;
	}

	public void setLrdata(List_Reserve_Data lrdata) {
		this.lrdata = lrdata;
	}

	public Reserve_Data getRdata() {
		return rdata;
	}

	public void setRdata(Reserve_Data rdata) {
		this.rdata = rdata;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBank_num() {
		return bank_num;
	}

	public void setBank_num(String bank_num) {
		this.bank_num = bank_num;
	}
    
}
