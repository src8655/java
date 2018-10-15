package shop;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.struts2.interceptor.*;
import com.opensymphony.xwork2.Action;

import config.FactoryService;

public class Action_Index extends Action_Init implements Action, ServletRequestAware, ServletResponseAware  {
	private List best_list;
	private List best_list_1;
	private List best_list_2;
	private List best_list_3;
	private List best_list_4;
	private List best_list_5;
	private List best_list_6;
	private List best_list_7;
	private List best_list_8;

	private List list_1;
	private List list_2;
	private List list_3;
	private List list_4;
	private List list_5;
	private List list_6;
	private List list_7;
	private List list_8;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//SqlSession sqlSession = FactoryService.getFactory().openSession(true);
		
		//sqlSession.insert("insert1", "aaa");
		//sqlSession.close();
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();

		best_list = ldb.getArticles_M(1, 6, -1, "", 10, -1, 1);
		best_list_1 = ldb.getArticles_M(1, 6, 1, "", 10, -1, 1);
		best_list_2 = ldb.getArticles_M(1, 6, 2, "", 10, -1, 1);
		best_list_3 = ldb.getArticles_M(1, 6, 3, "", 10, -1, 1);
		best_list_4 = ldb.getArticles_M(1, 6, 4, "", 10, -1, 1);
		best_list_5 = ldb.getArticles_M(1, 6, 5, "", 10, -1, 1);
		best_list_6 = ldb.getArticles_M(1, 6, 6, "", 10, -1, 1);
		best_list_7 = ldb.getArticles_M(1, 6, 7, "", 10, -1, 1);
		best_list_8 = ldb.getArticles_M(1, 6, 8, "", 10, -1, 1);

		
		list_1 = ldb.getArticles_M(1, 5, 1, "", 10, -1, -1);
		list_2 = ldb.getArticles_M(1, 5, 2, "", 10, -1, -1);
		list_3 = ldb.getArticles_M(1, 5, 3, "", 10, -1, -1);
		list_4 = ldb.getArticles_M(1, 5, 4, "", 10, -1, -1);
		list_5 = ldb.getArticles_M(1, 5, 5, "", 10, -1, -1);
		list_6 = ldb.getArticles_M(1, 5, 6, "", 10, -1, -1);
		list_7 = ldb.getArticles_M(1, 5, 7, "", 10, -1, -1);
		list_8 = ldb.getArticles_M(1, 5, 8, "", 10, -1, -1);

		
		return SUCCESS;
	}

	public List getBest_list() {
		return best_list;
	}

	public List getBest_list_1() {
		return best_list_1;
	}

	public List getBest_list_2() {
		return best_list_2;
	}

	public List getBest_list_3() {
		return best_list_3;
	}

	public List getBest_list_4() {
		return best_list_4;
	}

	public List getBest_list_5() {
		return best_list_5;
	}

	public List getBest_list_6() {
		return best_list_6;
	}

	public List getBest_list_7() {
		return best_list_7;
	}

	public List getBest_list_8() {
		return best_list_8;
	}

	public List getList_1() {
		return list_1;
	}

	public List getList_2() {
		return list_2;
	}

	public List getList_3() {
		return list_3;
	}

	public List getList_4() {
		return list_4;
	}

	public List getList_5() {
		return list_5;
	}

	public List getList_6() {
		return list_6;
	}

	public List getList_7() {
		return list_7;
	}

	public List getList_8() {
		return list_8;
	}


}
