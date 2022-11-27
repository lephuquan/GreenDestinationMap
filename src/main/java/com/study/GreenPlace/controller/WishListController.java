package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.WishListsModel;
import com.study.GreenPlace.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/wishList")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @PostMapping("/addWishList")
    public ResponseEntity<?> addPlace(@RequestBody WishListsModel wishListsModel){
        return ResponseEntity.ok(wishListService.addWishList(wishListsModel));
    }

    @PutMapping("/updateWishList")
    public ResponseEntity<?> updatePlace(@RequestBody WishListsModel wishListsModel){
        return ResponseEntity.ok(wishListService.updateWishList(wishListsModel));
    }

    @RequestMapping(value = "/deleteWishList/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePlace(@PathVariable(value = "id") short id) {
        return ok(wishListService.deleteWishList(id));
    }


    @GetMapping("/getWishlistByUserId/{id}")
    public ResponseEntity<?> getWishlistByUserId(@PathVariable(name = "id") short id) {
        return ok(wishListService.getWishlistByUserId(id));
    }
}
