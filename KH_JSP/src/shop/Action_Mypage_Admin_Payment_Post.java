package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Admin_Payment_Post extends Action_Init implements Action {

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
		if(member_info.getOrders() != 3) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		String times = request.getParameter("times");
		
		
		//상태를 입금완료로 설정
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		
		int res = 0;
		if(sgdb.changeStatus(times, 2)) res = 1;
		
		
		request.setAttribute("res", res);
		
		
		return "mypage_admin_payment_post.jsp";
	}


}
