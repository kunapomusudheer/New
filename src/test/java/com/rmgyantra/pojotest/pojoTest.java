package com.rmgyantra.pojotest;

import org.testng.annotations.Test;

import com.rmgyantra.pojo.library.Pojo;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class pojoTest {
	@Test
	public void pojo1() {
		Pojo poj=new Pojo("sudheer", "SDET-10", "created", 10);
		given()
		.contentType(ContentType.JSON)
		.body(poj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all();

	}
}
