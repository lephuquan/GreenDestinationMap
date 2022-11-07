package com.study.GreenPlace.model;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserModel {
    private Short usersId;
    private String firstname;
    private String lastname;
    private boolean gender;
    private String email;
    private String phonenumber;
    private String address;
    private byte[] avatar;
    private Date startdate;
    private String username;
    private String password;
}
