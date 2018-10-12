package shop;

public class Qna_Data_Bean {
	private int no;
	private String subject;
	private String memo;
	private String answer;
	private int isanswer = 0;
	private String dates;
	private int guest_no;
	private int category;
	
	private String memos = "";
	private String answers = "";
	
	
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	public String getMemos() {
		return memos;
	}
	public void setMemos(String memos) {
		this.memos = memos;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public int getGuest_no() {
		return guest_no;
	}
	public void setGuest_no(int guest_no) {
		this.guest_no = guest_no;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
}
