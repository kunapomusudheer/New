package com.crm.rmgyantra.WaystoPostRequest;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingHashMap {
	@Test
	public void hashMaping() {
		HashMap hm=new HashMap();
		hm.put("createdBy", "Sudheer1");
		hm.put("projectName", "SDET-9");
		hm.put("status", "On-going");
		hm.put("teamSize", "10");
		given()
		.contentType(ContentType.JSON)
		.body(hm)
		.when()
		.post("http://localhost:8084/addProject")	
		.then()
		.log()
		.all();



	}
}
