import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_008_DataDriver 
{
	@Test
	public void DataDriver() throws IOException
	{

		String path  = "./src/test/java/DDTestCase.xlsx";
		XLUtils xlreader =new XLUtils(path);

		int rowcount = xlreader.getRowCount("Sheet4");
		System.out.println(rowcount);
		int cellcount = xlreader.getCellCount("Sheet4", 1);
		System.out.println(cellcount);

		for(int i=1; i<=5; i++)
		{
			String name1 = xlreader.getCellData("Sheet4", i, 0);
			String job1 = xlreader.getCellData("Sheet4", i, 1);
			
			System.out.println(name1);
			System.out.println(job1);

			RestAssured.baseURI="https://reqres.in/api";
			RequestSpecification httpRequest = RestAssured.given();

			JSONObject obj = new JSONObject();
			obj.put("name", name1);
			obj.put("job", job1);

			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(obj.toJSONString());

			Response response = httpRequest.request(Method.POST, "/users");

			String responseBody = response.getBody().asString();
			System.out.println(responseBody);
			Assert.assertEquals(responseBody.contains(name1), true);
			Assert.assertEquals(responseBody.contains(job1), true);

			int ststusCode = response.getStatusCode();
			System.out.println(ststusCode);
			Assert.assertEquals(ststusCode, 201);

		}
	}




}
