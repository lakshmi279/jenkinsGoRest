package com.gorest.ui;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gorest.common.BaseClass;

public class UsersPage extends BaseClass{

	
	//private WebDriverWait wait;
	
	@FindBy(xpath="//i[@class='fa fa-database gutter-sm-right']")
	 WebElement ddPublicdata;
	
	//@FindBy(xpath="//ul[@id='w2']/li[1]")
	@FindBy(xpath="//a[@href=\"/public-data/users.html\"]")
	 WebElement lnkUsers;
	
	@FindBy(xpath="//input[@name='PublicUserSearch[email]']")
	WebElement sbEmail;
	
	//====================Users Page constructor===============================//
	/*
	 * public UsersPage(WebDriver driver) { this.driver = driver; //this.wait = new
	 * WebDriverWait(driver,30); //PageFactory.initElements(driver, this);
	 * 
	 * }
	 */
	
	public UsersPage(WebDriver driver) {
		super.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//=================Method to search a user===============================//
	public void searchUser(String Email) throws InterruptedException {
		
		//this.wait.until(ExpectedConditions.elementToBeClickable(this.ddPublicdata));
		Thread.sleep(500);
		Actions act = new Actions(driver);
		//act.moveToElement(this.ddPublicdata).click().build().perform();
		ddPublicdata.click();
		Thread.sleep(500);
		lnkUsers.click();
		//act.moveToElement(this.lnkUsers).click().build().perform();
		//this.wait.until(ExpectedConditions.visibilityOf(sbEmail));
		Thread.sleep(500);
		sbEmail.sendKeys(Email);
		
		act.sendKeys(Keys.ENTER);
		Thread.sleep(500);
	}
	
}
