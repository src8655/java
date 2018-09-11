package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Edit_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		//비로그인 접근금지
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('잘못된 접근입니다.')");
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
		if(request.getParameter("name").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이름을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(request.getParameter("email").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이메일을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
				
			return null;
		}


		Member_Data_Bean mdata = new Member_Data_Bean();
		mdata.setUser_id(request.getParameter("user_id"));
		mdata.setPasswords(request.getParameter("passwords"));
		mdata.setName(request.getParameter("name"));
		mdata.setEmail(request.getParameter("email"));
		mdata.setBirthy(request.getParameter("birthy"));
		mdata.setBirthm(request.getParameter("birthm"));
		mdata.setBirthd(request.getParameter("birthd"));
		mdata.setAddr_code(request.getParameter("addr_code"));
		mdata.setAddr(request.getParameter("addr"));
		mdata.setPhone1(request.getParameter("phone1"));
		mdata.setPhone2(request.getParameter("phone2"));
		mdata.setPhone3(request.getParameter("phone3"));
		mdata.setKakao(Integer.parseInt(request.getParameter("kakao")));
		mdata.setNo(Integer.parseInt(request.getParameter("no")));


		//회원no전달

		Member_DB_Bean manager = Member_DB_Bean.getInstance();

		//성공시 1
		int res = 0;
		if(manager.update(mdata)) {
			res = 1;
		}

		request.setAttribute("res", res);
				
		return "join_edit_post.jsp";
	}

}
