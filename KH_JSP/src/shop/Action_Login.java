package shop;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {

		String user_id = "";	//�������̵�

		//��Ű����
		Cookie_Bean cmanager = Cookie_Bean.getInstance();
		user_id = cmanager.getId(request);	//��Ű���� ���̵� �޾ƿ´�


		request.setAttribute("user_id", user_id);
		
		
		return "login.tiles";/////
	}

}
