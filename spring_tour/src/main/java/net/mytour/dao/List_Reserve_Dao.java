package net.mytour.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mytour.data.List_Reserve_Data;

public interface List_Reserve_Dao {
	List getArticlesMain(int cnt);
	List getArticlesCheck();
	void Reserve_del(int no);
	Integer getCountAll(String startdates, int days, int category, int money, String subject);
	List getArticlesAll(String startdates, int days, int category, int money, String subject, int start, int end);
	List getArticles(int no);
	List_Reserve_Data getArticle(int no);
	void setIsreserve(int no, int isreserve);
	void insert(List_Reserve_Data lrdata);
	void del(int no);
}
