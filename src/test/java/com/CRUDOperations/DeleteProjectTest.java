package com.CRUDOperations;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {
	@Test
	public void deleteProjectTest() {
		Response rsps=RestAssured.delete("http://localhost:8084/projects/TY_PROJ_834");
		//rsps.prettyPrint();
		//		System.out.println();

		ValidatableResponse vldt = rsps.then();
		vldt.assertThat().statusCode(204);
		vldt.assertThat().contentType(ContentType.JSON);
      }
	
}
