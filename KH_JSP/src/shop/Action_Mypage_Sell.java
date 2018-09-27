package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Sell extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 2) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//분류(-1 이면 모두보기(배송완료는 제외))
		String cate = "-1";
		if(request.getParameter("cate") != null)
			if(!request.getParameter("cate").equals(""))
				cate = request.getParameter("cate");

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		
		int board_total = sdb.count2(member_info.getNo(), Integer.parseInt(cate));	//총 개수
		int board_cnt = 0;						//no를 위한 카운트

		int board_lengths = 10;	//한번에 보일 리스트 개수
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//시작지점
		int board_ends = board_starts+board_lengths-1;										//마지막지점
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//페이지 링크 개수

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;


		//게시판
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//페이징부분
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);
		
		
		
		
		
		
		//리스트 가져오기
		List list = sdb.getArticles2(board_starts, board_ends, member_info.getNo(), Integer.parseInt(cate));

		request.setAttribute("cate", cate);
		request.setAttribute("list", list);
		
		
		return "mypage_sell.jsp";
	}


}
