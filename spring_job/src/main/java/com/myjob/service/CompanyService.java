package com.myjob.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.CompanyDao;
import com.myjob.data.CompanyData;
import com.myjob.data.MemberData;


@Service
public class CompanyService implements CompanyDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(CompanyData cdata) {
		sqlSessionTemplate.insert("CompanyInsert", cdata);
	}

	@Override
	public List getArticles(int start, int end, String searchValue, int search, int searchType, int searchSort) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("searchValue", searchValue);
		map.put("search", search);
		map.put("searchType", searchType);
		map.put("searchSort", searchSort);
		return (List)sqlSessionTemplate.selectList("CompanyGetArticles", map);
	}

	@Override
	public Integer getCount(String searchValue, int search, int searchType, int searchSort) {
		Map map = new HashMap();
		map.put("searchValue", searchValue);
		map.put("search", search);
		map.put("searchType", searchType);
		map.put("searchSort", searchSort);
		return (Integer)sqlSessionTemplate.selectOne("CompanyGetCount", map);
	}

	@Override
	public CompanyData getArticle(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (CompanyData)sqlSessionTemplate.selectOne("CompanyGetArticle", map);
	}

	@Override
	public void update(CompanyData cdata) {
		sqlSessionTemplate.update("CompanyUpdate", cdata);
	}

	@Override
	public List getFollows(String member_no, int start, int end) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("CompanyGetFollows", map);
	}

	@Override
	public Integer getFollowsCount(String member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (Integer)sqlSessionTemplate.selectOne("CompanyGetFollowsCount", map);
	}
	@Override
	public void deleteUser(MemberData mdata) {
		sqlSessionTemplate.delete("CompanyDeleteUser", mdata);
	}

}
