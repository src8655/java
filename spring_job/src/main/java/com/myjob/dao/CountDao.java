package com.myjob.dao;

public interface CountDao {
	void insert(String dates, int member_no);
	Integer getCount(String dates, int member_no);
}
