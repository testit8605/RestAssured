import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_AuthenticationAPI 
{
	@Test
	public void AuthenticationAPI ()
	{
		//Specify Base URI
		RestAssured.baseURI="https://postman-echo.com/basic-auth";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authschem = new PreemptiveBasicAuthScheme();
		authschem.setUserName("postman");
		authschem.setPassword("password");
		RestAssured.authentication=authschem;
		
		
		RequestSpecification httpRequest= RestAssured.given();
		Response response = httpRequest.request(Method.GET, "/");
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		int ststuscode = response.statusCode();
		System.out.println(ststuscode);
		Assert.assertEquals(ststuscode, 200);
		
		
		
		
		
		
	}
	
	

}
