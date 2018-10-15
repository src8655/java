package shop2;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Qna_Answer_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int product_no = -1;
		int no = -1;
		String memo = "";
		
		if(request.getParameter("product_no") != null)
			product_no = Integer.parseInt(request.getParameter("product_no"));
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		if(request.getParameter("memo") != null)
			memo = request.getParameter("memo");
		
		//ȸ������
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
		View_Qna_Data_Bean vqdata =  vqdb.getArticle(no);
		
		//�亯�ڰ� �ƴϸ�
		if(vqdata.getSellers_no() != member_info.getNo()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		vqdata = new View_Qna_Data_Bean();
		vqdata.setNo(no);
		vqdata.setAnswer(memo);
		vqdata.setIsanswer(1);
		
		int res = 0;
		if(vqdb.answer(vqdata)) res = 1;
		
		request.setAttribute("res", res);


		request.setAttribute("no", no);
		request.setAttribute("product_no", product_no);
		
		
		return "view_qna_answer_post.tiles";
	}

}
