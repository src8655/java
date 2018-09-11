package board2;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Index extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		Board_DB_Bean manager = Board_DB_Bean.getInstance();

		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

		List list = manager.getArticles2(1, 5);	//리스트받아오기


		request.setAttribute("date", date);
		request.setAttribute("list", list);
		
		return "index.jsp";
	}
}
