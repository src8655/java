package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login_Find_Pw extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String user_id = "";
		String name = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";
		
		if(request.getParameter("user_id") != null)
			user_id = request.getParameter("user_id");
		if(request.getParameter("name") != null)
			name = request.getParameter("name");
		if(request.getParameter("phone1") != null)
			phone1 = request.getParameter("phone1");
		if(request.getParameter("phone2") != null)
			phone2 = request.getParameter("phone2");
		if(request.getParameter("phone3") != null)
			phone3 = request.getParameter("phone3");
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("name", name);
		request.setAttribute("phone1", phone1);
		request.setAttribute("phone2", phone2);
		request.setAttribute("phone3", phone3);
		
		
		return "login_find_pw.tiles";
	}

}
