package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.model.ImageModel;
import com.study.GreenPlace.repository.ImageRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Images> getAllImage(){
        List<Images> Images = imageRepository.findAll();
        return new ModelMapper().map(Images, new TypeToken<List<ImageModel>>() {}.getType());
    }

    public List<Images> finImageByPlaceId(short placeId){// remember check placeId exist before sent request
        List<Images> Images = imageRepository.getImageByPlaceId(placeId);
        return new ModelMapper().map(Images, new TypeToken<List<ImageModel>>() {}.getType());
    }
}
