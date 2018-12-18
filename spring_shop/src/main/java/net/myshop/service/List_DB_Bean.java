package net.myshop.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.myshop.dao.List_DB;
import net.myshop.data.List_Data_Bean;



@Service
public class List_DB_Bean implements List_DB {
	public static String savePathd = "/shop/upload/";	//파일저장 상대경로
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
      
    //여러 줄 가져오기(시작번호, 끝번호, 검색카테고리, 검색어, 제목길이, 특정판매자(-1이면 전체), order는 1 2 3 중 하나(베스트,추천,무료배송))	list에서 쓰는거 
	public List getArticles_M(int start, int end, int searchs, String searchs_value, int length, int sellers, int order) {
		List<List_Data_Bean> list = null;
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("searchs", searchs);
		map.put("searchs_value", searchs_value);
		map.put("sellers", sellers);
		map.put("order", order);
		

		list = sqlSessionTemplate.selectList("List_getArticles", map);
		
		int cnt = 1;
		for(int i=0;i<list.size();i++) {
			List_Data_Bean bdb = list.get(i);
			bdb.setCnt(cnt);
			
			//5일때 1로 초기화
			if(cnt == 5) cnt = 0;
			cnt++;
			
			//할인금액 적용
			bdb.setDiscount_money(bdb.getMoney()-bdb.getRmoney());

			//통화 형식
			bdb.setRmoneys(number_format(bdb.getRmoney()));
			bdb.setMoneys(number_format(bdb.getMoney()));
			bdb.setShip_moneys(number_format(bdb.getShip_money()));
			bdb.setDiscount_moneys(number_format(bdb.getDiscount_money()));
			
			//제목글자수
			if(bdb.getName().length() > length) 
				bdb.setName(bdb.getName().substring(0, length));
		}
		
    	  
    	return list;
	}
	
	//입력하기
	public void insert_M(List_Data_Bean ldata) {
		sqlSessionTemplate.insert("List_insert", ldata);
	}
	//검색된 카운트 list에서 쓰는거 order추가됨
    public int getCount_M(int searchs, String searchs_value, int sellers, int order) {
    	Map map = new HashMap();
		map.put("searchs", searchs);
		map.put("searchs_value", searchs_value);
		map.put("sellers", sellers);
		map.put("order", order);
		

		int count = (Integer)sqlSessionTemplate.selectOne("List_getCount", map);
    	
    	return count;
    }
	//하나만 no로 찾기
    public List_Data_Bean getArticle_M(int no)  {
		
		List_Data_Bean ldata = (List_Data_Bean)sqlSessionTemplate.selectOne("List_getArticle", no);
		if(ldata == null) return ldata;
		//할인금액 적용
		ldata.setDiscount_money(ldata.getMoney()-ldata.getRmoney());

		//통화 형식
		ldata.setRmoneys(number_format(ldata.getRmoney()));
		ldata.setMoneys(number_format(ldata.getMoney()));
		ldata.setShip_moneys(number_format(ldata.getShip_money()));
		ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
		
    	return ldata;
    }
    //삭제하기
    public boolean delete_M(int no) {
    	sqlSessionTemplate.delete("List_delete", no);
		
		return true;
    }
	//입력하기
	public boolean update_M(List_Data_Bean ldata) {
		sqlSessionTemplate.insert("List_update", ldata);
		
		return true;
	}
	//존재하는 글인지 확인
	public boolean existArticle_M(int no) {
		int count = (Integer)sqlSessionTemplate.selectOne("List_existArticle", no);
		
		if(count == 0) return false;
		else return true;
	}
	//hit 카운트를 추가하기
    public boolean addHit_M(int no) {
	  	//no에 해당하는 데이터를 가져와서
	  	List_Data_Bean bdata = getArticle_M(no);
			
	  	//카운트추가
	  	bdata.setHit(bdata.getHit() + 1);
	  	
	  	sqlSessionTemplate.update("List_addHit", bdata);
	  	
		return true;
    }
    //buy 카운트를 추가하기
    public boolean addBuy_M(int no) {
	  	//no에 해당하는 데이터를 가져와서
	  	List_Data_Bean bdata = getArticle_M(no);
			
	  	//카운트추가
	  	bdata.setBuy(bdata.getBuy() + 1);

	  	sqlSessionTemplate.update("List_addBuy", bdata);
		
		return true;
    }
    //금액 형태로 바꾸기
    public String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
