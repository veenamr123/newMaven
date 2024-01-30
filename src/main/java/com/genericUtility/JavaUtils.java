package com.genericUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	
	/**
	 *This method is used to generate a random number 
	 * @return
	 */
	public int getRandomNo()
	{
		Random r = new Random();
		int ran = r.nextInt(100);
		return ran;
	}
	
	/**
	 * This method is used to get system date 
	 * @return
	 */
	public String getSystemDate()
	{
		 Date dt = new Date();
		 String date = dt.toString();
		 return date;
	}
	
	/**
	 * This method is used to get system date in format
	 * @return
	 */
	
	public String getSystemDateInFormat()
	{
		SimpleDateFormat datefor = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		
		Date dt = new Date();
		
		String dateFormat = datefor.format(dt);
		return dateFormat;
	}
	
}
