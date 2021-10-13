import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_GoogleMapTest 
{
	@Test
	public void googleMapApi()
	{
		//Specify base URI
		RestAssured.baseURI= "https://reqres.in";
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		//Response Object
		Response response = httpRequest.request(Method.GET,"/api/users/2");
		//Response Body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body"+responseBody);
		//Response headers
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json; charset=utf-8");
		String transferEncoding = response.header("Transfer-Encoding");
		Assert.assertEquals(transferEncoding, "chunked");
		String Connection = response.header("Connection");
		Assert.assertEquals(Connection, "keep-alive");
		
	}
	

}
