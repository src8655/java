package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�α��� ���ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 2) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		return "mypage.jsp";
	}


}
