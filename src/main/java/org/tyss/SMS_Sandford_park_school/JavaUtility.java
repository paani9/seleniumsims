package org.tyss.SMS_Sandford_park_school;

import java.util.Random;

/**
 * This class consists all java reusable actions
 * @author PAAVANI
 *
 */

public class JavaUtility {
	
	public int getRandomNumber(int limit)
	{
		
		/**
		 * This method is used to generate the random number
		 * 
		 */
		return new Random().nextInt(limit);
		
	}
	

}
