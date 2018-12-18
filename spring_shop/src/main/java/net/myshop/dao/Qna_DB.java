package net.myshop.dao;

import java.util.List;

import net.myshop.data.Qna_Data_Bean;


public interface Qna_DB {
	public int count_M(int guest_no);
	public List getArticles_M(int start, int end, int length, int guest_no);
	public boolean insert_M(Qna_Data_Bean qdata);
	public Qna_Data_Bean getArticle_M(int no);
	public boolean update_M(Qna_Data_Bean qdata);
	public boolean delete_M(int no);
	public boolean answer_M(Qna_Data_Bean qdata);
	public boolean answerDel_M(int no);
}
