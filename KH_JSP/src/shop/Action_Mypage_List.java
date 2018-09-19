package shop;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_List extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		//�Ǹ������� �ƴ��� Ȯ��
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�α��� ���ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		if(member_info.getOrders() != 2) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}
		
		List_DB_Bean list_manager = List_DB_Bean.getInstance();
		
		int board_total = list_manager.getCount(searchs, searchs_value, member_info.getNo());	//�� ����
		int board_cnt = 0;						//no�� ���� ī��Ʈ

		int board_lengths = 20;	//�ѹ��� ���� ����Ʈ ����
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		int board_ends = board_starts+board_lengths-1;										//����������
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;

		List list = list_manager.getArticles(board_starts, board_ends, searchs, searchs_value, 10, member_info.getNo());	//����Ʈ�޾ƿ���

		String date = cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);

		//�Խ���
		request.setAttribute("date", date);
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//����¡�κ�
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);

		//�Խ��� ����Ʈ
		request.setAttribute("list", list);
		
		
		return "mypage_list.jsp";
	}

}
