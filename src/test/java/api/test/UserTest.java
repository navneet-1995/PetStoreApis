package api.test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoint;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	User user;
	Faker faker;
	UserEndPoint userendpoint;
	
	//To test git update
	
	@BeforeClass
	public void setup() {
		
		user=new User();
		faker=new Faker();
		
		user.setId(faker.number().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstname(faker.name().firstName());
		user.setLastname(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPassword(faker.internet().password());
		user.setPhno(faker.phoneNumber().phoneNumber());
		

	}
	
	@Test(priority=1)
	public void validateCreateUser() {
		Response response=userendpoint.createuser(user);
		//response.then().log().all();
		
	}
	
	@Test(priority=2)
	public void validateGetUser() {
		Response response=userendpoint.getUser(this.user.getUsername() );
		response.then().log().all();
		
	}
	
	@Test(priority=3)
	public void validateUpdateUser() {
		user.setFirstname(faker.name().firstName());
		user.setLastname(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		
		userendpoint.updateuser(user,this.user.getUsername());
		Response response=userendpoint.getUser(this.user.getUsername());
		response.then().log().all();
		
	}
	
	
	@Test(priority=4)
	public void validateDeleteUser() {
		Response response=userendpoint.deleteuser(this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
}
