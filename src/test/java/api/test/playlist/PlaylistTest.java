package api.test.playlist;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PlaylistTest {
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1)
	public void TC33_topUsersTest() {
		
		int ExpectedValue = 20;
		Response response = EndPoints.topUsersEndpoint();
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
		
		System.out.println("TopUser Name:"+jsonPath.getList("data."+testReturnObject.toString()+".name").get(0));
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC33_topUsersTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 3)
	public void TC35_listVideoTypesTest() {
		
		int ExpectedValue = 10;
		Response response = EndPoints.listVideoTypesEndpoint();
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
		
		System.out.println("FirstObject Name:"+jsonPath.getList("data."+testReturnObject.toString()+".name").get(0));
        System.out.println(dataStringList.size());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC35_listVideoTypesTest⚡⚡⚡⚡⚡⚡⚡");
	}
}
