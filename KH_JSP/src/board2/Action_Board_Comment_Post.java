package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Comment_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String data_no = request.getParameter("data_no");

		if(request.getParameter("name").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('이름을 입력하세요.')");
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
		if(request.getParameter("memo").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('내용을 입력하세요.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}


		Comment_Data_Bean cdata = new Comment_Data_Bean();
		cdata.setRt_no(Integer.parseInt(request.getParameter("rt_no")));
		cdata.setData_no(Integer.parseInt(request.getParameter("data_no")));
		cdata.setName(request.getParameter("name"));
		cdata.setPasswords(request.getParameter("passwords"));
		cdata.setMemo(request.getParameter("memo"));

		//암호화
		cdata.setPasswords(Md5Enc.getEncMD5(cdata.getPasswords().getBytes()));


		Comment_DB_Bean manager = Comment_DB_Bean.getInstance();
		manager.insert(cdata);


		//댓글카운트갱신
		Board_DB_Bean bdb = Board_DB_Bean.getInstance();
		bdb.updateComment(Integer.parseInt(data_no));


		request.setAttribute("data_no", data_no);
		
		return "board_comment_post.jsp";
	}

}
