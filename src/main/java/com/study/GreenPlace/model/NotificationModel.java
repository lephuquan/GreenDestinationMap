package com.study.GreenPlace.model;

import com.study.GreenPlace.entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class NotificationModel {
    private Short notificationid;
    private Date sentdate;
    private String topic;
    private String notificationcontent;
    private Users useridfr;
    private Users adminid;
}
