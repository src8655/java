package com.myjob.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.RecruitDao;
import com.myjob.data.MemberData;
import com.myjob.data.RecruitData;

@Service
public class RecruitService implements RecruitDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(RecruitData rcdata) {
		sqlSessionTemplate.insert("RecruitInsert", rcdata);
	}

	@Override
	public Integer exist(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (Integer)sqlSessionTemplate.selectOne("RecruitExist", map);
	}

	@Override
	public RecruitData getArticle(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (RecruitData)sqlSessionTemplate.selectOne("RecruitGetArticle", map);
	}

	@Override
	public String getEnddates(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (String)sqlSessionTemplate.selectOne("RecruitGetEnddates", map);
	}

	@Override
	public RecruitData getArticleNo(int no) {
		Map map = new HashMap();
		map.put("no", no);
		return (RecruitData)sqlSessionTemplate.selectOne("RecruitGetArticleNo", map);
	}

	@Override
	public void update(RecruitData rcdata) {
		sqlSessionTemplate.update("RecruitUpdate", rcdata);
	}

	@Override
	public void del(int no) {
		Map map = new HashMap();
		map.put("no", no);
		sqlSessionTemplate.delete("RecruitDel", map);
	}

	@Override
	public Integer getCount(String searchValue, int search, int searchType, int searchSort, int status) {
		Map map = new HashMap();
		map.put("searchValue", searchValue);
		map.put("search", search);
		map.put("searchType", searchType);
		map.put("searchSort", searchSort);
		map.put("status", status);
		return (Integer)sqlSessionTemplate.selectOne("RecruitGetCount", map);
	}

	@Override
	public List getArticles(int start, int end, String searchValue, int search, int searchType, int searchSort, int status) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("searchValue", searchValue);
		map.put("search", search);
		map.put("searchType", searchType);
		map.put("searchSort", searchSort);
		map.put("status", status);
		return (List)sqlSessionTemplate.selectList("RecruitGetArticles", map);
	}

	@Override
	public List getListArticles(int start, int end, int member_no, int status) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("member_no", member_no);
		map.put("status", status);
		return (List)sqlSessionTemplate.selectList("RecruitGetListArticles", map);
	}

	@Override
	public Integer getListCount(int member_no, int status) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("status", status);
		return (Integer)sqlSessionTemplate.selectOne("RecruitGetListCount", map);
	}

	@Override
	public List getMyArticles(int writer_no, int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("writer_no", writer_no);
		return (List)sqlSessionTemplate.selectList("RecruitGetMyArticles", map);
	}

	@Override
	public Integer getMyCount(int writer_no) {
		Map map = new HashMap();
		map.put("writer_no", writer_no);
		return (Integer)sqlSessionTemplate.selectOne("RecruitGetMyCount", map);
	}

	@Override
	public void end(int no, int status) {
		Map map = new HashMap();
		map.put("no", no);
		map.put("status", status);
		sqlSessionTemplate.update("RecruitEnd", map);
	}
	@Override
	public void deleteUser(MemberData mdata) {
		sqlSessionTemplate.delete("RecruitDeleteUser", mdata);
	}

}
