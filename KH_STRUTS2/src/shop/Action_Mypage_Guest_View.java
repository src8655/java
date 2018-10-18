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
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		sgdata = sgdb.getArticle_M(times);
			

		//�ݾ����·� �ٲٱ�
		sgdata.setMoneys(number_format(sgdata.getMoney()));
		sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
		sgdata.setRmoneys(number_format(sgdata.getRmoney()));
		sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
		sgdata.setPoints(number_format(sgdata.getPoint()));
		
		
		//����κ�
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		list = sdb.getArticles3_M(sgdata.getTimes());
		
		//�ߺ��Ȱ� ī��Ʈ
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//���ο�� ������ ���� �׷��� ������ŭ rowspan���� ����
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count(sdata.getTimes()));
			tmp = sdata.getTimes();
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		return SUCCESS;
	}

	//�ݾ� ���·� �ٲٱ�
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
