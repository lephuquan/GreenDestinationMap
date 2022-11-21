package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CommentsModel {

    private Short commentid;
    private Date postdate;
    private String content;
//    @JsonBackReference
    private PlaceModel placeModel;
    private UserModel userModel;
}