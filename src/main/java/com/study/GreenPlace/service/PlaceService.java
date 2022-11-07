package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.repository.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;


    public List<Places> getAllPlace(){
        List<Places>  places = placeRepository.findAll();
        return new ModelMapper().map(places, new TypeToken<List<PlaceModel>>() {}.getType());
    }

    public PlaceModel findPlaceById(Short id){
        Places places = placeRepository.findById(id).get();
            return new ModelMapper().map(places, PlaceModel.class);
    }

    public PlaceModel findPlaceByName(String name){
        Places places = placeRepository.findByNamePlace(name);
        return new ModelMapper().map(places, PlaceModel.class);
    }

    public List<Places> findPlaceBySupplierId(short id){
        List<Places> places = placeRepository.findPlaceBySupplierId(id);
        return new ModelMapper().map(places, new TypeToken<List<PlaceModel>>()  {}.getType());
    }

//    public PlaceModel addPlace(PlaceModel placeModel){
//        ModelMapper modelMapper = new ModelMapper();
//        Places places = modelMapper.map(placeModel, Places.class);
//    }

    public  boolean deletePlace(short id){
        placeRepository.deleteById(id);
        return true;
    }

}
