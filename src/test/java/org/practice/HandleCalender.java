package org.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCalender {
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		 String actualMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		 System.out.println(actualMonthYear);
		driver.close();
	}

}
