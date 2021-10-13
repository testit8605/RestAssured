package com.employess.base;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import com.employess.utilities.RestUtils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase 
{
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public String ID = "2";
	public String empID = "9";
	
	
	
	
	public Logger logger;
	
	
	@BeforeClass
	public void setUp()
	{
		logger= Logger.getLogger("EmployessRestAPI");
		PropertyConfigurator.configure("Log4j2.properties");
		logger.setLevel(Level.DEBUG);
	
	}
	
	
	
	
	

}
