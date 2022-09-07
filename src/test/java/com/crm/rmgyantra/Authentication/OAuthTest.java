package com.crm.rmgyantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class OAuthTest {
@Test
public void oauth() {
	Response rsps = given()
	.formParam("client_id", "SDET77")
	.formParam("client_secret", "61581af9dca67be1e78398372c57c4d9")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://example.com")
	.when()
	.post("http://coop.apps.symfonycasts.com/token");
	String token = rsps.jsonPath().get("access_token");
	System.out.println(token);
	given()
	.auth().oauth2(token)
	.pathParam("USER_ID", 3618)
	.when()
	.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	.then()
	.log()
	.all();
	
}

}
