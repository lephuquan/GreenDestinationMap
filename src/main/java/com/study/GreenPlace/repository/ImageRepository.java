package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Images, Short> {

    @Query("SELECT i FROM Images i WHERE i.placeid.placeid = :placeId")
    public List<Images> getImageByPlaceId(@Param("placeId") short id);

    @Modifying // allow delete
    @Transactional // allow delete
    @Query("DELETE FROM Images i WHERE i.placeid.placeid = :placeId")
    public void deleteImagesByPlaceId(@Param("placeId") short id);
}
