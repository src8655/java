package board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board extends Action_Init implements Action {

	public String execute() throws ServletException, IOException {
		Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
		int board_total = board_manager.getCount(id, searchs, searchs_value);	//총 개수
		int board_cnt = 0;						//no를 위한 카운트

		int board_lengths = 7;	//한번에 보일 리스트 개수
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//시작지점
		int board_ends = board_starts+board_lengths-1;										//마지막지점
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//페이지 링크 개수

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;

		Board_DB_Bean manager = Board_DB_Bean.getInstance();
		List list = manager.getArticles(board_starts, board_ends, id, searchs, searchs_value);	//리스트받아오기



		//게시판
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//페이징부분
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);

		//게시판 리스트
		request.setAttribute("list", list);
		
		return "board.jsp";
	}

}
