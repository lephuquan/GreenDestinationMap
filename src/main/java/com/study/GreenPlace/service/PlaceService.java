package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.*;
import com.study.GreenPlace.model.*;
import com.study.GreenPlace.repository.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceTypeRepository placeTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private  RatingRepository ratingRepository;

    @Autowired
    private  WishListItemsRepository wishListItemsRepository;


    public List<Places> getAllPlace(){
        List<Places>  places = placeRepository.findAll();
        return new ModelMapper().map(places, new TypeToken<List<PlaceModel>>() {}.getType());
    }

    public PlaceModel findPlaceById(Short id){
        Places places = placeRepository.findById(id).get();
            return new ModelMapper().map(places, PlaceModel.class);
    }

    public PlaceModel findPlaceByName(String name){
        Places places = placeRepository.findByNamePlace(name);
        return new ModelMapper().map(places, PlaceModel.class);
    }

    public PlaceModel findPlaceBySupplierName(String name){
        Places places = placeRepository.findPlaceBySupplierName(name);
        return new ModelMapper().map(places, PlaceModel.class);
    }

    public String addPlace(PlaceModel placeModel){
        ModelMapper modelMapper = new ModelMapper();
        Places places = modelMapper.map(placeModel, Places.class);
        places.setStartday(placeModel.getStartday());
        places.setMapid(placeModel.getMapid());
        places.setStatus(false);// sau khi được duyệt sẽ chuyển thành true
        places.setPlacename(placeModel.getPlacename());
        places.setLat(placeModel.getLat());
        places.setLon((placeModel.getLon()));
        places.setCountry(placeModel.getCountry());
        places.setCity(placeModel.getCity());
        places.setDistrict(placeModel.getDistrict());
        places.setWard(placeModel.getWard());
        places.setDescription(placeModel.getDescription());
        places.setStar(placeModel.getStar());
        places.setRoad(placeModel.getRoad());
        places.setPhone(placeModel.getPhone());
        places.setBrowserday(placeModel.getBrowserday());
        places.setPlacetypeid(placeTypeRepository.findById(placeModel.getPlaceTypeModel().getPlacetypeid()).get());
        places.setUserid(userRepository.findById(placeModel.getUserModel().getUserid()).get());

        places = placeRepository.save(places);

        //handle list image
        Collection<ImageModel> imageModels = placeModel.getImagesCollection();
        for (ImageModel item: imageModels){
            Images images = modelMapper.map(item, Images.class);
            images.setPlaceid(places);
            images = imageRepository.save(images);
        }
        //handle comment list
        Collection<CommentsModel> commentsModels = placeModel.getCommentsModels();
        for(CommentsModel item: commentsModels){
            Comments comments = modelMapper.map(item, Comments.class);
            comments.setPlaceid(places);// come to place object get placeId
            comments.setUseridfr(places.getUserid());// come to user object get userId
            comments =  commentRepository.save(comments);
        }

        //handle Rating list
        Collection<RatingsModel> ratingsModels = placeModel.getRatingsModelCollection();
        for(RatingsModel item: ratingsModels){
            Ratings ratings = modelMapper.map(item, Ratings.class);
            ratings =  ratingRepository.save(ratings);
        }

        //handle wishLishItem list
        Collection<WishListItemsModel> wishListItemsModels = placeModel.getWishListItemsModels();
        for(WishListItemsModel item: wishListItemsModels){
            WishListItems wishListItems = modelMapper.map(item, WishListItems.class);
            wishListItems =  wishListItemsRepository.save(wishListItems);
        }

        //Adding a location does not need to add comments, ratings and wishlist
        // because this information must be added to its own table. When adding place,
        // only place information is added, not place's relational tables
        return "success";
    }

    public  boolean deletePlace(short id){
        placeRepository.deleteById(id);
        return true;
    }

}
