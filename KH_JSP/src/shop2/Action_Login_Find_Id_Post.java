package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login_Find_Id_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String name = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";

		if(request.getParameter("name") != null)
			name = request.getParameter("name");
		if(request.getParameter("phone1") != null)
			phone1 = request.getParameter("phone1");
		if(request.getParameter("phone2") != null)
			phone2 = request.getParameter("phone2");
		if(request.getParameter("phone3") != null)
			phone3 = request.getParameter("phone3");
		
		
		if(name.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이름을 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone1.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('휴대전화를 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('휴대전화를 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(phone3.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('휴대전화를 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		
		String user_id = mdb.findId(name, phone1, phone2, phone3);
		
		if(user_id == null) user_id = "";

		request.setAttribute("user_id", user_id);
		request.setAttribute("name", name);
		request.setAttribute("phone1", phone1);
		request.setAttribute("phone2", phone2);
		request.setAttribute("phone3", phone3);
		
		return "login_find_id_post.tiles";
	}

}
