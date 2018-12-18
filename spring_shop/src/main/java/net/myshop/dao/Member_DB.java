package net.myshop.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.myshop.data.Member_Data_Bean;


public interface Member_DB {
	public Member_Data_Bean getLogin_M(HttpSession session);
	public boolean login_M(Member_Data_Bean mdata);
	public boolean findPw_M(String user_id, String name, String phone1, String phone2, String phone3, int quest, String answer);
	public boolean changePw_M(String user_id, String name, String phone1, String phone2, String phone3, int quest, String answer, String user_pw);
	public String findId_M(String name, String phone1, String phone2, String phone3);
	public Member_Data_Bean login_info_M(String user_id, String user_pw);
	public Member_Data_Bean getArticle_M(int no);
	public int selectId_M(String user_id);
	public boolean insert_M(Member_Data_Bean mdata);
	public boolean update_M(Member_Data_Bean mdata);
	public boolean setPoint_M(int no, int point);
	public List getArticles_M(int start, int end);
	public int count_M();
	
}
