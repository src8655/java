package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Sell_Post extends Action_Init implements Action {

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
		
		int no = Integer.parseInt(request.getParameter("no"));
		int status = Integer.parseInt(request.getParameter("status"));
		
		//�з�(-1 �̸� ��κ���(��ۿϷ�� ����))
				String cate = "-1";
				if(request.getParameter("cate") != null)
					if(!request.getParameter("cate").equals(""))
						cate = request.getParameter("cate");
		

		//���º���
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		int res = 0;
		
		//�ԱݿϷ�(2)�����̸�
		if(status == 2) {
			if(sdb.changeStatus(no, 3)) res = 1;
		}
		//����غ���(3)�����̸�
		if(status == 3) {
			String ship_num = "";
			if(request.getParameter("ship_num") != null)
				if(!request.getParameter("ship_num").equals(""))
					ship_num = request.getParameter("ship_num");
			
			//������ȣ�� ������ ���
			if(ship_num.equals("")) {
				response.getWriter().println("<script>");
				response.getWriter().println("alert('������ȣ�� �Է����ּ���.')");
				response.getWriter().println("history.go(-1)");
				response.getWriter().println("</script>");
				
				return null;
			}
			if(sdb.changeShipStatus(no, ship_num)) res = 1;
		}
		

		request.setAttribute("cate", cate);
		request.setAttribute("res", res);
		
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� �Ϸ�.')");
			response.getWriter().println("location.href='mypage_sell.o?pages="+pages+"&cate="+cate+"';");
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
		
		
		//return "mypage_sell_post.jsp";
	}


}
