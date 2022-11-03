package com.study.GreenPlace.controller;

import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.service.ImageService;
import com.study.GreenPlace.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/place")
public class HomeController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/information")
    public ResponseEntity<?> getAllPlace(){
        return ok(placeService.getAllPlace());
    }
}
