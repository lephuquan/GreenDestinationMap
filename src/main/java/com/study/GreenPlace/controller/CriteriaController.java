package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.service.CriteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addCriterias")
    public ResponseEntity<?> addCriterias(@RequestBody CriteriasModel criteriasModel){
        return ResponseEntity.ok(criteriaService.addCriterias(criteriasModel));
    }

    @PutMapping("/updateCriterias")
    public ResponseEntity<?> updateCriterias(@RequestBody CriteriasModel criteriasModel){
        return ResponseEntity.ok(criteriaService.updateCriterias(criteriasModel));
    }
}
