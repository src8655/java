package com.myjob.data;

public class CompanyData {
	private int no = -1;
	private int member_no = -1;
	private String url = "";
	private String info = "";
	private String name = "";
	private String founding = "";
	private String count = "";
	private int company_type = -1;
	private String money = "";
	private String addr = "";
	private String file1 = "";
	private String file2 = "";
	
	private String company = "";
	private int company_cate = -1;
	private String company_num = "";
	
	private int count_review = 0;
	private int count_income = 0;
	private int count_interview = 0;
	private double avg_stars = 0;
	private int avg_money = 0;

	private int avg_stars_p = 0;
	private String avg_moneys = "";
	
	private int isfollow = -1;
	
	private ReviewData rdata;
	
	
	public ReviewData getRdata() {
		return rdata;
	}

	public void setRdata(ReviewData rdata) {
		this.rdata = rdata;
	}

	public int getIsfollow() {
		return isfollow;
	}

	public void setIsfollow(int isfollow) {
		this.isfollow = isfollow;
	}

	public int getAvg_stars_p() {
		return avg_stars_p;
	}

	public void setAvg_stars_p(int avg_stars_p) {
		this.avg_stars_p = avg_stars_p;
	}

	public int getAvg_money() {
		return avg_money;
	}

	public void setAvg_money(int avg_money) {
		this.avg_money = avg_money;
	}

	public String getAvg_moneys() {
		return avg_moneys;
	}

	public void setAvg_moneys(String avg_moneys) {
		this.avg_moneys = avg_moneys;
	}

	public int getCount_review() {
		return count_review;
	}

	public void setCount_review(int count_review) {
		this.count_review = count_review;
	}

	public int getCount_income() {
		return count_income;
	}

	public void setCount_income(int count_income) {
		this.count_income = count_income;
	}

	public int getCount_interview() {
		return count_interview;
	}

	public void setCount_interview(int count_interview) {
		this.count_interview = count_interview;
	}

	public double getAvg_stars() {
		return avg_stars;
	}

	public void setAvg_stars(double avg_stars) {
		this.avg_stars = avg_stars;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCompany_cate() {
		return company_cate;
	}

	public void setCompany_cate(int company_cate) {
		this.company_cate = company_cate;
	}

	public String getCompany_num() {
		return company_num;
	}

	public void setCompany_num(String company_num) {
		this.company_num = company_num;
	}

	public int getNo() {
		return no;
	}
	
	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public void setNo(int no) {
		this.no = no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFounding() {
		return founding;
	}
	public void setFounding(String founding) {
		this.founding = founding;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public int getCompany_type() {
		return company_type;
	}
	public void setCompany_type(int company_type) {
		this.company_type = company_type;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
