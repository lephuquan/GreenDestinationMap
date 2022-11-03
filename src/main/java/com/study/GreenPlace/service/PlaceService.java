package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.model.ImageModel;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.repository.PlaceRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public List<Places> getAllPlace(){
        List<Places>  places = placeRepository.findAll();
        return new ModelMapper().map(places, new TypeToken<List<PlaceModel>>() {}.getType());
    }
}
