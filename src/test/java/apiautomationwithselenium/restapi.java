/*
 * package apiautomationwithselenium;
 * 
 * import java.io.FileInputStream; import java.io.FileOutputStream; import
 * java.io.IOException; import java.sql.Timestamp; import java.util.Collections;
 * import java.util.List; import java.util.Properties; import
 * java.util.concurrent.Future;
 * 
 * import org.json.JSONObject; import org.jtwig.JtwigModel; import
 * org.jtwig.JtwigTemplate; import org.openqa.selenium.By; import
 * org.openqa.selenium.Keys; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.chrome.ChromeOptions; import
 * org.openqa.selenium.interactions.Actions; import
 * org.openqa.selenium.json.Json; import org.testng.Assert;
 * 
 * import com.mashape.unirest.http.HttpResponse; import
 * com.mashape.unirest.http.JsonNode; import com.mashape.unirest.http.Unirest;
 * import com.mashape.unirest.http.exceptions.UnirestException;
 * 
 * import io.restassured.path.json.JsonPath;
 * 
 * public class restapi {
 * 
 * public static void main(String[] args) throws UnirestException, IOException,
 * InterruptedException { // TODO Auto-generated method stub
 * 
 * // Getting all the users list
 * 
 * String searchQueryApi =
 * "https://gorest.co.in/public-api/users?access-token=nPQDO6XQnQXkTReYAiEm_GqXbru76DKHJxBU";
 * 
 * // gmail access token =
 * "https://gorest.co.in/public-api/users?access-token=4NWwJWH4Nc3-i5xMjCHbYU_8tPp_8g4dxlSW";
 * JsonNode body = Unirest.get(searchQueryApi).asJson().getBody();
 * System.out.println(body);
 * 
 * // ----Post a new user data --------//
 * 
 * // === reading data from a file and replace the values at runtime =====//
 * JtwigTemplate template = JtwigTemplate.classpathTemplate("userinfo.json");
 * JtwigModel model = JtwigModel.newModel().with("email",
 * "dsddsdyyu@gmail.com").with("id", "34345") .with("first_name",
 * "kgfg").with("last_name", "dkdkfj").with("gender", "male");
 * 
 * template.render(model);
 * 
 * // ==== using unirest to send above json to create a new user ==== //
 * 
 * String postApi = "https://gorest.co.in/public-api/users";
 * 
 * HttpResponse<JsonNode> response = Unirest.post(postApi).header("accept",
 * "application/json") .header("Content-Type", "application/json")
 * .queryString("access-token",
 * "nPQDO6XQnQXkTReYAiEm_GqXbru76DKHJxBU").body(template.render(model)).asJson()
 * ;
 * 
 * //String resp= response.getBody().toString(); int status =
 * response.getStatus(); System.out.println(response.getBody());
 * System.out.println(status); //String res = response.toString();
 * 
 * JSONObject myobj = response.getBody().getObject(); // String idv = myobj.
 * 
 * //String idvalue = myobj.getString("id"); //String emailid =
 * myobj.getString("email"); //String fname = myobj.getString("first_name");
 * //String lname = myobj.getString("last_name"); //JsonPath js = new
 * JsonPath(resp); // String idvalue = js.getString("id"); // String emailid =
 * js.getString("email"); // String fname = js.getString("first_name"); //
 * String lname = js.getString("last_name");
 * 
 * 
 * 
 * //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
 * 
 * 
 * //String timestamps = timestamp.toString(); //System.out.println(response);
 * //System.out.println(status);
 * 
 * //String filePath =
 * "D:\\eclipseworkspace\\apiautomationwithselenium\\src\\test\\resources\\apiresponse.properties";
 * 
 * // Properties props = new Properties();
 * 
 * //FileOutputStream writefile = new FileOutputStream(filePath); //
 * props.setProperty("customerid", idv);
 * props.setProperty("timestamp",timestamps); // props.setProperty("email",
 * emailid); // props.setProperty("firstname", fname);
 * props.setProperty("Lastname", lname); // props.store(writefile, null);
 * //writefile.close();
 * 
 * 
 * //FileInputStream readfile = new FileInputStream(filePath);
 * 
 * //props.load(readfile); //readfile.close();
 * 
 * // ====== UI Testing ===============//
 * 
 * 
 * 
 * System.setProperty("webdriver.chrome.driver",
 * "D:\\eclipseworkspace\\selenium3\\drivers\\chromedriver.exe"); ChromeOptions
 * options = new ChromeOptions();
 * options.setExperimentalOption("useAutomationExtension", false);
 * options.setExperimentalOption("excludeSwitches",
 * Collections.singletonList("enable-automation"));
 * options.setCapability("acceptSslCerts", true);
 * options.addArguments("--start-maximized");
 * 
 * WebDriver driver = new ChromeDriver(options);
 * 
 * driver.get("https://gorest.co.in");
 * 
 * WebElement login =
 * driver.findElement(By.xpath("//a[@href='/user/login.html']")); login.click();
 * Thread.sleep(300);
 * 
 * //switch to window
 * 
 * String handle = driver.getWindowHandle();
 * driver.findElement(By.xpath("//span[@class='auth-icon facebook']")).click();
 * Thread.sleep(300);
 * 
 * for(String winHandle : driver.getWindowHandles()){
 * driver.switchTo().window(winHandle); } driver.manage().window().maximize();
 * 
 * // log into FB
 * driver.findElement(By.id("email")).sendKeys("automationpracticea@gmail.com");
 * driver.findElement(By.id("pass")).sendKeys("Automation@786");
 * driver.findElement(By.id("loginbutton")).click();
 * driver.switchTo().window(handle);
 * 
 * Thread.sleep(2000);
 * //driver.findElement(By.xpath("//span[@class='RveJvd snByac'][1]")).click();
 * 
 * Actions act = new Actions(driver); 
 * //act.click(driver.findElement(By.xpath("//i[@class='fa fa-database gutter-sm-right']"))).perform();
 * 
 * //
 * driver.findElement(By.xpath("//i[@class='fa fa-database gutter-sm-right']"));
 * act.moveToElement(driver.findElement(By.
 * xpath("//i[@class='fa fa-database gutter-sm-right']"))).click().perform();
 * //driver.findElement(By.xpath("//ul[@id='w2']/li[4]")).click();
 * Thread.sleep(500); //driver.switchTo().activeElement().click(); //Navigate to
 * users page
 * act.moveToElement(driver.findElement(By.xpath("//*[text()='Users']"))).click(
 * ).perform(); //driver.findElement(By.xpath("//ul[@id='w4']/li[1]")).click();
 * Thread.sleep(1200); //driver.switchTo().activeElement().click(); //String
 * value = props.getProperty(emailid);
 * //driver.findElement(By.xpath("//input[@name='PublicUserSearch[email]']")).
 * sendKeys(value); //act.sendKeys(Keys.ENTER);
 * //Assert.assertEquals(driver.findElement(By.xpath("//*[text()='ihuyb']")),
 * props.getProperty("Lastname") );
 * 
 * 
 * }
 * 
 * }
 */