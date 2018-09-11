package board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_View extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
		int board_total = board_manager.getCount(id, searchs, searchs_value);	//�� ����


		String no = request.getParameter("no");


		//��Ű����
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		cmanager.view_cookie(no, request, response);


		//�����͹ޱ�
		Board_DB_Bean manager = Board_DB_Bean.getInstance();
		Board_Data_Bean bdb = manager.getArticle(Integer.parseInt(no));

		//1�� �ƴ϶�� ���� �� ���� ����̶�°�
		String rt_no = no;
		if(bdb.getRt_no() != 1)	rt_no = Integer.toString(bdb.getRt_no());

		//����� ��� ��۷� �ޱ�
		String name_tmp = "";
		String passwords_tmp = "";
		if(member_info != null) {
			name_tmp = member_info.getName();
			passwords_tmp = member_info.getPasswords();
		}


		//���
		Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
		List list = cdb.getArticles(Integer.parseInt(no));
		for(int i=0;i<list.size();i++) {
			Comment_Data_Bean data = (Comment_Data_Bean)list.get(i);
			String c_memos = data.getMemo().replaceAll("\n", "<br />");
			data.setMemo(c_memos);
			list.set(i, data);
		}



		request.setAttribute("no", no);
		request.setAttribute("board_total", board_total);
		request.setAttribute("bdb", bdb);
		request.setAttribute("rt_no", rt_no);

		request.setAttribute("list", list);
		request.setAttribute("name_tmp", name_tmp);
		request.setAttribute("passwords_tmp", passwords_tmp);
		
		return "board_view.jsp";
	}

}
