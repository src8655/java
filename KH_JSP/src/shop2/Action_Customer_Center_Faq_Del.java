package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Customer_Center_Faq_Del extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		//���������� �ƴ��� Ȯ��
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�α��� ���ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 3) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		

		int no = -1;
		int category = -1;

		if(request.getParameter("no") != null)
			if(!request.getParameter("no").equals(""))
				no = Integer.parseInt(request.getParameter("no"));
		if(request.getParameter("category") != null)
			if(!request.getParameter("category").equals(""))
				category = Integer.parseInt(request.getParameter("category"));
		

		if(no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		
		
		int res = 0;
		if(fdb.delete(no)) res = 1;
		
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� �Ϸ�')");
			response.getWriter().println("location.href='customer_center_faq.o?pages="+pages+"&category="+category+"&p_search="+p_search+"&p_search_value="+p_search_values+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� ����.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
	}


}
