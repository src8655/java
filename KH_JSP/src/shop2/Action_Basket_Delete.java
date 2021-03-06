package shop2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Basket_Delete extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		if(request.getParameter("no") == null || request.getParameter("no").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		HashMap map = (HashMap)session.getAttribute("basket");
		map.remove(no);
		session.setAttribute("basket", map);
		
		
		int res = 1;
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('삭제 성공.')");
			response.getWriter().println("location.href='basket.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('삭제 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "basket_delete.jsp";
	}

}
