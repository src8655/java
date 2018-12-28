package com.myjob.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.InterviewDao;
import com.myjob.data.InterviewData;
@Service
public class InterviewService implements InterviewDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(InterviewData itdata) {
		sqlSessionTemplate.insert("InterviewInsert", itdata);
	}

	@Override
	public Integer getCount(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (Integer)sqlSessionTemplate.selectOne("InterviewGetCount", map);
	}

	@Override
	public List getArticles(int member_no, int start, int end) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("InterviewGetArticles", map);
	}

	@Override
	public Integer getMyCount(int member_no, int writer_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("writer_no", writer_no);
		return (Integer)sqlSessionTemplate.selectOne("InterviewGetMyCount", map);
	}

	@Override
	public Double getDifficulty(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		Double result = (Double)sqlSessionTemplate.selectOne("InterviewGetDifficulty", map);
		if(result == null) return 0.0;
		else return result;
	}

	@Override
	public Integer getInterviewdir(int member_no, int interviewdir) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("interviewdir", interviewdir);
		return (Integer)sqlSessionTemplate.selectOne("InterviewGetInterviewdir", map);
	}

	@Override
	public Integer getInterviewex(int member_no, int interviewex) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("interviewex", interviewex);
		return (Integer)sqlSessionTemplate.selectOne("InterviewGetInterviewex", map);
	}

	@Override
	public Integer getInterviewresult(int member_no, int interviewresult) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("interviewresult", interviewresult);
		return (Integer)sqlSessionTemplate.selectOne("InterviewGetInterviewresult", map);
	}

}
