package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.model.WishListItemsModel;
import com.study.GreenPlace.service.WishlistItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/wishlistItem")
public class WishlistItemController {

    @Autowired
    private WishlistItemService wishlistItemService;

    @PostMapping("/addWishlistItem")
    public ResponseEntity<?> addWishlistItem(@RequestBody WishListItemsModel wishListItemsModel){
        return ResponseEntity.ok(wishlistItemService.addWishlistItem(wishListItemsModel));
    }

    @RequestMapping(value = "/deleteWishListItem/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWishListItem(@PathVariable(value = "id") short id) {
        return ok(wishlistItemService.deleteWishlistItem(id));
    }


    @GetMapping("/getWishlistItemByWishlistId/{id}")
    public ResponseEntity<?> getWishlistItemByWishlistId(@PathVariable(name = "id") short id) {
        return ok(wishlistItemService.getWishlistItemByWishlistId(id));
    }
}

