package com.rmg.Validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class StaticValidationTest {
	@Test
	public void staticValidation() {
		String expData="SDET-15";
		Response rspn =  when()
				.get("http://localhost:8084/projects/TY_PROJ_1002");
		String actual = rspn.jsonPath().get("projectName");
		Assert.assertEquals(actual,expData);
		rspn.then().log().all();

	}
}
