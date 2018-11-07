package tour;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

import config.FactoryService;
import tour.data.List_Data;
import tour.data.List_Reserve_Data;
import tour.data.Member_Data;


public class Action_Init {
	String msg = "";
	String url = "";
	int level = 1;
	int basket_size = 0;
	
	HttpServletRequest request;
	HttpServletResponse response;
	HttpSession session;
	
	//공통으로 받는 파라미터
	public Calendar cal = Calendar.getInstance();
	public int years = cal.get(Calendar.YEAR);
	public int months = cal.get(Calendar.MONTH)+1;
	public int days = cal.get(Calendar.DATE);
	
	String year = "";
	String month = "";
	String day = "";
	
	
	int category = -1;
	int pages = 1;
	String searchs = "";
	String searchs_utf = "";
	
	Member_Data member_info;

	List viewed_list;
	List viewed_list_all;
	int viewed_list_cnt = 0;
	
	
	
	Action_Init() {
	}
	
	public void run() throws UnsupportedEncodingException, SQLException {
		session = request.getSession();
		
		//날짜 편집
		year = Integer.toString(years);
		month = Integer.toString(months);
		day = Integer.toString(days);
		if(months < 10) month = "0"+month;
		if(days < 10) day = "0"+day;
		
		

		searchs_utf = URLEncoder.encode(searchs,"UTF-8");
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
    		Map map = new HashMap();
    		map.put("user_id", (String)session.getAttribute("user_id"));
    		map.put("user_pw", (String)session.getAttribute("user_pw"));
    		member_info = (Member_Data)sqlmap.queryForObject("Member_getArticle", map);
    	}else member_info = null;
		
		
		if(member_info != null) level = member_info.getOrders();
		
		
		
		if(session.getAttribute("basket") != null) {
			HashMap map = (HashMap)session.getAttribute("basket");
			basket_size = map.size();
		}
		
		
		
		
		
		

		
		//실제로는 풀것
		
		//예약대기중인 상품예약 중에 출발날짜가 초과된 상품은 모두 제거
		List list = (List)sqlmap.queryForList("List_Reserve_getArticlesCheck");
		for(int i=0;i<list.size();i++) {
			List_Reserve_Data rldata = (List_Reserve_Data)list.get(i);
			Long now = cal.getTimeInMillis();
			Long st = Long.parseLong(rldata.getTimes());
			if(now >= st) {
				sqlmap.delete("List_Reserve_del", rldata.getNo());
			}
		}
	
		
		
		
		
		
		
		//최근본상품가져오기
		Cookie_Bean cb = Cookie_Bean.getInstance();
		
		
		//존재하지 않는것 삭제처리
		List list_viewd_no = cb.get_viewed_cookie(request, response);
		for(int i=list_viewd_no.size()-1;i>=0;i--) {
			int no = Integer.parseInt((String)list_viewd_no.get(i));
			int tmp = (int)sqlmap.queryForObject("List_getCountNo", no);
			if(tmp == 0) cb.del_viewed_cookie(no, request, response);
		}
		
		
		
		
		
		
		
		
		list_viewd_no = cb.get_viewed_cookie(request, response);
		viewed_list_all = new ArrayList();
		viewed_list = new ArrayList();
		int maxsize = 30;
		for(int i=list_viewd_no.size()-1;i>=0;i--) {
			List_Data ldata = (List_Data)sqlmap.queryForObject("List_getArticle", Integer.parseInt((String)list_viewd_no.get(i)));
			if(ldata.getSubject().length() > maxsize) ldata.setSubject(ldata.getSubject().substring(0, maxsize)+"...");
			viewed_list_all.add(ldata);
		}
		if(viewed_list_all.size() >= 2) {
			viewed_list.add(viewed_list_all.get(0));
			viewed_list.add(viewed_list_all.get(1));
		}
		if(viewed_list_all.size() == 1) {
			viewed_list.add(viewed_list_all.get(0));
		}
		viewed_list_cnt = viewed_list_all.size();
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getMsg() {
		return msg;
	}
	public String getUrl() {
		return url;
	}
	

	public String getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public String getDay() {
		return day;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getSearchs() {
		return searchs;
	}

	public void setSearchs(String searchs) {
		this.searchs = searchs;
	}

	public Member_Data getMember_info() {
		return member_info;
	}

	public void setMember_info(Member_Data member_info) {
		this.member_info = member_info;
	}

	public int getLevel() {
		return level;
	}

	public int getBasket_size() {
		return basket_size;
	}

	public String getSearchs_utf() {
		return searchs_utf;
	}

	public List getViewed_list() {
		return viewed_list;
	}

	public List getViewed_list_all() {
		return viewed_list_all;
	}

	public int getViewed_list_cnt() {
		return viewed_list_cnt;
	}
	
	
	
	
	
}
