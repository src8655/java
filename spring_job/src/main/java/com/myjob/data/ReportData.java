package com.myjob.data;

public class ReportData {
	private int no = -1;
	private int member_no = -1;
	private int writer_no = -1;
	private int tab = -1;
	private int report_value = -1;
	private String dates = "";
	private int tab_no = -1;
	
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
