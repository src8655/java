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
	public static String savePathd = "/shop/upload/";	//�������� �����
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
      
    //���� �� ��������(���۹�ȣ, ����ȣ, �˻�ī�װ�, �˻���, �������, Ư���Ǹ���(-1�̸� ��ü), order�� 1 2 3 �� �ϳ�(����Ʈ,��õ,������))	list���� ���°� 
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
			
			//5�϶� 1�� �ʱ�ȭ
			if(cnt == 5) cnt = 0;
			cnt++;
			
			//���αݾ� ����
			bdb.setDiscount_money(bdb.getMoney()-bdb.getRmoney());

			//��ȭ ����
			bdb.setRmoneys(number_format(bdb.getRmoney()));
			bdb.setMoneys(number_format(bdb.getMoney()));
			bdb.setShip_moneys(number_format(bdb.getShip_money()));
			bdb.setDiscount_moneys(number_format(bdb.getDiscount_money()));
			
			//������ڼ�
			if(bdb.getName().length() > length) 
				bdb.setName(bdb.getName().substring(0, length));
		}
		
    	  
    	return list;
	}
	
	//�Է��ϱ�
	public void insert_M(List_Data_Bean ldata) {
		sqlSessionTemplate.insert("List_insert", ldata);
	}
	//�˻��� ī��Ʈ list���� ���°� order�߰���
    public int getCount_M(int searchs, String searchs_value, int sellers, int order) {
    	Map map = new HashMap();
		map.put("searchs", searchs);
		map.put("searchs_value", searchs_value);
		map.put("sellers", sellers);
		map.put("order", order);
		

		int count = (Integer)sqlSessionTemplate.selectOne("List_getCount", map);
    	
    	return count;
    }
	//�ϳ��� no�� ã��
    public List_Data_Bean getArticle_M(int no)  {
		
		List_Data_Bean ldata = (List_Data_Bean)sqlSessionTemplate.selectOne("List_getArticle", no);
		if(ldata == null) return ldata;
		//���αݾ� ����
		ldata.setDiscount_money(ldata.getMoney()-ldata.getRmoney());

		//��ȭ ����
		ldata.setRmoneys(number_format(ldata.getRmoney()));
		ldata.setMoneys(number_format(ldata.getMoney()));
		ldata.setShip_moneys(number_format(ldata.getShip_money()));
		ldata.setDiscount_moneys(number_format(ldata.getDiscount_money()));
		
    	return ldata;
    }
    //�����ϱ�
    public boolean delete_M(int no) {
    	sqlSessionTemplate.delete("List_delete", no);
		
		return true;
    }
	//�Է��ϱ�
	public boolean update_M(List_Data_Bean ldata) {
		sqlSessionTemplate.insert("List_update", ldata);
		
		return true;
	}
	//�����ϴ� ������ Ȯ��
	public boolean existArticle_M(int no) {
		int count = (Integer)sqlSessionTemplate.selectOne("List_existArticle", no);
		
		if(count == 0) return false;
		else return true;
	}
	//hit ī��Ʈ�� �߰��ϱ�
    public boolean addHit_M(int no) {
	  	//no�� �ش��ϴ� �����͸� �����ͼ�
	  	List_Data_Bean bdata = getArticle_M(no);
			
	  	//ī��Ʈ�߰�
	  	bdata.setHit(bdata.getHit() + 1);
	  	
	  	sqlSessionTemplate.update("List_addHit", bdata);
	  	
		return true;
    }
    //buy ī��Ʈ�� �߰��ϱ�
    public boolean addBuy_M(int no) {
	  	//no�� �ش��ϴ� �����͸� �����ͼ�
	  	List_Data_Bean bdata = getArticle_M(no);
			
	  	//ī��Ʈ�߰�
	  	bdata.setBuy(bdata.getBuy() + 1);

	  	sqlSessionTemplate.update("List_addBuy", bdata);
		
		return true;
    }
    //�ݾ� ���·� �ٲٱ�
    public String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }
}
