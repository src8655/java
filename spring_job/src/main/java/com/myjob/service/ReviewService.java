package com.myjob.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.ReviewDao;

@Service
public class ReviewService implements ReviewDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

}
