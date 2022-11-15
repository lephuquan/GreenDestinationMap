package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
//    @JsonManagedReference
    private Collection<ImageModel> imagesCollection;// với quan hệ 1 nhiều như này thì tự viết hàm để lấy thông tin ra, không nên dùng mapping @json
//    @JsonBackReference
    private PlaceTypeModel placetypeid;
    private UserModel userid;
//    @JsonManagedReference
    private Collection<CommentsModel> commentsCollection;
//    @JsonManagedReference
    private Collection<RatingsModel> ratingsCollection;
//    @JsonManagedReference
    private Collection<WishListItemsModel> wishListItemsCollection;
}