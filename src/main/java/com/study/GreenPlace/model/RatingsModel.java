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
    private CriteriasModel criteriasModel;
    private PlaceModel placeModel; //nestd -> need to process manual before get out
    private UserModel userModel;  //nestd -> need to process manual before get out
}
