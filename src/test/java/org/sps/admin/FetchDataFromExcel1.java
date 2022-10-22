package org.sps.admin;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/practice1.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		DataFormatter df = new DataFormatter();
		Sheet sheet=wb.getSheet("sheet1");
		Row row=sheet.getRow(0);
		Cell cell = row.getCell(0);
	//String data=cell.getStringCellValue();
		//double data = cell.getNumericCellValue();
		String data=df.formatCellValue(cell);
	System.out.println(data);
	wb.close();
	}

}
