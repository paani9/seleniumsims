package org.sps.admin.automationscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_park_school.WebDriverUtility;

public class automationScripts_1 {
public static void main(String[] args)
{  
	WebDriver driver=null;
	WebDriverUtility wb=new WebDriverUtility();
	driver=wb.openBrowserWithApplication("chrome",10l,"http://rmgtestingserver/domain/Student_Management_System/");
	 //driver.get("http://rmgtestingserver/domain/Student_Management_System/");
	    driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver.findElement(By.xpath("//span[.='Exam']")).click();
		driver.findElement(By.xpath("//a[.='Create Exam']")).click();
		driver.findElement(By.xpath("//a[.='Add ']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter exam name']")).sendKeys("a");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		List<WebElement> headerlist =driver.findElements(By.xpath("//table//tr//th"));
		List<WebElement> subjectlist = new ArrayList<WebElement>();
		 for(WebElement hl:headerlist)
		 {String headername=hl.getText();
		 if(headername.equals("Subject"))
		 {
			 subjectlist=driver.findElements(By.xpath("//table[@id='example1']//tbody//tr//td[2]"));
			 JavascriptExecutor js=(JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,500)");
			 
			 
			 for(WebElement s:subjectlist) 
				{String sd=s.getText();
				
				
				if(sd.equals("a"))
				{
					System.out.println("subject is updated");
					break;
					
				}
				
		 }
		 }
		 }
		 driver.quit();
}
}
		
		

