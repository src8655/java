package shop2;

import java.io.IOException;

import javax.servlet.ServletException;

public class Action_View_Qna_Write extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int no = -1;
		String sellers_no = "";
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));

		if(request.getParameter("sellers_no") != null)
			sellers_no = request.getParameter("sellers_no");
		

		request.setAttribute("no", no);
		request.setAttribute("sellers_no", sellers_no);
		
		return "view_qna_write.tiles";
	}

}
