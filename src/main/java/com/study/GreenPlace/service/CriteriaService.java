package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Criterias;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.repository.CriteriaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    public List<Criterias> getAllCriterias(){
        List<Criterias>  criterias = criteriaRepository.findAll();
        return new ModelMapper().map(criterias, new TypeToken<List<CriteriasModel>>() {}.getType());
    }
}
