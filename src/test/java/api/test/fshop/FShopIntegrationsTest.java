package api.test.fshop;

import java.util.ArrayList;
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

public class FShopIntegrationsTest {
	public Logger logger;
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
		
	    /*⚡FUF⚡*/
		@Test(priority = 1)
		public void TC00_signUpTokenGenerationTest() {
			
			JSONObject valuesJsonObjectC = new JSONObject();
			valuesJsonObjectC.put("code", "+880");
			valuesJsonObjectC.put("name", "Bangladesh");
			
			JSONObject valuesJsonObjectB = new JSONObject();
			valuesJsonObjectB.put("deviceId", "Iphone 14+");
			valuesJsonObjectB.put("deviceModel", "Pro Max");
			
			JSONObject valuesJsonObjectA = new JSONObject();
			valuesJsonObjectA.put("about", "Trying facebook signup");
			valuesJsonObjectA.put("country", valuesJsonObjectC);
			valuesJsonObjectA.put("dp", "Not available");
			valuesJsonObjectA.put("email", "shoumikrouf14@gmail.com");
			valuesJsonObjectA.put("firebaseRegToken", "123456");
			valuesJsonObjectA.put("id", "https://www.facebook.com/shoumikR/");
			valuesJsonObjectA.put("name", "MadMAx800");
			valuesJsonObjectA.put("platform", "fb");
			valuesJsonObjectA.put("referralCode", "Mr Beast");
			valuesJsonObjectA.put("signUpDevice", valuesJsonObjectB);	

			JSONObject variables = new JSONObject();
			variables.put("socialSignupUserInput", valuesJsonObjectA);
			
			Response response = EndPoints.signUpWithSocial(variables);
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();
			FrequentlyUsedFunctions.tokenStringGeneratorSignUp(jsonPath);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_signUpTokenGenerationTest⚡⚡⚡⚡⚡⚡⚡");	
		}
		
		/*⚡FUF⚡*/
		@Test(priority = 2)
		public void TC00_adminSignInTokenGenerationTest() {
			
			JSONObject valuesJsonObjectA = new JSONObject();
			valuesJsonObjectA.put("email", "admin@fanfare.com.bd");
			valuesJsonObjectA.put("firebaseRegToken", "123456");
			valuesJsonObjectA.put("password", "saD34$cc");
			
			JSONObject variables = new JSONObject();
			variables.put("signInUserEmailInput", valuesJsonObjectA);
			
			Response response = EndPoints.signInWithEmail(variables);
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);

			JsonPath jsonPath = response.jsonPath();
			FrequentlyUsedFunctions.tokenStringGeneratorSignIn(jsonPath);

//			System.out.println(FrequentlyUsedFunctions.getSignInToken());
//			System.out.println(FrequentlyUsedFunctions.getSignUpToken());
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_adminSignInTokenGenerationTest⚡⚡⚡⚡⚡⚡⚡");	
		}
		
		/*⚡FUF⚡*/
		@Test(priority = 10)
		public void TC00_getCategoryId() {
			
			Response response = EndPoints.toGetCategoryIdEndpoint();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();
			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
			
//			feeding that value to a list
			List <List<Object>> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".categories");
			
			List <Object> newDataList = new ArrayList<>();
//			Removing empty arrays
			for (int i = 0; i < dataStringList.size(); i++) {
	            if (dataStringList.get(i).size() == 0) {
	            	dataStringList.remove(i);
	                i--; // Decrement i to adjust for the removed element
	            }else {
	            	newDataList.add(dataStringList.get(i).get(0));
	            }        
	        }
			
			JSONArray jsonArray = new JSONArray(newDataList);
	        JSONObject firstObject = jsonArray.getJSONObject(0);
	        FrequentlyUsedFunctions.setCategoryId(firstObject.getString("_id"));
			
