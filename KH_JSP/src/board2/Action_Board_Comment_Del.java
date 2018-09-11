package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Comment_Del extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String no = request.getParameter("no");
		String data_no = request.getParameter("data_no");

		request.setAttribute("no", no);
		request.setAttribute("data_no", data_no);
		
		
		return "board_comment_del.jsp";
	}

}
