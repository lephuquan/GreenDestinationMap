package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Criterias;
import com.study.GreenPlace.entity.Ratings;
import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.model.PlaceModel;
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

import java.util.ArrayList;
import java.util.Collection;
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

    public List<RatingsModel> findRatingByPlaceIdAndUserId(Short placeId, Short userId){
        List<Ratings> rating = ratingRepository.findRatingByPlaceIdAndUserId(placeId, userId);
        List<RatingsModel> ratingsModelList = new ArrayList<>();
        for(Ratings item: rating){
            Criterias criterias = item.getCriteriaid();
            ModelMapper modelMapper = new ModelMapper();
            CriteriasModel criteriasModel = modelMapper.map(criterias, CriteriasModel.class);
            RatingsModel ratingsModel = new ModelMapper().map(item, RatingsModel.class) ;
            ratingsModel.setCriteriasModel(criteriasModel);
            ratingsModelList.add(ratingsModel);
        }
        return ratingsModelList; // return a model
    }

    public String addRating(Collection<RatingsModel> ratingsModel){
        for(RatingsModel item: ratingsModel){
            ModelMapper modelMapper = new ModelMapper();
            Ratings ratings = modelMapper.map(item, Ratings.class);
            ratings.setCriteriavalue(item.isCriteriavalue());
            Criterias criterias = modelMapper.map(item.getCriteriasModel(), Criterias.class);
            ratings.setCriteriaid(criteriaRepository.findById(item.getCriteriasModel().getCriteriaid()).get());
            ratings.setPlaceid(placeRepository.findById(item.getPlaceModel().getPlaceid()).get());
            ratings.setUseridfr(userRepository.findById(item.getUserModel().getUserid()).get());
            ratingRepository.save(ratings);
        }
        return  "sucess";
    }

    public String updateRating(Collection<RatingsModel> ratingsModel){
        for(RatingsModel item: ratingsModel){
            ratingRepository.deleteRatingBeforeUpdate(item.getPlaceModel().getPlaceid(), item.getUserModel().getUserid());
            break;
        }
        for(RatingsModel item: ratingsModel){
            ModelMapper modelMapper = new ModelMapper();
            Ratings ratings = modelMapper.map(item, Ratings.class);
            ratings.setCriteriavalue(item.isCriteriavalue());
            Criterias criterias = modelMapper.map(item.getCriteriasModel(), Criterias.class);
            ratings.setCriteriaid(criteriaRepository.findById(item.getCriteriasModel().getCriteriaid()).get());
            ratings.setPlaceid(placeRepository.findById(item.getPlaceModel().getPlaceid()).get());
            ratings.setUseridfr(userRepository.findById(item.getUserModel().getUserid()).get());
            ratingRepository.save(ratings);
        }
        return  "sucess";
    }


}
