package com.spotify.oauth2.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import io.restassured.response.Response;

public class RequestResource {

	public static Response post(String path, String token, Object requestPayload) {

		return given(SpecBuilder.getRequestSpecification()).header("Authorization", "Bearer " + token)
				.body(requestPayload).when().post(path).then().spec(SpecBuilder.getResponseSpecification()).extract()
				.response();
	}

	public static Response postAccount(HashMap<String, String> formParams) {

		return given(SpecBuilder.getRequestAccountSpecification()).formParams(formParams).when().post(Route.API+Route.TOKEN).

				then().spec(SpecBuilder.getResponseSpecification()).extract().response();
	}

	public static Response get(String path, String token) {

		return given().spec(SpecBuilder.getRequestSpecification()).header("Authorization", "Bearer " + token).when()
				.get(path).then().spec(SpecBuilder.getResponseSpecification()).extract().response();
	}

	public static Response put(String path, String token, Object requestPayload) {

		return given().spec(SpecBuilder.getRequestSpecification()).header("Authorization", "Bearer " + token)
				.body(requestPayload).when().put(path).then().spec(SpecBuilder.getResponseSpecification()).extract()
				.response();
	}

}
