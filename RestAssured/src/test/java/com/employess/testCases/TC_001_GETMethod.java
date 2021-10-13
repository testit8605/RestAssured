package com.employess.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employess.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_001_GETMethod extends TestBase
{
	
	@BeforeClass
	public void GETMethod() throws InterruptedException
	{
		logger.info("**********************Started TC_001_GETMethod**********************");
		
		RestAssured.baseURI="https://reqres.in/api/users";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/2");
		
		Thread.sleep(3000);
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("**********************Checking Response Body**********************");
		String responsebody = response.getBody().asString();
		logger.info("Response Body==>>"+responsebody);
		Assert.assertTrue(responsebody!=null);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("**********************Checking Status Code**********************");
		int statusCode = response.statusCode();
		logger.info("Status Code==>>"+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("**********************Checking Status Line**********************");
		String statusLine= response.statusLine();
		logger.info("Status Line==>>"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkResponseTime()
	{
		logger.info("**********************Checking Response Time**********************");
		long responseTime= response.getTime();
		logger.info("Status Line==>>"+responseTime);
		Assert.assertTrue(responseTime<2000);
	}
	
	@Test
	void checkContentType()
	{
		logger.info("**********************Checking Content Type**********************");
		String contentType = response.header("Content-Type");
		logger.info("Status Line==>>"+contentType);
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
	}
	
	@Test
	void checkServerType()
	{
		logger.info("**********************Checking Server Type**********************");
		String serverType = response.header("Server");
		logger.info("Status Line==>>"+serverType);
		Assert.assertEquals(serverType, "cloudflare");
	}
	
	@Test
	void checkXPoweredBy()
	{
		logger.info("**********************Checking x-powered-by Type**********************");
		String xPoweredByType = response.header("x-powered-by");
		logger.info("Status Line==>>"+xPoweredByType);
		Assert.assertEquals(xPoweredByType, "Express");
	}
	
	
	@AfterClass
	void tearDown()
	{
		logger.info("**********************Finished TC_001_GETMethod**********************");
	}
	
	
	
	

}
