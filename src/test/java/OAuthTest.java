import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;

import static io.restassured.RestAssured.*;

import java.util.List;

import com.sun.tools.javac.util.DefinedBy.Api;

public class OAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String authResponse=given().formParam("client_id", "<Value>").formParam("client_secret", "<Value>").formParam("grant_type", "")
		.formParam("scope", "<value>").when().post("").asString();
		
		JsonPath js=new JsonPath(authResponse);
		
		String accessToken=js.getString("access_token");
		
		
		String finalResponse=given().queryParam("accessToken", accessToken).when().get("").asString();
		
		
		
		///////////////   POJO Class
		
		GetCourse courseObj=given().queryParam("access_token", accessToken).when().log().all()
				.get("https://rahulshettyacademy.com/oAuthApi/getCourseDetails").as(GetCourse.class);
		
		System.out.println(courseObj.getLinkedIn());
		System.out.println(courseObj.getInstructor());
		
		courseObj.getCourses().getApi().get(1).getCourseTitle();
		
		List<pojo.Api> apiCourse=courseObj.getCourses().getApi();
		for(int i=0;i<apiCourse.size();i++) {
			if(apiCourse.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Web Testing")) {
				System.out.println(apiCourse.get(i).getPrice());
				
			}
		}
		
		
		
		

	}

}
