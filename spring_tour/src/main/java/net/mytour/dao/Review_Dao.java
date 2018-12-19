package net.mytour.dao;

import java.util.List;

import net.mytour.data.Review_Data;

public interface Review_Dao {
	Integer getCount(int list_no);
	List getArticles(int start, int end, int list_no);
	void insert(Review_Data rvdata);
}
