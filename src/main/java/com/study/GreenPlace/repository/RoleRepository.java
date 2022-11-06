package com.study.GreenPlace.repository;

import com.study.GreenPlace.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Short> {
    @Query("SELECT t FROM Roles t WHERE t.role=:role")
    public Roles findByRole(@Param("role") String role);

}