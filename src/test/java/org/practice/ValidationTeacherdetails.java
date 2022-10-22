package org.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidationTeacherdetails {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Student_Management_System/");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys("abhi@gmail.com");
		driver.findElement(By.name("password")).sendKeys("12345");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("//span[.='Subject']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Subject name']")).sendKeys("Circuits");
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver
		
	
	}
	

}
