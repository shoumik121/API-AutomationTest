package api.test.contest.detail;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ContestDetailTest {
	
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void TC00_getContestDetailsId() {
		
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
		
		JSONArray jsonArray = new JSONArray(dataStringList);
        FrequentlyUsedFunctions.setContestId(jsonArray.getString(0));
		System.out.println("CONTEST ID LIST: "+dataStringList+"\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getContestDetailsId⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 2)
	public void TC31_contestDetailsTest() {
		
		int ExpectedValue = 24;
		Response response = EndPoints.contestDetailsEndpoint();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();			
//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
	
//		feeding that value to a list
		String dataStringId = jsonPath.getString("data."+testReturnObject.toString()+".brand._id");

        System.out.println(dataStringId.length());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringId.length(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC31_contestDetailsTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 3)
	public void TC32_detailPageContestVideosTest() {
		
		int ExpectedValue = 10;
		Response response = EndPoints.detailPageContestVideosEndpoint();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();			
//      	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
	
//		feeding that value to a list
		List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString());
			
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
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC32_detailPageContestVideosTest⚡⚡⚡⚡⚡⚡⚡");
	}
}
