package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.Ratings;
import com.study.GreenPlace.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepository  extends JpaRepository<Comments, Short> {


    @Query("SELECT c FROM Comments c WHERE c.placeid.placeid = :placeId")
    public List<Comments> getCommentByPlaceId(@Param("placeId")Short placeId);

    @Modifying // allow delete
    @Transactional // allow delete
    @Query("DELETE FROM Comments c WHERE c.commentid = :id")
    public void deleteCommentById(@Param("id")short id);

    @Query("DELETE FROM Comments c WHERE c.placeid.placeid = :id")
    public void deleteCommentByPlaceId(@Param("id")short id);


    @Query("SELECT c FROM Comments c WHERE c.commentid = :id")
    public Comments finByCommentId(@Param("id")short id);
}