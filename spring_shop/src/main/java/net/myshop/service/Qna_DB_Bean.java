package net.myshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.myshop.dao.Qna_DB;
import net.myshop.data.Qna_Data_Bean;

@Service
public class Qna_DB_Bean implements Qna_DB {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
    
    //카운트 관리자면 -1 회원이면 회원번호
    public int count_M(int guest_no)  {
    	Map map = new HashMap();
    	map.put("guest_no", guest_no);
    	
    	return (Integer)sqlSessionTemplate.selectOne("Qna_count", map);
    }
    //여러개 가져오기 관리자면 -1 회원이면 회원번호
    public List getArticles_M(int start, int end, int length, int guest_no)  {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("length", length);
    	map.put("guest_no", guest_no);
    	
    	
    	List list = sqlSessionTemplate.selectList("Qna_getArticles", map);
    	for(int i=0;i<list.size();i++) {
    		Qna_Data_Bean qdata = (Qna_Data_Bean)list.get(i);
    		if(qdata.getSubject().length() > length)
				qdata.setSubject(qdata.getSubject().substring(1, length));
    	}
    	
    	return list;
    }
    //입력하기
    public boolean insert_M(Qna_Data_Bean qdata)  {
    	
    	sqlSessionTemplate.insert("Qna_insert", qdata);
    	
    	return true;
    }
    //하나만가져오기
    public Qna_Data_Bean getArticle_M(int no)  {
    	
    	return (Qna_Data_Bean)sqlSessionTemplate.selectOne("Qna_getArticle", no);
    }
    //수정하기
    public boolean update_M(Qna_Data_Bean qdata)  {
    	
    	sqlSessionTemplate.update("Qna_update", qdata);
    	
    	return true;
    }
    //삭제하기
    public boolean delete_M(int no)  {
    	
    	sqlSessionTemplate.delete("Qna_delete", no);
    	
    	return true;
    }
    //답변달기
    public boolean answer_M(Qna_Data_Bean qdata)  {
    	
    	sqlSessionTemplate.update("Qna_answer", qdata);
    	
    	return true;
    }
    //답변삭제
    public boolean answerDel_M(int no)  {
    	
    	sqlSessionTemplate.update("Qna_answerDel", no);

    	return true;
    }
}
