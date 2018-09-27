package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Sell extends Action_Init implements Action {

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
		
		//�з�(-1 �̸� ��κ���(��ۿϷ�� ����))
		String cate = "-1";
		if(request.getParameter("cate") != null)
			if(!request.getParameter("cate").equals(""))
				cate = request.getParameter("cate");

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		
		int board_total = sdb.count2(member_info.getNo(), Integer.parseInt(cate));	//�� ����
		int board_cnt = 0;						//no�� ���� ī��Ʈ

		int board_lengths = 10;	//�ѹ��� ���� ����Ʈ ����
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		int board_ends = board_starts+board_lengths-1;										//����������
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;


		//�Խ���
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//����¡�κ�
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);
		
		
		
		
		
		
		//����Ʈ ��������
		List list = sdb.getArticles2(board_starts, board_ends, member_info.getNo(), Integer.parseInt(cate));

		request.setAttribute("cate", cate);
		request.setAttribute("list", list);
		
		
		return "mypage_sell.jsp";
	}


}
