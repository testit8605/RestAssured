package com.employess.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils 
{
	
	public static String empName()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		
		String name = "Akshay"+generatedString;
	
		return name;
	}
	
	public static String empSalary()
	{
		String randomStringForSalary = RandomStringUtils.randomNumeric(4);
		
		return randomStringForSalary;
	}
	
	public static String empAge()
	{
		String randonStringForAge = RandomStringUtils.randomNumeric(2);
		
		return randonStringForAge;
	}
	
	

}
