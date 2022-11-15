package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Criterias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriteriaRepository extends JpaRepository<Criterias, Short> {

    @Query("SELECT c FROM Criterias c WHERE c.placetypeid.placetypeid = :id")
    public List<Criterias>  getListCriteriaByPlaceTypeId(@Param("id")Short  id);// just get criterias by placeId


}