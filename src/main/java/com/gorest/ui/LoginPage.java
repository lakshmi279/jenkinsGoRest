package com.gorest.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gorest.common.BaseClass;


public class LoginPage extends BaseClass {
	
	 	
	@FindBy(xpath="//a[@href='/user/login.html']")
	WebElement lnklogin;
	
	@FindBy(xpath="//a[@class='facebook auth-link']/span")
	 WebElement lnkFacebook;
	
	@FindBy(id="email")
	 WebElement txtEmail;
	
	@FindBy(id="pass")
	WebElement txtPassword;
	
	@FindBy(id="loginbutton")
    WebElement btnLogin;
	
	@FindBy(linkText="Home")
	WebElement lnkHome;
	
	//================================LoginPageConstructor=========================//
	
	  public LoginPage(WebDriver driver) {
		  super.driver=driver;
	  PageFactory.initElements(driver, this);
	  
	  }
	 
	
	//==============================Method to launch homepage=====================//
	
	/*
	 * public void launchhomepage() {
	 * 
	 * try { this.driver.get("https://gorest.co.in/");
	 * this.driver.manage().window().maximize();
	 * this.wait.until(ExpectedConditions.visibilityOf(this.lnklogin)); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * } }
	 */
	
	//============================Method to login using facebook===================//
	

	public void facebooklogin(String Username, String Password) throws InterruptedException {
		
		try {
			//wait.until(ExpectedConditions.visibilityOf(this.lnklogin));
			Thread.sleep(15000);
			lnklogin.click();
			Thread.sleep(5000);
			//this.wait.until(ExpectedConditions.visibilityOf(this.lnkFacebook));
//*******************Getting the current window handle***********************//
			String whandle = driver.getWindowHandle();
			
			Actions act = new Actions(driver);
			act.doubleClick(lnkFacebook).perform();
//****************Switching to the respective window*************************//	
			for(String handle:driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
			
			//this.wait.until(ExpectedConditions.visibilityOf(this.txtEmail));
			Thread.sleep(500);
			txtEmail.sendKeys(Username);
			txtPassword.sendKeys(Password);
			btnLogin.click();
			Thread.sleep(500);
//****facebook login page closes and redirects to gorest page,so switching back to main window*******//
			driver.switchTo().window(whandle);
			Thread.sleep(500);
			//this.wait.until(ExpectedConditions.visibilityOf(this.lnkHome));
			lnkHome.click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
