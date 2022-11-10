package com.study.GreenPlace.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class PlaceModel {

    private Short placeid;
    private Date startday;
    private long mapid;
    private boolean status;
    private String placename;
    private String lat;
    private String lon;
    private String country;
    private String city;
    private String district;
    private String ward;
    private String description;
    private BigDecimal star;
    private String road;
    private String phone;
    private Date browserday;
    private Collection<ImageModel> imagesCollection;
    private PlaceTypeModel placeTypeModel;
    private UserModel userModel;
    private Collection<CommentsModel> commentsModels;
    private Collection<RatingsModel> ratingsModelCollection;
    private Collection<WishListItemsModel> wishListItemsModels;
}
