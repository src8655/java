package com.myjob.dao;

import java.util.List;

import com.myjob.data.CompanyData;

public interface CompanyDao {
	void insert(CompanyData cdata);
	List getArticles(int start, int end, String searchValue);
	Integer getCount(String searchValue);
	CompanyData getArticle(int member_no);
	void update(CompanyData cdata);
}
