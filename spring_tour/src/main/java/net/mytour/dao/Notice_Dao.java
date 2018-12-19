package net.mytour.dao;

import java.util.List;

import net.mytour.data.Notice_Data;

public interface Notice_Dao {
	List getArticlesMain(int start, int end);
	Integer getCount();
	List getArticles(int start, int end);
	void insert(Notice_Data ndata);
	Notice_Data getArticle(int no);
	void update(Notice_Data ndata);
	void delete(Notice_Data ndata);
}
