import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_Request 
{
	@Test
	public void getWeatherDetails()
	{
		//Specify base URI
		RestAssured.baseURI= "https://reqres.in/api/users";
		//Request Object
		RequestSpecification httprequest = RestAssured.given();
		//Response Opject
		Response response = httprequest.request(Method.GET, "/2");
		//Print in concol
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		String statusLine = response.statusLine();
		System.out.println("This is status line is:  "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		
	}
	

}
