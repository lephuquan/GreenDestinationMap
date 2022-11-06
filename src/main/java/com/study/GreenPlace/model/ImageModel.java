package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.Places;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageModel {

    private Short imagesId;
    private String imagesName;
    private Places placesId;
}
