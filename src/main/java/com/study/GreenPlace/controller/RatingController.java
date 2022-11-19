package com.study.GreenPlace.controller;

import com.study.GreenPlace.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/getRatingByPlaceId/{id}")
    public ResponseEntity<?> getRatingByPlaceId(@PathVariable(name = "id") short id){
        return ok(ratingService.findRatingByPlaceId(id));
    }
}
