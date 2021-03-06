package com.myjob.dao;

import java.util.List;

import com.myjob.data.MemberData;
import com.myjob.data.RecruitData;

public interface RecruitDao {
	void insert(RecruitData rcdata);
	Integer exist(int member_no);
	RecruitData getArticle(int member_no);
	String getEnddates(int member_no);
	RecruitData getArticleNo(int no);
	void update(RecruitData rcdata);
	void del(int no);
	void end(int no, int status);
	Integer getCount(String searchValue, int search, int searchType, int searchSort, int status);
	List getArticles(int start, int end, String searchValue, int search, int searchType, int searchSort, int status);
	List getListArticles(int start, int end, int member_no, int status);
	Integer getListCount(int member_no, int status);
	List getMyArticles(int writer_no, int start, int end);
	Integer getMyCount(int writer_no);
	void deleteUser(MemberData mdata);
}
