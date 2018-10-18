package shop;

import java.util.List;
import org.apache.struts2.interceptor.*;
import com.opensymphony.xwork2.Action;

public class Action_View extends Action_Init implements Action, ServletRequestAware, ServletResponseAware  {
	private int no = -1;
	private int tab = 1;
	private List_Data_Bean ldata;
	
	private Action_Paging paging;
	private List list;

	private int member_orders = -1;
	private Member_Data_Bean mdata = null;
	private Member_Data_Bean sellers;
	

	private Action_Paging review_paging;
	private List review_list;
	
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldata = ldb.getArticle_M(no);
		
		Cookie_Bean cb = Cookie_Bean.getInstance();
		if(no != -1) {
			cb.view_cookie(no, request, response);		//조회수 중복방지 쿠키작업
			cb.viewed_cookie(no, request, response);	//최근본게시글 쿠키작업
		}
		
		
		
		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		paging = new Action_Paging(vqdb.count_M(no), 10, Integer.parseInt(pages));	//페이징 만들기
		list = vqdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), no, member_info);	//리스트받아오기

		
		//회원종류
		if(member_info != null)
			member_orders = member_info.getOrders();
		
		
		//비회원은 가상의 회원데이터 만들기
		//(null 참조 에러 방지)
		if(member_info == null) 
			mdata = new Member_Data_Bean();
		else
			mdata = member_info;
		
		
		View_Review_DB_Bean vrdb = View_Review_DB_Bean.getInstance();
		review_paging = new Action_Paging(vrdb.count_M(no), 10, Integer.parseInt(pages));	//페이징 만들기
		review_list = vrdb.getArticles_M(review_paging.getBoard_starts(), review_paging.getBoard_ends(), no);	//리스트받아오기
		
		
		//판매자정보 가져오기
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		sellers = mdb.getArticle_M(ldata.getSellers());
		
		
		return SUCCESS;
	}


	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getTab() {
		return tab;
	}
	public void setTab(int tab) {
		this.tab = tab;
	}
	public List_Data_Bean getLdata() {
		return ldata;
	}
	public void setLdata(List_Data_Bean ldata) {
		this.ldata = ldata;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getMember_orders() {
		return member_orders;
	}
	public void setMember_orders(int member_orders) {
		this.member_orders = member_orders;
	}
	public Member_Data_Bean getMdata() {
		return mdata;
	}
	public void setMdata(Member_Data_Bean mdata) {
		this.mdata = mdata;
	}
	public Member_Data_Bean getSellers() {
		return sellers;
	}
	public void setSellers(Member_Data_Bean sellers) {
		this.sellers = sellers;
	}
	public List getReview_list() {
		return review_list;
	}
	public void setReview_list(List review_list) {
		this.review_list = review_list;
	}


	public Action_Paging getPaging() {
		return paging;
	}


	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}


	public Action_Paging getReview_paging() {
		return review_paging;
	}


	public void setReview_paging(Action_Paging review_paging) {
		this.review_paging = review_paging;
	}

}
