package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Logout extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		session.setAttribute("user_id", null);
		session.setAttribute("user_pw", null);
		
		return "logout.jsp";
	}

}
