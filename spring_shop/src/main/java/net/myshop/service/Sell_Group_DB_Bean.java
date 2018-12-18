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
import net.myshop.data.Sell_Group_Data_Bean;

@Service
public class Sell_Group_DB_Bean implements Sell_Group {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
    
    //금액 형태로 바꾸기
    public String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
    //입력하기
    public boolean insert_M(Sell_Group_Data_Bean sgdata)  {
    	
    	sqlSessionTemplate.insert("Sell_Group_insert", sgdata);
    	
    	return true;
    }
    //times로 하나 찾기
    public Sell_Group_Data_Bean getArticle_M(String times)  {
    	
    	return (Sell_Group_Data_Bean)sqlSessionTemplate.selectOne("Sell_Group_getArticle", times);
    }
    //포인트 변경
    public boolean setPoint_M(int no, int point)  {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("point", point);
    	
    	
    	sqlSessionTemplate.update("Sell_Group_setPoint", map);
    	
    	return true;
    }
    //주문취소하기 그룹에 속한 sell이 없으면 그룹삭제
    public boolean delete_M(String times)  {
    	
    	sqlSessionTemplate.delete("Sell_Group_delete", times);
    	
    	
    	return true;
    }
    //주문취소하기 group에서 금액을 뺌
    public boolean delete_sell_M(Sell_Data_Bean sdata)  {
    	//그룹의 정보를 가져옴
    	Sell_Group_Data_Bean sgdata = getArticle_M(sdata.getTimes());
    	
    	//sell의 금액을 group에서 뺌
    	sgdata.setMoney(sgdata.getMoney() - sdata.getMoney());
    	sgdata.setShip_money(sgdata.getShip_money() - sdata.getShip_money());
    	sgdata.setRmoney(sgdata.getRmoney() - sdata.getRmoney());
    	
    	
    	
    	sqlSessionTemplate.update("Sell_Group_delete_sell", sgdata);
    	
    	return true;
    }
    //입금확인용//입금대기 상태(1)의 주문그룹만 조회
    public List getPayArticles_M(int status)  {
    	
    	List list = (List)sqlSessionTemplate.selectList("Sell_Group_getPayArticles", status);
    	
    	for(int i=0;i<list.size();i++) {
    		Sell_Group_Data_Bean sgdata = (Sell_Group_Data_Bean)list.get(i);
    		
    		//금액형태로 바꾸기
			sgdata.setMoneys(number_format(sgdata.getMoney()));
			sgdata.setShip_moneys(number_format(sgdata.getShip_money()));
			sgdata.setRmoneys(number_format(sgdata.getRmoney()));
			sgdata.setTotals(number_format(sgdata.getRmoney()+sgdata.getShip_money()-sgdata.getPoint()));
			sgdata.setPoints(number_format(sgdata.getPoint()));
    	}
    	return list;
    }
    //상태 바꾸기
    public boolean changeStatus_M(String times, int status)  {
    	Map map = new HashMap();
    	map.put("times", times);
    	map.put("status", status);
    	
    	
    	sqlSessionTemplate.update("Sell_Group_changeStatus", map);
    	
    	return true;
    }
}
