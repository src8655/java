package com.myjob.dao;

import java.util.List;

import com.myjob.data.MemberData;
import com.myjob.data.RecruitListData;

public interface RecruitListDao {
	void insert(RecruitListData rcldata);
	Integer getExistCount(int recruit_no, int writer_no);
	Integer getCount(int recruit_no);
	List getArticles(int recruit_no, int start, int end);
	void deleteRecruit(int recruit_no);
	void deleteUser(MemberData mdata);
}
