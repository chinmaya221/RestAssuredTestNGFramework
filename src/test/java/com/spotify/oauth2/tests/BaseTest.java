package com.spotify.oauth2.tests;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	
	@BeforeMethod
	public void beforeMethod(Method m) {
		
		System.out.println("Method getting called is "+m.getName());
		System.out.println("Thread id for the method "+m.getName()+" is "+Thread.currentThread().getId());
		
	}

}
