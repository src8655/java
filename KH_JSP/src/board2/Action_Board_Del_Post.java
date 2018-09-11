package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Del_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String no = request.getParameter("no");

		//����� ���
		String passwords = "";
		if(member_info != null) {
			passwords = member_info.getPasswords();
		}else{
			passwords = request.getParameter("passwords");
		}

		//��ȣȭ
		passwords = Md5Enc.getEncMD5(passwords.getBytes());



		Board_DB_Bean bdb = Board_DB_Bean.getInstance();

		//������ 1 ���н� 0
		int res = 1;
		if(!bdb.delete(Integer.parseInt(no), passwords)) res = 0;


		request.setAttribute("no", no);
		request.setAttribute("res", res);
		
		return "board_del_post.jsp";
	}

}
