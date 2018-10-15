package shop2;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Review_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {

		int no = -1;
		int product_no = -1;
		int stars = -1;
		String review1 = "";
		String review2 = "";
		String memo = "";

		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		if(request.getParameter("product_no") != null)
			product_no = Integer.parseInt(request.getParameter("product_no"));
		if(request.getParameter("stars") != null)
			stars = Integer.parseInt(request.getParameter("stars"));
		if(request.getParameter("review1") != null)
			review1 = request.getParameter("review1");
		if(request.getParameter("review2") != null)
			review2 = request.getParameter("review2");
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
		if(member_info.getOrders() != 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		//�߸��� ���� ����
		if(no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(product_no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(stars == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��ǰ�򰡸� �������ּ���')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(review1.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�������򰡸� �Է��� �ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(review2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�������򰡸� �Է��� �ּ���.')");
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
		
		//���ų����� �����ϴ��� Ȯ��
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		Sell_Data_Bean sdata = sdb.getArticle(no);
		
		//�� ���ų����� �ƴϸ�
		if(sdata.getGuest_no() != member_info.getNo()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		//�̹� ���䰡 �����ϸ�
		if(sdata.getHasreview() != 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//�ݼ��� ���̵�
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		View_Review_DB_Bean vrdb = View_Review_DB_Bean.getInstance();
		View_Review_Data_Bean vrdata = new View_Review_Data_Bean();
		vrdata.setDates(year+"-"+month+"-"+day);
		vrdata.setGuest_no(member_info.getNo());
		vrdata.setMemo(memo);
		vrdata.setProduct_no(product_no);
		vrdata.setReview1(review1);
		vrdata.setReview2(review2);
		vrdata.setStars(stars);
		vrdata.setGuest_id(guest_id);
		
		
		int res = 0;
		if(vrdb.insert(vrdata)) {
			sdb.updateReview(no);	//���ų����� ���䰡 �ۼ��Ǿ��ٴ°��� ����
			res = 1;
		}
		
		request.setAttribute("res", res);
		request.setAttribute("no", no);
		request.setAttribute("product_no", product_no);
		
		
		return "view_review_post.tiles";
	}

}
