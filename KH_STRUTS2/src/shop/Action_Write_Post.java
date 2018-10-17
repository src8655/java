package shop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Action_Write_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	public static String savePathd = "/shop/upload/";	//파일저장 상대경로
	
	private File[] files;
	private String[] filesFileName;
	private String[] filesContentType;
	private File save = null;
	
	
	
	int category = -1;
	String name = "";
	int money = 0;
	int discount = 0;
	String made = "";
	int ship_money = 0;
	String ship_company = "";
	int sellers = -1;
	String memo = "";
	
	@Override
	public String execute() throws Exception {
		super.run();
		String dir = request.getRealPath(savePathd)+"\\";
		
		for(int i=0;i<files.length;i++) {
			if(!filesFileName[i].equals("")) {
				int tmp = 0;
				//중복된 파일명 방지
				String filename_tmp;
				do {
					filename_tmp = year+"-"+month+"-"+day+"_ch"+i+"("+tmp+")"+filesFileName[i];
					save = new File(dir+filename_tmp);
					tmp++;
				}while(save.exists());
				filesFileName[i] = filename_tmp;
				FileUtils.copyFile(files[i], save);
				
			}
		}
		
		List_Data_Bean ldata = new List_Data_Bean();
		ldata.setCategory(category);
		ldata.setName(name);
		ldata.setMoney(money);
		ldata.setDiscount(discount);
		ldata.setMade(made);
		ldata.setShip_money(ship_money);
		ldata.setShip_company(ship_company);
		ldata.setSellers(member_info.getNo());
		ldata.setMemo(memo);

		if(files.length >= 1) ldata.setFile1(filesFileName[0]);
		if(files.length >= 2) ldata.setFile2(filesFileName[1]);
		if(files.length >= 3) ldata.setFile3(filesFileName[2]);
		if(files.length >= 4) ldata.setFile4(filesFileName[3]);
		if(files.length >= 5) ldata.setFile5(filesFileName[4]);
		ldata.setDates(year+"-"+month+"-"+day);
    	
    	//할인가격 계산
    	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
    	ldata.setRmoney(rmoney);
		

		
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldb.insert_M(ldata);
		

		
		msg = "작성 성공";
		url = "write.o";
		
		return SUCCESS;
	}

	public static void setSavePathd(String savePathd) {
		Action_Write_Post.savePathd = savePathd;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public void setMade(String made) {
		this.made = made;
	}
	public void setShip_money(int ship_money) {
		this.ship_money = ship_money;
	}
	public void setShip_company(String ship_company) {
		this.ship_company = ship_company;
	}
	public void setSellers(int sellers) {
		this.sellers = sellers;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}



	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public String[] getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}
	public String[] getFilesContentType() {
		return filesContentType;
	}
	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}
	
}
