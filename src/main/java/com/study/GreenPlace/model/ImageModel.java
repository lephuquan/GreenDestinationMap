package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.Places;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class ImageModel {

    private Short imagesId;
    private String imagesName;
    private Places placesId;
}
