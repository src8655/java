package board2.controller;

import java.util.*;
import board2.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class board_del_post
 */
public class board_del_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board_del_post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		//공통으로 받는 파라미터
		String id = "";
		String pages = "1";
		String searchs = "";
		String searchs_value = "";

		if(request.getParameter("id") != null)
			id = request.getParameter("id");
		if(request.getParameter("pages") != null)
			pages = request.getParameter("pages");
		if(request.getParameter("searchs") != null)			//검색
			searchs = request.getParameter("searchs");
		if(request.getParameter("searchs_value") != null)	//검색어
			searchs_value = request.getParameter("searchs_value");



		//Admin정보 불러오기
		Admin_DB_Bean admin_manager = Admin_DB_Bean.getInstance();
		Admin_Data_Bean adata = admin_manager.getArticle(id);

		//로그인정보 불러오기
		Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
		Member_Data_Bean member_info = mem_db.getLogin(session);

		//공통
		request.setAttribute("id", id);
		request.setAttribute("pages", pages);
		request.setAttribute("pages_int", Integer.parseInt(pages));
		request.setAttribute("searchs", searchs);
		request.setAttribute("searchs_value", searchs_value);

		request.setAttribute("adata", adata);
		request.setAttribute("member_info", member_info);
		////////////////////////////////////////////////////////////////

		String no = request.getParameter("no");

		//멤버일 경우
		String passwords = "";
		if(member_info != null) {
			passwords = member_info.getPasswords();
		}else{
			passwords = request.getParameter("passwords");
		}

		//암호화
		passwords = Md5Enc.getEncMD5(passwords.getBytes());



		Board_DB_Bean bdb = Board_DB_Bean.getInstance();

		//성공시 1 실패시 0
		int res = 1;
		if(!bdb.delete(Integer.parseInt(no), passwords)) res = 0;


		request.setAttribute("no", no);
		request.setAttribute("res", res);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./board_del_post.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
