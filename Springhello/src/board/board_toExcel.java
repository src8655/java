package board;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.sun.corba.se.spi.orbutil.fsm.Action;

import board.model.List_Data;


public class board_toExcel extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//값가져오기
		Map map = (Map)model.get("map");
		List<List_Data> list = (List<List_Data>) map.get("list_data");
		Action_Paging paging = (Action_Paging)map.get("paging");
		int pages = (int)map.get("pages");
		
		//시트생성
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "게시판");
		sheet.setColumnWidth(1, 256 * 20);
		
		//제목들
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell;
		cell = firstRow.createCell(0);
		cell.setCellValue("번호");
		cell = firstRow.createCell(1);
		cell.setCellValue("제목");
		cell = firstRow.createCell(2);
		cell.setCellValue("이름");
		cell = firstRow.createCell(3);
		cell.setCellValue("날짜");
		cell = firstRow.createCell(4);
		cell.setCellValue("조회수");
		
		//내용생성
		for(int i=0;i<list.size();i++) {
			List_Data ldata = (List_Data)list.get(i);
			int num = paging.getBoard_total()-(i)-(pages*paging.getBoard_lengths()-paging.getBoard_lengths());
			createPageRankRow(sheet,ldata,i+1,num);
		}
	}
	
	//내용넣기(한줄씩=rowNum)
	private void createPageRankRow(HSSFSheet sheet, List_Data ldata, int rowNum, int num) {
		HSSFRow row = sheet.createRow(rowNum);
		HSSFCell cell;
		
		cell = row.createCell(0);
		cell.setCellValue(num);

		cell = row.createCell(1);
		cell.setCellValue(ldata.getSubject());

		cell = row.createCell(2);
		cell.setCellValue(ldata.getName());

		cell = row.createCell(3);
		cell.setCellValue(ldata.getDates());

		cell = row.createCell(4);
		cell.setCellValue(ldata.getHit());

	}
}
