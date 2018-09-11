package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Check extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String user_id = request.getParameter("user_id");


		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		int count = mdb.selectId(user_id);


		//성공시 1 실패시 0
		String result = "0";	//결과코드
		if(count == 0) result = "1";

		request.setAttribute("result", result);
		
		return "join_check.jsp";
	}

}
