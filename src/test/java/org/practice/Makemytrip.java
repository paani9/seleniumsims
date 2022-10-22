package org.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='From']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("SDQ, Las Americas Intl Dominican Republic");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='Santo Domingo, Dominican Republic']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='To']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("BLR, Bengaluru International Airport India");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		
		Thread.sleep(3000);//class="langCardClose"
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		//driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//p[.='27']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Search']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
