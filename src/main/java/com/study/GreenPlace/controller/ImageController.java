package com.study.GreenPlace.controller;

import com.study.GreenPlace.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/img")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/image")
    public  ResponseEntity<?> randomStuff(){
        return ok(imageService.getAllImage());
    }

    @GetMapping("/image/{id}")
    public  ResponseEntity<?> getImageByPlaceId(@PathVariable(name = "id") short id){
        return ok(imageService.finImageByPlaceId(id));
    }
}
