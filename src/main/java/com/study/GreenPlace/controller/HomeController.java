package com.study.GreenPlace.controller;

import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.service.ImageService;
import com.study.GreenPlace.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") short id) {
        return ok(placeService.findPlaceById(id));
    }

    // chỗ này chưa cần dùng request body
    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findPlaceByName(@PathVariable(name = "name") String name) {
        return ok(placeService.findPlaceByName(name));
    }

    @GetMapping("/findByUser/{userName}")
    public ResponseEntity<?> findPlaceBySupplierName(@PathVariable(name = "userName") String name) {
        return ok(placeService.findPlaceBySupplierName(name));
    }



    @RequestMapping(value = "/deletePlace/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePlace(@PathVariable(value = "id") short id) {
        return ok(placeService.deletePlace(id));
    }
}