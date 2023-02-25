package com.spotify.oauth2.utility;

import java.util.Properties;

public class DataLoader {

	private final Properties properties;
	private static DataLoader dataLoader;

	private DataLoader() {
		properties = PropertyUtility.propertyLoader("src/test/resources/data.properties");
	}

	public static DataLoader getInstance() {
		if (dataLoader == null) {
			dataLoader = new DataLoader();
		}

		return dataLoader;
	}

	public String getPlaylistId() {

		String prop = properties.getProperty("palylist_id");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Properies palylist_id is not specified in the data.properties file");
		}

	}

	public String getUpdatePlaylistId() {

		String prop = properties.getProperty("update_playlist_id");
		if (prop != null) {
			return prop;
		} else {
			throw new RuntimeException("Properies update_playlist_id is not specified in the config.properties file");
		}

	}
}
