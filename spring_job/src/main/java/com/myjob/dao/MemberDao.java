package com.myjob.dao;

import com.myjob.data.MemberData;

public interface MemberDao {
	boolean existEmail(MemberData mdata);
	void insert(MemberData mdata);
	MemberData login(String email, String password);
	boolean existLogin(String email, String password);
	void followUpdate(String follow, int no);
	void update(MemberData mdata);
	Integer findEmailCount(String name, String phone1, String phone2, String phone3);
	MemberData findEmail(String name, String phone1, String phone2, String phone3);
	Integer findPwCount(MemberData mdata);
	void changePw(MemberData mdata);
	MemberData changePwKakao(MemberData mdata);
	void deleteUser(MemberData mdata);
}
