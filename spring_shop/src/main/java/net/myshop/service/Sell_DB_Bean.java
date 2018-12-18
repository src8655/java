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
    
    //sellersno�� status�� ã�� status�� -1�Ͻ� ��ۿϷḦ �����ϰ� ��� ����
    public List getArticles2_M(int start, int end, int sellers_no, int status) {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("sellers_no", sellers_no);
    	map.put("status", status);
    	
    	
		List list = sqlSessionTemplate.selectList("Sell_getArticles2", map);
    	
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
			sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
		}
    	
    	return list;
    }
    //sellersno�� status�� ���� ã�� status�� -1�Ͻ� ��ۿϷḦ �����ϰ� ��� ����(ī��Ʈ)
    public int count2_M(int sellers_no, int status) {
    	Map map = new HashMap();
    	map.put("sellers_no", sellers_no);
    	map.put("status", status);
    	
    	
		int count = (Integer)sqlSessionTemplate.selectOne("Sell_count2", map);
    	
    	return count;
    }
    //no�� ���� �ٲٱ�
    public boolean changeStatus_M(int no, int status) {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("status", status);
    	
    	
		sqlSessionTemplate.update("Sell_changeStatus", map);
    	
    	return true;
    }
    //no�� ����߻��·� �ٲٱ�
    public boolean changeShipStatus_M(int no, String ship_num) {
    	Map map = new HashMap();
    	map.put("no", no);
    	map.put("ship_num", ship_num);
    	
    	
		sqlSessionTemplate.update("Sell_changeShipStatus", map);
    	
    	return true;
    }
    //�Է��ϱ�
    public boolean insert_M(Sell_Data_Bean sdata) {
    	
    	sqlSessionTemplate.insert("Sell_insert", sdata);
    	
    	return true;
    }
    //guestno�� ã��
    public List getArticles_M(int start, int end, int guest_no) {
    	Map map = new HashMap();
    	map.put("start", start);
    	map.put("end", end);
    	map.put("guest_no", guest_no);
    	
    	
		List list = sqlSessionTemplate.selectList("Sell_getArticles", map);
    	
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
			sdata.setTotals(number_format(sdata.getShip_money()+sdata.getRmoney()));
		}
    	
    	return list;
    }
    //������ no�� ���°��� ���� ī��Ʈ ���ϱ�
    public int guest_sell_count_M(int guest_no, int status) {
    	Map map = new HashMap();
    	map.put("guest_no", guest_no);
    	map.put("status", status);
    	
    	
    	int count = (Integer)sqlSessionTemplate.selectOne("Sell_guest_sell_count", map);
    	
    	return count;
    }
    //guestno�� sell �� ���� ã��
    public int count_M(int guest_no) {
    	
    	int count = (Integer)sqlSessionTemplate.selectOne("Sell_count", guest_no);
    	
    	return count;
    }
    //times�� ã��
    public List getArticles3_M(String times) {
    	
    	return (List)sqlSessionTemplate.selectList("Sell_getArticles3", times);
    }
    //�ϳ���������
    public Sell_Data_Bean getArticle_M(int no) {
    	
    	return (Sell_Data_Bean)sqlSessionTemplate.selectOne("Sell_getArticle", no);
    }
    //�ֹ�����ϱ� (sdata = ������ ������)
    public boolean delete_M(Sell_Data_Bean sdata) {
		int count = group_count_M(sdata.getTimes());		//���� �׷쿡 �ִ� sell�� ����� Ȯ��
		if(count == 1) sell_Group_DB_Bean.delete_M(sdata.getTimes());	//�ϳ��̸� (���� ���ۿ� ������) �׷��� �׳� ����
		else sell_Group_DB_Bean.delete_sell_M(sdata);					//�������̸� ���� �׷쿡�� ���� sell�� �ݾ��� ���⸸��
		
		
		sqlSessionTemplate.delete("Sell_delete", sdata.getNo());
		
    	return true;
    }
    //���� �׷��� ���� ���ϱ�
    public int group_count_M(String times) {
    	
    	int count = (Integer) sqlSessionTemplate.selectOne("Sell_group_count", times);
    	
    	return count;
    }
    //�����ۼ��Ϸ�(hasreview = 1)�� ����
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
  //���� �������� ���� �׷��� ���� ���ϱ�
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
  //�ݾ� ���·� �ٲٱ�
    public String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
