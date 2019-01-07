package com.myjob.dao;

import com.myjob.data.MemberData;

public interface MemberDao {
	boolean existEmail(MemberData mdata);
	void insert(MemberData mdata);
	MemberData login(String email, String password);
	boolean existLogin(String email, String password);
	void followUpdate(String follow, int no);
	void update(MemberData mdata);
}
