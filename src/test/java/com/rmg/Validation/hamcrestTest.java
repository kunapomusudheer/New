package com.rmg.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class hamcrestTest {
	@Test
	public void hamcrestMatchersTest() {
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS )
		.log()
		.all();
	}
}