//	        System.out.println(FrequentlyUsedFunctions.getCategoryId());
//          Forced TypeCasted OUTPUT
//			System.out.println(((Map<String, Object>) newDataList.get(0)).get("_id"));
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getCategoryId⚡⚡⚡⚡⚡⚡⚡");
		}
		
		/*⚡FUF⚡*/
		@Test(priority = 14)
		public void TC00_getParentId() {
			
			Response response = EndPoints.toGetParentIdEndpoint();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();
			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
			
//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//			System.out.println(dataStringList);
			
//			Removing empty arrays
			for (int i = 0; i < dataStringList.size(); i++) {
	            if (dataStringList.get(i).length() == 0) {
	            	dataStringList.remove(i);
	                i--; // Decrement i to adjust for the removed element
	            }        
	        }		

			FrequentlyUsedFunctions.setParentId(dataStringList.get(0));	
//			System.out.println(FrequentlyUsedFunctions.getParentId());

			logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getParentId⚡⚡⚡⚡⚡⚡⚡");
		}
		
		/*⚡FUF⚡*/
		@Test(priority = 17)
		public void TC00_getBannerId() {
			
			Response response = EndPoints.toGetOfferBannerIdEndpoint();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();
			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
			
//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
//			System.out.println(dataStringList);
			
//			Removing empty arrays
			for (int i = 0; i < dataStringList.size(); i++) {
	            if (dataStringList.get(i).length() == 0) {
	            	dataStringList.remove(i);
	                i--; // Decrement i to adjust for the removed element
	            }        
	        }		

			FrequentlyUsedFunctions.setBannerId(dataStringList.get(0));	
//			System.out.println(FrequentlyUsedFunctions.getBannerId());

			logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getBannerId⚡⚡⚡⚡⚡⚡⚡");
		}
		
		/*⚡FUF⚡*/
		@Test(priority = 20)
		public void TC00_getadminProductSearchId() {
			
			Response response = EndPoints.toGetadminProductSearchIdEndpoint(FrequentlyUsedFunctions.getSignInToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();
			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
//			System.out.println(testReturnObject);
			
//			feeding that value to a list
			List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
//			System.out.println(dataStringList);
			
//			Removing empty arrays
			for (int i = 0; i < dataStringList.size(); i++) {
	            if (dataStringList.size() == 0) {
	            	dataStringList.remove(i);
	                i--; // Decrement i to adjust for the removed element
	            }      
	        }
			JSONArray jsonArray = new JSONArray(dataStringList);
	        JSONObject firstObject = jsonArray.getJSONObject(0);
	        FrequentlyUsedFunctions.setProductId(firstObject.getString("_id"));		
	
//			System.out.println(FrequentlyUsedFunctions.getProductId());

			logger.info("⚡⚡⚡⚡⚡⚡⚡TC00_getParentId⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 3)
		public void TC43_fshopcartProductsTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopcartProducts(FrequentlyUsedFunctions.getSignUpToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC43_fshopcartProductsTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 4)
		public void TC44_fshopDashboardShippingAddressesTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopDashboardShippingAddresses(FrequentlyUsedFunctions.getSignUpToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC44_fshopDashboardShippingAddressesTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 5)
		public void TC45_fshopDashboardReviewByUserTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopDashboardReviewByUser(FrequentlyUsedFunctions.getSignInToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC45_fshopDashboardReviewByUserTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 5)
		public void TC46_fshopDashboardSupportTicketsTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopDashboardSupportTickets(FrequentlyUsedFunctions.getSignUpToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC46_fshopDashboardSupportTicketsTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 6)
		public void TC47_fshopHomeParentCategoriesTest() {
			
			int ExpectedValue = 4;
			Response response = EndPoints.fshopHomeParentCategories();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC47_fshopHomeParentCategoriesTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 7)
		public void TC48_fshopHomeFlashSalesTest() {
			
			int ExpectedValue = 4;
			Response response = EndPoints.fshopHomeParentCategories();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC48_fshopHomeFlashSalesTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 8)
		public void TC49_fshopHomePromotionalOffersTest() {
			
			int ExpectedValue = 1;
			Response response = EndPoints.fshopHomePromotionalOffers();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC49_fshopHomePromotionalOffersTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 9)
		public void TC50_fshopHomeTopSellingBrandsTest() {
			
			int ExpectedValue = 9;
			Response response = EndPoints.fshopHomeTopSellingBrands();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC50_fshopHomeTopSellingBrandsTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 11)
		public void TC51_fshopHomeProductsByCategoryTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopHomeProductsByCategory();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC51_fshopHomeProductsByCategoryTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 12)
		public void TC52_fshopHomeMainBannersTest() {
			
			int ExpectedValue = 3;
			Response response = EndPoints.fshopHomeMainBanners();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC52_fshopHomeMainBannersTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 13)
		public void TC53_fshopHomeOfferBannersTest() {
			
			int ExpectedValue = 2;
			Response response = EndPoints.fshopHomeOfferBanners();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC53_fshopHomeOfferBannersTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 15)
		public void TC54_fshopHomeCategoryChildrensTest() {
			
			int ExpectedValue = 4;
			Response response = EndPoints.fshopHomeCategoryChildrens();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			System.out.println(dataStringList.size());
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC54_fshopHomeCategoryChildrensTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 16)
		public void TC55_fshopHomeFilterHotdealsTest() {
			
			int ExpectedValue = 188;
			Response response = EndPoints.fshopHomeFilterHotdeals();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC55_fshopHomeFilterHotdealsTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 18)
		public void TC56_fshopHomeBannerProductsTest() {
			
			int ExpectedValue = 1;
			Response response = EndPoints.fshopHomeBannerProducts();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC56_fshopHomeBannerProductsTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 19)
		public void TC57_fshopOrdersByUserTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopOrdersByUser(FrequentlyUsedFunctions.getSignUpToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC57_fshopOrdersByUserTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 21)
		public void TC58_fshopIdBasedProductCheckingstockQtyTest() {
			
			int ExpectedValue = 50;
			Response response = EndPoints.fshopOrdersProductById();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);
			
//			feeding that value to a list
			int stockQty = jsonPath.getInt("data."+testReturnObject.toString()+".stockQty");
			System.out.println(stockQty);		
	
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(stockQty,ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC58_fshopIdBasedProductCheckingstockQtyTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 22)
		public void TC59_fshopProductFaqsByIdTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopProductFaqsById();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString());
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC59_fshopProductFaqsByIdTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 23)
		public void TC60_fshopProductReviewByIdTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopProductReviewById();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//	      	Optional! To handle string use --> dataNullCheckerString

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString());
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC60_fshopProductReviewByIdTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 24)
		public void TC61_fshopSearchProductByQueryTest() {
			
			int ExpectedValue = 9;
			Response response = EndPoints.fshopSearchProductByQuery();
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();			
//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//			feeding that value to a list
			List <Object> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+"._id");
			
			
