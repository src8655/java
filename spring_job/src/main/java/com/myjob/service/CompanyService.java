package com.myjob.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.CompanyDao;
import com.myjob.data.CompanyData;


@Service
public class CompanyService implements CompanyDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(CompanyData cdata) {
		sqlSessionTemplate.insert("CompanyInsert", cdata);
	}

}
