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
		if(no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
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
		
		//구매내역이 존재하는지 확인
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		Sell_Data_Bean sdata = sdb.getArticle(no);
		
		//내 구매내역이 아니면
		if(sdata.getGuest_no() != member_info.getNo()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		//이미 리뷰가 존재하면
		if(sdata.getHasreview() != 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//반숨긴 아이디
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
			sdb.updateReview(no);	//구매내역에 리뷰가 작성되었다는것을 적용
			res = 1;
		}
		
		request.setAttribute("res", res);
		request.setAttribute("no", no);
		request.setAttribute("product_no", product_no);
		
		
		return "view_review_post.tiles";
	}

}
