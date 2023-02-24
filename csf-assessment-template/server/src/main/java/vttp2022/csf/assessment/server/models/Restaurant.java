package vttp2022.csf.assessment.server.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonValue;

// Do not modify this class
public class Restaurant {
	
	private String restaurantId;
	private String name;
	private String cuisine;
	private String address;
	private LatLng coordinates;
	private String mapUrl;

	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantId() {
		return this.restaurantId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getCuisine() {
		return this.cuisine;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}

	public void setCoordinates(LatLng coordinates) {
		this.coordinates = coordinates;
	}
	public LatLng getCoordinates() {
		return this.coordinates;
	}

	public void setMapURL(String mapUrl) {
		this.mapUrl = mapUrl;
	}
	public String getMapURL() {
		return this.mapUrl;
	}

	//Task 2
    public JsonValue toJson() {
        JsonObjectBuilder job = Json
			.createObjectBuilder()
			.add("restaurantId", restaurantId)
			.add("name", name)
			.add("cuisine", cuisine)
			.add("address", address);

		return job.build();
			
    }
	public static Restaurant createFromCache(JsonObject json) {
		//Json object from redis -> Restaurant 
		Restaurant r = new Restaurant();
		r.setRestaurantId(json.getString("restaurantId"));
		r.setName(json.getString("name"));
		r.setCuisine(json.getString("cuisine"));
		r.setAddress(json.getString("address"));
		return r;
	}
}
