package shop2;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Qna_Answer extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int no = -1;
		String product_no = "";
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));

		if(request.getParameter("product_no") != null)
			product_no = request.getParameter("product_no");
		

		request.setAttribute("no", no);
		request.setAttribute("product_no", product_no);
		
		return "view_qna_answer.tiles";
	}

}
