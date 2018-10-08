package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Buys_Post extends Action_Init implements Action {
	

	@Override
	public String execute() throws ServletException, IOException {
		
		int order = Integer.parseInt(request.getParameter("order"));
		int point_num = 0;


		if(request.getParameter("point_num") != null)
			if(!request.getParameter("point_num").equals("")) {
				try {
				point_num = Integer.parseInt(request.getParameter("point_num"));
				}catch (Exception e) {
					response.getWriter().println("<script>");
					response.getWriter().println("alert('���ڸ� �Է��� �ּ���.')");
					response.getWriter().println("history.go(-1)");
					response.getWriter().println("</script>");
					
					return null;
				}
			}
		
		
		String name = request.getParameter("name");
		String zipcode = request.getParameter("zipcode");
		String addr = request.getParameter("addr");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String ship_memo = request.getParameter("ship_memo");
		
		if(name.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�̸��� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(zipcode.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�����ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(addr.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�ּҸ� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone1.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ȭ��ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ȭ��ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone3.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ȭ��ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		
		
		//�� �ݾ� ���
		int total_money = 0;
		int total_discount_money = 0;
		int total_ship_money = 0;
		int total_rmoney = 0;
		int total_point = 0;
		
		//����Ʈ��� ����
		if(point_num != 0) {
			total_point = point_num;
			
			//����Ʈ�� �����ϸ� �߸��� ����
			if(member_info.getPoint() < point_num) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('����Ʈ�� �����մϴ�.')");
				response.getWriter().println("history.go(-1)");
				response.getWriter().println("</script>");
				
				return null;
			}
			//����Ʈ�� �ʱ�ȭ
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint(member_info.getNo(), member_info.getPoint() - point_num);
		}
				
		//�� �ݾ��� ��ȭ
		String total_moneys = "";
		String total_discount_moneys = "";
		String total_ship_moneys = "";
		String total_rmoneys = "";
		String total_points = "";
		
		String totals = "";	//��ۺ�+�ݾ�
		
		
		
		
		List list = (List)session.getAttribute("list");
		
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
		String admin_bank = "����";
		String admin_bank_num = "";
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
		sgdb.insert(sgdata);

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		for(int i=0;i<list.size();i++) {
			List_Data_Bean ldata = (List_Data_Bean)list.get(i);
			Sell_Data_Bean sdata = new Sell_Data_Bean();
			sdata.setGuest_no(member_info.getNo());
			sdata.setSellers_no(ldata.getSeller());
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
			
			
			sdb.insert(sdata);
			
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
		

		int res = 1;

		request.setAttribute("admin_bank", admin_bank);
		request.setAttribute("admin_bank_num", admin_bank_num);
		request.setAttribute("total_rmoneys", total_rmoneys);
		request.setAttribute("totals", totals);
		request.setAttribute("res", res);
		
		
		//��ٱ��� ���Ž�
		if(order == 2) session.setAttribute("basket", null);
		
		
		return "buys_post.tiles";
	}
	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

}
