package shop;

import java.util.List;
import org.apache.struts2.interceptor.*;
import com.opensymphony.xwork2.Action;

public class Action_View extends Action_Init implements Action, ServletRequestAware, ServletResponseAware  {
	private int no = -1;
	private int tab = 1;
	private List_Data_Bean ldata;
	
	private int board_total;
	private int board_cnt;

	private int board_lengths;
	private int board_starts;
	private int board_ends;
	private int board_paging;

	private int pstarts;
	private int pends;
	private List list;

	private int member_orders = -1;
	private Member_Data_Bean mdata = null;
	private Member_Data_Bean sellers;
	
	
	
	private int review_total;
	private int review_cnt;

	private int review_lengths;
	private int review_starts;
	private int review_ends;
	private int review_paging;

	private int review_pstarts;
	private int review_pends;
	private List review_list;
	
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		if(request.getParameter("tab") != null)
			if(!request.getParameter("tab").equals(""))
				tab = Integer.parseInt(request.getParameter("tab"));
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldata = ldb.getArticle(no);
		
		Cookie_Bean cb = Cookie_Bean.getInstance();
		if(no != -1) {
			cb.view_cookie(no, request, response);		//조회수 중복방지 쿠키작업
			cb.viewed_cookie(no, request, response);	//최근본게시글 쿠키작업
		}
		
		
		
		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		
		board_total = vqdb.count(no);	//총 개수
		board_cnt = 0;						//no를 위한 카운트

		board_lengths = 10;	//한번에 보일 리스트 개수
		board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//시작지점
		board_ends = board_starts+board_lengths-1;										//마지막지점
		board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//페이지 링크 개수

		pstarts = Integer.parseInt(pages)-5;
		pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
		

		list = vqdb.getArticles(board_starts, board_ends, no, member_info);	//리스트받아오기

		
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
		
		review_total = vrdb.count(no);	//총 개수
		review_cnt = 0;						//no를 위한 카운트

		review_lengths = 10;	//한번에 보일 리스트 개수
		review_starts = ((Integer.parseInt(pages))*review_lengths)-review_lengths+1;			//시작지점
		review_ends = review_starts+review_lengths-1;										//마지막지점
		review_paging = (int)Math.ceil((double)review_total/(double)review_lengths);	//페이지 링크 개수

		review_pstarts = Integer.parseInt(pages)-5;
		review_pends = Integer.parseInt(pages)+5;
		if(review_pstarts <= 0) review_pstarts = 1;
		if(review_pends > review_paging) review_pends = review_paging;
		

		review_list = vrdb.getArticles(review_starts, review_ends, no);	//리스트받아오기
		
		
		
		
		
		//판매자정보 가져오기
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		sellers = mdb.getArticle(ldata.getSellers());
		
		
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
	public int getBoard_total() {
		return board_total;
	}
	public void setBoard_total(int board_total) {
		this.board_total = board_total;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	public int getBoard_lengths() {
		return board_lengths;
	}
	public void setBoard_lengths(int board_lengths) {
		this.board_lengths = board_lengths;
	}
	public int getBoard_starts() {
		return board_starts;
	}
	public void setBoard_starts(int board_starts) {
		this.board_starts = board_starts;
	}
	public int getBoard_ends() {
		return board_ends;
	}
	public void setBoard_ends(int board_ends) {
		this.board_ends = board_ends;
	}
	public int getBoard_paging() {
		return board_paging;
	}
	public void setBoard_paging(int board_paging) {
		this.board_paging = board_paging;
	}
	public int getPstarts() {
		return pstarts;
	}
	public void setPstarts(int pstarts) {
		this.pstarts = pstarts;
	}
	public int getPends() {
		return pends;
	}
	public void setPends(int pends) {
		this.pends = pends;
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
	public int getReview_total() {
		return review_total;
	}
	public void setReview_total(int review_total) {
		this.review_total = review_total;
	}
	public int getReview_cnt() {
		return review_cnt;
	}
	public void setReview_cnt(int review_cnt) {
		this.review_cnt = review_cnt;
	}
	public int getReview_lengths() {
		return review_lengths;
	}
	public void setReview_lengths(int review_lengths) {
		this.review_lengths = review_lengths;
	}
	public int getReview_starts() {
		return review_starts;
	}
	public void setReview_starts(int review_starts) {
		this.review_starts = review_starts;
	}
	public int getReview_ends() {
		return review_ends;
	}
	public void setReview_ends(int review_ends) {
		this.review_ends = review_ends;
	}
	public int getReview_paging() {
		return review_paging;
	}
	public void setReview_paging(int review_paging) {
		this.review_paging = review_paging;
	}
	public int getReview_pstarts() {
		return review_pstarts;
	}
	public void setReview_pstarts(int review_pstarts) {
		this.review_pstarts = review_pstarts;
	}
	public int getReview_pends() {
		return review_pends;
	}
	public void setReview_pends(int review_pends) {
		this.review_pends = review_pends;
	}
	public List getReview_list() {
		return review_list;
	}
	public void setReview_list(List review_list) {
		this.review_list = review_list;
	}

}
