package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login_Find_Pw_Change extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String user_id = "";
		String name = "";
		String phone1 = "";
		String phone2 = "";
		String phone3 = "";
		int quest = -1;
		String answer = "";
		String user_pw = "";
		String user_pw2 = "";
		
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
		if(request.getParameter("user_pw") != null)
			user_pw = request.getParameter("user_pw");
		if(request.getParameter("user_pw2") != null)
			user_pw2 = request.getParameter("user_pw2");
		
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

		if(user_pw.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호를 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(user_pw2.equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호확인을 입력해주세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(!user_pw.equals(user_pw2)) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호가 다릅니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		//암호화
		user_pw = Md5Enc.getEncMD5(user_pw.getBytes());
		
		int res = 0;
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		if(mdb.changePw(user_id, name, phone1, phone2, phone3, quest, answer, user_pw))
			res = 1;
		
		request.setAttribute("res", res);
		
		if(res == 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호 변경 성공.')");
			response.getWriter().println("location.href='login.o';");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		if(res == 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호 변경 실패.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		
		return null;
	}

}
