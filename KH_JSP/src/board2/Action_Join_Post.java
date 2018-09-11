package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Join_Post extends Action_Init implements Action {

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
		if(request.getParameter("passwords2").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호 확인을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(!request.getParameter("passwords").equals(request.getParameter("passwords2"))) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('비밀번호가 다릅니다.')");
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


		//중복확인된 아이디인지 확인
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		int count = mdb.selectId(mdata.getUser_id());
			
		if(count != 0) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이미 존재하는 아이디 입니다.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		//암호화
		mdata.setPasswords(Md5Enc.getEncMD5(mdata.getPasswords().getBytes()));

		Member_DB_Bean manager = Member_DB_Bean.getInstance();
		manager.insert(mdata);
		
		return "join_post.jsp";
	}

}
