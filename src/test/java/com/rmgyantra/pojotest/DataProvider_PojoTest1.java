package com.rmgyantra.pojotest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.pojo.library.Pojo;

import io.restassured.http.ContentType;

public class DataProvider_PojoTest1 {
	@Test(dataProvider = "getData")
	public void pojo1(String createdBy, String projectName, String status, int teamSize) {
		Pojo poj=new Pojo("createdBy", "projectName", "status", teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(poj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log()
		.all();

	}
	@DataProvider
	public Object[][] getData(){
		Object[][] objArray=new Object[2][4];
		objArray[0][0]="Sudheer";
		objArray[0][1]="SDET-12";
		objArray[0][2]="created";
		objArray[0][3]=10;
		
		objArray[1][0]="Sudheer1";
		objArray[1][1]="SDET-13";
		objArray[1][2]="created";
		objArray[1][3]=10;
		
		return objArray;
		
		
	}
}