//			Removing empty arrays
			for (int i = 0; i < dataStringList.size(); i++) {
	            if (dataStringList.size() == 0) {
	            	dataStringList.remove(i);
	                i--; // Decrement i to adjust for the removed element
	            }      
	        }
			System.out.println(dataStringList.size());
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC61_fshopSearchProductByQueryTest⚡⚡⚡⚡⚡⚡⚡");
		}
		
		@Test(priority = 25)
		public void TC62_fshopWishlistProductsTest() {
			
			int ExpectedValue = 0;
			Response response = EndPoints.fshopWishlistProducts(FrequentlyUsedFunctions.getSignInToken());
			response.then()//.log().all()
					.assertThat()
					.statusCode(200);
			
			JsonPath jsonPath = response.jsonPath();

//	      	returns java object form data{first key name}		
			Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//			feeding that value to a list
			List <String> dataStringList = jsonPath.getList("data."+testReturnObject.toString()+".products");
			System.out.println(dataStringList.size());
	      
//			checks two integer values (input vs expected) here checking array size
			FrequentlyUsedFunctions.matchFunction(dataStringList.size(),ExpectedValue);
			
			logger.info("⚡⚡⚡⚡⚡⚡⚡TC62_fshopWishlistProductsTest⚡⚡⚡⚡⚡⚡⚡");
		}
}
