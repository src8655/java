package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Agree extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int order = Integer.parseInt(request.getParameter("order"));
		
		request.setAttribute("order", order);
		
		return "join_agree.jsp";
	}


}
