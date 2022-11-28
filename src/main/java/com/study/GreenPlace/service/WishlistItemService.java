package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.WishListItems;
import com.study.GreenPlace.entity.WishLists;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.model.WishListItemsModel;
import com.study.GreenPlace.model.WishListsModel;
import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.repository.WishListItemsRepository;
import com.study.GreenPlace.repository.WishListRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class WishlistItemService {

    @Autowired
    private WishListItemsRepository wishListItemsRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private WishListRepository wishListRepository;

    public String addWishlistItem(WishListItemsModel wishListItemsModel){
        ModelMapper modelMapper = new ModelMapper();
        WishListItems wishListItems = modelMapper.map(wishListItemsModel, WishListItems.class);
        wishListItems.setPlaceid(placeRepository.findById(wishListItemsModel.getPlaceModel().getPlaceid()).get());
        wishListItems.setWishlistid(wishListRepository.findById(wishListItemsModel.getWishListsModel().getWishlistid()).get());
        return  "sucess";
    }
    public boolean deleteWishlistItem(short id){
        wishListItemsRepository.deleteById(id);
        return true;
    }

    public List<WishListItemsModel> getWishlistItemByWishlistId(short id){
        ModelMapper modelMapper =  new ModelMapper();
        List<WishListItemsModel> wishListItemsModels =  new ArrayList<>();
        List<WishListItems> wishListItemsList = wishListItemsRepository.findWishlistItemByWishlistId(id);
        for (WishListItems item: wishListItemsList){
            WishListItemsModel wishListItemsModel = modelMapper.map(item, WishListItemsModel.class);
            Places places = item.getPlaceid();
            PlaceModel placeModel = modelMapper.map(places, PlaceModel.class);
            wishListItemsModel.setPlaceModel(placeModel);
            WishLists wishLists = item.getWishlistid();
            WishListsModel wishListsModel = modelMapper.map(wishLists, WishListsModel.class);
            wishListItemsModel.setWishListsModel(wishListsModel);
            wishListItemsModels.add(wishListItemsModel);
        }
        return wishListItemsModels;
    }
}
