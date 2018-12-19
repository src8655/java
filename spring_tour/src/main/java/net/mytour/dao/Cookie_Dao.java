package net.mytour.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Cookie_Dao {
	public String getId(HttpServletRequest request);
	public void setId(String user_id, HttpServletResponse response);
	public void delId(HttpServletResponse response);
	public void view_cookie(int no, HttpServletRequest request, HttpServletResponse response);
	public void viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response);
	public List get_viewed_cookie(HttpServletRequest request, HttpServletResponse response);
	public void del_viewed_cookie(int no, HttpServletRequest request, HttpServletResponse response);
}
