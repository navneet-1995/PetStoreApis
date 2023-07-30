package api.endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoint {

	public static Response createuser(User payload) {
		
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Route.createUserUrl);
		return response;
	}
	public static Response getUser(String username) {
		
		Response response=given()
			.pathParam("username", username)
		
		.when()
		.get(Route.getUserUrl);
		return response;
	}
	
	public static Response updateuser(User payload,String username) {
		
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username", username)
		
		.when()
		.put(Route.updateUserUrl);
		return response;
	}            
	
	public static Response deleteuser(String username) {
		
		Response response=given()
		.pathParam("username", username)
		
		.when()
		.delete(Route.deleteUserUrl);
		return response;
	}            
	
	
	
	
}
