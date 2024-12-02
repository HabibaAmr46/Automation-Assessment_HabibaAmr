package APITests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;
import api.endpoints.PostEndPoints;
import api.payload.Post;
import io.restassured.response.Response;
import utils.ExtentReportManager;
import utils.JsonFileManager;

public class CreatePostTests extends TestBase {
	
	JSONObject testData = JsonFileManager.readJsonFile("src/test/resources/CreatePostTestData.json");

	@Test
	public void createPost() {

		ExtentReportManager.createTest("API: Test Create Post with Valid Values");
		
		String title=JsonFileManager.getJsonValue(testData, "title");
		String body=JsonFileManager.getJsonValue(testData, "body");
		
		Post payload=Post.builder().
				userId(Integer.valueOf(JsonFileManager.getJsonValue(testData, "userId")))
				.title(title)
				.body(body).build();
		
		
		
		ExtentReportManager.info("Perform Post Request");	
		Response createPostResponse = PostEndPoints.createPost(payload);
		
		ExtentReportManager.info("Check Response is 201");
		Assert.assertEquals(createPostResponse.statusCode(), 201);
		
        Post postObj=createPostResponse.as(Post.class); //Extract response in pojo class
		ExtentReportManager.info("Check response body is the same as in the json file");
		Assert.assertEquals(postObj.getBody(), body);
		Assert.assertEquals(postObj.getTitle(), title);

	}

	@Test
	public void createPostWithMissingTitle() {

		ExtentReportManager.createTest("API: Test Create Post with missing title");
		
		Post payload=Post.builder().
				userId(Integer.valueOf(JsonFileManager.getJsonValue(testData, "userId")))
				.body(JsonFileManager.getJsonValue(testData, "body")).build();
		ExtentReportManager.info("Peform post request");
		Response createPostResponse = PostEndPoints.createPost(payload);
		
		ExtentReportManager.info("Check Response is 404");
		Assert.assertEquals(createPostResponse.statusCode(), 404);

	}

	@Test
	public void createPostWithEmptyBody() {

		ExtentReportManager.createTest("API: Test Create Post with empty body");
		Post payload=Post.builder().
				userId(Integer.valueOf(JsonFileManager.getJsonValue(testData, "userId")))
				.title(JsonFileManager.getJsonValue(testData, "title"))
				.body("").build();
		
		
		ExtentReportManager.info("Perform Post Request");
		Response createPostResponse = PostEndPoints.createPost(payload);
		
		ExtentReportManager.info("Check Response is 404");
		Assert.assertEquals(createPostResponse.statusCode(), 404);

	}


}
