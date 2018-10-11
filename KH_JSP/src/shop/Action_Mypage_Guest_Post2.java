package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Guest_Post2 extends Action_Init implements Action {

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

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		//내꺼인지 확인
		Sell_Data_Bean sdata = sdb.getArticle(no);
		
		//내꺼가아니면
		if(member_info.getNo() != sdata.getGuest_no()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		//상태가 입금대기중이 아니면
		if(sdata.getStatus() != 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('입금대기중 상태에서만 취소가 가능합니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		//포인트 적용된 그룹인지 아닌지 확인
		Sell_Group_DB_Bean sgdb = Sell_Group_DB_Bean.getInstance();
		Sell_Group_Data_Bean sgdata = sgdb.getArticle(sdata.getTimes());
		if(sgdata.getPoint() != 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('적용된 포인트가 취소됩니다.')");
			response.getWriter().println("</script>");
			
			//포인트 돌려주기
			Member_DB_Bean mdb = Member_DB_Bean.getInstance();
			mdb.setPoint(member_info.getNo(), member_info.getPoint() + sgdata.getPoint());
			sgdb.setPoint(sgdata.getNo(), 0);
		}
		
		
		//
		int res = 0;
		if(sdb.delete(sdata)) {
			res = 1;
		}
		
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('취소 성공.')");
			response.getWriter().println("location.href='mypage_guest.o?pages="+pages+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('취소 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "mypage_guest_post2.jsp";
	}


}
