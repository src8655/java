package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Guest_Post1 extends Action_Init implements Action {

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
		if(member_info.getOrders() != 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		int no = Integer.parseInt(request.getParameter("no"));

		Sell_DB_Bean sgdb = Sell_DB_Bean.getInstance();
		
		//�������� Ȯ��
		Sell_Data_Bean sdata = sgdb.getArticle(no);
		
		//�������ƴϸ�
		if(member_info.getNo() != sdata.getGuest_no()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		//���¸� ��ۿϷ�� ����
		int res = 0;
		if(sgdb.changeStatus(no, 5)) res = 1;
		
		
		request.setAttribute("res", res);
		
		
		return "mypage_guest_post1.jsp";
	}


}
