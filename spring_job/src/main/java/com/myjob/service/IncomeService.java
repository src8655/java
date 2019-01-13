package com.myjob.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.IncomeDao;
import com.myjob.data.IncomeData;
import com.myjob.data.MemberData;

@Service
public class IncomeService implements IncomeDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void insert(IncomeData idata) {
		sqlSessionTemplate.insert("IncomeInsert", idata);
	}

	@Override
	public Integer getMyCount(int member_no, int writer_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map.put("writer_no", writer_no);
		return (Integer)sqlSessionTemplate.selectOne("IncomeGetMyCount", map);
	}
	
	@Override
	public Integer getCount(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (Integer)sqlSessionTemplate.selectOne("IncomeGetCount", map);
	}

	@Override
	public List getArticles(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		return (List)sqlSessionTemplate.selectList("IncomeGetArticles", map);
	}

	@Override
	public Map getMoneyMaxMin(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		map = (Map)sqlSessionTemplate.selectOne("IncomeGetMoneyMaxMin", map);
		Map map2 = new HashMap();
		if(map != null) {
			map2.put("maxs", ((BigDecimal)map.get("MAXS")).intValue());
			map2.put("mins", ((BigDecimal)map.get("MINS")).intValue());
			map2.put("avgs", ((BigDecimal)map.get("AVGS")).intValue());
		}else {
			map2.put("maxs", 0);
			map2.put("mins", 0);
			map2.put("avgs", 0);
		}
		return map2;
	}

	@Override
	public Integer getRank(int member_no) {
		Map map = new HashMap();
		map.put("member_no", member_no);
		Integer result = (Integer)sqlSessionTemplate.selectOne("IncomeGetLank", map);
		if(result == null) return 0;
		else return result;
	}
	@Override
	public void deleteUser(MemberData mdata) {
		sqlSessionTemplate.delete("IncomeDeleteUser", mdata);
	}

}
