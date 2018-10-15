package shop2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Logout extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		
		response.getWriter().println("<script>");
		response.getWriter().println("alert('로그아웃 성공.')");
		response.getWriter().println("location.href='index.o';");
		response.getWriter().println("</script>");
		return null;
		//return "logout.jsp";
	}

}
