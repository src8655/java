package net.mytour.dao;

import java.util.List;

import net.mytour.data.List_Data;

public interface List_Dao {
	List getArticlesHit(int start, int end, int category);
	List getArticlesBuy(int start, int end);
	List getArticleHot();
	int getHit(int no);
	void setHit(int no, int hit);
	Integer getCountNo(int no);
	List_Data getArticle(int no);
	Integer getCount(int category, String searchs);
	List getArticles(int start, int end, int category, String searchs);
	Integer getBuy(int no);
	void setBuy(int buy, int no);
	void insert(List_Data ldata);
	void edit(List_Data ldata);
	void del(int no);
}
