package net.myshop.dao;

import java.util.List;

import net.myshop.data.Sell_Data_Bean;


public interface Sell_DB {
	public List getArticles2_M(int start, int end, int sellers_no, int status);
	public int count2_M(int sellers_no, int status);
	public boolean changeStatus_M(int no, int status);
	public boolean changeShipStatus_M(int no, String ship_num);
	public boolean insert_M(Sell_Data_Bean sdata);
	public List getArticles_M(int start, int end, int guest_no);
	public int guest_sell_count_M(int guest_no, int status);
	public int count_M(int guest_no);
	public List getArticles3_M(String times);
	public Sell_Data_Bean getArticle_M(int no);
	public boolean delete_M(Sell_Data_Bean sdata);
	public int group_count_M(String times);
	public boolean updateReview_M(int no);
	public boolean changeStatus_M(String times, int status);
	public int group_count_M2(int start, int end, String times, int guest_no);
	public String number_format(int dSource);
}
