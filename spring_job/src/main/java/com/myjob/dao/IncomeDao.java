package com.myjob.dao;

import java.util.List;
import java.util.Map;

import com.myjob.data.IncomeData;

public interface IncomeDao {
	void insert(IncomeData idata);
	Integer getMyCount(int member_no, int writer_no);
	Integer getCount(int member_no);
	List getArticles(int member_no);
	Map getMoneyMaxMin(int member_no);
	Integer getRank(int member_no);
}
