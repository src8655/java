package com.myjob.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myjob.dao.MemberDao;
import com.myjob.data.MemberData;

@Service
public class MemberService implements MemberDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public boolean existEmail(MemberData mdata) {
		int count = (Integer)sqlSessionTemplate.selectOne("MemberExistEmail", mdata);
		boolean result = true;
		if(count == 0) result = false;
		return result;
	}

	@Override
	public void insert(MemberData mdata) {
		sqlSessionTemplate.insert("MemberInsert", mdata);
	}

	@Override
	public MemberData login(String email, String password) {
		MemberData mdata = new MemberData();
		mdata.setEmail(email);
		mdata.setPassword(password);
		return (MemberData)sqlSessionTemplate.selectOne("MemberLogin", mdata);
	}

	@Override
	public boolean existLogin(String email, String password) {
		MemberData mdata = new MemberData();
		mdata.setEmail(email);
		mdata.setPassword(password);
		int count = (Integer)sqlSessionTemplate.selectOne("MemberExistLogin", mdata);
		
		boolean result = true;
		if(count == 0) result = false;
		return result;
	}

	@Override
	public void followUpdate(String follow, int no) {
		Map map = new HashMap();
		map.put("follow", follow);
		map.put("no", no);
		sqlSessionTemplate.update("MemberFollowUpdate", map);
	}

	@Override
	public void update(MemberData mdata) {
		sqlSessionTemplate.update("MemberUpdate", mdata);
	}

	@Override
	public Integer findEmailCount(String name, String phone1, String phone2, String phone3) {
		Map map = new HashMap();
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		return (Integer)sqlSessionTemplate.selectOne("MemberFindEmailCount", map);
	}

	@Override
	public MemberData findEmail(String name, String phone1, String phone2, String phone3) {
		Map map = new HashMap();
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		return (MemberData)sqlSessionTemplate.selectOne("MemberFindEmail", map);
	}

	@Override
	public Integer findPwCount(MemberData mdata) {
		return (Integer)sqlSessionTemplate.selectOne("MemberFindPwCount", mdata);
	}

	@Override
	public void changePw(MemberData mdata) {
		sqlSessionTemplate.update("MemberChangePw", mdata);
	}

	@Override
	public MemberData changePwKakao(MemberData mdata) {
		return (MemberData)sqlSessionTemplate.selectOne("MemberChangePwKakao", mdata);
	}
}
