package org.sps.admin.automationscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_park_school.Constantpaths;
import org.tyss.SMS_Sandford_park_school.ExcelUtility;
import org.tyss.SMS_Sandford_park_school.FileUtility;
import org.tyss.SMS_Sandford_park_school.WebDriverUtility;

public class CreateExam {
	public static void main(String[] args) {
		FileUtility fb = new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		ExcelUtility eb=new ExcelUtility();
		String url = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH, "url");
		String browser = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH, "browser");
		String timeout = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH, "timeout");
		String username=fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"adminUn" );
		String password=fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"adminPassword");
		String subject=eb.getDataFromExcel(Constantpaths.EXCEL_PATH_TESTDATA,"SC",5,0);
		
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		driver.findElement(By.xpath("//span[.='Exam']")).click();
		driver.findElement(By.xpath("//a[.='Create Exam']")).click();
		driver.findElement(By.xpath("//a[.='Add ']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(subject);
		driver.findElement(By.xpath("//button[.='Submit']")).click();
		List<WebElement> headerlist = driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
		List<WebElement> namelist = new ArrayList<WebElement>();
		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Name")) {
				namelist = driver
						.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));

				int count = 0;

				for (WebElement n : namelist) {
					String nd = n.getText();

					if (nd.equals(subject)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
				

				driver.findElement(By.xpath("//a[.='Next']")).click();
				namelist = driver
						.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));

				for (WebElement n : namelist) {
					String nd = n.getText();

					if (nd.equals(subject)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
				if (count == 0) {
					System.out.println("Tc fail");
				}

			}

		}

		driver.close();

	}

}
