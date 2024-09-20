import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuthTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String authResponse=given().formParam("client_id", "<Value>").formParam("client_secret", "<Value>").formParam("grant_type", "")
		.formParam("scope", "<value>").when().post("").asString();
		
		JsonPath js=new JsonPath(authResponse);
		
		String accessToken=js.getString("access_token");
		
		
		String finalResponse=given().queryParam("accessToken", accessToken).when().get("").asString();
		
		
		

	}

}
