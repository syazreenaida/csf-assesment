package vttp2022.csf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.MapCache;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private MapCache mapCache;

	// TODO Task 2 
	// Use the following method to get a list of cuisines 
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public List<Restaurant> getCuisines(String cuisine) {
		// Implmementation in here
		Restaurant restCuisine;

		Optional<Restaurant> optRest = MapCache.saveCuisine(cuisine);

		if(optRest.isPresent()){
			System.out.println("Cuisine: %d found in cache".formatted(cuisine));
			restCuisine = optRest.get();
		}else{
			System.out.println( "Character: %d not found in cache".formatted(cuisine));
		}

		// cache results in redis
		MapCache.saveCuisine(cuisine);
	}

	// TODO Task 3 
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	public List<Restaurant> getRestaurantsByCuisine(String restaurantId, String name) {
		// Implmementation in here

		Restaurant restNames;

		Optional<Restaurant> optRest = MapCache.getRestaurantsByCuisine(restaurantId, name);

		if(optRest.isPresent()){
			System.out.println("Cuisine: %d found in cache".formatted(restaurantId, name));
			restNames = optRest.get();
		}else{
			System.out.println( "Character: %d not found in cache".formatted(restaurantId, name));
		}

		// cache results in redis
		MapCache.saveRestaurants(restaurantId, name);
		
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public Optional<Restaurant> getRestaurant(???) {
		// Implmementation in here
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public void addComment(Comment comment) {
		// Implmementation in here
		
	}
	//
	// You may add other methods to this class
}
