package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.Qna_Dao;
import net.mytour.data.Qna_Data;
@Service
public class Qna_Service implements Qna_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Integer getCount(int member_no, int status) {
		Map maps = new HashMap();
		maps.put("member_no", member_no);
		maps.put("status", status);
		return (Integer)sqlSessionTemplate.selectOne("Qna_getCount", maps);
	}

	@Override
	public List getArticles(int member_no, int status, int start, int end) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("status", status);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Qna_getArticles", map);
	}

	@Override
	public void insert(Qna_Data qdata) {
		sqlSessionTemplate.insert("Qna_insert", qdata);
	}

	@Override
	public Qna_Data getArticle(int no) {
		Map map = new HashMap();
		map.put("no", no);
		return (Qna_Data)sqlSessionTemplate.selectOne("Qna_getArticle", map);
	}

	@Override
	public void update(Qna_Data qdata) {
		sqlSessionTemplate.update("Qna_update", qdata);
	}

	@Override
	public void delete(int no) {
		Map map = new HashMap();
		map.put("no", no);
		sqlSessionTemplate.update("Qna_delete", map);
	}

	@Override
	public void answer(Qna_Data qdata) {
		sqlSessionTemplate.update("Qna_answer", qdata);
	}

	@Override
	public void answerDel(Qna_Data qdata) {
		sqlSessionTemplate.update("Qna_answerDel", qdata);
	}

}
