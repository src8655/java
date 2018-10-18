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

public class Action_Mypage_Guest_View extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	String times = "";
	Sell_Group_Data_Bean sgdata;
	List list;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		sgdata = sgdb.getArticle_M(times);
			

		//금액형태로 바꾸기
		sgdata.setMoneys(number_format(sgdata.getMoney()));
		sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
		sgdata.setRmoneys(number_format(sgdata.getRmoney()));
		sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
		sgdata.setPoints(number_format(sgdata.getPoint()));
		
		
		//내용부분
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		list = sdb.getArticles3_M(sgdata.getTimes());
		
		//중복된것 카운트
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//새로운게 나오면 같은 그룹의 개수만큼 rowspan값을 지정
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count(sdata.getTimes()));
			tmp = sdata.getTimes();
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		return SUCCESS;
	}

	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public Sell_Group_Data_Bean getSgdata() {
		return sgdata;
	}

	public void setSgdata(Sell_Group_Data_Bean sgdata) {
		this.sgdata = sgdata;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

}
