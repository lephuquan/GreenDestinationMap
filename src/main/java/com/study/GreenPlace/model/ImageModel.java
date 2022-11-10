package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.Places;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageModel {

    private Short imageid;
    private String imagename;
    private PlaceModel placeid;
}
