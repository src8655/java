package com.myjob.dao;

import java.util.List;

import com.myjob.data.ReportData;

public interface ReportDao {
	Integer exist(ReportData rpdata);
	void insert(ReportData rpdata);
	List getArticles(int start, int end, int tab);
	Integer getCount(int tab);
	ReportData getArticle(int no, int tab);
}
