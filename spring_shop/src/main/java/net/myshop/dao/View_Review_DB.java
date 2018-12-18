package net.myshop.dao;

import java.util.List;

import net.myshop.data.View_Review_Data_Bean;

public interface View_Review_DB {
	public int count_M(int product_no);
	public List getArticles_M(int start, int end, int product_no);
	public boolean insert_M(View_Review_Data_Bean vrdata);
	public View_Review_Data_Bean getArticle_M(int no);
}
