package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageModel {


    private Short imageid;
    private String imagename;
    private String imagekey;
//    @JsonBackReference
//    private PlaceModel placeid;
}
