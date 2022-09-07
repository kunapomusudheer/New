package com.CRUDOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettingProjectTest {
	@Test
	public void getProjectTest() {
		Response rsps=RestAssured.get("http://localhost:8084/projects");
//		rsps.prettyPrint();
//		System.out.println(rsps.getStatusCode());
		ValidatableResponse vldt = rsps.then();
		vldt.assertThat().statusCode(200);
		vldt.assertThat().contentType(ContentType.JSON);
		vldt.log().all();
		
		
		
	}
}
