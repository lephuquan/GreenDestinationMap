package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Short> {

    @Query("SELECT r FROM Ratings r WHERE r.placeid.placeid = :placeId and r.useridfr.userid =:userId")
    public List<Ratings> findRatingByPlaceIdAndUserId(@Param("placeId")Short placeId,@Param("userId") Short userId );

    @Modifying // allow delete
    @Transactional // allow delete
    @Query("DELETE FROM Ratings r WHERE r.placeid.placeid = :placeId")
    public void deleteRatingsByPlaceId(@Param("placeId") short id);


    @Modifying // allow delete
    @Transactional // allow delete
    @Query("DELETE FROM Ratings r WHERE r.placeid.placeid = :placeId and r.useridfr.userid =:userId")
    public void deleteRatingBeforeUpdate(@Param("placeId")Short placeId,@Param("userId") Short userId );
}