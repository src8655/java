package tour;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.Action;

import config.FactoryService;
import tour.data.List_Data;
import tour.data.List_Reserve_Data;
import tour.data.Reserve_Data;

public class Action_Admin_List extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	Action_Paging paging;
	List list;
	
	//write_post
	public static String savePathd = "/tour/upload/";	//�������� �����
	
	private File file1;
	private String file1FileName;
	private String file1ContentType;
	private File save = null;
	
	
	private String subject = "";
	private String city = "";
	private int days = -1;
	private String air = "";
	private int money = -1;
	private String memo1 = "";
	private String memo2 = "";
	private int category = -1;
	
	//reserve_post
	int list_no = -1;
	String startdates = "";
	String enddates = "";
	//String subject = "";
	int max_cnts = 0;
	//int money = 0;
	int special = 0;
	
	//edit
	int no = -1;
	List_Data ldata;
	
	//edit_post
	/*public static String savePathd = "/tour/upload/";	//�������� �����
	
	private File file1;
	private String file1FileName;
	private String file1ContentType;
	private File save = null;
	
	
	private String subject = "";
	private String city = "";
	private int days = -1;
	private String air = "";
	private int money = -1;
	private String memo1 = "";
	private String memo2 = "";*/
	private int categorys = -1;
	//int no = -1;
	
	//del
	//int no = -1;
	
	//reserve_del
	//int no = -1;
	//int list_no = -1;
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		Map map = new HashMap();
		map.put("category", category);
		map.put("searchs", searchs);
		int tmp = (int)sqlmap.queryForObject("List_getCount", map);
		paging = new Action_Paging(tmp, 10, pages);
		map.clear();
		map.put("category", category);
		map.put("searchs", searchs);
		map.put("start", paging.getBoard_starts());
		map.put("end", paging.getBoard_ends());
		list = (List)sqlmap.queryForList("List_getArticles", map);
		
		
		
		return SUCCESS;
	}
	public String write() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		return SUCCESS;
	}
	public String write_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		if(subject.equals("")) {
			msg = "��ǰ���� �Է��� �ּ���.";
			return ERROR;
		}
		if(city.equals("")) {
			msg = "���൵�ø� �Է��� �ּ���.";
			return ERROR;
		}
		if(days == -1) {
			msg = "����Ⱓ�� �Է��� �ּ���.";
			return ERROR;
		}
		if(air.equals("")) {
			msg = "�������� �Է��� �ּ���.";
			return ERROR;
		}
		if(money == -1) {
			msg = "�ݾ��� �Է��� �ּ���.";
			return ERROR;
		}
		if(category == -1) {
			msg = "ī�װ��� ������ �ּ���.";
			return ERROR;
		}
		
		
		
		//���� ó��
		String dir = request.getRealPath(savePathd)+"\\";
		if(!file1FileName.equals("")) {
			int tmp = 0;
			//�ߺ��� ���ϸ� ����
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"("+tmp+")"+file1FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file1FileName = filename_tmp;
			FileUtils.copyFile(file1, save);
		}
		
		
		List_Data ldata = new List_Data();
		ldata.setSubject(subject);
		ldata.setCity(city);
		ldata.setDays(days);
		ldata.setAir(air);
		ldata.setMoney(money);
		ldata.setMoneys(Number_Format.number_format(money));
		ldata.setMemo1(memo1);
		ldata.setMemo2(memo2);
		ldata.setCategory(category);
		ldata.setDates(year+"-"+month+"-"+day);
		ldata.setFile1(file1FileName);
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.insert("List_insert", ldata);
		
		msg = "�ۼ� ����.";
		url = "admin_list_write.o";
		
		return SUCCESS;
	}
	public String reserve_post() throws Exception {
		super.run();
		
		List_Reserve_Data lrdata = new List_Reserve_Data();
		lrdata.setList_no(list_no);
		lrdata.setStartdates(startdates);
		lrdata.setEnddates(enddates);
		lrdata.setSubject(subject);
		lrdata.setMax_cnts(max_cnts);
		lrdata.setMoney(money);
		lrdata.setMoneys(Number_Format.number_format(lrdata.getMoney()));
		if(special == 1) lrdata.setSpecial(1);
		else lrdata.setSpecial(0);
		lrdata.setDates(year+"-"+month+"-"+day);
		
		
		String[] split = startdates.split("-");
		if(split.length != 3) {
			msg = "�߸��� ����� �����Դϴ�.";
			return ERROR;
		}

		//times
		int y = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int d = Integer.parseInt(split[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(y, m-1, d);
		lrdata.setTimes(Long.toString(calendar.getTimeInMillis()));
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.insert("List_Reserve_insert", lrdata);

		msg = "�ۼ� ����";
		url = "view.o?no="+list_no+"&category="+category+"&searchs="+searchs_utf;
		
		return SUCCESS;
	}
	public String edit() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		ldata = (List_Data)sqlmap.queryForObject("List_getArticle", no);
		
		
		return SUCCESS;
	}
	public String edit_post() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		if(subject.equals("")) {
			msg = "��ǰ���� �Է��� �ּ���.";
			return ERROR;
		}
		if(city.equals("")) {
			msg = "���൵�ø� �Է��� �ּ���.";
			return ERROR;
		}
		if(days == -1) {
			msg = "����Ⱓ�� �Է��� �ּ���.";
			return ERROR;
		}
		if(air.equals("")) {
			msg = "�������� �Է��� �ּ���.";
			return ERROR;
		}
		if(money == -1) {
			msg = "�ݾ��� �Է��� �ּ���.";
			return ERROR;
		}
		if(categorys == -1) {
			msg = "ī�װ��� ������ �ּ���.";
			return ERROR;
		}
		
		
		//���� ó��
		String dir = request.getRealPath(savePathd)+"\\";
		
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		List_Data ldatas = (List_Data)sqlmap.queryForObject("List_getArticle", no);
		List_Data ldata = new List_Data();
		//�������ϸ��� ����
		ldata.setFile1(ldatas.getFile1());
		
		if(!file1FileName.equals("")) {
			int tmp = 0;
			//�ߺ��� ���ϸ� ����
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"("+tmp+")"+file1FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file1FileName = filename_tmp;
			FileUtils.copyFile(file1, save);
			
			//������ ������ ��쿡�� ���� ����
			ldata.setFile1(file1FileName);
		}
		
		ldata.setNo(no);
		ldata.setSubject(subject);
		ldata.setCity(city);
		ldata.setDays(days);
		ldata.setAir(air);
		ldata.setMoney(money);
		ldata.setMoneys(Number_Format.number_format(money));
		ldata.setMemo1(memo1);
		ldata.setMemo2(memo2);
		ldata.setCategory(categorys);
		ldata.setDates(year+"-"+month+"-"+day);
		
		sqlmap.update("List_edit", ldata);
		
		msg = "���� ����.";
		url = "admin_list.o?pages="+pages+"&category="+category+"&searchs="+searchs_utf;
		
		return SUCCESS;
	}
	public String del() throws Exception {
		super.run();
		
		if(member_info == null) {
			msg = "�α������ּ���.";
			url = "login.o";
			return LOGIN;
		}
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.delete("List_del", no);
		
		msg = "���� ����";
		url = "admin_list.o?pages="+pages+"&category="+category+"&searchs="+searchs_utf;
		
		return SUCCESS;
	}
	public String reserve_del() throws Exception {
		super.run();
		
		if(level != 3) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		if(no == -1) {
			msg = "�߸��� �����Դϴ�.";
			return ERROR;
		}
		
		SqlMapClient sqlmap = FactoryService.getSqlmap();
		sqlmap.delete("List_Reserve_del", no);
		
		msg = "���� ����";
		url = "view.o?pages="+pages+"&category="+category+"&searchs="+searchs_utf+"&no="+list_no;
		
		return SUCCESS;
	}
	
	
	//����set�Լ�
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	
	public Action_Paging getPaging() {
		return paging;
	}

	public List getList() {
		return list;
	}
	public File getSave() {
		return save;
	}
	public void setSave(File save) {
		this.save = save;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getAir() {
		return air;
	}
	public void setAir(String air) {
		this.air = air;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getMemo1() {
		return memo1;
	}
	public void setMemo1(String memo1) {
		this.memo1 = memo1;
	}
	public String getMemo2() {
		return memo2;
	}
	public void setMemo2(String memo2) {
		this.memo2 = memo2;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getList_no() {
		return list_no;
	}
	public void setList_no(int list_no) {
		this.list_no = list_no;
	}
	public String getStartdates() {
		return startdates;
	}
	public void setStartdates(String startdates) {
		this.startdates = startdates;
	}
	public String getEnddates() {
		return enddates;
	}
	public void setEnddates(String enddates) {
		this.enddates = enddates;
	}
	public int getMax_cnts() {
		return max_cnts;
	}
	public void setMax_cnts(int max_cnts) {
		this.max_cnts = max_cnts;
	}
	public int getSpecial() {
		return special;
	}
	public void setSpecial(int special) {
		this.special = special;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public List_Data getLdata() {
		return ldata;
	}
	public void setLdata(List_Data ldata) {
		this.ldata = ldata;
	}
	public int getCategorys() {
		return categorys;
	}
	public void setCategorys(int categorys) {
		this.categorys = categorys;
	}
	public void setPaging(Action_Paging paging) {
		this.paging = paging;
	}
	public void setList(List list) {
		this.list = list;
	}
	
}
