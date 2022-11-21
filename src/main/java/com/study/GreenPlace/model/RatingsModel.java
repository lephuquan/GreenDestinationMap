package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RatingsModel {


    private Short ratingid;
    private boolean criteriavalue;
//    @JsonManagedReference
    private CriteriasModel criteriasModel; // if open this -> addPlace fail. phải show criteria của place mà ko ảnh hướng đến addplace

    private PlaceModel placeModel; //nestd -> neet to process manual before get out

    private UserModel userModel;  //nestd -> neet to process manual before get out
}
