package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Criterias;
import com.study.GreenPlace.entity.Ratings;
import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.model.RatingsModel;
import com.study.GreenPlace.repository.CriteriaRepository;
import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.repository.RatingRepository;
import com.study.GreenPlace.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private CriteriaRepository criteriaRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    public RatingsModel findRatingByPlaceIdAndUserId(Short placeId, Short userId){
        Ratings rating = ratingRepository.findRatingByPlaceIdAndUserId(placeId, userId);
        Criterias criterias = rating.getCriteriaid();
        ModelMapper modelMapper = new ModelMapper();
        CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
        RatingsModel ratingsModel = new ModelMapper().map(rating, RatingsModel.class) ;
        ratingsModel.setCriteriasModel(criteriasModel);
        return ratingsModel;
    }

    public String addRating(RatingsModel ratingsModel){// be ok
        ModelMapper modelMapper = new ModelMapper();
        Ratings ratings = modelMapper.map(ratingsModel, Ratings.class);
        ratings.setCriteriavalue(ratingsModel.isCriteriavalue());
//        ratings.setCriteriaid(criteriaRepository.getCriteriasById(ratingsModel.getCriteriasModel().getCriteriaid()));
        Criterias criterias = modelMapper.map(ratingsModel.getCriteriasModel(), Criterias.class);
        ratings.setCriteriaid(criteriaRepository.findById(ratingsModel.getCriteriasModel().getCriteriaid()).get());
        ratings.setPlaceid(placeRepository.findById(ratingsModel.getPlaceModel().getPlaceid()).get());
        ratings.setUseridfr(userRepository.findById(ratingsModel.getUserModel().getUserid()).get());
        ratingRepository.save(ratings);
        return  "sucess";
    }


}
