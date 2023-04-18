package api.endpoints;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.payload.User;

public class UserEndPoints {
	public static Response createUser(User payload)
	{
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
	
		 return response;
		
	}
	public static Response getUser(String userName)
	{
		 Response response = 
				 given()
				 	.pathParam("username", userName)
				 
		//for body needed
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.body(payload)
		.when()
			.get(Routes.get_url);
	
		 return response;
		
	}
	public static Response updateUser(String userName,User payload)
	{
		 Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
			.body(payload)
		.when()
			.put(Routes.update_url);
	
		 return response;
		
	}
	public static Response deleteUser(String userName)
	{
		 Response response = given()
				 .pathParam("username", userName)
			//for body needed	 
//			.contentType(ContentType.JSON)
//			.accept(ContentType.JSON)
//			.body(payload)
		.when()
			.delete(Routes.delete_url);
	
		 return response;
		
	}

}
