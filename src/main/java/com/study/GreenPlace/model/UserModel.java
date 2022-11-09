package com.study.GreenPlace.model;


import com.study.GreenPlace.entity.Roles;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Data
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
    private RolesModel roleid;
}
