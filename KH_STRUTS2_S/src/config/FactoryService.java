package config;

import java.io.Reader;
import java.sql.*;
import java.io.*;
import java.util.*;
import com.ibatis.common.resources.*;
import com.ibatis.sqlmap.client.*;


public class FactoryService {
	private static SqlMapClient sqlmap;
	
	static{
		try{
			String xmlPath="/config/SqlMapConfig.xml";
			Reader reader=Resources.getResourceAsReader(xmlPath);
			sqlmap=SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		}catch(Exception ex){
			System.out.println("SqlMapConfig Parsing Error()"+ex.getMessage());
		}
	}

	public static SqlMapClient getSqlmap() {
		return sqlmap;
	}
	
	
	/*
	private static SqlSessionFactory factory;
		static{
		try{
			Reader r = Resources.getResourceAsReader("config/sqlMapConfig.xml"); 
			factory = new SqlSessionFactoryBuilder().build(r);
			r.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	 
	public static SqlSessionFactory getFactory(){
		return factory;
	}*/
}
