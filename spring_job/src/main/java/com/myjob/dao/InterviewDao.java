package com.myjob.dao;

import java.util.List;

import com.myjob.data.InterviewData;
import com.myjob.data.MemberData;

public interface InterviewDao {
	void insert(InterviewData itdata);
	Integer getCount(int member_no);
	List getArticles(int member_no, int start, int end);
	Integer getMyCount(int member_no, int writer_no);
	Double getDifficulty(int member_no);
	Integer getInterviewdir(int member_no, int interviewdir);
	Integer getInterviewex(int member_no, int interviewex);
	Integer getInterviewresult(int member_no, int interviewresult);
	void deleteUser(MemberData mdata);
	InterviewData getArticleNo(int no);
}
