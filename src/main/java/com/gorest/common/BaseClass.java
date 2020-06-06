
  package com.gorest.common;
  
  import org.openqa.selenium.WebDriver; 
  import org.openqa.selenium.chrome.ChromeDriver; 
  import org.openqa.selenium.firefox.FirefoxDriver;
  import org.openqa.selenium.remote.DesiredCapabilities;
  
  public class BaseClass {
  
  public static WebDriver driver ;
  
  
  //==================================Method to invoke before the test  begins========================//
  public BaseClass() {
	  
  }
  
  public static void setupDriver() {
  
  DesiredCapabilities dc;
  
  if(System.getProperty("BROWSER") !=null &&
  System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
  System.setProperty("webdriver.gecko.driver",
  "D:\\eclipseworkspace\\apiautomationwithselenium\\src\\test\\resources\\Drivers\\geckodriver.exe"
  ); dc= DesiredCapabilities.firefox(); BaseClass.driver = new FirefoxDriver();
  
  }
  
  else { System.setProperty("webdriver.chrome.driver",
  "D:\\eclipseworkspace\\apiautomationwithselenium\\src\\test\\resources\\Drivers\\chromedriver.exe"
  ); dc= DesiredCapabilities.chrome(); BaseClass.driver = new ChromeDriver();
  
  }
  
  driver.get("https://gorest.co.in/");
  driver.manage().window().maximize();
  
  }
  
  //==========================Method to invoke after the test  ===============================//
  

  
  
  
  }
 
