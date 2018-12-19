package net.mytour.dao;

import java.util.List;

import net.mytour.data.Reserve_Data;

public interface Reserve_Dao {
	void insert(Reserve_Data rdata);
	Integer getStatusCount(int member_no, int status);
	Integer getCount(int member_no);
	List getArticles(int member_no, int start, int end);
	void setStatus(int no, int status);
	Reserve_Data getArticle(int no);
	Integer getCountAll(int status);
	List getArticlesAll(int status, int start, int end);
}
