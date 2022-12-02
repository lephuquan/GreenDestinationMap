package com.study.GreenPlace.controller;

import com.study.GreenPlace.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<?> getNotificationByUserId(@PathVariable(value = "id")short id){
        return ok(notificationService.finNotificationByUserId(id));
    }

    @GetMapping("/updateStatus/{id}")
    public ResponseEntity<?> updateStatusNotification(@PathVariable(value = "id")short id){
        return ok(notificationService.updateStatusWatched(id));
    }
}
