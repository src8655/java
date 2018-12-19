package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.Reserve_Dao;
import net.mytour.data.Reserve_Data;
@Service
public class Reserve_Service implements Reserve_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(Reserve_Data rdata) {
		sqlSessionTemplate.insert("Reserve_insert",rdata);
	}

	@Override
	public Integer getStatusCount(int member_no, int status) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("status", status);
		return (Integer)sqlSessionTemplate.selectOne("Reserve_getStatusCount", map);
	}

	@Override
	public Integer getCount(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (Integer)sqlSessionTemplate.selectOne("Reserve_getCount", map);
	}

	@Override
	public List getArticles(int member_no, int start, int end) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Reserve_getArticles", map);
	}

	@Override
	public void setStatus(int no, int status) {
		Map map2 = new HashMap();
		map2.put("no", no);
		map2.put("status", status);
		sqlSessionTemplate.update("Reserve_setStatus", map2);
	}

	@Override
	public Reserve_Data getArticle(int no) {
		return (Reserve_Data)sqlSessionTemplate.selectOne("Reserve_getArticle", no);
	}

	@Override
	public Integer getCountAll(int status) {
		Map map = new HashMap();
		map.put("status", status);
		return (Integer)sqlSessionTemplate.selectOne("Reserve_getCountAll", map);
	}

	@Override
	public List getArticlesAll(int status, int start, int end) {
		Map map = new HashMap();
		map.put("status", status);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Reserve_getArticlesAll", map);
	}

}
