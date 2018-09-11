package board2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Board_Comment_Del_Post extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		String no = request.getParameter("no");
		String data_no = request.getParameter("data_no");

		//����� ���
		String passwords_tmp = "";
		if(member_info != null) {
			passwords_tmp = member_info.getPasswords();
		}else{
			passwords_tmp = request.getParameter("passwords");
		}

		//��ȣȭ
		passwords_tmp = Md5Enc.getEncMD5(passwords_tmp.getBytes());

		int res = 0;	//�������� ��������
		Comment_DB_Bean cdb = Comment_DB_Bean.getInstance();
		if(cdb.delete(Integer.parseInt(no), passwords_tmp)) {
			//���ī��Ʈ����
			Board_DB_Bean bdb = Board_DB_Bean.getInstance();
			bdb.updateComment(Integer.parseInt(data_no));
			
			res = 1;
		}

		request.setAttribute("no", no);
		request.setAttribute("data_no", data_no);
		request.setAttribute("res", res);
		
		return "board_comment_del_post.jsp";
	}

}
