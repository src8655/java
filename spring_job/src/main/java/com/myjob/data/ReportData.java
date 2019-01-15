package com.myjob.data;

public class ReportData {
	private int no = -1;
	private int member_no = -1;
	private int writer_no = -1;
	private int tab = -1;
	private int report_value = -1;
	private String dates = "";
	private int tab_no = -1;
	
	private String company = "";
	private int company_cate = -1;
	private String file1 = "";
	private double avg_stars = 0;
	private int avg_stars_p = 0;
	private MemberData mdata;
	
	public MemberData getMdata() {
		return mdata;
	}
	public void setMdata(MemberData mdata) {
		this.mdata = mdata;
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
	public String getFile1() {
		return file1;
	}
	public void setFile1(String file1) {
		this.file1 = file1;
	}
	public double getAvg_stars() {
		return avg_stars;
	}
	public void setAvg_stars(double avg_stars) {
		this.avg_stars = avg_stars;
	}
	public int getAvg_stars_p() {
		return avg_stars_p;
	}
	public void setAvg_stars_p(int avg_stars_p) {
		this.avg_stars_p = avg_stars_p;
	}
	public int getTab_no() {
		return tab_no;
	}
	public void setTab_no(int tab_no) {
		this.tab_no = tab_no;
	}
	public int getNo() {
		return no;
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
	public int getWriter_no() {
		return writer_no;
	}
	public void setWriter_no(int writer_no) {
		this.writer_no = writer_no;
	}
	public int getTab() {
		return tab;
	}
	public void setTab(int tab) {
		this.tab = tab;
	}
	public int getReport_value() {
		return report_value;
	}
	public void setReport_value(int report_value) {
		this.report_value = report_value;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	
	
}
