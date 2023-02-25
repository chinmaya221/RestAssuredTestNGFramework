package com.spotify.oauth2.tests;

import org.testng.annotations.Test;

import com.spotify.oauth2.applicationApi.PlaylistAPI;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utility.DataLoader;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlaylistTests extends BaseTest {

	@Step
	public Playlist playlistBuilder(String name, String desc, boolean _public) {
		
		  Playlist playlist = new Playlist();
		  playlist.setName(name);
		  playlist.setDescription(desc);
		  playlist.set_public(_public);
		  
		return playlist;
	}
    
	@Step
	public void assertPlaylistEquals(Playlist responsePlaylist, Playlist requestPlaylist) {

		assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
		assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
		assertThat(responsePlaylist.get_public(), equalTo(requestPlaylist.get_public()));
	}

	@Step
	public void assertPlaylistStatuscode(int actualStatuscode, int expectedStatuscode) {
		assertThat(actualStatuscode, equalTo(expectedStatuscode));
	}

	@Step
	public void assertError(Error responseError, int errorStatuscode, String errorMsg) {
		assertThat(responseError.getError().getMessage(), equalTo(errorMsg));
		assertThat(responseError.getError().getStatus(), equalTo(errorStatuscode));
	}

	@Step
	public void assertGetPlaylist(Playlist responsePlaylist, String name, String desc, boolean _public) {
		assertThat(responsePlaylist.getName(), equalTo(name));
		assertThat(responsePlaylist.getDescription(), equalTo(desc));
		assertThat(responsePlaylist.get_public(), equalTo(_public));
	}
    
	@Description("This is create playlist descriptions")
	@Test(description = "SHould be Able to Create a playlist")
	public void shouldBeAbleToCreateAPalylist() {

		Playlist createPlaylist = playlistBuilder("My Test Playlist", "New playlist description", false);

		Response response = PlaylistAPI.post(createPlaylist);
		assertPlaylistStatuscode(response.statusCode(), 201);
		assertPlaylistEquals(response.as(Playlist.class), createPlaylist);

	}

	@Test
	public void shouldBeAbleToGetAPalylist() {

		Response response = PlaylistAPI.get(DataLoader.getInstance().getPlaylistId());
		assertPlaylistStatuscode(response.statusCode(), 200);

		Playlist responseGetPlaylist = response.as(Playlist.class);
		assertGetPlaylist(responseGetPlaylist, "My Test Playlist", "New playlist description", false);
	}

	@Test
	public void shouldBeAbleToUpdateAPalylist() {

		Playlist updatePlaylistRequest = playlistBuilder("My Test Playlist", "New playlist description", false);

		Response response = PlaylistAPI.put(updatePlaylistRequest, DataLoader.getInstance().getUpdatePlaylistId());
		assertPlaylistStatuscode(response.statusCode(), 200);

	}

	@Test
	public void shouldBeAbleToCreateAPalylistWithoutName() {

		Playlist playlistWithoutName = playlistBuilder("", "New playlist description", false);

		Response response = PlaylistAPI.post(playlistWithoutName);
		assertPlaylistStatuscode(response.statusCode(), 400);

		Error error = response.as(Error.class);

		assertError(error, 400, "Missing required field: name");

	}

	public void createPlayListWithInvalidToken() {

		String invalidToken = "123456";

		Playlist createPlaylist = playlistBuilder("My Test Playlist", "New playlist description", false);

		Response response = PlaylistAPI.post(invalidToken, createPlaylist);
		assertPlaylistStatuscode(response.statusCode(), 401);

		Error error = response.as(Error.class);
		assertError(error, 401, "Invalid access token");

	}

}
