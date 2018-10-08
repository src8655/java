package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Buys extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		int order = Integer.parseInt(request.getParameter("order"));
		
		
		
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인후 이용해주세요.')");
			response.getWriter().println("location.href='login.o'");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() == 2) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('판매자는 구입할 수 없습니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		List list = new ArrayList();
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
		String member_points = number_format(member_info.getPoint());
		

		//order 가 1이면 일반구입, 2면 장바구니구입 3이면 장바구니에서 일반구입
		if(order == 1 || order == 3) {
			int no = Integer.parseInt(request.getParameter("no"));
			int counts = Integer.parseInt(request.getParameter("counts"));
			List_Data_Bean ldata = list_manager.getArticle(no);
			
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
		

		//총 금액을 통화로 변경 - 포인트
		total_rmoneys_point = number_format(total_rmoney - member_info.getPoint());

		request.setAttribute("isEmpty", isEmpty);
		request.setAttribute("list", list);
		
		//세션에 저장해서 구입완료창으로 전달
		session.setAttribute("list", list);
		

		request.setAttribute("member_points", member_points);
		request.setAttribute("total_rmoneys_point", total_rmoneys_point);
		

		request.setAttribute("total_moneys", total_moneys);
		request.setAttribute("total_discount_moneys", total_discount_moneys);
		request.setAttribute("total_ship_moneys", total_ship_moneys);
		request.setAttribute("total_rmoneys", total_rmoneys);
		request.setAttribute("total_rmoney", total_rmoney);

		request.setAttribute("order", order);
		
		return "buys.tiles";
	}

    //금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

}
