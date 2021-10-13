import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataProviderMethod 
{
	@Test(dataProvider="Userdata")
	public void DataDriver(String name, String job)
	{
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("job", job);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(obj.toJSONString());

		Response response = httpRequest.request(Method.POST, "/users");
	
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		Assert.assertEquals(responseBody.contains(name), true);
		Assert.assertEquals(responseBody.contains(job), true);
		
		int ststusCode = response.getStatusCode();
		System.out.println(ststusCode);
		Assert.assertEquals(ststusCode, 201);
	}
	
	
	
	@DataProvider(name="Userdata")
	String[][] getData() throws IOException
	{
		String path = "C:\\Users\\bhaga\\myworkspace\\RestAssured\\src\\test\\java\\DDTestCase.xlsx";
		XLUtils xlreader =new XLUtils(path);
		
		int rowcount = xlreader.getRowCount("Sheet4");
		System.out.println(rowcount);
		int cellcount = xlreader.getCellCount("Sheet4", 1);
		System.out.println(cellcount);
		
		String data[][] = new String[rowcount][cellcount];
		
		for(int i=1;i<=6; i++)
		{
			for(int j=0;j<=1;j++)
			{
				data[i-1][j]=xlreader.getCellData("Sheet4", i, j);
			}
		}
		
		return data;
	}
	

}
