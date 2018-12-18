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

import net.myshop.dao.Faq_DB;
import net.myshop.data.Faq_Data_Bean;
@Service
public class Faq_DB_Bean implements Faq_DB {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
    //카운트
    public int count_M(int search, String search_value, int category)  {
    	Map map = new HashMap();
    	map.put("search", search);
    	map.put("search_value", search_value);
    	map.put("category", category);
    	
    	return (Integer)sqlSessionTemplate.selectOne("Faq_count", map);
    }
    //여러개 가져오기
    public List getArticles_M(int start, int end, int search, String search_value, int category)  {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("search", search);
    	map.put("search_value", search_value);
    	map.put("category", category);
    	
    	return (List)sqlSessionTemplate.selectList("Faq_getArticles", map);
    }
    //입력하기
    public boolean insert_M(Faq_Data_Bean fdata)  {
    	sqlSessionTemplate.insert("Faq_insert", fdata);
    	
    	return true;
    }
    //하나만가져오기
    public Faq_Data_Bean getArticle_M(int no)  {
    	return (Faq_Data_Bean)sqlSessionTemplate.selectOne("Faq_getArticle", no);
    }
    //수정하기
    public boolean update_M(Faq_Data_Bean fdata)  {
    	sqlSessionTemplate.update("Faq_update", fdata);
    	
    	return true;
    }
    //삭제하기
    public boolean delete_M(int no)  {
    	sqlSessionTemplate.delete("Faq_delete", no);
    	
    	return true;
    }
}
