package vttp2022.csf.assessment.server.repositories;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import vttp2022.csf.assessment.server.configs.AppConfig;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class MapCache {

	@Autowired
	@Qualifier(AppConfig.MAP_CACHE)
	private static RedisTemplate<String, String> redisTemplate;


	// TODO Task 4
	// Use this method to retrieve the map
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME

	
	public ??? getMap(???) {
		// Implmementation in here
		
	}

	// You may add other methods to this class



    public void saveCuisine(List<Restaurant> cuisines) {
		for (Restaurant r : cuisines){
			redisTemplate
				.opsForValue()
				.set(
					r.getCuisine().toString(),
					r.toJson().toString(),
					Duration.ofDays(1));
		}
    }


	

	public static Optional<Restaurant> getRestaurantsByCuisine(String restaurantId, String name) {
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		
        String value = ops.get(name);
		
    
	}

	
