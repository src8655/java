package net.myshop.service;

import java.sql.*;
import java.text.DecimalFormat;
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

import net.myshop.dao.Sell_DB;
import net.myshop.dao.Sell_Group;
import net.myshop.data.Sell_Data_Bean;

@Service
public class Sell_DB_Bean implements Sell_DB {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	@Autowired
	Sell_Group sell_Group_DB_Bean;
    
    //sellersno와 status로 찾기 status가 -1일시 배송완료를 제외하고 모두 보기
    public List getArticles2_M(int start, int end, int sellers_no, int status) {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("sellers_no", sellers_no);
    	map.put("status", status);
    	
    	
		List list = sqlSessionTemplate.selectList("Sell_getArticles2", map);
    	
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
			sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
		}
    	
    	return list;
    }
    //sellersno와 status로 개수 찾기 status가 -1일시 배송완료를 제외하고 모두 보기(카운트)
    public int count2_M(int sellers_no, int status) {
    	Map map = new HashMap();
    	map.put("sellers_no", sellers_no);
    	map.put("status", status);
    	
    	
		int count = (Integer)sqlSessionTemplate.selectOne("Sell_count2", map);
    	
    	return count;
    }
    //no로 상태 바꾸기
    public boolean changeStatus_M(int no, int status) {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("status", status);
    	
    	
		sqlSessionTemplate.update("Sell_changeStatus", map);
    	
    	return true;
    }
    //no로 배송중상태로 바꾸기
    public boolean changeShipStatus_M(int no, String ship_num) {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("ship_num", ship_num);
    	
    	
		sqlSessionTemplate.update("Sell_changeShipStatus", map);
    	
    	return true;
    }
    //입력하기
    public boolean insert_M(Sell_Data_Bean sdata) {
    	
    	sqlSessionTemplate.insert("Sell_insert", sdata);
    	
    	return true;
    }
    //guestno로 찾기
    public List getArticles_M(int start, int end, int guest_no) {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("guest_no", guest_no);
    	
    	
		List list = sqlSessionTemplate.selectList("Sell_getArticles", map);
    	
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			//금액형태로 바꾸기
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
			sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
		}
    	
    	return list;
    }
    //구매자 no와 상태값에 따른 카운트 구하기
    public int guest_sell_count_M(int guest_no, int status) {
    	Map map = new HashMap();
    	map.put("guest_no", guest_no);
    	map.put("status", status);
    	
    	
    	int count = (Integer)sqlSessionTemplate.selectOne("Sell_guest_sell_count", map);
    	
    	return count;
    }
    //guestno로 sell 총 개수 찾기
    public int count_M(int guest_no) {
    	
    	int count = (Integer)sqlSessionTemplate.selectOne("Sell_count", guest_no);
    	
    	return count;
    }
    //times로 찾기
    public List getArticles3_M(String times) {
    	
    	return (List)sqlSessionTemplate.selectList("Sell_getArticles3", times);
    }
    //하나가져오기
    public Sell_Data_Bean getArticle_M(int no) {
    	
    	return (Sell_Data_Bean)sqlSessionTemplate.selectOne("Sell_getArticle", no);
    }
    //주문취소하기 (sdata = 삭제할 데이터)
    public boolean delete_M(Sell_Data_Bean sdata) {
		int count = group_count_M(sdata.getTimes());		//같은 그룹에 있는 sell이 몇개인지 확인
		if(count == 1) sell_Group_DB_Bean.delete_M(sdata.getTimes());	//하나이면 (현재 셀밖에 없으면) 그룹을 그냥 삭제
		else sell_Group_DB_Bean.delete_sell_M(sdata);					//여러개이면 기존 그룹에서 현재 sell의 금액을 빼기만함
		
		
		sqlSessionTemplate.delete("Sell_delete", sdata.getNo());
		
    	return true;
    }
    //같은 그룹의 개수 구하기
    public int group_count_M(String times) {
    	
    	int count = (Integer) sqlSessionTemplate.selectOne("Sell_group_count", times);
    	
    	return count;
    }
    //리뷰작성완료(hasreview = 1)로 변경
    public boolean updateReview_M(int no) {
    	
    	sqlSessionTemplate.update("Sell_updateReview", no);
    	
    	return true;
    }
    public boolean changeStatus_M(String times, int status) {
    	
    	Map map = new HashMap();
    	map.put("times", times);
    	map.put("status", status);
    	sqlSessionTemplate.update("Sell_changeStatus2", map);
    	
    	return true;
    }
  //같은 페이지에 같은 그룹의 개수 구하기
    public int group_count_M2(int start, int end, String times, int guest_no) {
    	int count = 0;
    	
    	
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("times", times);
    	map.put("guest_no", guest_no);
    	
    	count = (Integer)sqlSessionTemplate.selectOne("Sell_group_count2", map);
    	
    	return count;
    }
  //금액 형태로 바꾸기
    public String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
