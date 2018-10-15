package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Customer_Center_Faq extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		//���������� �ƴ��� Ȯ��
		if(member_info == null) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�α��� ���ּ���.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		int category = -1;
		if(request.getParameter("category") != null)
			if(!request.getParameter("category").equals(""))
				category = Integer.parseInt(request.getParameter("category"));
		request.setAttribute("category", category);
		
		
		
		Faq_DB_Bean fdb = Faq_DB_Bean.getInstance();
		
		int board_total = fdb.count(p_search, p_search_value, category);			//�ƴҶ�
		
		int board_cnt = 0;						//no�� ���� ī��Ʈ

		int board_lengths = 10;	//�ѹ��� ���� ����Ʈ ����
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		int board_ends = board_starts+board_lengths-1;										//����������
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
		
		

		List list = fdb.getArticles(board_starts, board_ends, p_search, p_search_value, category);
		
		//�Խ���
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//����¡�κ�
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);

		//�Խ��� ����Ʈ
		request.setAttribute("list", list);
		
		
		return "customer_center_faq.tiles";
	}


}
