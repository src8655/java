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

public class Action_Buys extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	int order = -1;
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
	

	//총 금액의 통화 - 포인트
	String total_rmoneys_point = "";
	
	//멤버의 포인트의 통화
	String member_points = "";
	
	int no = -1;
	int counts = -1;
			
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "로그인후 이용해주세요.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() == 2) {
			msg = "판매자는 구입할 수 없습니다.";
			return ERROR;
		}
		
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		list = new ArrayList();
		isEmpty = 0;		//0이면 안비어있음 1이면 비어있음
		
		//총 금액 계산
		total_money = 0;
		total_discount_money = 0;
		total_ship_money = 0;
		total_rmoney = 0;
		
		//총 금액의 통화
		total_moneys = "";
		total_discount_moneys = "";
		total_ship_moneys = "";
		total_rmoneys = "";
		

		//총 금액의 통화 - 포인트
		total_rmoneys_point = "";
		
		//멤버의 포인트의 통화
		member_points = number_format(member_info.getPoint());
		

		//order 가 1이면 일반구입, 2면 장바구니구입 3이면 장바구니에서 일반구입
		if(order == 1 || order == 3) {
			List_Data_Bean ldata = list_manager.getArticle_M(no);
			
			//갯수 넣고
			ldata.setBasket_cnt(counts);
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
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (int) it.next();
				List_Data_Bean ldata = list_manager.getArticle_M(key);
				
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
		

		//총 금액을 통화로 변경 - 포인트
		total_rmoneys_point = number_format(total_rmoney - member_info.getPoint());
		
		
		
		//세션에 저장해서 구입완료창으로 전달
		session.setAttribute("list", list);
		
		return SUCCESS;
	}

    //금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(int isEmpty) {
		this.isEmpty = isEmpty;
	}

	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}

	public int getTotal_discount_money() {
		return total_discount_money;
	}

	public void setTotal_discount_money(int total_discount_money) {
		this.total_discount_money = total_discount_money;
	}

	public int getTotal_ship_money() {
		return total_ship_money;
	}

	public void setTotal_ship_money(int total_ship_money) {
		this.total_ship_money = total_ship_money;
	}

	public int getTotal_rmoney() {
		return total_rmoney;
	}

	public void setTotal_rmoney(int total_rmoney) {
		this.total_rmoney = total_rmoney;
	}

	public String getTotal_moneys() {
		return total_moneys;
	}

	public void setTotal_moneys(String total_moneys) {
		this.total_moneys = total_moneys;
	}

	public String getTotal_discount_moneys() {
		return total_discount_moneys;
	}

	public void setTotal_discount_moneys(String total_discount_moneys) {
		this.total_discount_moneys = total_discount_moneys;
	}

	public String getTotal_ship_moneys() {
		return total_ship_moneys;
	}

	public void setTotal_ship_moneys(String total_ship_moneys) {
		this.total_ship_moneys = total_ship_moneys;
	}

	public String getTotal_rmoneys() {
		return total_rmoneys;
	}

	public void setTotal_rmoneys(String total_rmoneys) {
		this.total_rmoneys = total_rmoneys;
	}

	public String getTotal_rmoneys_point() {
		return total_rmoneys_point;
	}

	public void setTotal_rmoneys_point(String total_rmoneys_point) {
		this.total_rmoneys_point = total_rmoneys_point;
	}

	public String getMember_points() {
		return member_points;
	}

	public void setMember_points(String member_points) {
		this.member_points = member_points;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

}
