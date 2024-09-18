import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

public class bugTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="";
		
		given().header("Content-Type","application/json").header("Authorization","").pathParam("Key", "Balue")
		.body("").post("").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		
		// Add Attachement
		
		given().header("Content-Type","application/json").header("Authorization","").multiPart("file",new File("///Path of the file"))
		.log().all().post("{Key}").then().assertThat().statusCode(200);

	}

}
