package board2.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board2.*;


public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map pathMap = new HashMap();		//path맵 key=path, value=class(path별 객체 저장)

    public controller() {
        super();
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//configProperties 의 url이 담긴 파라미터
    	String configURL = config.getInitParameter("configURL");
    	Properties pr = new Properties();
    	FileInputStream f = null;
    	
    	//프로퍼티 경로
    	String configFilePath = config.getServletContext().getRealPath(configURL);
    	try {
			f = new FileInputStream(configFilePath);
	    	pr.load(f);
    	
	    	//하나씩 꺼낸다
	    	Iterator it = pr.keySet().iterator();
	    	while(it.hasNext()) {
	    		String path = (String)it.next();			//키=왼쪽
	    		String className = pr.getProperty(path);	//클래스=오른쪽
	    		
	    		Class pathClass;
				pathClass = Class.forName(className);		//객체를 받아서
		    	Object cinstance = pathClass.newInstance();	//새로운 객체를 생성
		    	pathMap.put(path, cinstance);
	    	}

		} catch (Exception e) {}finally {
		try {if(f != null) f.close();} catch (IOException e) {}}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		init(getServletConfig());
		
		//경로받기
		String path = request.getRequestURI().replaceAll(request.getContextPath(),"");
		
		//맵에서 path를 키로 한 객체를 가져오고
		Action action = (Action) pathMap.get(path);
		if(action != null) action.action_Init(request, response);
		
		response.getWriter().print(path);
		
		String url = null;
		
		
		//action 이 null이 아닐경우
		if(action != null) {
			url = action.execute();		//실행 후 forward경로 받기
					
			if(url != null) {
				//forward한다
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
