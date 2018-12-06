package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import board.dao.Board;
import board.model.Comment_Data;
import board.model.List_Data;
import board.model.List_Data_Xml;

public class BoardService implements Board {
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}



	@Override
	public List<List_Data> getList_Datas(int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		return sqlMapClientTemplate.queryForList("List_Select", map);
	}
	@Override
	public int getList_DataCount() {
		return (int)sqlMapClientTemplate.queryForObject("List_Count");
	}
	@Override
	public void insertList_Data(List_Data ldata) {
		sqlMapClientTemplate.insert("List_Insert", ldata);
	}
	@Override
	public void addHit(int no) {
		sqlMapClientTemplate.update("List_addHit", no);
	}
	@Override
	public List_Data getList_Data(int no) {
		return (List_Data)sqlMapClientTemplate.queryForObject("List_getArticle", no);
	}
	@Override
	public List<List_Data_Xml> getList_Datas_Xml(int start, int end) {
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		return sqlMapClientTemplate.queryForList("List_Select_Xml", map);
	}
	@Override
	public List<List_Data_Xml> getList_Datas_Ajax(String search_value) {
		return sqlMapClientTemplate.queryForList("List_Select_Ajax", search_value);
	}
	@Override
	public void delete(int no) {
		sqlMapClientTemplate.delete("List_del", no);
	}
	@Override
	public void update(List_Data ldata) {
		sqlMapClientTemplate.update("List_update", ldata);
	}
	@Override
	public void insertComment(Comment_Data cdata) {
		sqlMapClientTemplate.insert("Comment_Insert", cdata);
	}
	@Override
	public void insertComment_No(Comment_Data cdata) {
		sqlMapClientTemplate.insert("Comment_Insert_No", cdata);
	}
	@Override
	public List<Comment_Data> getComments(int board_no) {
		return sqlMapClientTemplate.queryForList("Comment_Select", board_no);
	}
	@Override
	public List<Comment_Data> getArticle_rtComment(Comment_Data cdata) {
		return sqlMapClientTemplate.queryForList("Comment_getArticle_rt", cdata);
	}
	@Override
	public Comment_Data getArticleComment(String no) {
		return (Comment_Data)sqlMapClientTemplate.queryForObject("Comment_getArticle", no);
	}
	@Override
	public void deleteComment(String no) {
		sqlMapClientTemplate.delete("Comment_del", no);
	}


}
