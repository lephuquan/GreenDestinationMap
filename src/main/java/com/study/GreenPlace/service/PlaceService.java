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


    public List<PlaceModel> getAllPlace(){
        ModelMapper modelMapper = new ModelMapper();
        List<Places> places = placeRepository.findAll();
        List<PlaceModel> placeModelList = new ArrayList<>();
        for(Places item: places){
            Collection<Ratings> ratingsList = item.getRatingsCollection();
            List<RatingsModel> ratingsModelList = new ArrayList<>();
            for(Ratings ratings: ratingsList) {
                Criterias criterias = ratings.getCriteriaid();
                RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
                CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
                ratingsModel.setCriteriasModel(criteriasModel);
                ratingsModelList.add(ratingsModel);
            }
            PlaceModel placeModel =  modelMapper.map(item, PlaceModel.class);
            placeModel.setRatingsCollection(ratingsModelList);
            placeModelList.add(placeModel);
        }
        return placeModelList;
    }

    public PlaceModel findPlaceById(Short id){// key
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

    public List<PlaceModel> findPlaceBySupplierId(short id){
        ModelMapper modelMapper = new ModelMapper();
        List<Places> places = placeRepository.findPlaceBySupplierId(id);
        List<PlaceModel> placeModelList = new ArrayList<>();
        for(Places item: places){
            Collection<Ratings> ratingsList = item.getRatingsCollection();
            List<RatingsModel> ratingsModelList = new ArrayList<>();
            for(Ratings ratings: ratingsList) {
                Criterias criterias = ratings.getCriteriaid();
                RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
                CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
                ratingsModel.setCriteriasModel(criteriasModel);
                ratingsModelList.add(ratingsModel);
            }
            PlaceModel placeModel =  modelMapper.map(item, PlaceModel.class);
            placeModel.setRatingsCollection(ratingsModelList);
            placeModelList.add(placeModel);
        }
        return placeModelList;
    }

    public PlaceModel findPlaceByName(String name){
        Places places = placeRepository.findByNamePlace(name);
        return new ModelMapper().map(places, PlaceModel.class);
    }


    public String addPlace(PlaceModel placeModel){
        ModelMapper modelMapper = new ModelMapper();
        Places places = modelMapper.map(placeModel, Places.class);
        places.setStartday(placeModel.getStartday());
        places.setMapid(placeModel.getMapid());
        places.setStatus(placeModel.isStatus());// sau khi được duyệt sẽ chuyển thành true
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
            // List<DCriterias> criteriasList = criteriaRepository.getListCriteriaByPlaceTypeId(places.getPlacetypeid().getPlacetypeid());
            Criterias criterias = criteriaRepository.findById(item.getCriteriasModel().getCriteriaid()).get();
            Ratings ratings = modelMapper.map(item, Ratings.class);
            ratings.setPlaceid(places);
            ratings.setUseridfr(places.getUserid());// user rating, not user's place
            ratings.setCriteriaid(criterias);
            ratings =  ratingRepository.save(ratings);
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
        places.setUserid(userRepository.findById(placeModel.getUserid().getUserid()).get());//. userId have to exist in database
        places.setRatingsCollection(null);
        places.setImagesCollection(null);
        places.setCommentsCollection(null);
        places.setWishListItemsCollection(null);
        places = placeRepository.save(places);

        //handle list image
        imageRepository.deleteImagesByPlaceId(places.getPlaceid());
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

        ratingRepository.deleteRatingsByPlaceId(places.getPlaceid());
        Collection<RatingsModel> ratingsModels = placeModel.getRatingsCollection();// rating dùng để lưu  đánh giá và là submit nhưng tiêu chỉ mà địa điểm này có
        for(RatingsModel item: ratingsModels){
            // List<Criterias> criteriasList = criteriaRepository.getListCriteriaByPlaceTypeId(places.getPlacetypeid().getPlacetypeid());
            Criterias criterias = criteriaRepository.findById(item.getCriteriasModel().getCriteriaid()).get();
            Ratings ratings = modelMapper.map(item, Ratings.class);
            ratings.setPlaceid(places);
            ratings.setUseridfr(places.getUserid());// user rating, not user's place
            ratings.setCriteriaid(criterias);
            ratings =  ratingRepository.save(ratings);
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