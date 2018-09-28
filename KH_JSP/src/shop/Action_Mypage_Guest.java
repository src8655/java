package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Mypage_Guest extends Action_Init implements Action {

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
		if(member_info.getOrders() != 1) {
			response.getWriter().println("<script>");
			response.getWriter().println("alert('�߸��� �����Դϴ�.')");
			response.getWriter().println("history.go(-1)");
			response.getWriter().println("</script>");
			
			return null;
		}

		Sell_DB_Bean sdb = Sell_DB_Bean.getInstance();
		
		int board_total = sdb.count(member_info.getNo());	//�� ����
		int board_cnt = 0;						//no�� ���� ī��Ʈ

		int board_lengths = 7;	//�ѹ��� ���� ����Ʈ ����
		int board_starts = ((Integer.parseInt(pages))*board_lengths)-board_lengths+1;			//��������
		int board_ends = board_starts+board_lengths-1;										//����������
		int board_paging = (int)Math.ceil((double)board_total/(double)board_lengths);	//������ ��ũ ����

		int pstarts = Integer.parseInt(pages)-5;
		int pends = Integer.parseInt(pages)+5;
		if(pstarts <= 0) pstarts = 1;
		if(pends > board_paging) pends = board_paging;
		
		request.setAttribute("board_total", board_total);
		request.setAttribute("board_cnt", board_starts);
		request.setAttribute("board_paging", board_paging);
		//����¡�κ�
		request.setAttribute("pstarts", pstarts);
		request.setAttribute("pends", pends);
		
		
		
		
		
		List list = sdb.getArticles(board_starts, board_ends, member_info.getNo());
		
		//�ߺ��Ȱ� ī��Ʈ
		String tmp = "";
		for(int i=0;i<list.size();i++) {
			Sell_Data_Bean sdata = (Sell_Data_Bean)list.get(i);
			
			//���ο�� ������ ���� �׷��� ������ŭ rowspan���� ����
			if(!sdata.getTimes().equals(tmp)) sdata.setRowspans(sdb.group_count(board_starts, board_ends, sdata.getTimes(), sdata.getGuest_no()));
			tmp = sdata.getTimes();
			//�ݾ����·� �ٲٱ�
			sdata.setMoneys(number_format(sdata.getMoney()));
			sdata.setShip_moneys(number_format(sdata.getShip_money()));
			sdata.setRmoneys(number_format(sdata.getRmoney()));
		}
		
		
		//���������ֹ� ����
		int process1 = sdb.guest_sell_count(member_info.getNo(), 1);
		int process2 = sdb.guest_sell_count(member_info.getNo(), 2);
		int process3 = sdb.guest_sell_count(member_info.getNo(), 3);
		int process4 = sdb.guest_sell_count(member_info.getNo(), 4);
		int process5 = sdb.guest_sell_count(member_info.getNo(), 5);

		request.setAttribute("list", list);
		request.setAttribute("process1", process1);
		request.setAttribute("process2", process2);
		request.setAttribute("process3", process3);
		request.setAttribute("process4", process4);
		request.setAttribute("process5", process5);
		
		return "mypage_guest.jsp";
	}

	//�ݾ� ���·� �ٲٱ�
    public static String number_format(int dSource) {
        return new DecimalFormat("#,##0").format(dSource);
    }

}
