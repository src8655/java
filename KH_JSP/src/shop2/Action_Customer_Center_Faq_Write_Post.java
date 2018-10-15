package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Customer_Center_Faq_Write_Post extends Action_Init implements Action {

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
		
		
		int category = -1;
		String subject = "";
		String memo = "";
		
		if(request.getParameter("category") != null)
			if(!request.getParameter("category").equals(""))
				category = Integer.parseInt(request.getParameter("category"));
		if(request.getParameter("subject") != null)
			subject = request.getParameter("subject");
		if(request.getParameter("memo") != null)
			memo = request.getParameter("memo");
		

		if(category == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(subject.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('������ �Է����ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(memo.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�亯�� �Է����ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		Faq_Data_Bean fdata = new Faq_Data_Bean();
		fdata.setCategory(category);
		fdata.setSubject(subject);
		fdata.setMemo(memo);
		fdata.setDates(year+"-"+month+"-"+day);
		
		
		int res = 0;
		if(fdb.insert(fdata)) res = 1;
		
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�ۼ� �Ϸ�')");
			response.getWriter().println("location.href='customer_center_faq.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�ۼ� ����.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
	}


}
