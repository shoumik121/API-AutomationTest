package api.test.mobile.homepage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.EndPoints;
import api.endpoints.FrequentlyUsedFunctions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class HomepageIntegrationsTest {
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void TC08_homepagePerticularTypeContestsTest() {
		
		Response response = EndPoints.perticularTypeContests();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);

//  Expected value
			int ExpectedValue = 10;		
		
		JsonPath jsonPath = response.jsonPath();
//      returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//      Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC08_homepagePerticularTypeContestsTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 2)
	public void TC09_homepageBrandsTest() {
		Response response = EndPoints.homepageBrands();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
//  Expected value
		int ExpectedValue = 10;
		
		JsonPath jsonPath = response.jsonPath();
//      returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//      Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC09_homepageBrandsTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 3)
	public void TC10_homepageOffersTest() {
	
		Response response = EndPoints.homepageOffers();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
//  Expected value
		int ExpectedValue = 11;
		
		JsonPath jsonPath = response.jsonPath();
//      returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//      Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC10_homepageOffersTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 4)
	public void TC11_homepageTopSellingFromTrafficTest() {
		
		Response response = EndPoints.homepageTopSellingFromTraffic();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//	    System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC11_homepageTopSellingFromTrafficTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 5)
	public void TC12_homepageTrendingVideosTrendingTagTest() {
		
		Response response = EndPoints.homepageTrendingVideosTrendingTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);		
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC12_homepageTrendingVideosTrendingTagTest⚡⚡⚡⚡⚡⚡⚡");
	}
	
	@Test(priority = 6)
	public void TC13_homepageTalentVideosByHashTagTest() {
		
		Response response = EndPoints.talentVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 2;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC13_homepageTalentVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 7)
	public void TC14_homepageBeautyVideosByHashTagTest() {
		
		Response response = EndPoints.beautyVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC14_homepageBeautyVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 8)
	public void TC15_homepageTechVideosByHashTagTest() {
		
		Response response = EndPoints.techVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC15_homepageTechVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 9)
	public void TC16_homepageFashionVideosByHashTagTest() {
		
		Response response = EndPoints.fashionVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//			System.out.println(dataStringList);
	      
//			checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC16_homepageFashionVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 10)
	public void TC17_homepageFoodVideosByHashTagTest() {
		
		Response response = EndPoints.foodVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 11;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC17_homepageFoodVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 11)
	public void TC18_homepageSportsVideosByHashTagTest() {
		
		Response response = EndPoints.sportsVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);

		logger.info("⚡⚡⚡⚡⚡⚡⚡TC18_homepageSportsVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 12)
	public void TC19_homepageSmartphoneVideosByHashTagTest() {
		
		Response response = EndPoints.smartphoneVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC19_homepageSmartphoneVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 13)
	public void TC20_homepageTravelVideosByHashTagTest() {
		
		Response response = EndPoints.travelVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC20_homepageTravelVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 14)
	public void TC21_homepageDecorVideosByHashTagTest() {
		
		Response response = EndPoints.decorVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 3;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC21_homepageDecorVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 15)
	public void TC22_homepageHomeapplianceVideosByHashTagTest() {
		
		Response response = EndPoints.homeapplianceVideosByHashTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC22_homepageHomeapplianceVideosByHashTagTest⚡⚡⚡⚡⚡⚡⚡");
	}

	@Test(priority = 16)
	public void TC23_homepageTrendingVideosNewTagTest() {
		
	
		
		Response response = EndPoints.homepageTrendingVideosNewTag();
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
				
//  Expected value
		int ExpectedValue = 10;
			
		JsonPath jsonPath = response.jsonPath();
//		returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		Optional! To handle string use --> dataNullCheckerString

//		feeding that value to a list
		List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//		System.out.println(dataStringList);
	      
//		checks two integer values (input vs expected) here checking array size
		System.out.println("⚡" + dataStringList.size());
		FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
		
		logger.info("⚡⚡⚡⚡⚡⚡⚡TC23_homepageTrendingVideosNewTagTest⚡⚡⚡⚡⚡⚡⚡");
	}
}


