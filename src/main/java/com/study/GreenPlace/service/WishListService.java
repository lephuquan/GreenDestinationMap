package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.*;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.model.UserModel;
import com.study.GreenPlace.model.WishListItemsModel;
import com.study.GreenPlace.model.WishListsModel;
import com.study.GreenPlace.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private UserRepository  userRepository;


    @Autowired
    private WishListItemsRepository wishListItemsRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ImageRepository imageRepository;


    public String addWishList(WishListsModel wishListsModel){
        ModelMapper modelMapper = new ModelMapper();
        WishLists wishLists = modelMapper.map(wishListsModel, WishLists.class);
        wishLists.setWishlistname(wishListsModel.getWishlistname());
        wishLists.setUserid(userRepository.findById(wishListsModel.getUserModel().getUserid()).get());
        wishLists.setWishListItemsCollection(null);
        wishListRepository.save(wishLists);

       if(wishListsModel.getWishListItemsModels() != null){
           Collection<WishListItemsModel> wishListItemsModels = wishListsModel.getWishListItemsModels();
           for(WishListItemsModel item: wishListItemsModels){
               WishListItems wishListItems = modelMapper.map(item, WishListItems.class);
               wishListItems.setWishlistid(wishLists);
               wishListItems.setPlaceid(placeRepository.findById(item.getPlaceModel().getPlaceid()).get());
               wishListItemsRepository.save(wishListItems);
           }
       }

        return "sucess";
    }

    public String updateWishList(WishListsModel wishListsModel){
        ModelMapper modelMapper = new ModelMapper();
        WishLists wishLists = wishListRepository.getReferenceById(wishListsModel.getWishlistid());
        wishLists.setWishlistname(wishListsModel.getWishlistname());
        wishLists.setUserid(userRepository.findById(wishListsModel.getUserModel().getUserid()).get());
        wishLists.setWishListItemsCollection(null);
        wishListRepository.save(wishLists);

        if(wishListsModel.getWishListItemsModels() != null){
            Collection<WishListItemsModel> wishListItemsModels = wishListsModel.getWishListItemsModels();
            for(WishListItemsModel item: wishListItemsModels){
                WishListItems wishListItems = modelMapper.map(item, WishListItems.class);
                wishListItems.setWishlistid(wishLists);
                wishListItems.setPlaceid(placeRepository.findById(item.getPlaceModel().getPlaceid()).get());
                wishListItemsRepository.save(wishListItems);
            }
        }

        return "sucess";
    }

    public List<WishListsModel> getWishlistByUserId(short id){
        ModelMapper modelMapper =  new ModelMapper();
        List<WishLists> wishListsList = wishListRepository.findPlaceByUserId(id);
        List<WishListsModel> wishListsModelList = new ArrayList<>();

        for(WishLists item: wishListsList){
            WishListsModel wishListsModel = modelMapper.map(item, WishListsModel.class);
            wishListsModel.setWishlistid(item.getWishlistid());
            wishListsModel.setWishlistname(item.getWishlistname());
            Users users = item.getUserid();
            UserModel userModel = modelMapper.map(users, UserModel.class);
            wishListsModel.setUserModel(userModel);


            //---------------process wishlistItem to get place to get image in place
            List<WishListItems> wishListItemsList = wishListItemsRepository.findWishlistItemByWishlistId(item.getWishlistid());
            Collection<WishListItemsModel> wishListItemsModels = new ArrayList<>();
            for (WishListItems wishListItems: wishListItemsList){
                WishListItemsModel wishListItemsModel = modelMapper.map(wishListItems, WishListItemsModel.class);
                Places places = placeRepository.findById(wishListItems.getPlaceid().getPlaceid()).get();// get place from wishlistItem


                List<Images> imagesList = imageRepository.getImageByPlaceId(places.getPlaceid());//get image from plce
                for(Images imagesItem: imagesList){
                    wishListsModel.setImage(imagesItem.getImagename());//set wishlistImage
                    break;
                }
                    //-> set place for wishlistItem but don't need
//                PlaceModel placeModel = modelMapper.map(places, PlaceModel.class);
//                wishListItemsModel.setPlaceModel(placeModel);
//                wishListItemsModels.add(wishListItemsModel);
            }
            //---------------

            wishListsModel.setWishListItemsModels(wishListItemsModels);
            wishListsModelList.add(wishListsModel);
        }
        return wishListsModelList;
    }



    public boolean deleteWishList(short id){
        wishListRepository.deleteById(id);
       return  true;
    }
}
