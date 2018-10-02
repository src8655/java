package shop;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Review_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int product_no = -1;
		int stars = -1;
		String review1 = "";
		String review2 = "";
		String memo = "";

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

		
		//회원인지
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		//잘못된 접근 막기
		if(product_no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(stars == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('상품평가를 선택해주세요')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(review1.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('만족도평가를 입력해 주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(review2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('만족도평가를 입력해 주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(memo.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('내용을 입력해 주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		/*
		int guest_no = member_info.getNo();
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		
		//데이터를 빈즈에 담음
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
		
		*/
		return "view_review_post.tiles";
	}

}
