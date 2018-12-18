package net.myshop.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.myshop.dao.Member_DB;
import net.myshop.data.Member_Data_Bean;

@Service
public class Member_DB_Bean implements Member_DB {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
    
    //������ ���� �α��ν� ���� ��������
    public Member_Data_Bean getLogin_M(HttpSession session)  {
    	Member_Data_Bean member_info = null;
    	if(session.getAttribute("user_id") != null && session.getAttribute("user_pw") != null) {
    		member_info = login_info_M((String)session.getAttribute("user_id"), (String)session.getAttribute("user_pw"));
    	}
    	
    	return member_info;
    }
    //�α����ϱ�
    public boolean login_M(Member_Data_Bean mdata)  {
    	if(mdata.getUser_id() == null || mdata.getUser_pw() == null) return false;
    	
    	Map map = new HashMap();
		map.put("user_id", mdata.getUser_id());
		map.put("user_pw", mdata.getUser_pw());
		

		int cnt = (Integer)sqlSessionTemplate.selectOne("Member_login", map);
    	
    	
    	if(cnt == 0) return false;
    	else return true;
    }
    //���̵�� �̸��� �޴���ȭ�� ������ �亯���� ��й�ȣ �ٲ���?
    public boolean findPw_M(String user_id, String name, String phone1, String phone2, String phone3, int quest, String answer)  {
    	Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		map.put("quest", quest);
		map.put("answer", answer);
		

		int cnt = (Integer)sqlSessionTemplate.selectOne("Member_findPw", map);
    	
		if(cnt == 0) return false;
    	else return true;
    }
    //���̵�� �̸��� �޴���ȭ�� ������ �亯���� ��й�ȣ �ٲٱ�
    public boolean changePw_M(String user_id, String name, String phone1, String phone2, String phone3, int quest, String answer, String user_pw)  {
    	Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
		map.put("quest", quest);
		map.put("answer", answer);
		map.put("user_pw", user_pw);
		
		sqlSessionTemplate.update("Member_changePw", map);

		return true;
    }
  //�̸��� �޴���ȭ�� ���̵�ã��
    public String findId_M(String name, String phone1, String phone2, String phone3)  {
    	String user_id = null;
    	
    	Map map = new HashMap();
		map.put("name", name);
		map.put("phone1", phone1);
		map.put("phone2", phone2);
		map.put("phone3", phone3);
    	
		user_id = (String)sqlSessionTemplate.selectOne("Member_findId", map);
		
		return user_id;
    }
    //�α��� ���� ��������
    public Member_Data_Bean login_info_M(String user_id, String user_pw)  {
    	Map map = new HashMap();
		map.put("user_id", user_id);
		map.put("user_pw", user_pw);
		
		Member_Data_Bean mdata = (Member_Data_Bean)sqlSessionTemplate.selectOne("Member_login_info", map);
    	
    	return mdata;
    }
    //ȸ������ �ϳ� ��������
    public Member_Data_Bean getArticle_M(int no)  {
		Member_Data_Bean mdata = (Member_Data_Bean)sqlSessionTemplate.selectOne("Member_getArticle", no);
    	
    	return mdata;
    }
    //id�� ����� ȸ���� �ִ��� Ȯ��
    public int selectId_M(String user_id)  {
    	int count = (Integer) sqlSessionTemplate.selectOne("Member_selectId", user_id);
    	
    	return count;
    }
    //�Է��ϱ�
    public boolean insert_M(Member_Data_Bean mdata)  {
    	sqlSessionTemplate.insert("Member_insert", mdata);
    	
    	return true;
    }
    //�����ϱ�
    public boolean update_M(Member_Data_Bean mdata)  {
    	sqlSessionTemplate.update("Member_update", mdata);
    	
    	return true;
    }
    //����Ʈ ����
    public boolean setPoint_M(int no, int point)  {
    	Map map = new HashMap();
		map.put("no", no);
		map.put("point", point);
		
		sqlSessionTemplate.update("Member_setPoint", map);
		
    	return true;
    }
    //������ ��������
    public List getArticles_M(int start, int end)  {
    	Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
    	List list = sqlSessionTemplate.selectList("Member_getArticles", map);

    	return list;
    }
    //�� ȸ���� �� 
    public int count_M()  {
    	return (Integer)sqlSessionTemplate.selectOne("Member_count");
    }
}
