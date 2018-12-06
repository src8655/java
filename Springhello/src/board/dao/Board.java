package board.dao;

import java.util.List;
import java.util.Map;

import board.model.Comment_Data;
import board.model.List_Data;
import board.model.List_Data_Xml;

public interface Board {
	List<List_Data> getList_Datas(int start, int end);
	int getList_DataCount();
	void insertList_Data(List_Data ldata);
	void addHit(int no);
	List_Data getList_Data(int no);
	List<List_Data_Xml> getList_Datas_Xml(int start, int end);
	List<List_Data_Xml> getList_Datas_Ajax(String search_value);
	void delete(int no);
	void update(List_Data ldata);

	void insertComment(Comment_Data cdata);
	void insertComment_No(Comment_Data cdata);
	List<Comment_Data> getComments(int board_no);
	List<Comment_Data> getArticle_rtComment(Comment_Data cdata);
	Comment_Data getArticleComment(String no);
}
