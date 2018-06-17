package genericActionsLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile {
	static String testData;
	public static String readExcel(String filePath, int sheeNum, int rowNum, int cellNum) throws Exception
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(sheeNum);
		Row row = sheet.getRow(rowNum);
		
		testData = row.getCell(cellNum).getStringCellValue();
		return testData;
	}
	public static void writeExcel(String filePath, int sheeNum, int rowNum, int cellNum) throws Exception
	{
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheetAt(sheeNum);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue("Passed");
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
	}
}
