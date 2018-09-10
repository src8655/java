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
 * Servlet implementation class board_view
 */
public class board_view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board_view() {
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


		Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
		int board_total = board_manager.getCount(id, searchs, searchs_value);	//�� ����


		String no = request.getParameter("no");


		//��Ű����
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		cmanager.view_cookie(no, request, response);


		//�����͹ޱ�
		Board_DB_Bean manager = Board_DB_Bean.getInstance();
		Board_Data_Bean bdb = manager.getArticle(Integer.parseInt(no));

		//1�� �ƴ϶�� ���� �� ���� ����̶�°�
		String rt_no = no;
		if(bdb.getRt_no() != 1)	rt_no = Integer.toString(bdb.getRt_no());

		//����� ��� ��۷� �ޱ�
		String name_tmp = "";
		String passwords_tmp = "";
		if(member_info != null) {
			name_tmp = member_info.getName();
			passwords_tmp = member_info.getPasswords();
		}


		//���
		Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
		List list = cdb.getArticles(Integer.parseInt(no));
		for(int i=0;i<list.size();i++) {
			Comment_Data_Bean data = (Comment_Data_Bean)list.get(i);
			String c_memos = data.getMemo().replaceAll("\n", "<br />");
			data.setMemo(c_memos);
			list.set(i, data);
		}



		request.setAttribute("no", no);
		request.setAttribute("board_total", board_total);
		request.setAttribute("bdb", bdb);
		request.setAttribute("rt_no", rt_no);

		request.setAttribute("list", list);
		request.setAttribute("name_tmp", name_tmp);
		request.setAttribute("passwords_tmp", passwords_tmp);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("./board_view.jsp");
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
