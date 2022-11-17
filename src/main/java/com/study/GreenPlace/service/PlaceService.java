package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.*;
import com.study.GreenPlace.model.*;
import com.study.GreenPlace.repository.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private CriteriaRepository criteriaRepository;


    public List<Places> getAllPlace(){
        List<Places>  places = placeRepository.findAll();
        return new ModelMapper().map(places, new TypeToken<List<PlaceModel>>() {}.getType());
    }

    public PlaceModel findPlaceById(Short id){// đưa criterias vào listRating
        ModelMapper modelMapper = new ModelMapper();
        Places places = placeRepository.findById(id).get();
        Collection<Ratings> ratingsList = places.getRatingsCollection();
        List<RatingsModel> ratingsModelList = new ArrayList<>();
        for(Ratings ratings: ratingsList) {
            Criterias criterias = ratings.getCriteriaid();
            RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
            CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
            ratingsModel.setCriteriasModel(criteriasModel);
            ratingsModelList.add(ratingsModel);
        }
        PlaceModel placeModel =  modelMapper.map(places, PlaceModel.class);
        placeModel.setRatingsCollection(ratingsModelList);
        return placeModel;
    }

    public PlaceModel findPlaceByName(String name){
        Places places = placeRepository.findByNamePlace(name);
        return new ModelMapper().map(places, PlaceModel.class);
    }

    public List<Places> findPlaceBySupplierId(short id){
        List<Places> places = placeRepository.findPlaceBySupplierId(id);
        return new ModelMapper().map(places, new TypeToken<List<PlaceModel>>()  {}.getType());
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
        places.setBrowserday(null);
        places.setPlacetypeid(placeTypeRepository.findById(placeModel.getPlacetypeid().getPlacetypeid()).get());
        places.setUserid(userRepository.findById(placeModel.getUserid().getUserid()).get());//. userId have to exist in database
        places.setRatingsCollection(null);
        places.setImagesCollection(null);
        places.setCommentsCollection(null);
        places.setWishListItemsCollection(null);
        places = placeRepository.save(places);

        //handle list image
        Collection<ImageModel> imageModels = placeModel.getImagesCollection();
        for (ImageModel item: imageModels){
            Images images = modelMapper.map(item, Images.class);
            images.setPlaceid(places);
            images = imageRepository.save(images);
        }
        //handle comment list
//        Collection<CommentsModel> commentsModels = placeModel.getCommentsModels();
//        for(CommentsModel item: commentsModels){
//            Comments comments = modelMapper.map(item, Comments.class);
//            comments.setPlaceid(places);// come to place object get placeId
//            comments.setUseridfr(places.getUserid());// come to user object get userId
//            comments =  commentRepository.save(comments);
//        }

        //handle Rating list
//        Collection<RatingsModel> ratingsModels = placeModel.getRatingsModelCollection();// rating dùng để lưu  đánh giá và là submit nhưng tiêu chỉ mà địa điểm này có
//        for(RatingsModel item: ratingsModels){
//            Ratings ratings = modelMapper.map(item, Ratings.class);
//            ratings =  ratingRepository.save(ratings);
//        }

        //handle wishLishItem list
//        Collection<WishListItemsModel> wishListItemsModels = placeModel.getWishListItemsModels();
//        for(WishListItemsModel item: wishListItemsModels){
//            WishListItems wishListItems = modelMapper.map(item, WishListItems.class);
//            wishListItems =  wishListItemsRepository.save(wishListItems);
//        }

        Collection<RatingsModel> ratingsModels = placeModel.getRatingsCollection();// rating dùng để lưu  đánh giá và là submit nhưng tiêu chỉ mà địa điểm này có
        for(RatingsModel item: ratingsModels){
            List<Criterias> criteriasList = criteriaRepository.getListCriteriaByPlaceTypeId(places.getPlacetypeid().getPlacetypeid());
            for(Criterias criterias: criteriasList) {
                Ratings ratings = modelMapper.map(item, Ratings.class);
                ratings.setPlaceid(places);
                ratings.setUseridfr(places.getUserid());// user rating, not user's place
                ratings.setCriteriaid(criterias);
                ratings =  ratingRepository.save(ratings);
            }
        }
        //Adding a location does not need to add comments, ratings and wishlist
        // because this information must be added to its own table. When adding place,
        // only place information is added, not place's relational tables
        return "success";
    }

    public String updatePlace(PlaceModel placeModel){
        ModelMapper modelMapper = new ModelMapper();
        Places places = placeRepository.getReferenceById(placeModel.getPlaceid());
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
        places.setPlacetypeid(placeTypeRepository.findById(placeModel.getPlacetypeid().getPlacetypeid()).get());
        places.setUserid(userRepository.findById(placeModel.getUserid().getUserid()).get());
        places.setRatingsCollection(null);
    places = placeRepository.save(places);

    //handle list image
    Collection<ImageModel> imageModels = placeModel.getImagesCollection();
        for (ImageModel item: imageModels){
        Images images = modelMapper.map(item, Images.class);
        images.setPlaceid(places);
        images = imageRepository.save(images);
    }
    //handle comment list
//        Collection<CommentsModel> commentsModels = placeModel.getCommentsModels();
//        for(CommentsModel item: commentsModels){
//            Comments comments = modelMapper.map(item, Comments.class);
//            comments.setPlaceid(places);// come to place object get placeId
//            comments.setUseridfr(places.getUserid());// come to user object get userId
//            comments =  commentRepository.save(comments);
//        }


    //handle Rating list
//        Collection<RatingsModel> ratingsModels = placeModel.getRatingsModelCollection();// rating dùng để lưu  đánh giá và là submit nhưng tiêu chỉ mà địa điểm này có
//        for(RatingsModel item: ratingsModels){
//            Ratings ratings = modelMapper.map(item, Ratings.class);
//            ratings =  ratingRepository.save(ratings);
//        }


    //handle wishLishItem list
//        Collection<WishListItemsModel> wishListItemsModels = placeModel.getWishListItemsModels();
//        for(WishListItemsModel item: wishListItemsModels){
//            WishListItems wishListItems = modelMapper.map(item, WishListItems.class);
//            wishListItems =  wishListItemsRepository.save(wishListItems);
//        }


//    Collection<RatingsModel> ratingsModels = placeModel.getRatingsCollection();// rating dùng để lưu  đánh giá và là submit nhưng tiêu chỉ mà địa điểm này có
//        for(RatingsModel item: ratingsModels){
//        List<Criterias> criteriasList = criteriaRepository.getListCriteriaByPlaceTypeId(places.getPlacetypeid().getPlacetypeid());
//        for(Criterias criterias: criteriasList) {
//            Ratings ratings = modelMapper.map(item, Ratings.class);
//            ratings.setPlaceid(places);
//            ratings.setUseridfr(places.getUserid());
//            ratings.setCriteriaid(criterias);
//            ratings =  ratingRepository.save(ratings);
//        }
//    }
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