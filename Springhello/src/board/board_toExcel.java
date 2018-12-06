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
		
		//����������
		Map map = (Map)model.get("map");
		List<List_Data> list = (List<List_Data>) map.get("list_data");
		Action_Paging paging = (Action_Paging)map.get("paging");
		int pages = (int)map.get("pages");
		
		//��Ʈ����
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "�Խ���");
		sheet.setColumnWidth(1, 256 * 20);
		
		//�����
		HSSFRow firstRow = sheet.createRow(0);
		HSSFCell cell;
		cell = firstRow.createCell(0);
		cell.setCellValue("��ȣ");
		cell = firstRow.createCell(1);
		cell.setCellValue("����");
		cell = firstRow.createCell(2);
		cell.setCellValue("�̸�");
		cell = firstRow.createCell(3);
		cell.setCellValue("��¥");
		cell = firstRow.createCell(4);
		cell.setCellValue("��ȸ��");
		
		//�������
		for(int i=0;i<list.size();i++) {
			List_Data ldata = (List_Data)list.get(i);
			int num = paging.getBoard_total()-(i)-(pages*paging.getBoard_lengths()-paging.getBoard_lengths());
			createPageRankRow(sheet,ldata,i+1,num);
		}
	}
	
	//����ֱ�(���پ�=rowNum)
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
