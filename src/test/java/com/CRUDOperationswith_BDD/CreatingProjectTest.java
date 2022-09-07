package com.CRUDOperationswith_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectTest {
	@Test
	public void creatingProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sudheer");
		jobj.put("projectName", "SDET-8");
		jobj.put("status", "On-going");
		jobj.put("teamSize", "10");
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
