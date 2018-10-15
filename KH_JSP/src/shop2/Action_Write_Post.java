package shop2;

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

		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('작성 성공.')");
			response.getWriter().println("location.href='write.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('작성 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		//return "write_post.jsp";
		return null;
	}

}
