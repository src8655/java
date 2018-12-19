package net.mytour.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.mytour.dao.Member_Dao;
import net.mytour.data.Member_Data;
@Service
public class Member_Service implements Member_Dao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Member_Data getArticle(String user_id, String user_pw) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		return (Member_Data)sqlSessionTemplate.selectOne("Member_getArticle", map);
	}

	@Override
	public Integer getUserIdPwCount(String user_id, String user_pw) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		return (Integer)sqlSessionTemplate.selectOne("Member_getUserIdPwCount", map);
	}

	@Override
	public void changeInfo(Member_Data mdata) {
		sqlSessionTemplate.update("Member_changeInfo", mdata);
	}

	@Override
	public String getFindId(String name, String phone1, String phone2, String phone3) {
		Map map = new HashMap();
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		return (String)sqlSessionTemplate.selectOne("Member_getFindId", map);
	}

	@Override
	public Integer getFindPw(String user_id, String name, String phone1, String phone2, String phone3, int quest, String answer) {
		Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		map.put("quest", quest);
		map.put("answer", answer);
		return (Integer)sqlSessionTemplate.selectOne("Member_getFindPw", map);
	}

	@Override
	public void changePw(Member_Data mdata) {
		sqlSessionTemplate.update("Member_changePw", mdata);
	}

	@Override
	public void insert(Member_Data mdata) {
		sqlSessionTemplate.insert("Member_insert", mdata);
	}

	@Override
	public Integer getUserIdCount(String user_id) {
		return (Integer)sqlSessionTemplate.selectOne("Member_getUserIdCount", user_id);
	}

	@Override
	public Integer getCount() {
		return (Integer)sqlSessionTemplate.selectOne("Member_getCount");
	}

	@Override
	public List getArticles(int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		return (List)sqlSessionTemplate.selectList("Member_getArticles", map);
	}

	@Override
	public Member_Data getArticleNo(int no) {
		return (Member_Data)sqlSessionTemplate.selectOne("Member_getArticleNo", no);
	}

	@Override
	public void delete(int no) {
		Map map = new HashMap();
		map.put("no", no);
		sqlSessionTemplate.delete("Member_delete", map);
	}

}
