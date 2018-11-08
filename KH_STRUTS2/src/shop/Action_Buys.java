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
	int isEmpty = 0;		//0�̸� �Ⱥ������ 1�̸� �������
	
	//�� �ݾ� ���
	int total_money = 0;
	int total_discount_money = 0;
	int total_ship_money = 0;
	int total_rmoney = 0;
	
	//�� �ݾ��� ��ȭ
	String total_moneys = "";
	String total_discount_moneys = "";
	String total_ship_moneys = "";
	String total_rmoneys = "";
	

	//�� �ݾ��� ��ȭ - ����Ʈ
	String total_rmoneys_point = "";
	
	//����� ����Ʈ�� ��ȭ
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
	
	//�� �ݾ� ���
	//int total_money = 0;
	//int total_discount_money = 0;
	//int total_ship_money = 0;
	//int total_rmoney = 0;
	int total_point = 0;
	
	//�� �ݾ��� ��ȭ
	//String total_moneys = "";
	//String total_discount_moneys = "";
	//String total_ship_moneys = "";
	//String total_rmoneys = "";
	String total_points = "";
	
	String totals = "";	//��ۺ�+�ݾ�

	//List list;

	String admin_bank = "";
	String admin_bank_num = "";
			
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α����� �̿����ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() == 2) {
			msg = "�Ǹ��ڴ� ������ �� �����ϴ�.";
			return ERROR;
		}
		
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		list = new ArrayList();
		isEmpty = 0;		//0�̸� �Ⱥ������ 1�̸� �������
		
		//�� �ݾ� ���
		total_money = 0;
		total_discount_money = 0;
		total_ship_money = 0;
		total_rmoney = 0;
		
		//�� �ݾ��� ��ȭ
		total_moneys = "";
		total_discount_moneys = "";
		total_ship_moneys = "";
		total_rmoneys = "";
		

		//�� �ݾ��� ��ȭ - ����Ʈ
		total_rmoneys_point = "";
		
		//����� ����Ʈ�� ��ȭ
		member_points = number_format(member_info.getPoint());
		

		//order �� 1�̸� �Ϲݱ���, 2�� ��ٱ��ϱ��� 3�̸� ��ٱ��Ͽ��� �Ϲݱ���
		if(order == 1 || order == 3) {
			List_Data_Bean ldata = list_manager.getArticle_M(no);
			
			//���� �ְ�
			ldata.setBasket_cnt(counts);
			//������ŭ �ݾ׺���
			ldata.setMoney(ldata.getMoney()*ldata.getBasket_cnt());
			ldata.setRmoney(ldata.getRmoney()*ldata.getBasket_cnt());
			ldata.setDiscount_money(ldata.getDiscount_money()*ldata.getBasket_cnt());
			
			//��ȭ����
			ldata.setRmoneys(number_format(ldata.getRmoney()));
			ldata.setMoneys(number_format(ldata.getMoney()));
			ldata.setShip_moneys(number_format(ldata.getShip_money()));
			ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
			
			
			//�� �ݾ�
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
				
				//���� �ְ�
				ldata.setBasket_cnt((int)map.get(key));
				//������ŭ �ݾ׺���
				ldata.setMoney(ldata.getMoney()*ldata.getBasket_cnt());
				ldata.setRmoney(ldata.getRmoney()*ldata.getBasket_cnt());
				ldata.setDiscount_money(ldata.getDiscount_money()*ldata.getBasket_cnt());
				
				//��ȭ����
				ldata.setRmoneys(number_format(ldata.getRmoney()));
				ldata.setMoneys(number_format(ldata.getMoney()));
				ldata.setShip_moneys(number_format(ldata.getShip_money()));
				ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
				
				
				//�� �ݾ�
				total_money += ldata.getMoney();
				total_discount_money += ldata.getDiscount_money();
				total_ship_money += ldata.getShip_money();
				total_rmoney += ldata.getRmoney()+ldata.getShip_money();
				
				list.add(ldata);
			}
		}
		
		//�� �ݾ��� ��ȭ�� ����
		total_moneys = number_format(total_money);
		total_discount_moneys = number_format(total_discount_money);
		total_ship_moneys = number_format(total_ship_money);
		total_rmoneys = number_format(total_rmoney);
		

		//�� �ݾ��� ��ȭ�� ���� - ����Ʈ
		total_rmoneys_point = number_format(total_rmoney - member_info.getPoint());
		
		
		
		//���ǿ� �����ؼ� ���ԿϷ�â���� ����
		session.setAttribute("list", list);
		
		return SUCCESS;
	}
	public String post() throws Exception {
		super.run();
		
		if(name.equals("")) {
			msg = "�̸��� �Է��ϼ���.";
			return ERROR;
		}
		if(zipcode.equals("")) {
			msg = "�����ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(addr.equals("")) {
			msg = "�ּҸ� �Է��ϼ���.";
			return ERROR;
		}
		if(phone1.equals("")) {
			msg = "��ȭ��ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(phone2.equals("")) {
			msg = "��ȭ��ȣ�� �Է��ϼ���.";
			return ERROR;
		}
		if(phone3.equals("")) {
			msg = "��ȭ��ȣ�� �Է��ϼ���.";
			return ERROR;
		}

		
		
		//����Ʈ��� ����
		if(point_num != 0) {
			total_point = point_num;
			
			//����Ʈ�� �����ϸ� �߸��� ����
			if(member_info.getPoint() < point_num) {
				msg = "����Ʈ�� �����մϴ�.";
				return ERROR;
			}
			//����Ʈ�� �ʱ�ȭ
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint(member_info.getNo(), member_info.getPoint() - point_num);
		}
				
		
		
		
		
		list = (List)session.getAttribute("list");
		
		//�ѱݾ� ���ϴºκ�
		for(int i=0;i<list.size();i++) {
			List_Data_Bean ldata = (List_Data_Bean)list.get(i);
			
			//�� �ݾ�
			total_money += ldata.getMoney();
			total_discount_money += ldata.getDiscount_money();
			total_ship_money += ldata.getShip_money();
			total_rmoney += ldata.getRmoney();
		}
		
		
		
		
		
		
		/////////////////
		//������� �����κ�
		/////////////////
		admin_bank = "����";
		admin_bank_num = "";
		Random rand = new Random();
		int tmp1 = rand.nextInt(90000)+10000;
		int tmp2 = rand.nextInt(90)+10;
		int tmp3 = rand.nextInt(9000000)+10000000;
		admin_bank_num = tmp1+"-"+tmp2+"-"+tmp3;
		
		
		
		
		
		
		
		
		
		//�׷��� ���� ����� db�� �Է�
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
		//������ �� ����
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
			//�׷�� ���� ������ �� ����
			sdata.setTimes(sgdata.getTimes());
			
			
			sdb.insert_M(sdata);
			
			//��ٱ��� �ϳ� ���Ž�
			if(order == 3) {
				HashMap map = (HashMap)session.getAttribute("basket");
				map.remove(sdata.getProduct_no());
				session.setAttribute("basket", map);
			}
		}
		
		//�� �ݾ��� ��ȭ�� ����
		total_moneys = number_format(total_money);
		total_discount_moneys = number_format(total_discount_money);
		total_ship_moneys = number_format(total_ship_money);
		total_rmoneys = number_format(total_rmoney);
		total_points = number_format(total_point);
		totals = number_format(total_ship_money+total_rmoney-total_point);
		
		//��ٱ��� ���Ž�
		if(order == 2) session.setAttribute("basket", null);
		
		
		return SUCCESS;
	}
    //�ݾ� ���·� �ٲٱ�
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
