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

import net.myshop.dao.View_Qna_DB;
import net.myshop.data.Member_Data_Bean;
import net.myshop.data.View_Qna_Data_Bean;

@Service
public class View_Qna_DB_Bean implements View_Qna_DB {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
    
    //카운트
    public int count_M(int product_no)  {
    	
		int count = (Integer)sqlSessionTemplate.selectOne("View_Qna_count", product_no);
    	
    	return count;
    }
    //여러개 가져오기
    public List getArticles_M(int start, int end, int product_no, Member_Data_Bean mdata)  {
    	Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("product_no", product_no);
    	
		
    	List list = sqlSessionTemplate.selectList("View_Qna_getArticles", map);
    	

		for(int i=0;i<list.size();i++) {
			View_Qna_Data_Bean vqdata = (View_Qna_Data_Bean)list.get(i);
			
			//비밀글이고
			if(vqdata.getSecret() == 1) {
				
				if(mdata != null) {
					if(mdata.getNo() == vqdata.getGuest_no()) {
						String tmp = vqdata.getMemo();
						if(tmp.length() <= 30) vqdata.setSubject(tmp);
						else vqdata.setSubject(tmp.substring(0, 30)+"...");
					}else if(mdata.getNo() == vqdata.getSellers_no()) {
						String tmp = vqdata.getMemo();
						if(tmp.length() <= 30) vqdata.setSubject(tmp);
						else vqdata.setSubject(tmp.substring(0, 30)+"...");
					}else {
						vqdata.setSubject("비밀글 입니다.");
						vqdata.setMemo("비밀글 입니다.");
						vqdata.setAnswer("비밀글 입니다.");
					}
				}else {
					vqdata.setSubject("비밀글 입니다.");
					vqdata.setMemo("비밀글 입니다.");
					vqdata.setAnswer("비밀글 입니다.");
				}
			}else {
				String tmp = vqdata.getMemo();
				if(tmp.length() <= 30) vqdata.setSubject(tmp);
				else vqdata.setSubject(tmp.substring(0, 30)+"...");
			}
		}
    	
    	return list;
    }
    public boolean insert_M(View_Qna_Data_Bean vqdata)  {
    	
    	sqlSessionTemplate.insert("View_Qna_insert", vqdata);
    	
    	return true;
    }
    //하나만가져오기
    public View_Qna_Data_Bean getArticle_M(int no)  {
    	
    	View_Qna_Data_Bean vqdata = (View_Qna_Data_Bean)sqlSessionTemplate.selectOne("View_Qna_getArticle", no);
    	
    	return vqdata;
    }
    //삭제하기
    public boolean delete_M(int no)  {
    	
    	sqlSessionTemplate.delete("View_Qna_delete", no);
    	
    	return true;
    }
    //답변달기
    public boolean answer_M(View_Qna_Data_Bean vqdata)  {
    	
    	sqlSessionTemplate.update("View_Qna_answer", vqdata);
    	
    	return true;
    }
}
