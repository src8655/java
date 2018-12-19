package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.List_Dao;
import net.mytour.data.List_Data;
@Service
public class List_Service implements List_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;


	@Override
	public List getArticlesHit(int start, int end, int category) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("category", category);
		return (List)sqlSessionTemplate.selectList("List_getArticlesHit", map);
	}

	@Override
	public List getArticlesBuy(int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("List_getArticlesBuy", map);
	}

	@Override
	public List getArticleHot() {
		return (List)sqlSessionTemplate.selectList("List_getArticleHot");
	}

	@Override
	public int getHit(int no) {
		return (Integer)sqlSessionTemplate.selectOne("List_getHit", no);
	}

	@Override
	public void setHit(int no, int hit) {
		Map map = new HashMap();
		map.put("no", no);
		map.put("hit", hit);
		
		sqlSessionTemplate.update("List_setHit", map);
	}

	@Override
	public Integer getCountNo(int no) {
		return (Integer)sqlSessionTemplate.selectOne("List_getCountNo", no);
	}

	@Override
	public List_Data getArticle(int no) {
		return (List_Data)sqlSessionTemplate.selectOne("List_getArticle", no);
	}

	@Override
	public Integer getCount(int category, String searchs) {
		Map map1 = new HashMap();
		map1.put("category", category);
		map1.put("searchs", searchs);
		return (Integer)sqlSessionTemplate.selectOne("List_getCount", map1);
	}

	@Override
	public List getArticles(int start, int end, int category, String searchs) {
		Map map2 = new HashMap();
		map2.put("start", start);
		map2.put("end", end);
		map2.put("category", category);
		map2.put("searchs", searchs);
		
		return (List)sqlSessionTemplate.selectList("List_getArticles", map2);
	}

	@Override
	public Integer getBuy(int no) {
		return (Integer)sqlSessionTemplate.selectOne("List_getBuy", no);
	}

	@Override
	public void setBuy(int buy, int no) {
		Map map = new HashMap();
		map.put("buy", buy);
		map.put("no", no);
		sqlSessionTemplate.update("List_setBuy", map);
	}

	@Override
	public void insert(List_Data ldata) {
		sqlSessionTemplate.insert("List_insert", ldata);
	}

	@Override
	public void edit(List_Data ldata) {
		sqlSessionTemplate.update("List_edit", ldata);
	}

	@Override
	public void del(int no) {
		sqlSessionTemplate.delete("List_del", no);
	}
}
