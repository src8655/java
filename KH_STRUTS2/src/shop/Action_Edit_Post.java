package shop;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.Action;

public class Action_Edit_Post extends Action_Init implements Action, ServletRequestAware, ServletResponseAware {
	public static String savePathd = "/shop/upload/";	//파일저장 상대경로
	
	private File[] files = new File[5];
	private String[] filesFileName = new String[5];
	private String[] filesContentType = new String[5];
	private File save = null;
	
	int no = -1;
	
	int category = -1;
	String name = "";
	int money = 0;
	int discount = 0;
	String made = "";
	int ship_money = 0;
	String ship_company = "";
	int sellers = -1;
	String memo = "";
	
	int file_del1 = -1;
	int file_del2 = -1;
	int file_del3 = -1;
	int file_del4 = -1;
	int file_del5 = -1;
	
	
	@Override
	public String execute() throws Exception {
		super.run();
		
		//판매자인지 아닌지 확인
		if(member_info == null) {
			msg = "로그인 해주세요.";
			url = "login.o";
					
			return LOGIN;
		}
		if(member_info.getOrders() != 2) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		

		List_DB_Bean ldb = List_DB_Bean.getInstance();
		
		//내 게시글이 아니면 에러
		List_Data_Bean ldatas = ldb.getArticle_M(no);
		if(ldatas.getSellers() != member_info.getNo()) {
			msg = "잘못된 접근입니다.";
			return ERROR;
		}
		
		

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

		
		ldata.setDates(year+"-"+month+"-"+day);
    	
    	//할인가격 계산
    	int rmoney = (int)((double)ldata.getMoney()-((double)ldata.getMoney()*(ldata.getDiscount()/100.0)));
    	ldata.setRmoney(rmoney);
		
    	//삭제 명령시
    	if(file_del1 != -1) ldata.setFile1(""); else ldata.setFile1(ldatas.getFile1());
    	if(file_del2 != -1) ldata.setFile2(""); else ldata.setFile2(ldatas.getFile2());
    	if(file_del3 != -1) ldata.setFile3(""); else ldata.setFile3(ldatas.getFile3());
    	if(file_del4 != -1) ldata.setFile4(""); else ldata.setFile4(ldatas.getFile4());
    	if(file_del5 != -1) ldata.setFile5(""); else ldata.setFile5(ldatas.getFile5());
    	
    	

		if(!filesFileName[0].equals("")) ldata.setFile1(filesFileName[0]);
		if(!filesFileName[2].equals("")) ldata.setFile2(filesFileName[1]);
		if(!filesFileName[3].equals("")) ldata.setFile3(filesFileName[2]);
		if(!filesFileName[4].equals("")) ldata.setFile4(filesFileName[3]);
		if(!filesFileName[5].equals("")) ldata.setFile5(filesFileName[4]);
		
		
    	ldata.setNo(ldatas.getNo());
		
		
		//1이면 성공 0이면 실패
		int res = 0;
		if(ldb.update_M(ldata)) res = 1;
		
		
		if(res == 1) {
			msg = "수정 성공.";
			url = "mypage_list.o";
					
			return SUCCESS;
		}else{
			msg = "수정 실패.";
			return ERROR;
		}
	}


	public static String getSavePathd() {
		return savePathd;
	}


	public static void setSavePathd(String savePathd) {
		Action_Edit_Post.savePathd = savePathd;
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


	public File getSave() {
		return save;
	}


	public void setSave(File save) {
		this.save = save;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public String getMade() {
		return made;
	}


	public void setMade(String made) {
		this.made = made;
	}


	public int getShip_money() {
		return ship_money;
	}


	public void setShip_money(int ship_money) {
		this.ship_money = ship_money;
	}


	public String getShip_company() {
		return ship_company;
	}


	public void setShip_company(String ship_company) {
		this.ship_company = ship_company;
	}


	public int getSellers() {
		return sellers;
	}


	public void setSellers(int sellers) {
		this.sellers = sellers;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public int getFile_del1() {
		return file_del1;
	}


	public void setFile_del1(int file_del1) {
		this.file_del1 = file_del1;
	}


	public int getFile_del2() {
		return file_del2;
	}


	public void setFile_del2(int file_del2) {
		this.file_del2 = file_del2;
	}


	public int getFile_del3() {
		return file_del3;
	}


	public void setFile_del3(int file_del3) {
		this.file_del3 = file_del3;
	}


	public int getFile_del4() {
		return file_del4;
	}


	public void setFile_del4(int file_del4) {
		this.file_del4 = file_del4;
	}


	public int getFile_del5() {
		return file_del5;
	}


	public void setFile_del5(int file_del5) {
		this.file_del5 = file_del5;
	}

}
