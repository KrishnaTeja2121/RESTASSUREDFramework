import files.payload;
import io.restassured.path.json.JsonPath;

public class advancedJsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js=new JsonPath(payload.courses());
		
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		int totalAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);
		
		String titleFirstCourse=js.getString("courses[0].title");
		System.out.println(titleFirstCourse);
		
		String titleSecondCourse=js.getString("courses[2].title");
		System.out.println(titleSecondCourse);
		
		
		
		

	}

}
