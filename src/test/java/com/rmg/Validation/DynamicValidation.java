package com.rmg.Validation;

import javax.annotation.meta.When;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidation {
	@Test
	public void dynamicValidation() {
		String expData="Sudheer816";
		Response rspn = when()
				.get("http://localhost:8084/projects");
		List<String> list = rspn.jsonPath().get("projectName");
		for (String act : list) {
			if (act.contains(expData)) {
				System.out.println(expData+"project is available");
				break;
			}

		}
		rspn.then().log().all();
	}

}
