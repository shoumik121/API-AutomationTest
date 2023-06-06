package api.test.video;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class VideoTest {
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void TC00_getVideoId() {
//		Input Parameters
		String inputVideoTitleForQueryParam = "love";
		FrequentlyUsedFunctions.setVideoTitle(inputVideoTitleForQueryParam);
		int ExpectedValue = 10;
		
		Response response = EndPoints.searchVideoEndpoint();
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
		FrequentlyUsedFunctions.setVideoId(dataStringList.get(0).toString());
//		System.out.println(FrequentlyUsedFunctions.getVideoId());

		System.out.println("Video Id Found: "+ dataStringList);
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getVideoId⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 2)
	public void TC40_showCommentsForVideoTest() {
//		Input Parameters
		int ExpectedValue = 0;
		
		Response response = EndPoints.showCommentsForVideoEndpoint();
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

		System.out.println("Comments Found: "+ dataStringList);
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC40_showCommentsForVideoTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 3)
	public void TC41_singleVideoTest() {
//		Input Parameters
		int ExpectedValue = 881;
		
		Response response = EndPoints.singleVideoEndpoint();
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
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC41_singleVideoTest⚡⚡⚡⚡⚡⚡⚡");
	}
}
