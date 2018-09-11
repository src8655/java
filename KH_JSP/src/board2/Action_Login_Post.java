package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Login_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		if(request.getParameter("user_id").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('아이디를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(request.getParameter("passwords").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(request.getParameter("user_id"));
		mdata.setPasswords(request.getParameter("passwords"));
		mdata.setKakao(Integer.parseInt(request.getParameter("kakao")));
		mdata.setName(request.getParameter("name"));

		int auto_id = 0;
		if(request.getParameter("auto_id") != null)
			if(!request.getParameter("auto_id").equals(""))
				auto_id = 1;
		mdata.setAuto_id(auto_id);

		Member_DB_Bean manager = Member_DB_Bean.getInstance();

		//성공시 1
		int res = 0;
		if(manager.login(mdata, response)) {
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getPasswords());
			
			res = 1;
		}

		request.setAttribute("res", res);
		
		return "login_post.jsp";
	}

}
