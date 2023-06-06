package api.test.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NotificationTest {
	
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
	
	@Test(priority = 2)
	public void TC42_showNotificationListTest() {
		
		int ExpectedValue = 267;
		Response response = EndPoints.showNotificationListEndpoint(FrequentlyUsedFunctions.getAdminLiveToken());
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();			
//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		Object dataObject = jsonPath.getString("data."+testReturnObject.toString());

		System.out.println("Video details Found: "+ dataObject);
        System.out.println(dataObject.toString().length());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataObject.toString().length(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC42_showNotificationListTest⚡⚡⚡⚡⚡⚡⚡");
	}
}
