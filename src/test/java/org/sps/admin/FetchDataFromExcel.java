package org.sps.admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/testdata1.xlsx");
		Workbook wb=WorkbookFactory.create(fisExcel);
		Sheet sheet=wb.getSheet("CommonData");
		Row row=sheet.getRow(1);
		Cell cell = row.getCell(1);
	String url=cell.getStringCellValue();
	System.out.println(url);
	wb.close();
		
		
	}

}
