package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images, Short> {
}
