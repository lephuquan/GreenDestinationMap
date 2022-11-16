package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.entity.PlaceTypes;
import com.study.GreenPlace.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceTypeRepository extends JpaRepository<PlaceTypes, Short> {
    @Query("SELECT i FROM Images i WHERE i.placeid.placeid = :placeId")
    public List<Images> gePlaceTypeByCreteriaId(@Param("placeId") short id);
}