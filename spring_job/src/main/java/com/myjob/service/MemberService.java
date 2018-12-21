package com.myjob.service;

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
}
