package shop;

public class View_Qna_Data_Bean {
	private int no;
	private int product_no;
	private int guest_no;
	private String guest_id;
	private int category;
	private String memo;
	private int secret = 0;
	private String dates;
	private String answer;
	private int isanswer = 0;
	private int sellers_no;
	private String subject = "";
	private int whos = -1;
	
	
	public int getWhos() {
		return whos;
	}
	public void setWhos(int whos) {
		this.whos = whos;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSellers_no() {
		return sellers_no;
	}
	public void setSellers_no(int sellers_no) {
		this.sellers_no = sellers_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getProduct_no() {
		return product_no;
	}
	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	public int getGuest_no() {
		return guest_no;
	}
	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}
	public String getGuest_id() {
		return guest_id;
	}
	public void setGuest_id(String guest_id) {
		this.guest_id = guest_id;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getSecret() {
		return secret;
	}
	public void setSecret(int secret) {
		this.secret = secret;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getIsanswer() {
		return isanswer;
	}
	public void setIsanswer(int isanswer) {
		this.isanswer = isanswer;
	}
	
	
}
