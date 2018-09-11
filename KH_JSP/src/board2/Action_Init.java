package board2;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Action_Init implements Action {
	public HttpServletRequest request;
	public HttpServletResponse response;
	//�������� �޴� �Ķ����
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH);
	public int day = cal.get(Calendar.DATE);
	public String id = "";
	public String pages = "1";
	public String searchs = "";
	public String searchs_value = "";
	
	public Admin_DB_Bean admin_manager;
	public Admin_Data_Bean adata;
	Member_DB_Bean mem_db;
	Member_Data_Bean member_info;
	HttpSession session;
	
	public Action_Init() {
		
	}

	public Action_Init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action_Init(request, response);
	}
	public void action_Init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		this.request = request;
		this.response = response;
		
		session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		

		if(request.getParameter("id") != null)
			id = request.getParameter("id");
		if(request.getParameter("pages") != null)
			pages = request.getParameter("pages");
		if(request.getParameter("searchs") != null)			//�˻�
			searchs = request.getParameter("searchs");
		if(request.getParameter("searchs_value") != null)	//�˻���
			searchs_value = request.getParameter("searchs_value");


		admin_manager = Admin_DB_Bean.getInstance();
		adata = admin_manager.getArticle(id);
		request.setAttribute("adata", adata);
		
		//�α������� �ҷ�����
		mem_db = Member_DB_Bean.getInstance();
		member_info = mem_db.getLogin(session);


		//����
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("id", id);
		request.setAttribute("pages", pages);
		request.setAttribute("pages_int", Integer.parseInt(pages));
		request.setAttribute("searchs", searchs);
		request.setAttribute("searchs_value", searchs_value);

		request.setAttribute("member_info", member_info);
		////////////////////////////////////////////////////////////////
	}

	@Override
	public String execute() throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
