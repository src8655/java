package com.myjob.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.RecruitListDao;
import com.myjob.data.RecruitListData;

@Service
public class RecruitListService implements RecruitListDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(RecruitListData rcldata) {
		sqlSessionTemplate.insert("RecruitListInsert", rcldata);
	}

}
