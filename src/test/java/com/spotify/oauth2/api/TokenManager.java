package com.spotify.oauth2.api;

import java.time.Instant;
import java.util.HashMap;

import com.spotify.oauth2.utility.ConfigLoader;

import io.restassured.response.Response;

public class TokenManager {

	private static String access_token;
	private static Instant expiry_time;

	public static String getToken() {

		try {

			if (access_token == null || Instant.now().isAfter(expiry_time)) {
				
				System.out.println("............Renewing Token .........");
				Response response = renewToken();
				access_token = response.path("access_token");
				int expiryDurationInSeconds = response.path("expires_in");
				expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds - 300);
				
			} else {
				System.out.println("--------------- Token is good to use ---------------------");
			}

		} catch (Exception e) {

			throw new RuntimeException("ABORT!!! Failed to get Token");

		}

		return access_token;

	}

	private static Response renewToken() {

		HashMap<String, String> formParams = new HashMap<String, String>();
		formParams.put("grant_type", ConfigLoader.getInstance().getGrant_type());
		formParams.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());
		formParams.put("client_id", ConfigLoader.getInstance().getClientId());
		formParams.put("client_secret", ConfigLoader.getInstance().getClientSecret());

		Response response = RequestResource.postAccount(formParams);

		if (response.statusCode() != 200) {
			throw new RuntimeException("............Renew Token is Expired............");
		}

		return response;
	}

}
