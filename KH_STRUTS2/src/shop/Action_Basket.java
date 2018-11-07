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
	
	//edit
	int no = -1;
	int counts = -1;
	
	//delete
	//int no = -1;
	
	//add
	//int no = -1;
	//int counts = -1;
	int res = 1;
	
	@Override
	public String execute() throws Exception {
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

		
		return SUCCESS;
	}

    //�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
    public String edit() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(counts == -1) {
			msg = "������ �Է��ϼ���.";
			return ERROR;
		}
		
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.put(no, counts);
		session.setAttribute("basket", map);
		
		msg = "���� ����.";
		url = "basket.o";
		return SUCCESS;
	}
    public String delete() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.remove(no);
		session.setAttribute("basket", map);
		

		msg = "���� ����";
		url = "basket.o";
		return SUCCESS;
	}
    public String add() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(counts < 1) {
			msg = "������ �Է��ϼ���.";
			return ERROR;
		}
		
		//���� �Է�
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, counts);
			session.setAttribute("basket", map);		//no=counts ���·� ����
		}else {
			//�����Է��� �ƴҶ�
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, counts);
			session.setAttribute("basket", map);	//     //�� �����ڷ� ��
		}
		
		
		if(res == 1) {
			msg = "�߰�����";
			url = "basket.o";
			return SUCCESS;
		}
		
		if(res == 0) {
			msg = "�߰�����";
			return ERROR;
		}
		return SUCCESS;
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

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}
    
}
