package shop;

import java.io.File;
import java.io.IOException;

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
	
	private File file1 = null;
	private File file2 = null;
	private File file3 = null;
	private File file4 = null;
	private File file5 = null;
	private String file1FileName = null;
	private String file2FileName = null;
	private String file3FileName = null;
	private String file4FileName = null;
	private String file5FileName = null;
	private String file1ContentType = null;
	private String file2ContentType = null;
	private String file3ContentType = null;
	private String file4ContentType = null;
	private String file5ContentType = null;
	private File save = null;
	
	private String msg = "";
	private String url = "";
	
	
	int category = -1;
	String name = "";
	int money = 0;
	int discount = 0;
	String made = "";
	int ship_money = 0;
	String ship_company = "";
	int sellers = -1;
	
	@Override
	public String execute() throws IOException {
		//String dir = "d:\\"; 
		String dir = request.getRealPath(savePathd)+"\\";
		
		if(!file1FileName.equals("")) {
			int tmp = 0;
			//중복된 파일명 방지
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"_ch1("+tmp+")"+file1FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file1FileName = filename_tmp;
			FileUtils.copyFile(file1, save);
		}
		if(!file2FileName.equals("")) {
			int tmp = 0;
			//중복된 파일명 방지
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"_ch2("+tmp+")"+file2FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file2FileName = filename_tmp;
			FileUtils.copyFile(file2, save);
		}
		if(!file3FileName.equals("")) {
			int tmp = 0;
			//중복된 파일명 방지
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"_ch3("+tmp+")"+file3FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file3FileName = filename_tmp;
			FileUtils.copyFile(file3, save);
		}
		if(!file4FileName.equals("")) {
			int tmp = 0;
			//중복된 파일명 방지
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"_ch4("+tmp+")"+file4FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file4FileName = filename_tmp;
			FileUtils.copyFile(file4, save);
		}
		if(!file5FileName.equals("")) {
			int tmp = 0;
			//중복된 파일명 방지
			String filename_tmp;
			do {
				filename_tmp = year+"-"+month+"-"+day+"_ch5("+tmp+")"+file5FileName;
				save = new File(dir+filename_tmp);
				tmp++;
			}while(save.exists());
			file5FileName = filename_tmp;
			FileUtils.copyFile(file5, save);
		}
		
		List_Data_Bean ldata = new List_Data_Bean();
		ldata.setCategory(category);
		ldata.setName(name);
		ldata.setMoney(money);
		ldata.setDiscount(discount);
		ldata.setMade(made);
		ldata.setShip_money(ship_money);
		ldata.setShip_company(ship_company);
		ldata.setSellers(sellers);

		ldata.setFile1(file1FileName);
		ldata.setFile2(file2FileName);
		ldata.setFile3(file3FileName);
		ldata.setFile4(file4FileName);
		ldata.setFile5(file5FileName);
		ldata.setDates(year+"-"+month+"-"+day);
    	
    	//할인가격 계산
    	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
    	ldata.setRmoney(rmoney);
		
		
		
		
		
		List_DB_Bean ldb = List_DB_Bean.getInstance();
		ldb.insert_M(ldata);
		
		//res=1이면 성공
		//int res = 0;
		//if(ldb.insert(request, session)) res = 1;
		
		msg = "작성 성공";
		url = "write.o";
		
		return SUCCESS;
	}


	public String getMsg() {
		return msg;
	}
	public String getUrl() {
		return url;
	}
	public File getFile1() {
		return file1;
	}
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public String getFile1FileName() {
		return file1FileName;
	}
	public void setFile1FileName(String file1FileName) {
		this.file1FileName = file1FileName;
	}
	public String getFile1ContentType() {
		return file1ContentType;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	public void setFile2(File file2) {
		this.file2 = file2;
	}
	public void setFile3(File file3) {
		this.file3 = file3;
	}
	public void setFile4(File file4) {
		this.file4 = file4;
	}
	public void setFile5(File file5) {
		this.file5 = file5;
	}
	public void setFile2FileName(String file2FileName) {
		this.file2FileName = file2FileName;
	}
	public void setFile3FileName(String file3FileName) {
		this.file3FileName = file3FileName;
	}
	public void setFile4FileName(String file4FileName) {
		this.file4FileName = file4FileName;
	}
	public void setFile5FileName(String file5FileName) {
		this.file5FileName = file5FileName;
	}
	public void setFile2ContentType(String file2ContentType) {
		this.file2ContentType = file2ContentType;
	}
	public void setFile3ContentType(String file3ContentType) {
		this.file3ContentType = file3ContentType;
	}
	public void setFile4ContentType(String file4ContentType) {
		this.file4ContentType = file4ContentType;
	}
	public void setFile5ContentType(String file5ContentType) {
		this.file5ContentType = file5ContentType;
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

	
}
