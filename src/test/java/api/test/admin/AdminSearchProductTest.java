package api.test.admin;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import graphql.Assert;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.awt.RenderingHints.Key;
import java.util.*;

public class AdminSearchProductTest {
	public Logger logger;

	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void TC00_adminLiveApiTokenGenerator() {
		
		JSONObject valuesJsonObjectA = new JSONObject();
		valuesJsonObjectA.put("email", "admin@fanfare.com.bd");
		valuesJsonObjectA.put("firebaseRegToken", "123456");
		valuesJsonObjectA.put("password", "fAD53bb!");
		
		JSONObject variables = new JSONObject();
		variables.put("signInUserEmailInput", valuesJsonObjectA);
		
		Response response = EndPoints.signInToLiveApiAsAdminEndpoint(variables);
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);

		JsonPath jsonPath = response.jsonPath();
		String access_token = jsonPath.getString("data."+FrequentlyUsedFunctions.dataNullChecker(jsonPath).toString()+".access_token");
		FrequentlyUsedFunctions.setAdminLiveToken(access_token);
//		System.out.println(FrequentlyUsedFunctions.getAdminLiveToken());
	
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_adminLiveApiTokenGenerator⚡⚡⚡⚡⚡⚡⚡");
	}
	
	/**
	 * TestCase: TC_07
	 * Description: Verify SignIn Test to ADMIN
	 */
	@Test(priority = 2)
	public void TC07_AdminLoginSearchProductTest() {
		
		int ExpectedValue = 1;
//		JSONObject dateRange = new JSONObject();
//		dateRange.put("endDate", "2023-05-05");
//		dateRange.put("startDate","2023-01-10");
//		
//		JSONObject productSearchInput = new JSONObject();
//		productSearchInput.put("brandName", "null");
//		productSearchInput.put("dateRange", dateRange);
//		productSearchInput.put("id", "null");
//		productSearchInput.put("productName", "null");
//		productSearchInput.put("sellerName", "null");
//		
//		JSONObject variables = new JSONObject();
//		variables.put("productSearchInput", productSearchInput);
//		variables.put("perPage", 10);
//		variables.put("pageNumber", 10);
				
		Response response = EndPoints.signInWithAdmin(FrequentlyUsedFunctions.getAdminLiveToken());
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);

		JsonPath jsonPath = response.jsonPath();

//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
		System.out.println(dataStringList.size());
      
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC07_AdminLoginSearchProductTest⚡⚡⚡⚡⚡⚡⚡");
			
	}
}
