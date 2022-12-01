package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Notifications;
import com.study.GreenPlace.entity.Users;
import com.study.GreenPlace.model.NotificationModel;
import com.study.GreenPlace.model.UserModel;
import com.study.GreenPlace.repository.NotificationRepository;
import com.study.GreenPlace.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<NotificationModel> finNotificationByUserId(short id){
        List<Notifications> notificationsList = notificationRepository.findNotificationByUserId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<NotificationModel> notificationModelList = new ArrayList<>();
        for(Notifications item: notificationsList){
            NotificationModel notificationModel = modelMapper.map(item, NotificationModel.class);
            notificationModelList.add(notificationModel);
        }
        return  notificationModelList;
    }

    public String updateStatusWatched(short id){
        Notifications notifications = notificationRepository.getReferenceById(id);
        if (notifications.getState() == false){
            try {
                notificationRepository.updateStatus(id);
            }catch (Exception e){
                return "updated";
            }
        }
        return "updated";
    }
}
