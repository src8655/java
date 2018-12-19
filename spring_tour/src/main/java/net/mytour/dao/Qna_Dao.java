package net.mytour.dao;

import java.util.List;

import net.mytour.data.Qna_Data;

public interface Qna_Dao {
	Integer getCount(int member_no, int status);
	List getArticles(int member_no, int status, int start, int end);
	void insert(Qna_Data qdata);
	Qna_Data getArticle(int no);
	void update(Qna_Data qdata);
	void delete(int no);
	void answer(Qna_Data qdata);
	void answerDel(Qna_Data qdata);
}
