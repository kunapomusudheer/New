package com.CRUDOperations;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PartialUpdateProTest {
	@Test
	public void patch() {
		JSONObject jobj=new JSONObject();
		jobj.put("name", "sudheer");
		jobj.put("job", "resident");
		Response rspn = RestAssured.patch("https://reqres.in/api/users/2");
		ValidatableResponse vldt = rspn.then();
		vldt.contentType(ContentType.JSON);
		RequestSpecification rsp = RestAssured.given();	
		

    }
}
