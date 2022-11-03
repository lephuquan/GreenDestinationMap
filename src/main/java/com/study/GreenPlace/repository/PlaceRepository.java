package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Places, Short> {


}
