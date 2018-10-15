package shop2;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Qna_Write_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int product_no = -1;
		int sellers_no = -1;
		int category = -1;
		String memo = "";
		int secret = 0;
		
		if(request.getParameter("product_no") != null)
			product_no = Integer.parseInt(request.getParameter("product_no"));
		if(request.getParameter("sellers_no") != null)
			sellers_no = Integer.parseInt(request.getParameter("sellers_no"));
		if(request.getParameter("category") != null)
			category = Integer.parseInt(request.getParameter("category"));
		if(request.getParameter("memo") != null)
			memo = request.getParameter("memo");
		if(request.getParameter("secret") != null) {
			String tmp = request.getParameter("secret");
			if(tmp.equals("1")) secret = 1;
			else secret = 0;
		}
		
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
		if(sellers_no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//������ �Է��ߴ���
		if(category == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�з��� ������ �ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(memo.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('������ �Է��� �ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		int guest_no = member_info.getNo();
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		
		//�����͸� ��� ����
		View_Qna_Data_Bean vqdata = new View_Qna_Data_Bean();
		vqdata.setProduct_no(product_no);
		vqdata.setSellers_no(sellers_no);
		vqdata.setCategory(category);
		vqdata.setMemo(memo);
		vqdata.setSecret(secret);
		vqdata.setGuest_no(guest_no);
		vqdata.setGuest_id(guest_id);
		vqdata.setDates(year+"-"+month+"-"+day);

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		
		int res = 0;
		if(vqdb.insert(vqdata)) res = 1;
		
		request.setAttribute("res", res);
		request.setAttribute("product_no", product_no);
		
		
		return "view_qna_write_post.tiles";
	}

}
