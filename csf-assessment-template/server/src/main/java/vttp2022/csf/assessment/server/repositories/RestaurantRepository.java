package vttp2022.csf.assessment.server.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	// 

	@Autowired
	MongoTemplate mongoTemplate;

	private static final String CUISINES_COLLECTION ="cuisine";
	private static final String RESTAURANTS_COLLECTION ="restaurant";

	public Optional<List<Restaurant>> getCuisines(String cuisine) {
		// Implmementation in here

		//Mongo query 
		/*
		 db.restaurants.find({
			cuisine: "japanese"
		 }).sort({createdAt: -1})
		 .limit(10)
		 */
		 
		 //fliter by cuisine
		 Criteria c = Criteria.where("cuisine").is(cuisine);
		 Query q = Query.query(c);

		 //sortby most recent 
		 Sort sortByMostRecent = Sort.by(Sort.Direction.DESC, "createdAt");
		 q.with(sortByMostRecent);

		 //limit to 10 most recent comments
		 q.limit(10);

		 //query results
		 List<Document> results = mongoTemplate.find(
			q,
			Document.class,
			CUISINES_COLLECTION
		 );

		 //if no comments for cuisine, return empty
		 if (results.size() < 1){
			System.out.println("No cuisine found: &d". formatted(cuisine));
			return Optional.empty();
		 }


	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type 
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//  
	

	//Mongo query 
		/*
		 db.restaurants.find({
			name: "japanese"
		 }).sort({createdAt: -1})
		 .limit(10)
		 */

	public Optional <List<Restaurant>> getRestaurantsByCuisine(String restaurantId, String name) {
		// Implmementation in here
		//fliter by cuisine
		Criteria c = Criteria.where("name").is(name);
		Query q = Query.query(c);

		//sortby most recent 
		Sort sortByMostRecent = Sort.by(Sort.Direction.DESC, "createdAt");
		q.with(sortByMostRecent);

		//limit to 10 most recent comments
		q.limit(10);

		//query results
		List<Document> results = mongoTemplate.find(
		   q,
		   Document.class,
		   CUISINES_COLLECTION
		);

		//if no comments for cuisine, return empty
		if (results.size() < 1){
		   System.out.println("No cuisine found: &d". formatted(name));
		   return Optional.empty();
		}
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any) 
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  
	public Optional<Restaurant> getRestaurant(???) {
		// Implmementation in here
		
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//  
	public void addComment(Comment comment) {
		// Implmementation in here
		
	}

	

	
	
	// You may add other methods to this class

}
