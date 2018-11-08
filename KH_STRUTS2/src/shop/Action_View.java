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
	
	//review
	//int no = -1;
	int product_no = -1;
	//List_Data_Bean ldata;
	
	//review_post
	//int no = -1;
	//int product_no = -1;
	int stars = -1;
	String review1 = "";
	String review2 = "";
	String memo = "";
	int res = 0;
	
	//qna_write
	//int no = -1;
	String sellers_no = "";
	
	//qna_write_post
	//int product_no = -1;
	int sellers_no2 = -1;
	int category = -1;
	//String memo = "";
	int secret = 0;
	//int res = 0;
	
	//qna_del
	/*int product_no = -1;
	int no = -1;
	int res = 0;*/
	
	//qna_answer
	//int no = -1;
	//String product_no = "";
	
	//qna_answer_post
	/*int product_no = -1;
	int no = -1;
	String memo = "";
	int res = 0;*/
	
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldata = ldb.getArticle_M(no);
		
		Cookie_Bean cb = Cookie_Bean.getInstance();
		if(no != -1) {
			cb.view_cookie(no, request, response);		//��ȸ�� �ߺ����� ��Ű�۾�
			cb.viewed_cookie(no, request, response);	//�ֱٺ��Խñ� ��Ű�۾�
		}
		
		
		
		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		paging = new Action_Paging(vqdb.count_M(no), 10, Integer.parseInt(pages));	//����¡ �����
		list = vqdb.getArticles_M(paging.getBoard_starts(), paging.getBoard_ends(), no, member_info);	//����Ʈ�޾ƿ���

		
		//ȸ������
		if(member_info != null)
			member_orders = member_info.getOrders();
		
		
		//��ȸ���� ������ ȸ�������� �����
		//(null ���� ���� ����)
		if(member_info == null) 
			mdata = new Member_Data_Bean();
		else
			mdata = member_info;
		
		
		View_Review_DB_Bean vrdb = View_Review_DB_Bean.getInstance();
		review_paging = new Action_Paging(vrdb.count_M(no), 10, Integer.parseInt(pages));	//����¡ �����
		review_list = vrdb.getArticles_M(review_paging.getBoard_starts(), review_paging.getBoard_ends(), no);	//����Ʈ�޾ƿ���
		
		
		//�Ǹ������� ��������
		Member_DB_Bean mdb = Member_DB_Bean.getInstance();
		sellers = mdb.getArticle_M(ldata.getSellers());
		
		
		return SUCCESS;
	}
	public String review() throws Exception {
		super.run();
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldata = ldb.getArticle_M(product_no);
		
		return SUCCESS;
	}
	public String review_post() throws Exception {
		super.run();
		
		//ȸ������
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//�߸��� ���� ����
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(product_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(stars == -1) {
			msg = "��ǰ�򰡸� �������ּ���";
			return ERROR;
		}
		if(review1.equals("")) {
			msg = "�������򰡸� �Է��� �ּ���.";
			return ERROR;
		}
		if(review2.equals("")) {
			msg = "�������򰡸� �Է��� �ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "������ �Է��� �ּ���.";
			return ERROR;
		}
		
		//���ų����� �����ϴ��� Ȯ��
		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		Sell_Data_Bean sdata = sdb.getArticle_M(no);
		
		//�� ���ų����� �ƴϸ�
		if(sdata.getGuest_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		//�̹� ���䰡 �����ϸ�
		if(sdata.getHasreview() != 0) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		//�ݼ��� ���̵�
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		View_Review_DB_Bean vrdb = View_Review_DB_Bean.getInstance();
		View_Review_Data_Bean vrdata = new View_Review_Data_Bean();
		vrdata.setDates(year+"-"+month+"-"+day);
		vrdata.setGuest_no(member_info.getNo());
		vrdata.setMemo(memo);
		vrdata.setProduct_no(product_no);
		vrdata.setReview1(review1);
		vrdata.setReview2(review2);
		vrdata.setStars(stars);
		vrdata.setGuest_id(guest_id);
		
		
		
		if(vrdb.insert_M(vrdata)) {
			sdb.updateReview_M(no);	//���ų����� ���䰡 �ۼ��Ǿ��ٴ°��� ����
			res = 1;
		}
		
		return SUCCESS;
	}
	public String qna_write() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String qna_write_post() throws Exception {
		super.run();
		
		//ȸ������
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//�߸��� ���� ����
		if(product_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(sellers_no2 == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		//������ �Է��ߴ���
		if(category == -1) {
			msg = "�з��� ������ �ּ���.";
			return ERROR;
		}
		if(memo.equals("")) {
			msg = "������ �Է��� �ּ���.";
			return ERROR;
		}
		
		
		int guest_no = member_info.getNo();
		String guest_id = member_info.getUser_id().substring(0, 3)+"***";
		
		
		//�����͸� ��� ����
		View_Qna_Data_Bean vqdata = new View_Qna_Data_Bean();
		vqdata.setProduct_no(product_no);
		vqdata.setSellers_no(sellers_no2);
		vqdata.setCategory(category);
		vqdata.setMemo(memo);
		vqdata.setSecret(secret);
		vqdata.setGuest_no(guest_no);
		vqdata.setGuest_id(guest_id);
		vqdata.setDates(year+"-"+month+"-"+day);

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		
		
		if(vqdb.insert_M(vqdata)) res = 1;
		
		
		return SUCCESS;
	}
	public String qna_del() throws Exception {
		super.run();
		
		//ȸ������
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//�߸��� ���� ����
		if(product_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		View_Qna_Data_Bean vqdata = vqdb.getArticle_M(no);
		
		//�� ȸ����ȣ�ϰ� �Խñ��� ȸ����ȣ�ϰ� �ٸ���
		if(vqdata.getGuest_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		
		//����
		
		if(vqdb.delete_M(no)) res = 1;
		
		if(res == 1) {
			msg = "���� ����.";
			url = "view.o?no="+product_no+"&tab=3&pages="+pages;
			return SUCCESS;
		}else{
			msg = "���� ����.";
			return ERROR;
		}
	}
	public String qna_answer() throws Exception {
		super.run();
		
		
		return SUCCESS;
	}
	public String qna_answer_post() throws Exception {
		super.run();
		
		
		//ȸ������
		if(member_info == null) {
			msg = "�α��� ���ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}

		//�߸��� ���� ����
		if(product_no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		
		View_Qna_DB_Bean vqdb = View_Qna_DB_Bean.getInstance();
		View_Qna_Data_Bean vqdata =  vqdb.getArticle_M(no);
		
		//�亯�ڰ� �ƴϸ�
		if(vqdata.getSellers_no() != member_info.getNo()) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		vqdata = new View_Qna_Data_Bean();
		vqdata.setNo(no);
		vqdata.setAnswer(memo);
		vqdata.setIsanswer(1);
		
		
		if(vqdb.answer_M(vqdata)) res = 1;


		
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
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public String getReview1() {
		return review1;
	}
	public void setReview1(String review1) {
		this.review1 = review1;
	}
	public String getReview2() {
		return review2;
	}
	public void setReview2(String review2) {
		this.review2 = review2;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public String getSellers_no() {
		return sellers_no;
	}
	public void setSellers_no(String sellers_no) {
		this.sellers_no = sellers_no;
	}
	public int getSellers_no2() {
		return sellers_no2;
	}
	public void setSellers_no2(int sellers_no2) {
		this.sellers_no2 = sellers_no2;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}

}
