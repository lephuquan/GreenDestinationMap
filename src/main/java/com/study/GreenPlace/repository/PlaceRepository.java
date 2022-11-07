package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Places, Short> {

    @Query("SELECT p FROM Places p WHERE p.placename LIKE :name")
    public Places findByNamePlace(@Param("name")String  name);

    @Query("SELECT p FROM Places p WHERE p.userid.userid = :id")
    public List<Places> findPlaceBySupplierId(@Param("id")short id);
}
