package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Customer_Center extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 해주세요.')");
			response.getWriter().println("location.href='login.o'");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		return "customer_center.tiles";
	}


}
