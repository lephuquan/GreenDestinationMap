package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.Users;
import com.study.GreenPlace.entity.WishListItems;
import com.study.GreenPlace.entity.WishLists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishLists, Short> {


    @Query("SELECT w FROM WishLists w WHERE w.userid.userid = :id")
    public List<WishLists> findPlaceByUserId(@Param("id")short id);


}