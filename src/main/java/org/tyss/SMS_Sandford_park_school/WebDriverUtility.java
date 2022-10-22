package org.tyss.SMS_Sandford_park_school;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists all WebDriver actions
 * @author PAAVANI
 *
 */

public class WebDriverUtility {
	/*
	 * This method is used to Launch the browser
	 * @author PAAVANI
	 */

	public WebDriver launchBrowser(String browser)
	
	{
		WebDriver driver=null;
		switch(browser)
		{case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
	 default:
		 System.out.println("you entered wrong browser key in the property file");
		 break;
		
		}
		return driver;
		
		
		}
	



	/**
	 *This method is used to maximize the browser
	 * @author PAAVANI
	 * 
	 */
public void maximizeBrowser(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * This method is used to wait the controller implicitly till load
 * @author PAAVANI
 * 
 */
	public void waitTillPageLoad(WebDriver driver,Long longTimeout)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	
}
	/**
	 * This method is used to open the application
	 * @author PAAVANI
	 */
	public void openApplication(WebDriver driver,String url)
	{
		driver.get(url);
		
	}
	/**
	 * This method is used to Launch browser,Maximize Browser,wait until page get load,navigate application
	 * @author PAAVANI
	 */
public WebDriver openBrowserWithApplication(String browser,Long longTimeout,String url)
{
	WebDriver driver = launchBrowser(browser);
	maximizeBrowser(driver);
	waitTillPageLoad(driver,longTimeout);
	openApplication(driver,url);
	return driver;
	
	
	
}
/**
 *This method is used to do mouse hover action 
 * @author PAAVANI
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{ 
	new Actions(driver).moveToElement(element).perform();
	
}
/**
 * This method is used to double click on webelement
 * @author PAAVANI
 */

public void doubleClick(WebDriver driver,WebElement element)
{
	new Actions(driver).doubleClick(element).perform();
}
/**
 * This method is used to double click on page
 * @author PAAVANI
 */
public void doubleClick(WebDriver driver)
{
	new Actions(driver).doubleClick().perform();
}
/**
 * This method is used to close the application 
 * @author PAAVANI
 */
public void closeBrowser(WebDriver driver)
{
	driver.quit();
}
public WebElement convertDynamicxpathIntoWebElement(String dynamicXpath,String replaceData,WebDriver driver)
{
	String requiredXpath=String.format(dynamicXpath,replaceData);
	WebElement element=driver.findElement(By.xpath(requiredXpath));
	return element;
}
}






