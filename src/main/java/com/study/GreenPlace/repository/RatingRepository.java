package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Short> {

    @Query("SELECT r FROM Ratings r WHERE r.placeid.placeid = :id")
    public List<Ratings> findRatingByPlaceId(@Param("id")Short id);
}