package org.laraclassified.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.tyss.SMS_Sandford_park_school.WebDriverUtility;

public class CreateUserAccount {
	
	
	public static void main(String[] args) throws InterruptedException
	{WebDriver driver=null;
		WebDriverUtility wb=new WebDriverUtility();
		driver=wb.openBrowserWithApplication("chrome",10l,"http://122.166.192.191:9003/");
		
		driver.findElement(By.xpath("//a[.='Signup']")).click();
		WebElement gender = driver.findElement(By.xpath("//select[@name='gender']"));
		Select g=new Select(gender);
		g.selectByVisibleText("Mrs");
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("uvwp01");
		driver.findElement(By.xpath("//input[@id='user_type-3']")).click();
		WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
		Select c=new Select(country);
		c.selectByVisibleText("India");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1029384765");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("uvwp001@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='password_confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[.=' Register ']")).click();
		WebElement i = driver.findElement(By.xpath("//p[.='Your account has been created.']"));
		String inform = i.getText();
		if(inform.equals("Your account has been created."))
		{
			System.out.println("user account is successfully created");
		}
		else
		{
			System.out.println("user account is not created");
		}
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("uvwp001@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[.=' Login ']")).click();
		WebElement login = driver.findElement(By.xpath("//h3[.='Hello uvwp01 ! ']"));
		String l=login.getText();
		System.out.println(l);
		
		if(l.equals("Hello uvwp01 !"))
		{
			System.out.println("user account is successfully logged");
		}
		else
		{
			System.out.println("user account is not logged");
		}
			
		driver.findElement(By.xpath("//a[.='Signout  ']")).click();
		System.out.println("over");
		WebElement homepage = driver.findElement(By.xpath("//a[.='Login']"));
	    String h = homepage.getText();
	    if(h.equals("Login"))
		{
			System.out.println("user account is successfully loggedout");
			System.out.println("Tc is pass");
		}
		else
		{
			System.out.println("user account is not loggedout");
			System.out.println("Tc is fail");
		}
	    
		/*driver.findElement(By.xpath(""))
		driver.findElement(By.xpath(""))
		driver.findElement(By.xpath(""))
		driver.findElement(By.xpath(""))*/
		wb.closeBrowser(driver);
	}

}
