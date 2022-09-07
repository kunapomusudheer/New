package com.Assignment_endToend;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.rmgyantra.genericLibrary.BaseAPIUtility;
import com.rmgyantra.genericLibrary.Endpoints;
import com.rmgyantra.genericLibrary.JavaUtility;
import com.rmgyantra.pojo.library.Pojo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndtoEnd extends BaseAPIUtility {
	@Test
	public void endToend() throws Throwable {
		JavaUtility j=new JavaUtility();
		Pojo poj=new Pojo("sudheer", "SDET-11"+j.random(), "created", 10);
		baseURI="http://localhost";
		port=8084;
		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(poj)
				.when()
				.post(Endpoints.addProject);

		Object projectid = rsps.jsonPath().get("projectId");
		Response rsps1 = given()
				.pathParam("proId",projectid)
				.when()
				.get(Endpoints.getsingleProject);
		Object proName = rsps1.jsonPath().get("projectName");
		System.out.println(proName);
	
		ResultSet result = db.executeQueryTest("select* from project;");
		while (result.next()) {
			if (proName.equals(result.getString(4))) {
				System.out.println("it is verified in database");
			}
		}



	}


}	


