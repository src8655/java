package shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Index extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();

		List list_1 = ldb.getArticles(1, 5, 1, "", 10);
		List list_2 = ldb.getArticles(1, 5, 2, "", 10);
		List list_3 = ldb.getArticles(1, 5, 3, "", 10);
		List list_4 = ldb.getArticles(1, 5, 4, "", 10);
		List list_5 = ldb.getArticles(1, 5, 5, "", 10);
		List list_6 = ldb.getArticles(1, 5, 6, "", 10);
		List list_7 = ldb.getArticles(1, 5, 7, "", 10);
		List list_8 = ldb.getArticles(1, 5, 8, "", 10);

		request.setAttribute("list_1", list_1);
		request.setAttribute("list_2", list_2);
		request.setAttribute("list_3", list_3);
		request.setAttribute("list_4", list_4);
		request.setAttribute("list_5", list_5);
		request.setAttribute("list_6", list_6);
		request.setAttribute("list_7", list_7);
		request.setAttribute("list_8", list_8);
		
		
		return "index.jsp";
	}

}
