package com.solerafinals.hpels_mx.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


@SpringBootTest
public class ApiTests {
	
	@Test
    void whenPostForUserIsSent_withCorrectData_shouldPass() {
		RestAssured.baseURI = "http://localhost:8080";
		given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().post("userinfo/add")
				.then().assertThat().statusCode(200).body("email", equalTo("test@email.com"))
				.extract().response().asString();
    }
	
	@Test
    void whenGetSpecificUser_withId_shouldPass() {
		RestAssured.baseURI = "http://localhost:8080";
		String response = given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().post("userinfo/add")
				.then().assertThat().statusCode(200).body("email", equalTo("test@email.com"))
				.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		int userId = js.getInt("id");
		
		given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().get("userinfo/"+userId)
				.then().log().all().assertThat().statusCode(200).body("id", equalTo(userId))
				.extract().response().asString();
    }
	
	@Test
    void whenGetIsSent_forAllUsers_shouldPass() {
		RestAssured.baseURI = "http://localhost:8080";
		String response = given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().get("userinfo/all")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

		assertNotNull(response);
    }
	
	@Test
    void whenUpdatingUser_withNewName_shouldPass() {
		RestAssured.baseURI = "http://localhost:8080";
		String response = given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().post("userinfo/add")
				.then().assertThat().statusCode(200).body("email", equalTo("test@email.com"))
				.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		int userId = js.getInt("id");
		
		response = given().log().all().header("Content-Type","application/json")
				.body(Payload.EditUser()).when().put("userinfo/"+userId)
				.then().assertThat().statusCode(200).body("last_name", equalTo("LastUpdated"))
				.extract().response().asString();
    }
	
	@Test
    void whenDeletingUser_withId_shouldPass() {
		RestAssured.baseURI = "http://localhost:8080";
		String response = given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().post("userinfo/add")
				.then().assertThat().statusCode(200).body("email", equalTo("test@email.com"))
				.extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		int userId = js.getInt("id");
		
		given().log().all().header("Content-Type","application/json")
				.body(Payload.AddUser()).when().delete("userinfo/"+userId)
				.then().assertThat().statusCode(200).body(equalTo("true"))
				.extract().response().asString();
    }
}
