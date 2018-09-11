package board2;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Edit extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		//비로그인 접근금지
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		request.setAttribute("datey", year);
		request.setAttribute("datem", month);
		request.setAttribute("dated", day);
		
		return "join_edit.jsp";
	}

}
