package net.mytour.dao;

import java.util.List;

import net.mytour.data.Member_Data;

public interface Member_Dao {
	Member_Data getArticle(String user_id, String user_pw);
	Integer getUserIdPwCount(String user_id, String user_pw);
	void changeInfo(Member_Data mdata);
	String getFindId(String name, String phone1, String phone2, String phone3);
	Integer getFindPw(String user_id, String name, String phone1, String phone2, String phone3, int quest, String answer);
	void changePw(Member_Data mdata);
	void insert(Member_Data mdata);
	Integer getUserIdCount(String user_id);
	Integer getCount();
	List getArticles(int start, int end);
	Member_Data getArticleNo(int no);
	void delete(int no);
}
