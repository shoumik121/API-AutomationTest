package api.test.search;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SearchTest {
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void TC36_searchUserTest() {
//		Input Parameters
		String inputStringForQueryStringParam = "Guru";
		FrequentlyUsedFunctions.setSearchQuery(inputStringForQueryStringParam);
		int ExpectedValue = 10;
		
		Response response = EndPoints.searchUserEndpoint();
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
		
		System.out.println("Users list Name:"+jsonPath.getList("data."+testReturnObject.toString()+".name"));
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC36_searchUserTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 2)
	public void TC37_searchVideoHashtagTest() {
//		Input Parameters
		String inputHashtagForQueryParam = "New";
		FrequentlyUsedFunctions.setHashtag(inputHashtagForQueryParam);
		int ExpectedValue = 10;
		
		Response response = EndPoints.searchVideoHashtagEndpoint();
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
		
		System.out.println("Video Titles:"+jsonPath.getList("data."+testReturnObject.toString()+"._id"));
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC37_searchVideoHashtagTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 3)
	public void TC38_searchVideoTest() {
//		Input Parameters
		String inputVideoTitleForQueryParam = "prank";
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
		List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString());
			
//		Removing empty arrays
		for (int i = 0; i < dataStringList.size(); i++) {
            if (dataStringList.size() == 0) {
            	dataStringList.remove(i);
                i--; // Decrement i to adjust for the removed element
            }      
        }
		
		System.out.println("Videos Found:"+jsonPath.getList("data."+testReturnObject.toString()+".hashtags"));
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC38_searchVideoTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 4)
	public void TC39_searchContestTest() {
//		Input Parameters
		String inputSearchContestForQueryParam = "Beauty";
		FrequentlyUsedFunctions.setContestTitle(inputSearchContestForQueryParam);
		int ExpectedValue = 10;
		
		Response response = EndPoints.searchContestEndpoint();
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
		
		System.out.println("Contests Found:"+jsonPath.getList("data."+testReturnObject.toString()+".name"));
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC39_searchContestTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
}
