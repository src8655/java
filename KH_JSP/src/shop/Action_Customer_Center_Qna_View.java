package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Customer_Center_Qna_View extends Action_Init implements Action {

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
		
		int no = -1;
		if(request.getParameter("no") != null)
			if(!request.getParameter("no").equals(""))
				no = Integer.parseInt(request.getParameter("no"));
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		Qna_Data_Bean qdata = qdb.getArticle(no);
		
		//�����ڵ��ƴѵ�
		if(member_info.getOrders() != 3)
			if(qdata.getGuest_no() != member_info.getNo()) {
				//�� �ڷᰡ �ƴѰ� ���� �ȵ�
				
				response.getWriter().println("<script>");
				response.getWriter().println("alert('�߸��� �����Դϴ�.')");
				response.getWriter().println("history.go(-1)");
				response.getWriter().println("</script>");
				
				return null;
			}
		
		
		request.setAttribute("qdata", qdata);
		
		
		return "customer_center_qna_view.tiles";
	}


}
