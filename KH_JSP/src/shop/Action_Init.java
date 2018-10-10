package shop;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Action_Init implements Action {
	public HttpServletRequest request;
	public HttpServletResponse response;
	//공통으로 받는 파라미터
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH);
	public int day = cal.get(Calendar.DATE);
	public String pages = "1";
	public int searchs = -1;
	public String searchs_value = "";
	public String searchs_values = "";
	
	public int p_search = 1;
	public String p_search_value = "";
	public String p_search_values = "";
	
	HttpSession session;
	Member_DB_Bean mem_db;
	Member_Data_Bean member_info;
	
	int order = -1;
	
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

		if(request.getParameter("pages") != null)
			pages = request.getParameter("pages");
		if(request.getParameter("searchs") != null)			//검색
			if(!request.getParameter("searchs").equals(""))
				searchs = Integer.parseInt(request.getParameter("searchs"));
		if(request.getParameter("searchs_value") != null) {
			searchs_value = request.getParameter("searchs_value");
		}
		//url인코딩한 값을 저장
		searchs_values = URLEncoder.encode(searchs_value,"UTF-8");
		
		//공통
		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("day", day);
		request.setAttribute("pages", pages);
		request.setAttribute("pages_int", Integer.parseInt(pages));
		request.setAttribute("searchs", searchs);
		request.setAttribute("searchs_value", searchs_value);
		request.setAttribute("searchs_values", searchs_values);
		
		//로그인정보 불러오기
		mem_db = Member_DB_Bean.getInstance();
		member_info = mem_db.getLogin(session);
		
		
		
		//공동사용 검색
		if(request.getParameter("p_search") != null)			//검색
			if(!request.getParameter("p_search").equals(""))
				p_search = Integer.parseInt(request.getParameter("p_search"));
		if(request.getParameter("p_search_value") != null) {
			p_search_value = request.getParameter("p_search_value");
		}
		//url인코딩한 값을 저장
		p_search_values = URLEncoder.encode(p_search_value,"UTF-8");
		
		request.setAttribute("p_search", p_search);
		request.setAttribute("p_search_value", p_search_value);
		request.setAttribute("p_search_values", p_search_values);
		
		
		
		
		
		
		//장바구니 개수 구하기
		//비어있으면
		int basket_cnt = 0;
		if(session.getAttribute("basket") == null) {
			basket_cnt = 0;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			basket_cnt = map.size();
		}

		request.setAttribute("basket_cnt", basket_cnt);
		request.setAttribute("member_info", member_info);
		
		
		//order부분 list의
		if(request.getParameter("order") != null)
			if(!request.getParameter("order").equals(""))
				order = Integer.parseInt(request.getParameter("order"));
		request.setAttribute("order", order);
		
		
		
		
		
		//최근본게시글
		Cookie_Bean cb_tmp = Cookie_Bean.getInstance();
		List viewedListAll = cb_tmp.get_viewed_cookie(request, response);
		List viewedList = new ArrayList();
		if(viewedListAll.size() > 2) {
			viewedList.add(viewedListAll.get(viewedListAll.size()-2));
			viewedList.add(viewedListAll.get(viewedListAll.size()-1));
		}else viewedList = viewedListAll;
		
		List_DB_Bean ldb_tmp = List_DB_Bean.getInstance();
		List rviewedListAll = new ArrayList();
		List rviewedList = new ArrayList();
		
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle(Integer.parseInt((String)viewedListAll.get(i)));
			rviewedListAll.add(ldata);
		}
		for(int i=viewedList.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle(Integer.parseInt((String)viewedList.get(i)));
			rviewedList.add(ldata);
		}
		int rviewed_count = rviewedListAll.size();
		
		request.setAttribute("rviewedList", rviewedList);			//두개만보이기
		request.setAttribute("rviewedListAll", rviewedListAll);		//10개 모두 보이기
		request.setAttribute("rviewed_count", rviewed_count);		//개수
		
		
		
		////////////////////////////////////////////////////////////////
		
	}

	@Override
	public String execute() throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
