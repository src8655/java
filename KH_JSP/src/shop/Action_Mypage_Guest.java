package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Guest extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		List list = sdb.getArticles(member_info.getNo());
		
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
		
		request.setAttribute("list", list);
		
		return "mypage_guest.jsp";
	}

	//금액 형태로 바꾸기
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

}
