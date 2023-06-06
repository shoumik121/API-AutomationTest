package api.test.signin;

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

public class SigninTest {
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = LogManager.getLogger(this.getClass());
	}
	
	/**
	 * TestCase: TC_01
	 * Description: Verify SignUp Test Email
	 */
	@Test(priority = 1)
	public void TC01_SigninWithEmailTest() {
		
		int ExpectedValue = 254;
		JSONObject valuesJsonObjectA = new JSONObject();
		valuesJsonObjectA.put("email", "shoumikrouf14@gmail.com");
		valuesJsonObjectA.put("firebaseRegToken", "123456");
		valuesJsonObjectA.put("password", "Madmax123");
		
		
		JSONObject variables = new JSONObject();
		variables.put("signInUserEmailInput", valuesJsonObjectA);
		
		Response response = EndPoints.signInWithEmail(variables);
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);

		JsonPath jsonPath = response.jsonPath();			
//  	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		Object dataObject = jsonPath.getString("data."+testReturnObject.toString());

		System.out.println("Returned Data: "+ dataObject);
		System.out.println(dataObject.toString().length());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataObject.toString().length(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("**********Email SignIn***********");
			
	}
	
	/**
	 * TestCase: TC_02
	 * Description: Verify SignUp Test Phone
	 */
	@Test(priority = 2)
	public void TC02_SigninWithPhoneTest() {
		
		int ExpectedValue = 254;
		JSONObject valuesJsonObjectA = new JSONObject();
		valuesJsonObjectA.put("firebaseRegToken", "123456");
		valuesJsonObjectA.put("password", "Madmax123");
		valuesJsonObjectA.put("phone", "01776633121");
		
		JSONObject variables = new JSONObject();
		variables.put("signInUserPhoneInput", valuesJsonObjectA);
		
		Response response = EndPoints.signInWithPhone(variables);
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);

		JsonPath jsonPath = response.jsonPath();			
//  	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		Object dataObject = jsonPath.getString("data."+testReturnObject.toString());

		System.out.println("Returned Data: "+ dataObject);
		System.out.println(dataObject.toString().length());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataObject.toString().length(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("**********Phone SignIn***********");

	}
	
	/**
	 * TestCase: TC_01
	 * Description: Verify SignUp Test Email
	 */
	@Test(priority = 3)
	public void TC03_SigninWithSocialTest() {
		
		int ExpectedValue = 254;
		JSONObject valuesJsonObjectA = new JSONObject();
		valuesJsonObjectA.put("dp", "https://images.pexels.com/photos/91227/pexels-photo-91227.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		valuesJsonObjectA.put("firebaseRegToken", "123456");
		valuesJsonObjectA.put("id", "https://www.facebook.com/shoumikR/");
		valuesJsonObjectA.put("platform", "fb");
		
		JSONObject variables = new JSONObject();
		variables.put("socialSigninUserInput", valuesJsonObjectA);
		
		Response response = EndPoints.signInWithSocial(variables);
		response.then()//.log().all()
			.assertThat()
			.statusCode(200);

		JsonPath jsonPath = response.jsonPath();			
//  	returns java object form data{first key name}		
		Object testReturnObject = FrequentlyUsedFunctions.dataNullChecker(jsonPath);

//		feeding that value to a list
		Object dataObject = jsonPath.getString("data."+testReturnObject.toString());

		System.out.println("Returned Data: "+ dataObject);
		System.out.println(dataObject.toString().length());
//		checks two integer values (input vs expected) here checking array size
		FrequentlyUsedFunctions.matchFunction(dataObject.toString().length(),ExpectedValue);
		System.out.println("\n");
		
		logger.info("**********Social SignIn***********");
	}
}

