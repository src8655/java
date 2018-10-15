package shop2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Write extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		
		
		return "write.tiles";
	}

}
