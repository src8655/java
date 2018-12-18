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

import net.myshop.dao.View_Review_DB;
import net.myshop.data.View_Review_Data_Bean;
@Service
public class View_Review_DB_Bean implements View_Review_DB {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
    //카운트
    public int count_M(int product_no)  {
		
		int count = (Integer)sqlSessionTemplate.selectOne("View_Review_count", product_no);
    	
    	return count;
    }
    //여러개 가져오기
    public List getArticles_M(int start, int end, int product_no)  {
    	Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("product_no", product_no);
    	
		
    	List list = sqlSessionTemplate.selectList("View_Review_getArticles", map);
    	
    	for(int i=0;i<list.size();i++) {
			View_Review_Data_Bean vrdata = (View_Review_Data_Bean)list.get(i);
			
			//별 개수를 저장
			vrdata.setStar_01(vrdata.getStars());
			vrdata.setStar_02(5-vrdata.getStars());
    	}
    	
    	return list;
    }
    //입력하기
    public boolean insert_M(View_Review_Data_Bean vrdata)  {
    	
    	sqlSessionTemplate.insert("View_Review_insert", vrdata);
    	
    	return true;
    }
    //하나만가져오기
    public View_Review_Data_Bean getArticle_M(int no)  {
    	
    	return (View_Review_Data_Bean)sqlSessionTemplate.selectOne("View_Review_getArticle", no);
    }
}
