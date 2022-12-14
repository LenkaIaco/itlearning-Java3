package sk.itlearning.java3.java3b.p.excel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CreateExcelFile {

	public static void main(String[] args) {
		String EXCEL_FILE_LOCATION = "C:\\temp\\MyExcel.xls";
		WritableWorkbook myFirstWbook = null;
		try {
			myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
			WritableSheet excelSheet = myFirstWbook.createSheet("MySheet", 0);
			Label label = new Label(0, 0, "Test Count");
			excelSheet.addCell(label);
			myFirstWbook.write();
		} catch (IOException | WriteException e) {
			e.printStackTrace();
		} finally {
			if (myFirstWbook != null) {
				try {
					myFirstWbook.close();
				} catch (IOException | WriteException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
