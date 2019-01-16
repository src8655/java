package com.myjob.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.ReportDao;
import com.myjob.data.MemberData;
import com.myjob.data.ReportData;

@Service
public class ReportService implements ReportDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Integer exist(ReportData rpdata) {
		return (Integer)sqlSessionTemplate.selectOne("ReportExist", rpdata);
	}

	@Override
	public void insert(ReportData rpdata) {
		sqlSessionTemplate.insert("ReportInsert", rpdata);
	}

	@Override
	public List getArticles(int start, int end, int tab) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("tab", tab);
		return (List)sqlSessionTemplate.selectList("ReportGetArticles", map);
	}

	@Override
	public Integer getCount(int tab) {
		Map map = new HashMap();
		map.put("tab", tab);
		return (Integer)sqlSessionTemplate.selectOne("ReportGetCount", map);
	}

	@Override
	public ReportData getArticle(int no, int tab) {
		Map map = new HashMap();
		map.put("no", no);
		map.put("tab", tab);
		return (ReportData)sqlSessionTemplate.selectOne("ReportGetArticle", map);
	}

	@Override
	public void delete(int tab_no, int tab) {
		Map map = new HashMap();
		map.put("tab_no", tab_no);
		map.put("tab", tab);
		sqlSessionTemplate.delete("ReportDelete", map);
	}

	@Override
	public void deleteNo(int no) {
		Map map = new HashMap();
		map.put("no", no);
		sqlSessionTemplate.delete("ReportDeleteNo", map);
	}

	@Override
	public void deleteUser(MemberData mdata) {
		sqlSessionTemplate.delete("ReportDeleteUser", mdata);
	}

}
