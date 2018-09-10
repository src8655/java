package board2.controller;

import java.io.IOException;
import java.util.*;
import board2.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login_post
 */
public class login_post extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_post() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		
		
		//�������� �޴� �Ķ����
		String id = "";
		String pages = "1";
		String searchs = "";
		String searchs_value = "";

		if(request.getParameter("id") != null)
			id = request.getParameter("id");
		if(request.getParameter("pages") != null)
			pages = request.getParameter("pages");
		if(request.getParameter("searchs") != null)			//�˻�
			searchs = request.getParameter("searchs");
		if(request.getParameter("searchs_value") != null)	//�˻���
			searchs_value = request.getParameter("searchs_value");



		//Admin���� �ҷ�����
		Admin_DB_Bean admin_manager = Admin_DB_Bean.getInstance();
		Admin_Data_Bean adata = admin_manager.getArticle(id);

		//�α������� �ҷ�����
		Member_DB_Bean mem_db = Member_DB_Bean.getInstance();
		Member_Data_Bean member_info = mem_db.getLogin(session);

		//����
		request.setAttribute("id", id);
		request.setAttribute("pages", pages);
		request.setAttribute("pages_int", Integer.parseInt(pages));
		request.setAttribute("searchs", searchs);
		request.setAttribute("searchs_value", searchs_value);

		request.setAttribute("adata", adata);
		request.setAttribute("member_info", member_info);
		////////////////////////////////////////////////////////////////

		if(request.getParameter("user_id").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('���̵� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return;
		}
		if(request.getParameter("passwords").equals("")) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('��й�ȣ�� �Է��ϼ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return;
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

		//������ 1
		int res = 0;
		if(manager.login(mdata, response)) {
			session.setAttribute("user_id", mdata.getUser_id());
			session.setAttribute("user_pw", mdata.getPasswords());
			
			res = 1;
		}

		request.setAttribute("res", res);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./login_post.jsp");
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
