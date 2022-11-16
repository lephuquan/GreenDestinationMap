package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.WishLists;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
public class WishListItemsModel {

    private Short wishlistitemid;
//    @JsonBackReference
//    private PlaceModel placeid;
//    @JsonBackReference
//    private WishListsModel wishlistid;
}
