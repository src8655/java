package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.List_Reserve_Dao;
import net.mytour.data.List_Reserve_Data;
@Service
public class List_Reserve_Service implements List_Reserve_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List getArticlesMain(int cnt) {
		return (List)sqlSessionTemplate.selectList("List_Reserve_getArticlesMain", cnt);
	}

	@Override
	public List getArticlesCheck() {
		return (List)sqlSessionTemplate.selectList("List_Reserve_getArticlesCheck");
	}

	@Override
	public void Reserve_del(int no) {
		sqlSessionTemplate.delete("List_Reserve_del", no);
	}

	@Override
	public Integer getCountAll(String startdates, int days, int category, int money, String subject) {
		Map map = new HashMap();
		map.put("startdates", startdates);
		map.put("days", days);
		map.put("category", category);
		map.put("money", money);
		map.put("subject", subject);
		return (Integer)sqlSessionTemplate.selectOne("List_Reserve_getCountAll", map);
	}

	@Override
	public List getArticlesAll(String startdates, int days, int category, int money, String subject, int start,
			int end) {
		Map map = new HashMap();
		map.put("startdates", startdates);
		map.put("days", days);
		map.put("category", category);
		map.put("money", money);
		map.put("subject", subject);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("List_Reserve_getArticlesAll", map);
	}

	@Override
	public List getArticles(int no) {
		return (List)sqlSessionTemplate.selectList("List_Reserve_getArticles", no);
	}

	@Override
	public List_Reserve_Data getArticle(int no) {
		return (List_Reserve_Data) sqlSessionTemplate.selectOne("List_Reserve_getArticle", no);
	}

	@Override
	public void setIsreserve(int no, int isreserve) {
		Map maps = new HashMap();
		maps.put("no", no);
		maps.put("isreserve", isreserve);
		sqlSessionTemplate.update("List_Reserve_setIsreserve", maps);
	}

	@Override
	public void insert(List_Reserve_Data lrdata) {
		sqlSessionTemplate.insert("List_Reserve_insert", lrdata);
	}

	@Override
	public void del(int no) {
		sqlSessionTemplate.delete("List_Reserve_del", no);
	}

}
