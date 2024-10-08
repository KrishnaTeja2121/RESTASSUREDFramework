import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		///REST ASSURED
		
		//given- all the inputs
		
		// when - submit the API---resource and http method
		
		//Then - Validate the response
		
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")
		.extract().response().asString();
		
		//System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		
		String placeid=js.get("place_id");
		System.out.println(placeid);
		
		String newAddress="Test Addressszgsgbszdbzsdbz";
		
		
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.updatePlace(placeid,newAddress))
		.when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
		.when().get("maps/api/place/get/json").then().statusCode(200)
		.extract().response().asString();
		
		JsonPath js2=new JsonPath(getPlaceResponse);
		String actualAddress=js2.getString("address");
		
		Assert.assertEquals(actualAddress, newAddress);
		
		

	}

}
