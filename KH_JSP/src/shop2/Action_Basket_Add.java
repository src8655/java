package shop2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Basket_Add extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		if(request.getParameter("no") == null || request.getParameter("no").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(request.getParameter("counts") == null || request.getParameter("counts").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('개수를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//no와 개수
		int no = Integer.parseInt(request.getParameter("no"));
		int counts = Integer.parseInt(request.getParameter("counts"));
		
		//최초 입력
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, counts);
			session.setAttribute("basket", map);		//no=counts 형태로 저장
		}else {
			//최초입력이 아닐때
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, counts);
			session.setAttribute("basket", map);	//     //를 구분자로 씀
		}
		
		int res = 1;
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('추가 성공.')");
			response.getWriter().println("location.href='basket.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('추가 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "basket_add.jsp";
	}

}
