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
	
	
	
	
	
	
	
	
	//post
	//int order = -1;
	int point_num = 0;
	
	String name = "";
	String zipcode = "";
	String addr = "";
	String phone1 = "";
	String phone2 = "";
	String phone3 = "";
	String ship_memo = "";
	
	//총 금액 계산
	//int total_money = 0;
	//int total_discount_money = 0;
	//int total_ship_money = 0;
	//int total_rmoney = 0;
	int total_point = 0;
	
	//총 금액의 통화
	//String total_moneys = "";
	//String total_discount_moneys = "";
	//String total_ship_moneys = "";
	//String total_rmoneys = "";
	String total_points = "";
	
	String totals = "";	//배송비+금액

	//List list;

	String admin_bank = "";
	String admin_bank_num = "";
			
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
	public String post() throws Exception {
		super.run();
		
		if(name.equals("")) {
			msg = "이름을 입력하세요.";
			return ERROR;
		}
		if(zipcode.equals("")) {
			msg = "우편번호를 입력하세요.";
			return ERROR;
		}
		if(addr.equals("")) {
			msg = "주소를 입력하세요.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "전화번호를 입력하세요.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "전화번호를 입력하세요.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "전화번호를 입력하세요.";
			return ERROR;
		}

		
		
		//포인트사용 적용
		if(point_num != 0) {
			total_point = point_num;
			
			//포인트가 부족하면 잘못된 접근
			if(member_info.getPoint() < point_num) {
				msg = "포인트가 부족합니다.";
				return ERROR;
			}
			//포인트를 초기화
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint(member_info.getNo(), member_info.getPoint() - point_num);
		}
				
		
		
		
		
		list = (List)session.getAttribute("list");
		
		//총금액 구하는부분
		for(int i=0;i<list.size();i++) {
			List_Data_Bean ldata = (List_Data_Bean)list.get(i);
			
			//총 금액
			total_money += ldata.getMoney();
			total_discount_money += ldata.getDiscount_money();
			total_ship_money += ldata.getShip_money();
			total_rmoney += ldata.getRmoney();
		}
		
		
		
		
		
		
		/////////////////
		//가상계좌 생성부분
		/////////////////
		admin_bank = "농협";
		admin_bank_num = "";
		Random rand = new Random();
		int tmp1 = rand.nextInt(90000)+10000;
		int tmp2 = rand.nextInt(90)+10;
		int tmp3 = rand.nextInt(9000000)+10000000;
		admin_bank_num = tmp1+"-"+tmp2+"-"+tmp3;
		
		
		
		
		
		
		
		
		
		//그룹을 먼저 만들어 db에 입력
		Sell_Group_Data_Bean sgdata = new Sell_Group_Data_Bean();
		sgdata.setMoney(total_money);
		sgdata.setShip_money(total_ship_money);
		sgdata.setRmoney(total_rmoney);
		sgdata.setBank(admin_bank);
		sgdata.setBank_num(admin_bank_num);
		sgdata.setName(name);
		sgdata.setZipcode(zipcode);
		sgdata.setAddr(addr);
		sgdata.setPhone1(phone1);
		sgdata.setPhone2(phone2);
		sgdata.setPhone3(phone3);
		sgdata.setShip_memo(ship_memo);
		sgdata.setDates(year+"-"+month+"-"+day);
		//유일한 값 생성
		sgdata.setTimes(cal.getTimeInMillis()+"slsl"+member_info.getNo());
		sgdata.setGuest_no(member_info.getNo());
		sgdata.setStatus(1);
		sgdata.setPoint(total_point);
		
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		sgdb.insert_M(sgdata);

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		for(int i=0;i<list.size();i++) {
			List_Data_Bean ldata = (List_Data_Bean)list.get(i);
			Sell_Data_Bean sdata = new Sell_Data_Bean();
			sdata.setGuest_no(member_info.getNo());
			sdata.setSellers_no(ldata.getSellers());
			sdata.setProduct_no(ldata.getNo());
			sdata.setProduct_name(ldata.getName());
			sdata.setCounts(ldata.getBasket_cnt());
			sdata.setMoney(ldata.getMoney());
			sdata.setShip_money(ldata.getShip_money());
			sdata.setRmoney(ldata.getRmoney());
			sdata.setDates(year+"-"+month+"-"+day);
			sdata.setShip_company(ldata.getShip_company());
			sdata.setStatus(1);
			sdata.setAddr(addr);
			sdata.setZipcode(zipcode);
			sdata.setShip_memo(ship_memo);
			sdata.setName(name);
			sdata.setPhone1(phone1);
			sdata.setPhone2(phone2);
			sdata.setPhone3(phone3);
			sdata.setFile1(ldata.getFile1());
			//그룹과 같은 유일한 값 저장
			sdata.setTimes(sgdata.getTimes());
			
			
			sdb.insert_M(sdata);
			
			//장바구니 하나 구매시
			if(order == 3) {
				HashMap map = (HashMap)session.getAttribute("basket");
				map.remove(sdata.getProduct_no());
				session.setAttribute("basket", map);
			}
		}
		
		//총 금액을 통화로 변경
		total_moneys = number_format(total_money);
		total_discount_moneys = number_format(total_discount_money);
		total_ship_moneys = number_format(total_ship_money);
		total_rmoneys = number_format(total_rmoney);
		total_points = number_format(total_point);
		totals = number_format(total_ship_money+total_rmoney-total_point);
		
		//장바구니 구매시
		if(order == 2) session.setAttribute("basket", null);
		
		
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
	public int getPoint_num() {
		return point_num;
	}
	public void setPoint_num(int point_num) {
		this.point_num = point_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getShip_memo() {
		return ship_memo;
	}
	public void setShip_memo(String ship_memo) {
		this.ship_memo = ship_memo;
	}
	public int getTotal_point() {
		return total_point;
	}
	public void setTotal_point(int total_point) {
		this.total_point = total_point;
	}
	public String getTotal_points() {
		return total_points;
	}
	public void setTotal_points(String total_points) {
		this.total_points = total_points;
	}
	public String getTotals() {
		return totals;
	}
	public void setTotals(String totals) {
		this.totals = totals;
	}
	public String getAdmin_bank() {
		return admin_bank;
	}
	public void setAdmin_bank(String admin_bank) {
		this.admin_bank = admin_bank;
	}
	public String getAdmin_bank_num() {
		return admin_bank_num;
	}
	public void setAdmin_bank_num(String admin_bank_num) {
		this.admin_bank_num = admin_bank_num;
	}

}
