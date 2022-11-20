package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Ratings;
import com.study.GreenPlace.model.RatingsModel;
import com.study.GreenPlace.repository.RatingRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Ratings> findRatingByPlaceId(Short id){
        List<Ratings> ratings = ratingRepository.findRatingByPlaceId(id);
        return new ModelMapper().map(ratings, new TypeToken<List<RatingsModel>>() {}.getType());
    }
}
