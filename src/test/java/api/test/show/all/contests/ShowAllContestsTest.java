package api.test.show.all.contests;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ShowAllContestsTest {

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
		System.out.println(FrequentlyUsedFunctions.getAdminLiveToken());
	
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_adminLiveApiTokenGenerator⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 2)
	public void TC00_getUserListId() {
		
		Response response = EndPoints.togetUserListInfoEndpoint();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();
		
//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
//		System.out.println(testReturnObject);
		
//		feeding that value to a list
		List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
		System.out.println(dataStringList);
		
//		Removing empty arrays
		for (int i = 0; i < dataStringList.size(); i++) {
            if (dataStringList.size() == 0) {
            	dataStringList.remove(i);
                i--; // Decrement i to adjust for the removed element
            }      
        }
		JSONArray jsonArray = new JSONArray(dataStringList);
        FrequentlyUsedFunctions.setUserId(jsonArray.getString(0));
//		System.out.println(FrequentlyUsedFunctions.getUserId());

		logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getUserListId⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 3)
	public void TC24_showAllMyParticipationContestsTest() {
		
		int ExpectedValue = 0;
		Response response = EndPoints.showMyParticipationContests();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();			
//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			
//		Removing empty arrays
		for (int i = 0; i < dataStringList.size(); i++) {
            if (dataStringList.size() == 0) {
            	dataStringList.remove(i);
                i--; // Decrement i to adjust for the removed element
            }      
        }
		System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC24_showAllMyParticipationContestsTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 4)
	public void TC25_showAllperticularTypeContestsCustomTest() {
		
		int ExpectedValue = 10;
		Response response = EndPoints.perticularTypeContestsCustom();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();			
//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			
//		Removing empty arrays
		for (int i = 0; i < dataStringList.size(); i++) {
            if (dataStringList.size() == 0) {
            	dataStringList.remove(i);
                i--; // Decrement i to adjust for the removed element
            }      
        }
		System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC24_showAllMyParticipationContestsTest⚡⚡⚡⚡⚡⚡⚡");
	}
}
