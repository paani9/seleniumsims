package org.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPriceList {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    Thread.sleep(1000);
	    driver.manage().window().maximize();
	    Thread.sleep(1000);
	    driver.get("https://www.amazon.com");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("mobile phone");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	    Thread.sleep(2000);
	    //WebElement price = driver.findElement(By.xpath("//span[.='SAMSUNG Galaxy Z Fold 4 Cell Phone, Factory Unlocked Android Smartphone, 512GB, Flex Mode, Hands Free Video, Multi Window View, Foldable Display, S Pen Compatible, US Version, Beige']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
	    WebElement price = driver.findElement(By.xpath("//span[.='SAMSUNG Galaxy S22+ Cell Phone, Factory Unlocked Android Smartphone, 128GB, 8K Camera & Video, Brightest Display Screen, Long Battery Life, Fast 4nm Processor, US Version, Pink Gold']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
	    Thread.sleep(2000);
	    String p = price.getText();
	    Thread.sleep(1000);
	    System.out.println(p);
	    Thread.sleep(1000);
	    driver.quit();
	    FileInputStream fis=new FileInputStream("./src/test/resources/practice1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		Row row = sheet.createRow(10);
		Cell cell=row.createCell(1);
		cell.setCellValue(p);
		FileOutputStream fout = new FileOutputStream("./src/test/resources/practice1.xlsx");
		wb.write(fout);
		wb.close();
		System.out.println("Data successfully updated");
	    
	 
	}

}
