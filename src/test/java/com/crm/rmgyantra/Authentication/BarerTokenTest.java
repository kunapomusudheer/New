package com.crm.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarerTokenTest {
@Test
public void barerToken() {
	given()
	.auth().oauth2("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")
	.queryParam("sort", "created")
	.when()
	.get("https://api.github.com/user/repos")
	.then()
	.log()
	.all();
 }
}
