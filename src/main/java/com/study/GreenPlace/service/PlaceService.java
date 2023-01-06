package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.*;
import com.study.GreenPlace.model.*;
import com.study.GreenPlace.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

    @Autowired
    private WishListRepository wishListRepository;


    public List<PlaceModel> getAllPlace(){
        ModelMapper modelMapper = new ModelMapper();
        List<Places> places = placeRepository.findAll();
        List<PlaceModel> placeModelList = new ArrayList<>();
        for(Places item: places){
            Collection<Ratings> ratingsList = ratingRepository.getRatingsWithUserIdIsNull(item.getPlaceid());
            List<RatingsModel> ratingsModelList = new ArrayList<>();
            for(Ratings ratings: ratingsList) {
                Criterias criterias = ratings.getCriteriaid();
                RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
                CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
                ratingsModel.setCriteriasModel(criteriasModel);
                ratingsModelList.add(ratingsModel);
            }


            Collection<Comments> commentsList = commentRepository.getCommentByPlaceId(item.getPlaceid());
            List<CommentsModel> commentsModelList = new ArrayList<>();
            for(Comments comments: commentsList){
                Users users = comments.getUseridfr();
                CommentsModel commentsModel = modelMapper.map(comments, CommentsModel.class);
                UserModel userModel = modelMapper.map(users, UserModel.class);
                commentsModel.setUserModel(userModel);
                commentsModelList.add(commentsModel);
            }


            Collection<WishListItems> wishListItems = wishListItemsRepository.findWishlistItemByPlaceId(item.getPlaceid());
            List<WishListItemsModel> wishListItemsModels = new ArrayList<>();
            for(WishListItems listItems: wishListItems){
                WishListItemsModel wishListItemsModel = modelMapper.map(listItems, WishListItemsModel.class);
                wishListItemsModel.setWishlistitemid(listItems.getWishlistitemid());
                WishLists wishLists = listItems.getWishlistid();
                WishListsModel wishListsModel = modelMapper.map(wishLists, WishListsModel.class);
                Users users = userRepository.findUserByWilistId(wishLists.getUserid().getUserid());
                wishListsModel.setUserModel(modelMapper.map(users, UserModel.class));
                wishListItemsModel.setWishListsModel(wishListsModel);
                wishListItemsModels.add(wishListItemsModel);
            }

            PlaceModel placeModel =  modelMapper.map(item, PlaceModel.class);
            placeModel.setRatingsCollection(ratingsModelList);
            placeModel.setCommentsCollection(commentsModelList);
            placeModel.setWishListItemsCollection(wishListItemsModels);
            placeModelList.add(placeModel);
        }
        return placeModelList;
    }

    public List<PlaceModel> getPlacesByStatusIsTrue(){
        ModelMapper modelMapper = new ModelMapper();
        List<Places> places = placeRepository.findByStatusIsTrue();
        List<PlaceModel> placeModelList = new ArrayList<>();
        for(Places item: places){
            Collection<Ratings> ratingsList = ratingRepository.getRatingsWithUserIdIsNull(item.getPlaceid());
            List<RatingsModel> ratingsModelList = new ArrayList<>();
            for(Ratings ratings: ratingsList) {
                Criterias criterias = ratings.getCriteriaid();
                RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
                CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
                ratingsModel.setCriteriasModel(criteriasModel);
                ratingsModelList.add(ratingsModel);
            }


            Collection<Comments> commentsList = commentRepository.getCommentByPlaceId(item.getPlaceid());
            List<CommentsModel> commentsModelList = new ArrayList<>();
            for(Comments comments: commentsList){
                Users users = comments.getUseridfr();
                CommentsModel commentsModel = modelMapper.map(comments, CommentsModel.class);
                UserModel userModel = modelMapper.map(users, UserModel.class);
                commentsModel.setUserModel(userModel);
                commentsModelList.add(commentsModel);
            }


            Collection<WishListItems> wishListItems = wishListItemsRepository.findWishlistItemByPlaceId(item.getPlaceid());
            List<WishListItemsModel> wishListItemsModels = new ArrayList<>();
            for(WishListItems listItems: wishListItems){
                WishListItemsModel wishListItemsModel = modelMapper.map(listItems, WishListItemsModel.class);
                wishListItemsModel.setWishlistitemid(listItems.getWishlistitemid());
                WishLists wishLists = listItems.getWishlistid();
                WishListsModel wishListsModel = modelMapper.map(wishLists, WishListsModel.class);
                Users users = userRepository.findUserByWilistId(wishLists.getUserid().getUserid());
                wishListsModel.setUserModel(modelMapper.map(users, UserModel.class));
                wishListItemsModel.setWishListsModel(wishListsModel);
                wishListItemsModels.add(wishListItemsModel);
            }

            PlaceModel placeModel =  modelMapper.map(item, PlaceModel.class);
            placeModel.setRatingsCollection(ratingsModelList);
            placeModel.setCommentsCollection(commentsModelList);
            placeModel.setWishListItemsCollection(wishListItemsModels);
            placeModelList.add(placeModel);
        }
        return placeModelList;
    }

    public List<PlaceModel> getPlacesByWishlistId(short id){
        ModelMapper modelMapper = new ModelMapper();
        List<Places> places = placeRepository.findPlaceByWishlistId(id);
        List<PlaceModel> placeModelList = new ArrayList<>();
        for(Places item: places){
            Collection<Ratings> ratingsList = ratingRepository.getRatingsWithUserIdIsNull(item.getPlaceid());
            List<RatingsModel> ratingsModelList = new ArrayList<>();
            for(Ratings ratings: ratingsList) {
                Criterias criterias = ratings.getCriteriaid();
                RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
                CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
                ratingsModel.setCriteriasModel(criteriasModel);
                ratingsModelList.add(ratingsModel);
            }


            Collection<Comments> commentsList = commentRepository.getCommentByPlaceId(item.getPlaceid());
            List<CommentsModel> commentsModelList = new ArrayList<>();
            for(Comments comments: commentsList){
                Users users = comments.getUseridfr();
                CommentsModel commentsModel = modelMapper.map(comments, CommentsModel.class);
                UserModel userModel = modelMapper.map(users, UserModel.class);
                commentsModel.setUserModel(userModel);
                commentsModelList.add(commentsModel);
            }


            Collection<WishListItems> wishListItems = wishListItemsRepository.findWishlistItemByPlaceId(item.getPlaceid());
            List<WishListItemsModel> wishListItemsModels = new ArrayList<>();
            for(WishListItems listItems: wishListItems){
                WishListItemsModel wishListItemsModel = modelMapper.map(listItems, WishListItemsModel.class);
                wishListItemsModel.setWishlistitemid(listItems.getWishlistitemid());
                WishLists wishLists = listItems.getWishlistid();
                WishListsModel wishListsModel = modelMapper.map(wishLists, WishListsModel.class);
                Users users = userRepository.findUserByWilistId(wishLists.getUserid().getUserid());
                wishListsModel.setUserModel(modelMapper.map(users, UserModel.class));
                wishListItemsModel.setWishListsModel(wishListsModel);
                wishListItemsModels.add(wishListItemsModel);
            }

            PlaceModel placeModel =  modelMapper.map(item, PlaceModel.class);
            placeModel.setRatingsCollection(ratingsModelList);
            placeModel.setCommentsCollection(commentsModelList);
            placeModel.setWishListItemsCollection(wishListItemsModels);
            placeModelList.add(placeModel);
        }
        return placeModelList;
    }

    public PlaceModel findPlaceById(Short id){// key
        ModelMapper modelMapper = new ModelMapper();
        Places places = placeRepository.findById(id).get();
        Collection<Ratings> ratingsList = ratingRepository.getRatingsWithUserIdIsNull(id);
        List<RatingsModel> ratingsModelList = new ArrayList<>();
        for(Ratings ratings: ratingsList) {
            Criterias criterias = ratings.getCriteriaid();
            RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
            CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
            ratingsModel.setCriteriasModel(criteriasModel);
            ratingsModelList.add(ratingsModel);
        }


        Collection<Comments> commentsList = commentRepository.getCommentByPlaceId(id);
        List<CommentsModel> commentsModelList = new ArrayList<>();
        for(Comments comments: commentsList){
            Users users = comments.getUseridfr();
            CommentsModel commentsModel = modelMapper.map(comments, CommentsModel.class);
            UserModel userModel = modelMapper.map(users, UserModel.class);
            commentsModel.setUserModel(userModel);
            commentsModelList.add(commentsModel);
        }
        PlaceModel placeModel =  modelMapper.map(places, PlaceModel.class);
        placeModel.setRatingsCollection(ratingsModelList);
        placeModel.setCommentsCollection(commentsModelList);//
        return placeModel;
    }



    public List<PlaceModel> findPlaceBySupplierId(short id){
        ModelMapper modelMapper = new ModelMapper();
        List<Places> places = placeRepository.findPlaceBySupplierId(id);
        List<PlaceModel> placeModelList = new ArrayList<>();
        for(Places item: places){

            Collection<Ratings> ratingsList = ratingRepository.getRatingsWithUserIdIsNull(item.getPlaceid());
            List<RatingsModel> ratingsModelList = new ArrayList<>();
            for(Ratings ratings: ratingsList) {
                Criterias criterias = ratings.getCriteriaid();
                RatingsModel ratingsModel = modelMapper.map(ratings, RatingsModel.class);
                CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
                ratingsModel.setCriteriasModel(criteriasModel);
                ratingsModelList.add(ratingsModel);
            }


            Collection<Comments> commentsList = commentRepository.getCommentByPlaceId(item.getPlaceid());
            List<CommentsModel> commentsModelList = new ArrayList<>();
            for(Comments comments: commentsList){
                Users users = comments.getUseridfr();
                CommentsModel commentsModel = modelMapper.map(comments, CommentsModel.class);
                UserModel userModel = modelMapper.map(users, UserModel.class);
                commentsModel.setUserModel(userModel);
                commentsModelList.add(commentsModel);
            }


            PlaceModel placeModel =  modelMapper.map(item, PlaceModel.class);
            placeModel.setRatingsCollection(ratingsModelList);
            placeModel.setCommentsCollection(commentsModelList);//
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
            ratings.setUseridfr(null);// user rating, not user's place - set null cause when add place is user not yet rating
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
            ratings.setUseridfr(null);// user rating, not user's place
            ratings.setCriteriaid(criterias);
            ratings =  ratingRepository.save(ratings);
        }
        //Adding a location does not need to add comments, ratings and wishlist
        // because this information must be added to its own table. When adding place,
        // only place information is added, not place's relational tables
        return "success";
}

    public  boolean deletePlace(short id){
        ratingRepository.deleteRatingsByPlaceId(id);
        commentRepository.deleteCommentByPlaceId(id);
        wishListItemsRepository.deleteWishlistItemByPlaceId(id);
        placeRepository.deletePlace(id);
        return true;
    }

    //fixedRate = 1000000
    @Scheduled(cron = "0 45 1 * * ?", zone = "Europe/London")
    public void scheduleFixedDelayTask() {
//        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);

        List<Places> places = placeRepository.findByStatusIsTrue();
        System.out.println("vào hàm");
        for(Places item: places){
            System.out.println("-----------------vào for; id là: " + item.getPlaceid());
            System.out.println(item.getStar().floatValue());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


                System.out.println("vào try catch");
            Date browserDate = null;
            try {
                browserDate = simpleDateFormat.parse(String.valueOf(item.getBrowserday()));
                System.out.println(browserDate);
                Date today = simpleDateFormat.parse(String.valueOf(LocalDate.now()));
                System.out.println(today);

                long startValue = browserDate.getTime();
                System.out.println(startValue);
                long endValue = today.getTime();
                System.out.println(endValue);

                long tmp = Math.abs(startValue-endValue);

                long result = tmp/(24*60*60*1000);
                System.out.println("result"+result);

                if(result >= 90){

                    Integer ratingNumber = Integer.valueOf(placeRepository.countRating((short) item.getPlaceid()));
                    Integer userRatingNumber = Integer.valueOf(placeRepository.countUserRating((short) item.getPlaceid()));
                    System.out.println("-----------" + ratingNumber);
                    System.out.println("------------" + userRatingNumber);

                    int check = 0;
                    if(ratingNumber >= 4){// nếu nhỏ hơn 4 sau khi tính calstar sẽ <0 sau đó không thể chia cho 0
                        float calStar = (ratingNumber / (8*userRatingNumber))*5;
                        if(calStar < 3){
                            deletePlace(item.getPlaceid());
                            check ++;
                            System.out.println("Đã xóa place có id" + item.getPlaceid());
                        }
                    }
                    if(check == 0){
                        if(item.getStar().floatValue() < 3){
                            deletePlace(item.getPlaceid());
                            System.out.println("Đã xóa place có id" + item.getPlaceid());
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
    }


    public static void main(String[] args) {
        PlaceService placeService = new PlaceService();
        placeService.scheduleFixedDelayTask();
//        placeService.testCount();
    }
}