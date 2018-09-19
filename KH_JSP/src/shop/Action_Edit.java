package shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Action_Edit extends Action_Init implements Action {

	@Override
	public String execute() throws ServletException, IOException {
		
		int no = -1;
		
		if(request.getParameter("no") != null)
			no = Integer.parseInt(request.getParameter("no"));
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		List_Data_Bean ldata = ldb.getArticle(no);
		
		int ship_company = 1;
		if(ldata.getShip_company().equals("CJ대한통운")) ship_company = 1;
		if(ldata.getShip_company().equals("우체국택배")) ship_company = 2;
		if(ldata.getShip_company().equals("한진택배")) ship_company = 3;
		if(ldata.getShip_company().equals("로젠택배")) ship_company = 4;
		if(ldata.getShip_company().equals("CVSnet편의점")) ship_company = 5;

		request.setAttribute("ldata", ldata);
		request.setAttribute("ship_company", ship_company);
		
		
		return "edit.jsp";
	}

}
