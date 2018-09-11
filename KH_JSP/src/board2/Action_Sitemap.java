package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Sitemap extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "sitemap.jsp";
	}
}
