package com.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreatingProjectTest {
	@Test
	public void creatingProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Sudheer");
		jobj.put("projectName", "SDET-0");
		jobj.put("status", "Created");
		jobj.put("teamSize", "10");
		RequestSpecification rspn = RestAssured.given();
		rspn.contentType(ContentType.JSON);
		rspn.body(jobj);
		Response vldt = rspn.post("http://localhost:8084/addProject");
		ValidatableResponse vldt1 = vldt.then();
		vldt1.assertThat().statusCode(201);
		vldt1.log().all();


	}

}
