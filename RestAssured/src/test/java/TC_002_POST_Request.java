import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_POST_Request 
{
	@Test
	public void postMethod()
	{
		//Specify base URI
		RestAssured.baseURI="https://reqres.in/api";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request Payload sending along with post request
		JSONObject requestparameters = new JSONObject();
		requestparameters.put("name", "Vaibhav");
		requestparameters.put("job", "QA analysist");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestparameters.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST, "/users");
		
		//Response Body to perform validation
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.getStatusCode();
		String statusLine = response.getStatusLine();
		System.out.println(statusCode+":"+ statusLine);
		Assert.assertEquals(statusCode, 201);
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
		
		String name = response.jsonPath().get("name");
		Assert.assertEquals(name, "Vaibhav");
		
		
	}
	
	
	

}
