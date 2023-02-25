package com.spotify.oauth2.applicationApi;

import com.spotify.oauth2.api.RequestResource;
import com.spotify.oauth2.api.Route;
import com.spotify.oauth2.api.TokenManager;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utility.ConfigLoader;

import io.restassured.response.Response;

public class PlaylistAPI {

	public static Response post(Playlist requestPaylist) {

		return RequestResource.post(Route.USERS + "/"+ConfigLoader.getInstance().getUserId()+Route.PLAYLISTS, TokenManager.getToken(), requestPaylist);

	}

	public static Response post(String token, Playlist requestPaylist) {

		return RequestResource.post(Route.USERS + "/"+ConfigLoader.getInstance().getUserId()+Route.PLAYLISTS, token, requestPaylist);
	}

	public static Response get(String playlistId) {

		return RequestResource.get(Route.PLAYLISTS+"/" + playlistId, TokenManager.getToken());
	}

	public static Response put(Playlist requestPlaylist, String playlistId) {

		return RequestResource.put(Route.PLAYLISTS+"/" + playlistId, TokenManager.getToken(), requestPlaylist);
	}

}
