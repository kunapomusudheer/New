package com.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdatingProjectTest {
	@Test
	public void updatingProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sudheerk");
		jobj.put("projectName", "SDET-15");
		jobj.put("status", "Created");
		jobj.put("teamSize", "10");
		RequestSpecification rspn = RestAssured.given();
		rspn.contentType(ContentType.JSON);
		rspn.body(jobj);
		Response vldt = rspn.put("http://localhost:8084/projects/TY_PROJ_1002");
		ValidatableResponse vldt1 = vldt.then();
		vldt1.assertThat().statusCode(200);
		vldt1.log().all();


	}

}





