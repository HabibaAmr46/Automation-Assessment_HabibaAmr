package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Post;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostEndPoints {
	
	
	public static Response createPost(Post payload)
	{
		
		Response response=given()
							.contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body(payload)
							.when()
							.post(Routes.post_url);
		
		return response;					
				
				
	}
	
	public static Response getAllPosts()
	{
		
		Response response=given()
							.when()
							.get(Routes.get_url_allPosts);
		
		return response;					
							
	}
	
	public static Response getSinglePost(int postID)
	{
		
		Response response=given()
							.pathParam("postID", postID)
							.when()
							.get(Routes.get_url_onePost);
		
		return response;					
							
	}

}
