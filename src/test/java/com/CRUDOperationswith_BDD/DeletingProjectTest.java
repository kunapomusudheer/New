package com.CRUDOperationswith_BDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeletingProjectTest {
	@Test
	public void deleteProject() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_609")
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}

}
