package com.gorest.api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

import org.json.JSONObject;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class gorestapis {
	
	//private WebDriver driver;
	//private WebDriverWait wait;
	private String BaseUrl;
	private String filepath;
	private int status;
	
	//=========== API to get the list of available users========================//
	
	public void getUsers() {
		
		this.BaseUrl = "https://gorest.co.in/public-api/users/1651?access-token=nPQDO6XQnQXkTReYAiEm_GqXbru76DKHJxBU";
		try {
			//JsonNode Body = Unirest.get(this.BaseUrl).asJson().getBody();
			//System.out.println("This is the list of all avaialable users:"+ Body);
			//int getresult = Unirest.get(this.BaseUrl).asJson().getStatus();
			//System.out.println("The status of the output is :"+ getresult);
			
			HttpResponse<JsonNode> jsonResponse = Unirest.get(this.BaseUrl).asJson();
			System.out.println("Current users list is :"+ jsonResponse.getBody());
			System.out.println("Response status: " + jsonResponse.getStatus());
			//JSONObject idnode = jsonResponse.getBody().getObject();
			//String id= idnode.getString("$.result.id");
			 //System.out.println("ID value is : " +id);
			 
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//==========================API to post a User=============================//
	
	public void postUser() throws IOException, UnirestException {
		
	//********Reading data from Json file and replacing at runtime************//
		
		JtwigTemplate template = JtwigTemplate.classpathTemplate("userinfo.json");
		JtwigModel model = JtwigModel.newModel().with("email", "satvikasneha@gmail.com").with("id", "56712")
				.with("first_name", "satvika").with("last_name", "sneha").with("gender", "female");

		template.render(model);
		
	//*************Reading from file ends***********************************//
		
		this.BaseUrl = "https://gorest.co.in/public-api/users";
		String response = Unirest.post(this.BaseUrl).header("accept", "application/json")
				.header("Content-Type", "application/json").queryString("access-token", "nPQDO6XQnQXkTReYAiEm_GqXbru76DKHJxBU")
				.body(template.render(model)).getBody().toString();
		
	 this.status =Unirest.post(this.BaseUrl).header("accept", "application/json")
		.header("Content-Type", "application/json").queryString("access-token", "nPQDO6XQnQXkTReYAiEm_GqXbru76DKHJxBU")
		.body(template.render(model)).asJson().getStatus();
	
	//***************Getting the json attributes from response*************//
		
		JSONObject  js = new JSONObject(response);
		String Email = js.get("email").toString();
		String Id = js.get("id").toString();
		String fname = js.get("first_name").toString();
		String lname = js.get("last_name").toString();
	
	//**********Writing json values into properties file******************//
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String currenttime = timestamp.toString();
		
		this.filepath = "D:\\eclipseworkspace\\apiautomationwithselenium\\src\\test\\resources\\apiresponse.properties";
		FileInputStream readfile = new FileInputStream(this.filepath);
		Properties prop = new Properties();
		prop.load(readfile);
		readfile.close();
		
		FileOutputStream  writefile = new FileOutputStream(this.filepath);
		prop.setProperty("Email", Email);
		prop.setProperty("userId", Id);
		prop.setProperty("FirstName", fname);
		prop.setProperty("LastName", lname);
		prop.setProperty("TimeStamp", currenttime);
		prop.store(writefile, null);
		writefile.close();
		System.out.println("Email of the user is :"+Email);
		System.out.println("UserId is:"+Id);
		System.out.println("User firstname is "+fname);
		System.out.println("Currenttime when the test ran is :" +currenttime);
		System.out.println("Status of post request is :" + this.status);
	}
	
	
	
	
	

}
