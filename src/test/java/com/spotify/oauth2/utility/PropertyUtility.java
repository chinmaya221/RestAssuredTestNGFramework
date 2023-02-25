package com.spotify.oauth2.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	
	public static Properties propertyLoader(String filePath) {
		
		Properties properties = new Properties();
		BufferedReader bufferedReader;
		
		try {
			
			bufferedReader = new BufferedReader(new FileReader(filePath));
			try {
				
				properties.load(bufferedReader);
				bufferedReader.close();
				
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Failed to load properties file"+filePath);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Properties file not found"+ filePath);
		}
		
		return properties;
	}

}
