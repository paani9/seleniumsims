package org.tyss.SMS_Sandford_park_school;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is consists all common action on excel
 * @author PAAVANI
 *
 */

public class ExcelUtility {
	public String getDataFromExcel(String excelPath,String sheetName,int rowNumber,int cellNumber) 
	{  
		/**
		 * This method is used to fetch the data from excel
		 * 
		 */
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook wb=null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet(sheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}

}
