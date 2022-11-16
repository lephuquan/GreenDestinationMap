package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Criterias;
import com.study.GreenPlace.entity.PlaceTypes;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.model.PlaceTypeModel;
import com.study.GreenPlace.repository.CriteriaRepository;
import com.study.GreenPlace.repository.PlaceTypeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriteriaService {

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private PlaceTypeRepository placeTypeRepository;

    public List<Criterias> getAllCriterias(){
        List<Criterias>  criterias = criteriaRepository.findAll();
        return new ModelMapper().map(criterias, new TypeToken<List<CriteriasModel>>() {}.getType());
    }

    public List<CriteriasModel> getCriteriasByPlaceId(short id){// new
        ModelMapper modelMapper = new ModelMapper();// create a modelMapper to convert entity
        List<Criterias> criterias = criteriaRepository.getListCriteriaByPlaceTypeId(id);// get criterias by placeType
        List<CriteriasModel> criteriasModelList = modelMapper.map(criterias, new TypeToken<List<CriteriasModel>>() {}.getType());// convert entity list to model list
        for(CriteriasModel criteriasModel: criteriasModelList) {// assign each criterias from criteriaModelList
            PlaceTypes placeTypes = placeTypeRepository.findById(id).get();// get object placeType by placeId
            criteriasModel.setPlaceTypeModel(modelMapper.map(placeTypes, PlaceTypeModel.class));// set object placeType in placeTypeModel to placeTypeModel
        }
        return criteriasModelList;// return a criterias with each criteria has a placeType object
    }
}
