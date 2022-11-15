package com.study.GreenPlace.controller;

import com.study.GreenPlace.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/criterias")
public class CriteriaController {


    @Autowired
    private CriteriaService criteriaService;

    @GetMapping("/getAllCriterias")
    public ResponseEntity<?> getAllCriterias(){
        return ok(criteriaService.getAllCriterias());
    }

    @GetMapping("/getCriteriasByPlaceTypeId/{id}")
    public ResponseEntity<?> getAllCriterias(@PathVariable(name = "id") short id){
        return ok(criteriaService.getCriteriasByPlaceId(id));
    }
}
