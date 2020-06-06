package com.gorest.apitests;

import org.testng.annotations.Test;
import java.io.IOException;
import com.gorest.api.gorestapis;
import com.mashape.unirest.http.exceptions.UnirestException;

public class BasicApiTests {

	gorestapis gorest = new gorestapis();
	
	@Test(groups="smoke")
	public void getUsers() {
		
		
		gorest.getUsers();
	}
	
	
	@Test(groups ="Regression")
	public void postUser() throws IOException, UnirestException {
	
		gorest.postUser();
		
	}
	
}
