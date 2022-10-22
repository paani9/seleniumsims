package org.tyss.SMS_Sandford_park_school;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists reusable method to handle property file
 * @author PAAVANI
 *
 */

public class FileUtility {
	public String getDataFromPropertyFile(String propertyFilePath,String key)
	{
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 Properties  property=new Properties();
		 try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String value=property.getProperty(key).trim();
		 return value;

}
}
