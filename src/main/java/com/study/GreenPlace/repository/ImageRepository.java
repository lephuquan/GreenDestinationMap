package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Images, Short> {
}
