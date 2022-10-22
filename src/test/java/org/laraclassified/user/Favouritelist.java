package org.laraclassified.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_park_school.WebDriverUtility;

public class Favouritelist {
	public static void main(String[] args) 
	{
		WebDriverUtility wb = new WebDriverUtility();
		WebDriver driver = wb.openBrowserWithApplication("chrome",10l,"http://122.166.192.191:9003/");
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("uvw001@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[.=' Login ']")).click();
		driver.findElement(By.xpath("//img[@data-original-title='Lara  Classified Bhārat']")).click();
		driver.findElement(By.xpath("//input[@placeholder='What ?']")).sendKeys("car");
		driver.findElement(By.xpath("//strong[.='Find']")).click();
		driver.findElement(By.xpath("//a[@href='http://122.166.192.191:9003/car/421.html']/ancestor::div[@class='col-sm-7 add-desc-box']/following-sibling::div/a/i/following-sibling::span")).click();
		
		driver.findElement(By.xpath("//i[@class=' icon-down-open-big fa']")).click();
		driver.findElement(By.xpath("//a[.=' Favourite ads ']")).click();
		WebElement favproduct = driver.findElement(By.xpath("//strong/a[@href='http://122.166.192.191:9003/car/488.html']"));
		String fp = favproduct.getText();
		System.out.println(fp);
		if(fp.equals("car"))
		{
			System.out.println("tc is pass");
			
		}
		else
		{
			System.out.println("tc is fail");
		}
		
		wb.closeBrowser(driver);
	}

}
