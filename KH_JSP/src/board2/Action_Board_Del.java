package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Del extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
		int board_total = board_manager.getCount(id, searchs, searchs_value);	//ÃÑ °³¼ö

		request.setAttribute("board_total", board_total);

		String no = request.getParameter("no");

		request.setAttribute("no", no);
		
		return "board_del.jsp";
	}

}
