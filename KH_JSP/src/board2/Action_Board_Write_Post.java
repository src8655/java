package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Write_Post extends Action_Init implements Action {


	@Override
	public String execute() throws ServletException, IOException {
		//성공시 1 실패시 0
		int res = 1;
		Board_DB_Bean manager = Board_DB_Bean.getInstance();
		if(!manager.insert(request, session)) res = 0;

		request.setAttribute("res", res);
		
		return "board_write_post.jsp";
	}

}
