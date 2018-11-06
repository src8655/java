package tour;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.*;

public class Action_Basket extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	List list;
	int isEmpty = 0;
	
	//edit,del,add
	int no = -1;
	int max_cnts = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		list = new ArrayList();
		
		
		
		if(session.getAttribute("basket") == null) {
			isEmpty = 1;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (int) it.next();
				
				SqlMapClient sqlmap = FactoryService.getSqlmap();
				List_Reserve_Data lrdata = (List_Reserve_Data) sqlmap.queryForObject("List_Reserve_getArticle", key);
				
				//삭제된 경우
				if(lrdata == null) {
					HashMap maps = (HashMap)session.getAttribute("basket");
					maps.remove(key);
					session.setAttribute("basket", map);
					continue;
				}
				//이미 예약된경우
				if(lrdata.getIsreserve() == 1) {
					HashMap maps = (HashMap)session.getAttribute("basket");
					maps.remove(key);
					session.setAttribute("basket", map);
					continue;
				}
			}
		}
		
		

		if(session.getAttribute("basket") == null) {
			isEmpty = 1;
		}else {
			HashMap map = (HashMap)session.getAttribute("basket");
			Iterator it = map.keySet().iterator();
			
			while(it.hasNext()) {
				int key = (int) it.next();
				
				SqlMapClient sqlmap = FactoryService.getSqlmap();
				List_Reserve_Data lrdata = (List_Reserve_Data) sqlmap.queryForObject("List_Reserve_getArticle", key);
				
				//갯수 넣고
				lrdata.setChoice_cnts((int)map.get(key));
				
				//갯수만큼 금액변경
				lrdata.setMoney(lrdata.getMoney()*lrdata.getChoice_cnts());
				lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));

				
				list.add(lrdata);
			}
		}
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		//최초입력이 아닐때
		HashMap map = (HashMap)session.getAttribute("basket");
		map.put(no, max_cnts);
		session.setAttribute("basket", map);
		
		msg = "변경 성공";
		url = "basket.o";
		
		return SUCCESS;
	}
	public String del() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		//최초입력이 아닐때
		HashMap map = (HashMap)session.getAttribute("basket");
		map.remove(no);
		session.setAttribute("basket", map);
		
		msg = "삭제 성공";
		url = "basket.o";
		
		return SUCCESS;
	}
	public String add() throws Exception {
		super.run();
		
		if(no == -1) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		//최초 입력
		if(session.getAttribute("basket") == null) {
			HashMap map = new HashMap();
			map.put(no, max_cnts);
			session.setAttribute("basket", map);
		}else {
			//최초입력이 아닐때
			HashMap map = (HashMap)session.getAttribute("basket");
			map.put(no, max_cnts);
			session.setAttribute("basket", map);
		}
		
		msg = "추가 성공";
		url = "basket.o";
		
		return SUCCESS;
	}
	
	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public int getIsEmpty() {
		return isEmpty;
	}


	public void setIsEmpty(int isEmpty) {
		this.isEmpty = isEmpty;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getMax_cnts() {
		return max_cnts;
	}
	public void setMax_cnts(int max_cnts) {
		this.max_cnts = max_cnts;
	}
	
    
}
