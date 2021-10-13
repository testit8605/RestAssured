import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_GET_Request_PrintAllHeaader 
{
	@Test
	public void printAllHeader()
	{
		//Specify Base URI
		RestAssured.baseURI= "https://reqres.in";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response Object
		Response response = httpRequest.request(Method.GET,"/api/users/2");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
		
		String contentType = response.header("Content-Type");
		System.out.println(contentType);
		
		//All header returned from response
		Headers allHeaders = response.headers();
		
		for(Header header: allHeaders)
		{
			System.out.println("*******************");
			System.out.println(header.getName()+"   :    "+header.getValue());
		
		}
	}
}
