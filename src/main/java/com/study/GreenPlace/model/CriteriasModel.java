package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.PlaceTypes;
import com.study.GreenPlace.entity.Ratings;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
public class CriteriasModel {
    private Short criteriaid;
    private String image;
    private String criterianame;
    private PlaceTypeModel placetypeid;
    private Collection<RatingsModel> ratingsCollection;
}
