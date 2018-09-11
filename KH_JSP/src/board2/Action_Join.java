package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		request.setAttribute("datey", year);
		request.setAttribute("datem", month);
		request.setAttribute("dated", day);
		return "join.jsp";
	}

}
