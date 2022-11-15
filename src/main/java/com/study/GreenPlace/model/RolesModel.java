package com.study.GreenPlace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.study.GreenPlace.entity.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class RolesModel {
    private Short roleid;
    private short role;
    private String rolesname;
    @JsonManagedReference
    private Collection<UserModel> usersCollection;
}
