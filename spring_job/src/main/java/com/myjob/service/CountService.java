package com.myjob.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.CountDao;
import com.myjob.data.CountData;

@Service
public class CountService implements CountDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(String dates, int member_no) {
		CountData cntdata = new CountData();
		cntdata.setDates(dates);
		cntdata.setMember_no(member_no);
		sqlSessionTemplate.insert("CountInsert", cntdata);
	}

	@Override
	public Integer getCount(String dates, int member_no) {
		CountData cntdata = new CountData();
		cntdata.setDates(dates);
		cntdata.setMember_no(member_no);
		return (Integer)sqlSessionTemplate.selectOne("CountGetCount", cntdata);
	}

}
