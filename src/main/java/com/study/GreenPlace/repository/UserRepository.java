package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Short> {
    @Query("SELECT t FROM Users t WHERE t.username=:username")
    Users findByUsername(@Param("username") String username);
}