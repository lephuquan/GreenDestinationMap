package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
public class PlaceModel {

    private Short placesId;
    private String placesName;
    private String lat;
    private String lon;
    private String country;
    private String district;
    private String ward;
    private String street;
    private String description;
    private Date startday;
    private long mapid;
    private boolean status;
    private String city;
    private Collection<Images> imagesCollection;
    private PlaceTypes placeTypesId;
    private Users usersId;
    private Collection<Comments> commentsCollection;
    private Collection<Ratings> ratingsCollection;
    private Collection<WishLists> wishListsCollection;
}
