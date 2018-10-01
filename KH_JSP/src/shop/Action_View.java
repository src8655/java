package shop;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_View extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int no = -1;
		int tab = 1;
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		if(request.getParameter("tab") != null)
			if(!request.getParameter("tab").equals(""))
				tab = Integer.parseInt(request.getParameter("tab"));
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		List_Data_Bean ldata = ldb.getArticle(no);
		
		Cookie_Bean cb = Cookie_Bean.getInstance();
		if(no != -1) cb.view_cookie(no, request, response);
		
		
		request.setAttribute("ldata", ldata);
		request.setAttribute("no", no);
		request.setAttribute("tab", tab);
		
		
		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		
		int board_total = vqdb.count(no);	//총 개수
		int board_cnt = 0;						//no를 위한 카운트

		int board_lengths = 20;	//한번에 보일 리스트 개수
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//시작지점
		int board_ends = board_starts+board_lengths-1;										//마지막지점
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//페이지 링크 개수

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
		

		List list = vqdb.getArticles(board_starts, board_ends, no, member_info);	//리스트받아오기

		//qna
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//페이징부분
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);

		//게시판 리스트
		request.setAttribute("list", list);
		
		//회원종류
		int member_orders = -1;
		if(member_info != null)
			member_orders = member_info.getOrders();
		request.setAttribute("member_orders", member_orders);
		
		//비회원은 가상의 회원데이터 만들기
		//(null 참조 에러 방지)
		Member_Data_Bean mdata = null;
		if(member_info == null) 
			mdata = new Member_Data_Bean();
		else
			mdata = member_info;
		
		request.setAttribute("mdata", mdata);
		
		return "view.jsp";
	}

}
