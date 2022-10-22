package org.sps.admin.automationscripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automationscripts_practice2_subject {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	    Thread.sleep(2000);
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    driver.get("http://rmgtestingserver/domain/Student_Management_System/");
	    driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmit")).click();
	    driver.findElement(By.xpath("//span[.='Subject']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Enter Subject name']")).sendKeys("p0");
	    driver.findElement(By.xpath("//button[.='Submit']")).click();
	    WebElement d1=driver.findElement(By.xpath("//select[@name='example1_length']"));
		Select s1=new Select(d1);
		s1.selectByVisibleText("100");
		 List<WebElement> headerlist = driver.findElements(By.xpath("//div[@class='col-sm-12']/table/thead/tr/th"));
		 List<WebElement> subjectlist = new ArrayList<WebElement>();
		 
		 for(WebElement hl:headerlist)
		 {String headername=hl.getText();
		 if(headername.equals("Subject"))
		 {
			 subjectlist=driver.findElements(By.xpath("//table[@id='example1']/tbody/tr/td[2]"));
			 JavascriptExecutor js=(JavascriptExecutor) driver;
			 js.executeScript("window.scrollBy(0,1000)");
			  
			 for(WebElement s:subjectlist) 
				{String sd=s.getText();
				System.out.println(sd);
			
				
			/*	if(sd.equals("p0"))
				{
					System.out.println("TC Pass");
					
					
				}
				else
				{
					System.out.println("tc is fail");
				}
				*/
		}
		 }
		 }

		 driver.quit();
		
	}
}
