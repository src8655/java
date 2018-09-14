package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Write_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		
		
		//res=1이면 성공
		int res = 0;
		if(ldb.insert(request, session)) res = 1;
		
		
		
		request.setAttribute("res", res);
		
		return "write_post.jsp";
	}

}
