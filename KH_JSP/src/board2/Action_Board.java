package board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board extends Action_Init implements Action {

	public String execute() throws ServletException, IOException {
		Board_DB_Bean board_manager = Board_DB_Bean.getInstance();
		int board_total = board_manager.getCount(id, searchs, searchs_value);	//�� ����
		int board_cnt = 0;						//no�� ���� ī��Ʈ

		int board_lengths = 7;	//�ѹ��� ���� ����Ʈ ����
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		int board_ends = board_starts+board_lengths-1;										//����������
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;

		Board_DB_Bean manager = Board_DB_Bean.getInstance();
		List list = manager.getArticles(board_starts, board_ends, id, searchs, searchs_value);	//����Ʈ�޾ƿ���



		//�Խ���
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//����¡�κ�
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);

		//�Խ��� ����Ʈ
		request.setAttribute("list", list);
		
		return "board.jsp";
	}

}
