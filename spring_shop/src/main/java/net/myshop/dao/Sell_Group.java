package net.myshop.dao;

import java.util.List;

import net.myshop.data.Sell_Data_Bean;
import net.myshop.data.Sell_Group_Data_Bean;


public interface Sell_Group {
	public String number_format(int dSource);
	public boolean insert_M(Sell_Group_Data_Bean sgdata);
	public Sell_Group_Data_Bean getArticle_M(String times);
	public boolean setPoint_M(int no, int point);
	public boolean delete_M(String times);
	public boolean delete_sell_M(Sell_Data_Bean sdata);
	public List getPayArticles_M(int status);
	public boolean changeStatus_M(String times, int status);
}
