package org.sps.admin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {
public static void main(String[] args) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/test/resources/practice1.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("Sheet1");
	Row row = sheet.createRow(10);
	Cell cell=row.createCell(1);
	cell.setCellValue("pass");
	FileOutputStream fout = new FileOutputStream("./src/test/resources/practice1.xlsx");
	wb.write(fout);
	
	wb.close();
	System.out.println("Data successfully updated");
	
	
}

}
