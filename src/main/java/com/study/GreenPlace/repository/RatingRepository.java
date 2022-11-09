package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Ratings, Short> {


}