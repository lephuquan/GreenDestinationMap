package com.study.GreenPlace.model;


import lombok.Getter;
import lombok.Setter;
import com.study.GreenPlace.entity.Roles;
import java.util.Date;

@Getter
@Setter
public class UserModel {
    private Short userid;
    private boolean gender;
    private String email;
    private String address;
    private String avatar;
    private Date startdate;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String token;
    private String phonenumber;
    private Roles roleid;
}
