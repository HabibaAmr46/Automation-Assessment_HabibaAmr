package APITests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.TestBase;
import api.endpoints.PostEndPoints;
import api.payload.Post;
import io.restassured.response.Response;
import utils.ExtentReportManager;
import utils.JsonFileManager;

public class GetPostTests extends TestBase {

	JSONObject testData = JsonFileManager.readJsonFile("src/test/resources/GetPostsTestData.json");
	
	@Test
	public void getSinglePostTest()
	{
		ExtentReportManager.createTest("API: Test Get Single Post with valid ID");
		int postId = Integer.valueOf(JsonFileManager.getJsonValue(testData, "id"));
		
		ExtentReportManager.info("Perform get Request with ID: "+postId);
		Response response = PostEndPoints.getSinglePost(postId);
		
		ExtentReportManager.info("Check Response is 200");
		Assert.assertEquals(response.statusCode(), 200);
		
		Post postObj=response.as(Post.class); 
		
		ExtentReportManager.info("Check response body is the same as in the json file");
		Assert.assertEquals(postObj.getId(), postId);
		Assert.assertEquals(String.valueOf(postObj.getUserId()),JsonFileManager.getJsonValue(testData, "userId"));
		Assert.assertEquals(postObj.getBody(), JsonFileManager.getJsonValue(testData, "body"));
		Assert.assertEquals(postObj.getTitle(), JsonFileManager.getJsonValue(testData, "title"));
	}
	
	@Test
	public void getSinglePostTestWithInvalidID()
	{
		ExtentReportManager.createTest("API: Test Get Single Post with invalid ID");
		int postId = Integer.valueOf(JsonFileManager.getJsonValue(testData, "invalidId"));
		
		ExtentReportManager.info("Perform get Request with ID: "+postId);
		Response response = PostEndPoints.getSinglePost(postId);
		
		ExtentReportManager.info("Check Response is 404");
		Assert.assertEquals(response.statusCode(), 404);
	}

	@Test
	public void getAllPosts()
	{
		ExtentReportManager.createTest("API: Test Get all posts");
		
		ExtentReportManager.info("Perform get Request");
		Response response = PostEndPoints.getAllPosts();
		
		ExtentReportManager.info("Check Response is 200");
		Assert.assertEquals(response.statusCode(), 200);
		
		ExtentReportManager.info("Check the number of posts");
		int numberOfPosts = response.jsonPath().getList("$").size();
		
		Assert.assertEquals(String.valueOf(numberOfPosts), JsonFileManager.getJsonValue(testData,"numberOfPosts"));
	}
}
