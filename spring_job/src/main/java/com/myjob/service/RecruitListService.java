package com.myjob.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public Integer getExistCount(int recruit_no, int writer_no) {
		Map map = new HashMap();
		map.put("recruit_no", recruit_no);
		map.put("writer_no", writer_no);
		return (Integer)sqlSessionTemplate.selectOne("RecruitListExistCount", map);
	}

	@Override
	public Integer getCount(int recruit_no) {
		Map map = new HashMap();
		map.put("recruit_no", recruit_no);
		return (Integer)sqlSessionTemplate.selectOne("RecruitListGetCount", map);
	}

	@Override
	public List getArticles(int recruit_no, int start, int end) {
		Map map = new HashMap();
		map.put("recruit_no", recruit_no);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("RecruitListGetArticles", map);
	}

}
