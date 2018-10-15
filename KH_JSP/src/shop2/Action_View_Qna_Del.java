package shop2;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Qna_Del extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int product_no = -1;
		int no = -1;
		
		if(request.getParameter("product_no") != null)
			product_no = Integer.parseInt(request.getParameter("product_no"));
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		
		//ȸ������
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

		//�߸��� ���� ����
		if(product_no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		View_Qna_Data_Bean vqdata = vqdb.getArticle(no);
		
		//�� ȸ����ȣ�ϰ� �Խñ��� ȸ����ȣ�ϰ� �ٸ���
		if(vqdata.getGuest_no() != member_info.getNo()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		
		//����
		int res = 0;
		if(vqdb.delete(no)) res = 1;
		
		request.setAttribute("res", res);
		request.setAttribute("no", product_no);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� ����.')");
			response.getWriter().println("location.href='view.o?no="+product_no+"&tab=3&pages="+pages+"';");
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
		//return "view_qna_del.jsp";
	}

}
