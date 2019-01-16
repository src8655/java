package com.myjob.dao;

import java.util.List;

import com.myjob.data.MemberData;
import com.myjob.data.ReportData;

public interface ReportDao {
	Integer exist(ReportData rpdata);
	void insert(ReportData rpdata);
	List getArticles(int start, int end, int tab);
	Integer getCount(int tab);
	ReportData getArticle(int no, int tab);
	void delete(int tab_no, int tab);
	void deleteNo(int no);
	void deleteUser(MemberData mdata);
}
