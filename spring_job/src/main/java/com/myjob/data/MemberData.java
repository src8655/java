package com.myjob.data;

import java.util.ArrayList;

public class MemberData {
	private int no = -1;
	private String email = "";
	private String password = "";
	private String password2 = "";
	private String name = "";
	private String phone1 = "";
	private String phone2 = "";
	private String phone3 = "";
	private int quest = -1;
	private String answer = "";
	private String company = "";
	private int company_cate = -1;
	private String company_num = "";
	private int orders = -1;
	private String dates = "";
	private String follow = "";
	
	private ArrayList follow_list;
	
	public ArrayList getFollow_list() {
		return follow_list;
	}
	public void setFollow_list(ArrayList follow_list) {
		this.follow_list = follow_list;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public int getQuest() {
		return quest;
	}
	public void setQuest(int quest) {
		this.quest = quest;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
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
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	
	
}
