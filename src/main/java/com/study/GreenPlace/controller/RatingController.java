package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.model.RatingsModel;
import com.study.GreenPlace.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/getRatingByPlaceIdAndUserId/{placeId}/{userId}")
    public ResponseEntity<?> getRatingByPlaceId(@PathVariable(name = "placeId") short placeId,@PathVariable(name = "userId") short userId ){
        return ok(ratingService.findRatingByPlaceIdAndUserId(placeId, userId));
    }

    //getuser/place/add/update

    @PostMapping("/addRating")
    public ResponseEntity<?> addRating(@RequestBody RatingsModel ratingsModel){
        return ResponseEntity.ok(ratingService.addRating(ratingsModel));
    }
}
