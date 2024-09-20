
public enum enumTest {
	
	AddPlaceAPI("maps/ai/json"),
	getPlaceAPI("hdgte/fjeku/json"),
	deletePlaceAPI("cshjbsu/skjguisg/json");
	private String resource;

	enumTest(String resouce) {
		// TODO Auto-generated constructor stub
		this.resource=resource;
	}
	
	public String getResource() {
		return resource;
	}

}
