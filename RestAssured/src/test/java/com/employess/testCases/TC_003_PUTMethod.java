package com.employess.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employess.base.TestBase;
import com.employess.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class TC_003_PUTMethod extends TestBase
{
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSalary();
	String empAge = RestUtils.empAge();
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	void GETMethod_SingleUser() throws InterruptedException
	{
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		JSONObject requestParameters = new JSONObject();
		requestParameters.put("name", empName);
		requestParameters.put("salary", empSalary);
		requestParameters.put("age", empAge);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParameters.toJSONString());
		
		response = httpRequest.request(Method.PUT,"/update/"+empID);
		
		Thread.sleep(5000);
		
	}
	
	
	@Test
	void checkResponseBody()
	{
		logger.info("**********************Checking Response Body**********************");
		String responsebody = response.getBody().asString();
		logger.info("Response Body==>>"+responsebody);
		Assert.assertTrue(responsebody!=null);
		Assert.assertEquals(responsebody.contains(empName), true);
		Assert.assertEquals(responsebody.contains(empSalary), true);
		Assert.assertEquals(responsebody.contains(empAge), true);
	}
	
	@Test(enabled=false)
	void checkResponseBodyElement()
	{
		logger.info("**********************Checking Status Code**********************");
		
		System.out.println(response.jsonPath().get("name"));
		Assert.assertEquals(response.jsonPath().get("name"), empName);
		Assert.assertEquals(response.jsonPath().get("salary"), empSalary);
		Assert.assertEquals(response.jsonPath().get("age"), empAge);
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
	
	@Test
	void checkXEzoicCdn()
	{
		logger.info("**********************Checking x-ezoic-cdn Type**********************");
		String xPoweredByType = response.header("x-ezoic-cdn");
		logger.info("Status Line==>>"+xPoweredByType);
		Assert.assertEquals(xPoweredByType, "Miss");
	}

	

}
