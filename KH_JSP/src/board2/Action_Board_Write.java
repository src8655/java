package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Write extends Action_Init implements Action {


	public String execute() throws ServletException, IOException {
		Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
		int board_total = board_manager.getCount(id, searchs, searchs_value);	//ÃÑ °³¼ö

		request.setAttribute("board_total", board_total);


		String rt_no = "1";
		String subject = "";
		if(request.getParameter("rt_no") != null) {
			rt_no = request.getParameter("rt_no");
			Board_DB_Bean bdb = Board_DB_Bean.getInstance();
			Board_Data_Bean bdata = bdb.getArticle(Integer.parseInt(rt_no));
			subject = bdata.getSubject();
		}


		String name_tmp = "";
		String passwords_tmp = "";
		if(member_info != null) {
			name_tmp = member_info.getName();
			passwords_tmp = member_info.getPasswords();
		}




		request.setAttribute("rt_no", rt_no);
		request.setAttribute("subject", subject);
		request.setAttribute("name_tmp", name_tmp);
		request.setAttribute("passwords_tmp", passwords_tmp);
		
		return "board_write.jsp";
	}

}
