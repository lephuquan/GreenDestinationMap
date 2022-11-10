package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Images, Short> {

    @Query("SELECT i FROM Images i WHERE i.placeid.placeid = :placeId")
    public List<Images> getImageByPlaceId(@Param("placeId") short id);
}
