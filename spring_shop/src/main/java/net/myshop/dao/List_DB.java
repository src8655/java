package net.myshop.dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.myshop.data.List_Data_Bean;


public interface List_DB {
	public List getArticles_M(int start, int end, int searchs, String searchs_value, int length, int sellers, int order);
	public void insert_M(List_Data_Bean ldata);
	public int getCount_M(int searchs, String searchs_value, int sellers, int order);
	public List_Data_Bean getArticle_M(int no);
	public boolean delete_M(int no);
	public boolean update_M(List_Data_Bean ldata);
	public boolean existArticle_M(int no);
	public boolean addHit_M(int no);
	public boolean addBuy_M(int no);
}
