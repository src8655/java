package com.myjob.dao;

import java.util.List;

import com.myjob.data.MemberData;
import com.myjob.data.ReviewData;

public interface ReviewDao {
	void insert(ReviewData rdata);
	Integer getCount(int member_no);
	List getArticles(int member_no, int start, int end);
	Integer getMyCount(int member_no, int writer_no);
	ReviewData getAllStars(int member_no);
	ReviewData getIndexArticle(int member_no);
	void deleteUser(MemberData mdata);
	ReviewData getArticleNo(int no);
}
