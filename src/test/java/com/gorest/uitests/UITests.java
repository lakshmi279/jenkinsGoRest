package com.gorest.uitests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.gorest.common.BaseClass;
import com.gorest.ui.LoginPage;
import com.gorest.ui.UsersPage;

public class UITests extends BaseClass {
	
	//WebDriver driver;
	LoginPage login ;
	UsersPage user;
	public UITests() {
		super();
	}
	
	@BeforeClass(alwaysRun=true)
	public void setup() {
		setupDriver();
		login = new LoginPage(driver);
		
	}
	
	@Test(groups="Regression")
	public void verifyFacebooklogin() throws InterruptedException {

		login.facebooklogin("automationpracticea@gmail.com","Automation@786");
	
	}

	@Test(groups="Regression",dependsOnMethods="verifyFacebooklogin")
	public void verrifySearchuser() throws InterruptedException, IOException {
		
		String filepath = "D:\\eclipseworkspace\\apiautomationwithselenium\\src\\test\\resources\\apiresponse.properties";
		FileInputStream readfile = new FileInputStream(filepath);
		Properties property = new Properties();
		property.load(readfile);
		String email =property.getProperty("Email");
		System.out.println(email);
		//UsersPage up = new UsersPage();
		user = new UsersPage(driver);
		user.searchUser(email);
		readfile.close();
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}

