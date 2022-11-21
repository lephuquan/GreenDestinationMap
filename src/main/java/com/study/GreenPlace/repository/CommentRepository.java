package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.entity.Places;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository  extends JpaRepository<Comments, Short> {

}