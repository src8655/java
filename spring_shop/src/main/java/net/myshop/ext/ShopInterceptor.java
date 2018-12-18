package net.myshop.ext;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import net.myshop.dao.Cookies;
import net.myshop.dao.List_DB;
import net.myshop.dao.Member_DB;
import net.myshop.data.List_Data_Bean;
import net.myshop.data.Member_Data_Bean;


public class ShopInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	Member_DB member_DB_Bean;
	@Autowired
	List_DB list_DB_Bean;
	@Autowired
	Cookies cookie_Bean;
	
	public Calendar cal = Calendar.getInstance();
	public int year = cal.get(Calendar.YEAR);
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
	Member_Data_Bean member_info;
	
	int order = -1;
	
	
	private int basket_cnt;
	List rviewedListAll;
	List rviewedList;
	int rviewed_count;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		session = request.getSession();
		
		
		
		pages_int = Integer.parseInt(pages);
		
		
		//url���ڵ��� ���� ����
		searchs_values = URLEncoder.encode(searchs_value,"UTF-8");
		p_search_values = URLEncoder.encode(p_search_value,"UTF-8");
		
		
		//�α������� �ҷ�����
		member_info = member_DB_Bean.getLogin_M(session);
		request.setAttribute("member_info", member_info);
		
		
		//��ٱ��� ���� ���ϱ�
		//���������
		basket_cnt = 0;
		if(session.getAttribute("basket") == null) {
			basket_cnt = 0;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			basket_cnt = map.size();
		}
		
		
		
		//�ֱٺ��Խñ�
		List_DB ldb_tmp = list_DB_Bean;
		Cookies cb_tmp = cookie_Bean;
		List viewedListAll = cb_tmp.get_viewed_cookie(request, response);	//�ϴ� ��Ű���� �ް�
		
		//�ֱٺ��Խñ��� �����ϴ� �Խñ����� Ȯ��
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			int no = Integer.parseInt((String)viewedListAll.get(i));
			boolean isexist = ldb_tmp.existArticle_M(no);					//�����ϴ��� Ȯ��
			if(!isexist) cb_tmp.del_viewed_cookie(no, request, response);	//�������� ������ ��Ű���� ����
		}
		
		viewedListAll = cb_tmp.get_viewed_cookie(request, response);		//��Ű���� �ٽ� �޴´�
		
		List viewedList = new ArrayList();
		if(viewedListAll.size() > 2) {
			viewedList.add(viewedListAll.get(viewedListAll.size()-2));
			viewedList.add(viewedListAll.get(viewedListAll.size()-1));
		}else viewedList = viewedListAll;
		
		rviewedListAll = new ArrayList();
		rviewedList = new ArrayList();
		
		//�ֱٺ��Խñ� ���
		for(int i=viewedListAll.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle_M(Integer.parseInt((String)viewedListAll.get(i)));
			rviewedListAll.add(ldata);
		}
		for(int i=viewedList.size()-1;i>=0;i--) {
			List_Data_Bean ldata = ldb_tmp.getArticle_M(Integer.parseInt((String)viewedList.get(i)));
			rviewedList.add(ldata);
		}
		rviewed_count = rviewedListAll.size();

		
		
		
		
		
		
		request.setAttribute("rviewedListAll", rviewedListAll);
		request.setAttribute("rviewedList", rviewedList);
		request.setAttribute("rviewed_count", rviewed_count);
		request.setAttribute("basket_cnt", basket_cnt);
		
		
		return super.preHandle(request, response, handler);
	}

}
