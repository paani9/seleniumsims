package org.sps.admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchingDataFromPropertyFile {
	public static void main(String[] args) throws IOException 
	{
			FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		
 Properties  property=new Properties();
 property.load(fis);
 String url=property.getProperty("url").trim();
 String un=property.getProperty("adminUn").trim();
 String pwd=property.getProperty("adminPwd").trim(); 
 //String browser=property.getProperty("Browser");
 String browser=(String) property.setProperty("Browser","Google");
 String b=property.getProperty("Browser");
 System.out.println(url);
 System.out.println(un);
 System.out.println(pwd);
System.out.println(b);
	}

	}


