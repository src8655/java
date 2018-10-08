package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Guest_Post1 extends Action_Init implements Action {

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
		
		int no = Integer.parseInt(request.getParameter("no"));

		Sell_DB_Bean sgdb = Sell_DB_Bean.getInstance();
		
		//내꺼인지 확인
		Sell_Data_Bean sdata = sgdb.getArticle(no);
		
		//내꺼가아니면
		if(member_info.getNo() != sdata.getGuest_no()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		//상태를 배송완료로 설정
		int res = 0;
		if(sgdb.changeStatus(no, 5)) {
			res = 1;
			
			//구매확정 완료 후 에는 해당 제품에 구매 카운트를 추가함
			List_DB_Bean ldb = List_DB_Bean.getInstance();
			ldb.addBuy(sdata.getProduct_no());
			
			//구매확정시 회원 포인트를 구매금액의 3% 적립
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint(member_info.getNo(), member_info.getPoint() + (int)(((double)sdata.getRmoney())*(3.0/100.0)));
		}
		
		
		request.setAttribute("res", res);
		
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('구매확정 성공.')");
			response.getWriter().println("location.href='mypage_guest.o?pages="+pages+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('구매확정 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "mypage_guest_post1.jsp";
	}


}
