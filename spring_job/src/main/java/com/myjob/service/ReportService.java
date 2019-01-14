package com.myjob.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.ReportDao;
import com.myjob.data.ReportData;

@Service
public class ReportService implements ReportDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Integer exist(ReportData rpdata) {
		return (Integer)sqlSessionTemplate.selectOne("ReportExist", rpdata);
	}

	@Override
	public void insert(ReportData rpdata) {
		sqlSessionTemplate.insert("ReportInsert", rpdata);
	}

}
