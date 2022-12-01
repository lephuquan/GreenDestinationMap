package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.entity.Notifications;
import com.study.GreenPlace.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications, Short> {
    @Query("SELECT n FROM Notifications n WHERE n.useridfr.userid = :id")
    public List<Notifications> findNotificationByUserId(@Param("id")short id);

    @Query(value = "UPDATE Notifications SET state = 1 WHERE notificationid = :id", nativeQuery = true)
    public void updateStatus(@Param("id")short id);
}
