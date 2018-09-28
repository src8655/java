package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_View extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int no = -1;
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		List_Data_Bean ldata = ldb.getArticle(no);
		
		Cookie_Bean cb = Cookie_Bean.getInstance();
		if(no != -1) cb.view_cookie(no, request, response);
		
		
		request.setAttribute("ldata", ldata);
		
		
		return "view.jsp";
	}

}
