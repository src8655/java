package shop;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Basket_Add extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		if(request.getParameter("no") == null || request.getParameter("no").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(request.getParameter("counts") == null || request.getParameter("counts").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('������ �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//no�� ����
		int no = Integer.parseInt(request.getParameter("no"));
		int counts = Integer.parseInt(request.getParameter("counts"));
		
		//���� �Է�
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, counts);
			session.setAttribute("basket", map);		//no=counts ���·� ����
		}else {
			//�����Է��� �ƴҶ�
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, counts);
			session.setAttribute("basket", map);	//     //�� �����ڷ� ��
		}
		
		return "basket_add.jsp";
	}

}
