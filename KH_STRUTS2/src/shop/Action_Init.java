package shop;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Action_Init {
	HttpServletRequest request;
	HttpServletResponse response;
	

	//공통으로 받는 파라미터
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
	public int month = cal.get(Calendar.MONTH);
	public int day = cal.get(Calendar.DATE);
	public String pages = "1";
	public int pages_int;
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
	
	
	private int basket_cnt;
	List rviewedListAll;
	List rviewedList;
	int rviewed_count;
	
	Action_Init() {
	}
	
	public void run() throws UnsupportedEncodingException {
		session = request.getSession();

		
		
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
		
		pages_int = Integer.parseInt(pages);
		
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
		
		
		
		
		
		//장바구니 개수 구하기
		//비어있으면
		basket_cnt = 0;
		if(session.getAttribute("basket") == null) {
			basket_cnt = 0;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			basket_cnt = map.size();
		}
		
		
		
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
		rviewedListAll = new ArrayList();
		rviewedList = new ArrayList();
		
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle(Integer.parseInt((String)viewedListAll.get(i)));
			rviewedListAll.add(ldata);
		}
		for(int i=viewedList.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle(Integer.parseInt((String)viewedList.get(i)));
			rviewedList.add(ldata);
		}
		rviewed_count = rviewedListAll.size();
		
		
		
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Calendar getCal() {
		return cal;
	}

	public void setCal(Calendar cal) {
		this.cal = cal;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public int getSearchs() {
		return searchs;
	}

	public void setSearchs(int searchs) {
		this.searchs = searchs;
	}

	public String getSearchs_value() {
		return searchs_value;
	}

	public void setSearchs_value(String searchs_value) {
		this.searchs_value = searchs_value;
	}

	public String getSearchs_values() {
		return searchs_values;
	}

	public void setSearchs_values(String searchs_values) {
		this.searchs_values = searchs_values;
	}

	public int getP_search() {
		return p_search;
	}

	public void setP_search(int p_search) {
		this.p_search = p_search;
	}

	public String getP_search_value() {
		return p_search_value;
	}

	public void setP_search_value(String p_search_value) {
		this.p_search_value = p_search_value;
	}

	public String getP_search_values() {
		return p_search_values;
	}

	public void setP_search_values(String p_search_values) {
		this.p_search_values = p_search_values;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getPages_int() {
		return pages_int;
	}

	public void setPages_int(int pages_int) {
		this.pages_int = pages_int;
	}

	public Member_DB_Bean getMem_db() {
		return mem_db;
	}

	public void setMem_db(Member_DB_Bean mem_db) {
		this.mem_db = mem_db;
	}

	public Member_Data_Bean getMember_info() {
		return member_info;
	}

	public void setMember_info(Member_Data_Bean member_info) {
		this.member_info = member_info;
	}

	public int getBasket_cnt() {
		return basket_cnt;
	}

	public void setBasket_cnt(int basket_cnt) {
		this.basket_cnt = basket_cnt;
	}

	public List getRviewedListAll() {
		return rviewedListAll;
	}

	public void setRviewedListAll(List rviewedListAll) {
		this.rviewedListAll = rviewedListAll;
	}

	public List getRviewedList() {
		return rviewedList;
	}

	public void setRviewedList(List rviewedList) {
		this.rviewedList = rviewedList;
	}

	public int getRviewed_count() {
		return rviewed_count;
	}

	public void setRviewed_count(int rviewed_count) {
		this.rviewed_count = rviewed_count;
	}
	
	
	
	
	
}
