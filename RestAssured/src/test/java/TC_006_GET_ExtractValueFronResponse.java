import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_006_GET_ExtractValueFronResponse 
{
	
	@Test
	public void ExtractValueFronResponse()
	{
		//Specify Base URI
		RestAssured.baseURI="https://reqres.in/api/users";
		//Request Object
		RequestSpecification httpRequest= RestAssured.given();
		//Response Object
		Response response  = httpRequest.request(Method.GET, "/7");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(jsonPath.get("email"));
		
		String firstName = jsonPath.get("first_name");
		System.out.println(firstName);
		
	}
	
	

}
