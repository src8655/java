package shop2;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Action_Login_Find_Id extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		
		return "login_find_id.tiles";
	}

}
