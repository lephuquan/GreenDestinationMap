package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.model.UserModel;
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
    public ResponseEntity<?> findById(@PathVariable(name = "id") short id) {// trong api này có collection userId, muốn lấy đc userId trước tiên phải đăng nhập
        return ok(placeService.findPlaceById(id));
    }

    // chỗ này chưa cần dùng request body
    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findPlaceByName(@PathVariable(name = "name") String name) {
        return ok(placeService.findPlaceByName(name));
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<?> findPlaceBySupplierId(@PathVariable(name = "id") short id) {
        return ok(placeService.findPlaceBySupplierId(id));
    }

    @PostMapping("/addPlace")
    public ResponseEntity<?> addPlace(@RequestBody PlaceModel placeModel){
        return ResponseEntity.ok(placeService.addPlace(placeModel));
    }

    @PutMapping("/updatePlace")
    public ResponseEntity<?> updatePlace(@RequestBody PlaceModel placeModel){
        return ResponseEntity.ok(placeService.updatePlace(placeModel));
    }

    @RequestMapping(value = "/deletePlace/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePlace(@PathVariable(value = "id") short id) {
        return ok(placeService.deletePlace(id));
    }


}
