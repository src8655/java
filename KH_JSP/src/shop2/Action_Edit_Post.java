package shop2;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Edit_Post extends Action_Init implements Action {

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
		
		
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		
		//1�̸� ���� 0�̸� ����
		int res = 0;
		if(ldb.update(request, session)) res = 1;
		
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���� ����.')");
			response.getWriter().println("location.href='mypage_list.o';");
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
		//return "edit_post.jsp";
	}

}
