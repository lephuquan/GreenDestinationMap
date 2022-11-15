package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private PlaceTypeModel placeTypeModel; // đổi tên lại không trùng với entity để nó ko mapping -> không lồng json, sau đó vào service viết thủ công để lấy nhưng thuộc tính cần lấy ra(getplace cũng vậy)
    private Collection<RatingsModel> ratingsCollection;
}
