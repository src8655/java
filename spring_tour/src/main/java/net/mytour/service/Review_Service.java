package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.Review_Dao;
import net.mytour.data.Review_Data;
@Service
public class Review_Service implements Review_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Integer getCount(int list_no) {
		Map map = new HashMap();
		map.put("list_no", list_no);
		return (Integer)sqlSessionTemplate.selectOne("Review_getCount", map);
	}

	@Override
	public List getArticles(int start, int end, int list_no) {
		Map map = new HashMap();
		map.put("list_no", list_no);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Review_getArticles", map);
	}

	@Override
	public void insert(Review_Data rvdata) {
		sqlSessionTemplate.insert("Review_insert", rvdata);
	}

	
}
