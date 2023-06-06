package api.test.signup;

import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.EndPoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.response.ResponseBody;
import io.restassured.RestAssured;
import graphql.Assert;
import groovyjarjarantlr4.v4.tool.ErrorSeverity;

import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignupTest {
	
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
	public void TC04_SignupWithEmailTest() {
		JSONObject valuesJsonObjectB = new JSONObject();
		valuesJsonObjectB.put("deviceId", "Iphone 14+");
		valuesJsonObjectB.put("deviceModel", "Pro Max");
		
		JSONObject valuesJsonObjectA = new JSONObject();
		valuesJsonObjectA.put("birth_date", "1999-11-28");
		valuesJsonObjectA.put("email", "shoumikrouf16@gmail.com");
		valuesJsonObjectA.put("firebaseRegToken", "123456");
		valuesJsonObjectA.put("gender", "Male");
		valuesJsonObjectA.put("name", "MadMAx800");
		valuesJsonObjectA.put("password", "Madmax123");
		valuesJsonObjectA.put("referralCode", "Mr Beast");
		valuesJsonObjectA.put("signUpDevice", valuesJsonObjectB);
		
		JSONObject variables = new JSONObject();
		variables.put("signUpWithEmailInput", valuesJsonObjectA);
		
		Response response = EndPoints.signUpWithEmail(variables);
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);

		JsonPath jsonPath = response.jsonPath();
		String dataString = jsonPath.getString("data");
		System.out.println(dataString);

		if(dataString == null) {
			String errString = jsonPath.getString("errors.extensions.response.statusCode[0]");
			String str400 = "400";			
			if (errString.equalsIgnoreCase(str400) == true) {
				System.out.println("error status code passed");
				
				String errorMessageString = jsonPath.getString("errors[0].message");
				System.out.println(errorMessageString);
				
				String errorMessageCodeString = jsonPath.getString("errors[0].extensions.code");
				System.out.println(errorMessageCodeString);
			} else {
				System.out.println(errString);
			}
		}
		logger.info("**********Email SignUp***********");	
	}
	
	/**
	 * TestCase: TC_02
	 * Description: Verify SignUp Test Phone
	 */
	@Test(priority = 2,description = "NA")
	public void TC05_SignupWithPhoneTest() {
		
		JSONObject valuesJsonObjectC = new JSONObject();
		valuesJsonObjectC.put("national_number", "01776633121");
		
		JSONObject valuesJsonObjectB = new JSONObject();
		valuesJsonObjectB.put("deviceId", "Iphone 14+");
		valuesJsonObjectB.put("deviceModel", "Pro Max");
		
		JSONObject valuesJsonObjectA = new JSONObject();
		valuesJsonObjectA.put("birth_date", "1999-11-28");
		valuesJsonObjectA.put("name", "MadMAx800");
		valuesJsonObjectA.put("password", "Madmax123");
		valuesJsonObjectA.put("phone", valuesJsonObjectC);
		valuesJsonObjectA.put("signUpDevice", valuesJsonObjectB);
		valuesJsonObjectA.put("firebaseRegToken", "123456");
		valuesJsonObjectA.put("gender", "Male");
		valuesJsonObjectA.put("referralCode", "Mr Beast");

		JSONObject variables = new JSONObject();
		variables.put("signUpWithPhoneInput", valuesJsonObjectA);
		
		Response response = EndPoints.signUpWithPhone(variables);
		response.then()//.log().all()
				.assertThat()
				.statusCode(200);
		
		JsonPath jsonPath = response.jsonPath();
		String dataString = jsonPath.getString("data");
		System.out.println(dataString);
		
		if(dataString == null) {
			String errString = jsonPath.getString("errors.extensions.response.statusCode[0]");
			String str400 = "400";			
			if (errString.equalsIgnoreCase(str400) == true) {
				System.out.println("error status code passed");
				
				String errorMessageString = jsonPath.getString("errors[0].message");
				System.out.println(errorMessageString);
				
				String errorMessageCodeString = jsonPath.getString("errors[0].extensions.code");
				System.out.println(errorMessageCodeString);
			} else {
				System.out.println(errString);
			}
		}
		logger.info("**********Phone SignUP***********");
	}
	
	/**
	 * TestCase: TC_01
	 * Description: Verify SignUp Test Email
	 */
	@Test(priority = 3)
	public void TC06_SignupWithSocialTest() {
		
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
		String dataString = jsonPath.getString("data");
		System.out.println(dataString);

		if(dataString == null) {
			String errString = jsonPath.getString("errors.extensions.response.statusCode[0]");
			String str400 = "400";			
			if (errString.equalsIgnoreCase(str400) == true) {
				System.out.println("error status code passed");
				
				String errorMessageString = jsonPath.getString("errors[0].message");
				System.out.println(errorMessageString);
				
				String errorMessageCodeString = jsonPath.getString("errors[0].extensions.code");
				System.out.println(errorMessageCodeString);
			} else {
				System.out.println(errString);
			}
        }
		logger.info("**********Social SignUp***********");

	}

}
