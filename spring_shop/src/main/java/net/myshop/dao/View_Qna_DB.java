package net.myshop.dao;

import java.util.List;

import net.myshop.data.Member_Data_Bean;
import net.myshop.data.View_Qna_Data_Bean;

public interface View_Qna_DB {
	public int count_M(int product_no);
	public List getArticles_M(int start, int end, int product_no, Member_Data_Bean mdata);
	public boolean insert_M(View_Qna_Data_Bean vqdata);
	public View_Qna_Data_Bean getArticle_M(int no);
	public boolean delete_M(int no);
	public boolean answer_M(View_Qna_Data_Bean vqdata);
}
