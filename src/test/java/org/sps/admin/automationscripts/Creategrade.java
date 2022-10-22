package org.sps.admin.automationscripts;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_park_school.Constantpaths;
import org.tyss.SMS_Sandford_park_school.FileUtility;
import org.tyss.SMS_Sandford_park_school.WebDriverUtility;

public class Creategrade {
	public static void main(String[] args) throws InterruptedException
	{
		FileUtility fb=new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		String url = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"url");
		String browser = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"browser");
		String timeout=fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"timeout");
       Long timeouts = Long.parseLong(timeout);
	   WebDriver driver = wb.openBrowserWithApplication(browser,timeouts,url);
		driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Grade")).click();
		driver.findElement(By.id("name")).sendKeys("Grade a");
		driver.findElement(By.xpath("//input[@placeholder='Enter admission fee']")).sendKeys("2000");
		driver.findElement(By.xpath("//input[@id='hall_charge']")).sendKeys("30");
		driver.findElement(By.xpath("//button[.='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mark_range_text_1")).sendKeys("90-100");
		Thread.sleep(2000);
		driver.findElement(By.name("mark_grade[]")).sendKeys("s");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		List<WebElement> headerlist=driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
		List<WebElement> gradelist=new ArrayList<WebElement>();
		 for(WebElement hl:headerlist)
		 {String headername=hl.getText();
		 if(headername.equals("Grade"))
		 {
			 gradelist=driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
			 
 int count=0;
			 
			 
			 for(WebElement g:gradelist) 
				{String gd=g.getText();
			
				
				if(gd.equals("Grade a"))
				{
					System.out.println("TC Pass");
					count++;
					break;
					
				}
				
				
		}
			 Thread.sleep(3000);
			 
			 driver.findElement(By.xpath("//a[.='Next']")).click();
			 gradelist =driver.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
			
			 for(WebElement g:gradelist) 
				{String gd=g.getText();
			
				
				if(gd.equals("Grade a"))
				{
					System.out.println("TC Pass");
					count++;
					break;
					
				}
				
		 }
			 if(count==0)
			 {
				 System.out.println("Tc fail");
			 }
			
			 
		 }
		 
		 }
		 
	
wb.closeBrowser(driver);
}
	
		 

}



