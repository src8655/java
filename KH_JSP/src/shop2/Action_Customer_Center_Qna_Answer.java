package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Customer_Center_Qna_Answer extends Action_Init implements Action {

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
		
		
		int no = -1;
		String answer = "";
		
		if(request.getParameter("no") != null)
			if(!request.getParameter("no").equals(""))
				no = Integer.parseInt(request.getParameter("no"));
		if(request.getParameter("answer") != null)
			answer = request.getParameter("answer");
		

		if(no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(answer.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���Ǵ亯�� �Է����ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		Qna_DB_Bean qdb = Qna_DB_Bean.getInstance();
		Qna_Data_Bean qdata = new Qna_Data_Bean();
		qdata.setNo(no);
		qdata.setIsanswer(1);
		qdata.setAnswer(answer);
		
		
		int res = 0;
		if(qdb.answer(qdata)) res = 1;
		
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�亯�ۼ� �Ϸ�')");
			response.getWriter().println("location.href='customer_center_qna_view.o?no="+no+"&pages="+pages+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�亯�ۼ� ����.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
	}


}
