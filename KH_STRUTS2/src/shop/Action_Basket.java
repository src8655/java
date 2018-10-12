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

public class Action_Basket extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list;
	int isEmpty = 0;		//0이면 안비어있음 1이면 비어있음
	
	//총 금액 계산
	int total_money = 0;
	int total_discount_money = 0;
	int total_ship_money = 0;
	int total_rmoney = 0;
	
	//총 금액의 통화
	String total_moneys = "";
	String total_discount_moneys = "";
	String total_ship_moneys = "";
	String total_rmoneys = "";
	
	
	@Override
	public String execute() throws IOException {
		super.run();
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		list = new ArrayList();
		

		if(session.getAttribute("basket") == null) {
			isEmpty = 1;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (int) it.next();
				//response.getWriter().println(key+"="+map.get(key)+"<br />");
				List_Data_Bean ldata = list_manager.getArticle(key);
				
				//갯수 넣고
				ldata.setBasket_cnt((int)map.get(key));
				//갯수만큼 금액변경
				ldata.setMoney(ldata.getMoney()*ldata.getBasket_cnt());
				ldata.setRmoney(ldata.getRmoney()*ldata.getBasket_cnt());
				ldata.setDiscount_money(ldata.getDiscount_money()*ldata.getBasket_cnt());
				
				//통화형식
				ldata.setRmoneys(number_format(ldata.getRmoney()));
				ldata.setMoneys(number_format(ldata.getMoney()));
				ldata.setShip_moneys(number_format(ldata.getShip_money()));
				ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
				
				
				//총 금액
				total_money += ldata.getMoney();
				total_discount_money += ldata.getDiscount_money();
				total_ship_money += ldata.getShip_money();
				total_rmoney += ldata.getRmoney()+ldata.getShip_money();
				
				list.add(ldata);
			}
		}
		
		//총 금액을 통화로 변경
		total_moneys = number_format(total_money);
		total_discount_moneys = number_format(total_discount_money);
		total_ship_moneys = number_format(total_ship_money);
		total_rmoneys = number_format(total_rmoney);

		
		return SUCCESS;
	}

    //금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

	public List getList() {
		return list;
	}

	public int getIsEmpty() {
		return isEmpty;
	}

	public int getTotal_money() {
		return total_money;
	}

	public int getTotal_discount_money() {
		return total_discount_money;
	}

	public int getTotal_ship_money() {
		return total_ship_money;
	}

	public int getTotal_rmoney() {
		return total_rmoney;
	}

	public String getTotal_moneys() {
		return total_moneys;
	}

	public String getTotal_discount_moneys() {
		return total_discount_moneys;
	}

	public String getTotal_ship_moneys() {
		return total_ship_moneys;
	}

	public String getTotal_rmoneys() {
		return total_rmoneys;
	}
    
}
