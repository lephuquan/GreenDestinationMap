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
public interface CommentRepository  extends JpaRepository<Comments, Short> {


    @Query("SELECT c FROM Comments c WHERE c.placeid.placeid = :placeId")
    public List<Comments> getCommentByPlaceId(@Param("placeId")Short placeId);
}