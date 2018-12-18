package net.myshop.dao;

import java.util.List;

import net.myshop.data.Faq_Data_Bean;


public interface Faq_DB {
	public int count_M(int search, String search_value, int category);
	public List getArticles_M(int start, int end, int search, String search_value, int category);
	public boolean insert_M(Faq_Data_Bean fdata);
	public Faq_Data_Bean getArticle_M(int no);
	public boolean update_M(Faq_Data_Bean fdata);
	public boolean delete_M(int no);
}
