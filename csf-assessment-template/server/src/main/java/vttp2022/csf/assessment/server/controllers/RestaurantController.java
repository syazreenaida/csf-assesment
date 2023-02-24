package vttp2022.csf.assessment.server.controllers;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.StringReader;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;
import vttp2022.csf.assessment.server.services.RestaurantService;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    
    @Autowired
    private RestaurantService restSvc;

    @GetMapping(path = "/cuisines")
    public ResponseEntity<String> getCuisines(@RequestParam String cuisine,@RequestParam(defaultValue = "20") Integer limit,@RequestParam(defaultValue = "0") Integer offset){

        //get list
        List<Restaurant> restaurants = restSvc.getCuisines(cuisine, limit, offset);

        // List<MarvelCharacter> -> JsonArray
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();

        // add each MarvelCharacter -> JsonObject
        restaurants.forEach(c -> arrBuilder.add(c.toJson()));

        JsonArray resp = arrBuilder.build();

        return ResponseEntity.ok(resp.toString());

    }
}
