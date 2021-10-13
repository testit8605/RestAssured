package com.employess.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employess.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_005_DELETEMethod extends TestBase
{
	
	@BeforeClass
	void deleteEmployess() throws InterruptedException
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
//		response = httpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(3000);
		
//		JsonPath jPath = response.jsonPath();
//		String eid = jPath.get("[1].id");
//		System.out.println(eid);
		httpRequest.header("Content-Type", "application/json");
		response = httpRequest.request(Method.PUT,"/delete/"+empID);
		
		Thread.sleep(3000);
		
	}
	
	@Test
	void checkResponseBody()
	{
		logger.info("**********************Checking Response Body**********************");
		String responsebody = response.getBody().asString();
		logger.info("Response Body==>>"+responsebody);
		Assert.assertTrue(responsebody!=null);
		Assert.assertEquals(responsebody.contains("Successfully! Record has been deleted"), true);
		
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
		Assert.assertTrue(responseTime<10000);
	}
	
	@Test
	void checkContentType()
	{
		logger.info("**********************Checking Content Type**********************");
		String contentType = response.header("Content-Type");
		logger.info("Status Line==>>"+contentType);
		Assert.assertEquals(contentType, "application/json");
	}
	
	@Test
	void checkServerType()
	{
		logger.info("**********************Checking Server Type**********************");
		String serverType = response.header("Server");
		logger.info("Status Line==>>"+serverType);
		Assert.assertEquals(serverType, "cloudflare");
	}

}
