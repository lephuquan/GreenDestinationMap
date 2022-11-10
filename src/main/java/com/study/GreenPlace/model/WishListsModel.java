package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.Users;
import com.study.GreenPlace.entity.WishListItems;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Getter
@Setter
public class WishListsModel {
    private Short wishlistid;
    private String wishlistname;
    private UserModel userModel;
    private Collection<WishListItemsModel> wishListItemsModels;
}
