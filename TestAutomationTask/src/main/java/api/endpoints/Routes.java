package api.endpoints;

import java.util.Properties;

import utils.PropertiesReader;

public class Routes {
	public static String base_url=PropertiesReader.getProperties().getProperty("base_url_api");
	
	
	public static String post_url=base_url+"/posts";
	public static String get_url_allPosts=base_url+"/posts";
	public static String get_url_onePost=base_url+"/posts/{postID}";
}
