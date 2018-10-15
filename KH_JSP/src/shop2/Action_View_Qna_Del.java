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
		if(no == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		View_Qna_Data_Bean vqdata = vqdb.getArticle(no);
		
		//내 회원번호하고 게시글의 회원번호하고 다르면
		if(vqdata.getGuest_no() != member_info.getNo()) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		
		//삭제
		int res = 0;
		if(vqdb.delete(no)) res = 1;
		
		request.setAttribute("res", res);
		request.setAttribute("no", product_no);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('삭제 성공.')");
			response.getWriter().println("location.href='view.o?no="+product_no+"&tab=3&pages="+pages+"';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('삭제 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "view_qna_del.jsp";
	}

}
