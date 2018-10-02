package shop.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.Action;

public class shop_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map pathMap = new HashMap();		//path�� key=path, value=class(path�� ��ü ����)
       
    public shop_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		//configProperties �� url�� ��� �Ķ����
    	String configURL = config.getInitParameter("configURL");
    	Properties pr = new Properties();
    	FileInputStream f = null;
    	
    	//������Ƽ ���
    	String configFilePath = config.getServletContext().getRealPath(configURL);
    	try {
			f = new FileInputStream(configFilePath);
	    	pr.load(f);
    	
	    	//�ϳ��� ������
	    	Iterator it = pr.keySet().iterator();
	    	while(it.hasNext()) {
	    		String path = (String)it.next();			//Ű=����
	    		String className = pr.getProperty(path);	//Ŭ����=������
	    		
	    		Class pathClass;
				pathClass = Class.forName(className);		//��ü�� �޾Ƽ�
		    	Object cinstance = pathClass.newInstance();	//���ο� ��ü�� ����
		    	pathMap.put(path, cinstance);
	    	}

		} catch (Exception e) {}finally {
		try {if(f != null) f.close();} catch (IOException e) {}}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		init(getServletConfig());
		
		//��ιޱ�
		String path = request.getRequestURI().replaceAll(request.getContextPath(),"");
		
		//�ʿ��� path�� Ű�� �� ��ü�� ��������
		Action action = (Action) pathMap.get(path);
		if(action != null) action.action_Init(request, response);
		
		
		//response.getWriter().print("shops"+path);
		
		String url = null;
		
		
		//action �� null�� �ƴҰ��
		if(action != null) {
			url = action.execute();		//���� �� forward��� �ޱ�
			//response.getWriter().print("execute�� ����");
			if(url != null) {
				//forward�Ѵ�
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
