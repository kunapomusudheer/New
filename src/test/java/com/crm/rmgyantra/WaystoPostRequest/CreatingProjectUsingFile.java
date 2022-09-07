package com.crm.rmgyantra.WaystoPostRequest;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreatingProjectUsingFile {
	@Test
	public void createproject() {
		File file=new File("../RestAssured/jsonDataforCRUD.json");
		given()
		.contentType(ContentType.JSON)
		.body(file)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all();

	}
}