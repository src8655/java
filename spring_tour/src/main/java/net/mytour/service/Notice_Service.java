package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.Notice_Dao;
import net.mytour.data.Notice_Data;
@Service
public class Notice_Service implements Notice_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List getArticlesMain(int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Notice_getArticlesMain", map);
	}

	@Override
	public Integer getCount() {
		return (Integer)sqlSessionTemplate.selectOne("Notice_getCount");
	}

	@Override
	public List getArticles(int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Notice_getArticles", map);
	}

	@Override
	public void insert(Notice_Data ndata) {
		sqlSessionTemplate.insert("Notice_insert", ndata);
	}

	@Override
	public Notice_Data getArticle(int no) {
		Map map = new HashMap();
		map.put("no", no);
		return (Notice_Data)sqlSessionTemplate.selectOne("Notice_getArticle", map);
	}

	@Override
	public void update(Notice_Data ndata) {
		sqlSessionTemplate.update("Notice_update", ndata);
	}

	@Override
	public void delete(Notice_Data ndata) {
		sqlSessionTemplate.delete("Notice_delete", ndata);
	}

}
