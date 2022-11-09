package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.PlaceTypes;
import com.study.GreenPlace.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceTypeRepository extends JpaRepository<PlaceTypes, Short> {

}