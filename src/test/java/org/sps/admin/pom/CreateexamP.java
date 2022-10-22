package org.sps.admin.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tyss.SMS_Sandford_park_school.Constantpaths;
import org.tyss.SMS_Sandford_park_school.ExcelUtility;
import org.tyss.SMS_Sandford_park_school.FileUtility;
import org.tyss.SMS_Sandford_park_school.WebDriverUtility;
import org.tyss.objectRepository.Allexampage;
import org.tyss.objectRepository.Commonpage;
import org.tyss.objectRepository.Loginpage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateexamP {
	public static void main(String[] args) {
		FileUtility fb = new FileUtility();
		WebDriverUtility wb = new WebDriverUtility();
		ExcelUtility eb=new ExcelUtility();
		String url = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH, "url");
		String browser = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH, "browser");
		String timeout = fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH, "timeout");
		String username=fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"adminUn" );
		String password=fb.getDataFromPropertyFile(Constantpaths.PROPERTY_FILE_PATH,"adminPassword");
		String subject=eb.getDataFromExcel(Constantpaths.EXCEL_PATH_TESTDATA,"SC",4,0);
		
		Long timeouts = Long.parseLong(timeout);
		WebDriver driver = wb.openBrowserWithApplication(browser, timeouts, url);
		Loginpage loginpage=new Loginpage(driver);
		Commonpage commonpage=new Commonpage(driver);
		Allexampage ad=new Allexampage(driver);
		
		
		loginpage.loginAction(username, password);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		commonpage.clickRequiredTab(Tabnamesforhomepage.EXAMTAB,wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.CREATEEXAMTAB,wb);
		ad.addButtonClick();
		ad.addExam(subject);
		List<WebElement> headerlist = ad.getHeaderList();
		
		
		
	
		//driver.findElement(By.xpath("//span[.='Exam']")).click();
		//driver.findElement(By.xpath("//a[.='Create Exam']")).click();
		//driver.findElement(By.xpath("//a[.='Add ']")).click();
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys(subject);
		//driver.findElement(By.xpath("//button[.='Submit']")).click();
		//List<WebElement> headerlist = driver.findElements(By.xpath("//table[@id='example1']/thead/tr/th"));
		List<WebElement> namelist = new ArrayList<WebElement>();
		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Name")) {
				//namelist = driver
						//.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
				namelist = ad.getNameList();

				int count = 0;

				for (WebElement n : namelist) {
					String nd = n.getText();

					if (nd.equals(subject)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
				
                  //ad.nextbuttonClick();
				//driver.findElement(By.xpath("//a[.='Next']")).click();
				//namelist = driver
						//.findElements(By.xpath("//table[@id='example1']/thead/following-sibling::tbody/tr/td[2]"));
			/*	namelist = ad.getNameList();
				for (WebElement n : namelist) {
					String nd = n.getText();

					if (nd.equals(subject)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}*/
				if (count == 0) {
					System.out.println("Tc fail");
				}

			}

		}

		wb.closeBrowser(driver);

	}

}



