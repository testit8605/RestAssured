import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_GET_ValidatingJsonResponse 
{
	@Test
	public void getHeaderDetails()
	{
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response Opject
		Response response = httpRequest.request(Method.GET, "/api/users/7");
		
		String responseBody  = response.getBody().asString();
		System.out.println(responseBody);
		
		boolean id = responseBody.contains("7");
		Assert.assertEquals(id, true);
		
		
	}
	

}
