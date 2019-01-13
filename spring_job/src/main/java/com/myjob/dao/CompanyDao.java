package com.myjob.dao;

import java.util.List;

import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;

public interface CompanyDao {
	void insert(CompanyData cdata);
	List getArticles(int start, int end, String searchValue, int search, int searchType, int searchSort);
	Integer getCount(String searchValue, int search, int searchType, int searchSort);
	CompanyData getArticle(int member_no);
	void update(CompanyData cdata);
	List getFollows(String member_no, int start, int end);
	Integer getFollowsCount(String member_no);
	void deleteUser(MemberData mdata);
}
