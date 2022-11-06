package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.*;
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
    private Collection<Images> imagesCollection;
    private PlaceTypes placetypeid;
    private Users userid;
    private Collection<Comments> commentsCollection;
    private Collection<Ratings> ratingsCollection;
    private Collection<WishListItems> wishListItemsCollection;
}
