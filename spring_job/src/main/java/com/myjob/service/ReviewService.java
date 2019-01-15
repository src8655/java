package com.myjob.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.ReviewDao;
import com.myjob.data.MemberData;
import com.myjob.data.ReviewData;

@Service
public class ReviewService implements ReviewDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(ReviewData rdata) {
		sqlSessionTemplate.insert("ReviewInsert", rdata);
	}

	@Override
	public Integer getCount(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (Integer)sqlSessionTemplate.selectOne("ReviewGetCount", map);
	}

	@Override
	public List getArticles(int member_no, int start, int end) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("ReviewGetArticles", map);
	}

	@Override
	public Integer getMyCount(int member_no, int writer_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("writer_no", writer_no);
		return (Integer)sqlSessionTemplate.selectOne("ReviewGetMyCount", map);
	}

	@Override
	public ReviewData getAllStars(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (ReviewData)sqlSessionTemplate.selectOne("ReviewGetAllStars", map);
	}

	@Override
	public ReviewData getIndexArticle(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (ReviewData)sqlSessionTemplate.selectOne("ReviewGetIndexArticle", map);
	}
	@Override
	public void deleteUser(MemberData mdata) {
		sqlSessionTemplate.delete("ReviewDeleteUser", mdata);
	}

	@Override
	public ReviewData getArticleNo(int no) {
		Map map = new HashMap();
		map.put("no", no);
		return (ReviewData)sqlSessionTemplate.selectOne("ReviewGetArticleNo", map);
	}


}
