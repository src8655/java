package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		

		if(user_id.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('아이디를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(user_pw.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호를 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//자동아이디 체크되었는지 확인
		int auto_id = 0;
		if(request.getParameter("auto_id") != null)
			if(!request.getParameter("auto_id").equals(""))
				auto_id = 1;
		
		//아이디 쿠키
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		if(auto_id == 1) cmanager.setId(user_id, response);	//쿠키 저장
		else cmanager.delId(response);	//쿠키 삭제

		
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(user_id);
		mdata.setUser_pw(user_pw);
    	//암호화
    	mdata.setUser_pw(Md5Enc.getEncMD5(mdata.getUser_pw().getBytes()));
    	
		int res = 0;
		if(mdb.login(mdata)) {
			res = 1;
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getUser_pw());
		}
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 성공.')");
			response.getWriter().println("location.href='index.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('로그인 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		return null;
		//return "login_post.jsp";
	}

}
