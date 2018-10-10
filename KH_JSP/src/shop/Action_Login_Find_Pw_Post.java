package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login_Find_Pw_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String user_id = "";
		String name = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";
		int quest = -1;
		String answer = "";
		
		if(request.getParameter("user_id") != null)
			user_id = request.getParameter("user_id");
		if(request.getParameter("name") != null)
			name = request.getParameter("name");
		if(request.getParameter("phone1") != null)
			phone1 = request.getParameter("phone1");
		if(request.getParameter("phone2") != null)
			phone2 = request.getParameter("phone2");
		if(request.getParameter("phone3") != null)
			phone3 = request.getParameter("phone3");
		if(request.getParameter("quest") != null)
			if(!request.getParameter("quest").equals(""))
				quest = Integer.parseInt(request.getParameter("quest"));
		if(request.getParameter("answer") != null)
			answer = request.getParameter("answer");
		
		if(user_id.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('아이디를 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}if(name.equals("")) {
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
		if(quest == -1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('질문을 선택해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(answer.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('답변을 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		int res = 0;
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		if(mdb.findPw(user_id, name, phone1, phone2, phone3, quest, answer))
			res = 1;
		
		request.setAttribute("res", res);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("name", name);
		request.setAttribute("phone1", phone1);
		request.setAttribute("phone2", phone2);
		request.setAttribute("phone3", phone3);
		request.setAttribute("quest", quest);
		request.setAttribute("answer", answer);
		
		
		return "login_find_pw_post.tiles";
	}

}
