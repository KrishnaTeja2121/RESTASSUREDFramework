import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class serializationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setLanguage("French-IN");
		p.setPhone_number("(+91) 983 893 3937");
		p.setName("Frontline house");
		p.setWebsite("http://google.com");
		
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		
		p.setTypes(myList);
		
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		
		p.setLocation(l);
		
			
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		Response res=given().queryParam("key", "qaclick123").body(p).when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();
		
		String responseString=res.asString();
		System.out.println(responseString);
		
		
		
		

	}

}
