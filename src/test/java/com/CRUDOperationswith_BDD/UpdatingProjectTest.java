package com.CRUDOperationswith_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdatingProjectTest {
	@Test
	public void updateProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("projectName", "Proj-01");
		jobj.put("createdBy", "Sudheer");
		jobj.put("teamSize", "10");
		jobj.put("status", "on-going");
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_833")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
