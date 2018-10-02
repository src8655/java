package shop;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Review extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int no = -1;
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));

		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		List_Data_Bean ldata = ldb.getArticle(no);
		

		request.setAttribute("no", no);
		request.setAttribute("ldata", ldata);
		
		return "view_review.tiles";
	}

}
