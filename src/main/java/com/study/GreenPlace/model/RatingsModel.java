package com.study.GreenPlace.model;

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
    private CriteriasModel criteriaid;
    private PlaceModel placeid;
    private UserModel useridfr;
}
