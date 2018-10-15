package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Sell_Post extends Action_Init implements Action {

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
		if(member_info.getOrders() != 2) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		//분류(-1 이면 모두보기(배송완료는 제외))
				String cate = "-1";
				if(request.getParameter("cate") != null)
					if(!request.getParameter("cate").equals(""))
						cate = request.getParameter("cate");
		

		//상태변경
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		int res = 0;
		
		//입금완료(2)상태이면
		if(status == 2) {
			if(sdb.changeStatus(no, 3)) res = 1;
		}
		//배송준비중(3)상태이면
		if(status == 3) {
			String ship_num = "";
			if(request.getParameter("ship_num") != null)
				if(!request.getParameter("ship_num").equals(""))
					ship_num = request.getParameter("ship_num");
			
			//운송장번호가 없으면 취소
			if(ship_num.equals("")) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('운송장번호를 입력해주세요.')");
				response.getWriter().println("history.go(-1)");
				response.getWriter().println("</script>");
				
				return null;
			}
			if(sdb.changeShipStatus(no, ship_num)) res = 1;
		}
		

		request.setAttribute("cate", cate);
		request.setAttribute("res", res);
		
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('수정 완료.')");
			response.getWriter().println("location.href='mypage_sell.o?pages="+pages+"&cate="+cate+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('수정 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		
		
		//return "mypage_sell_post.jsp";
	}


}
