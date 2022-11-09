package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Images;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.model.ImageModel;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.repository.PlaceTypeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceTypeRepository placeTypeRepository;


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

    public String addPlace(PlaceModel placeModel){
        ModelMapper modelMapper = new ModelMapper();
        Places places = modelMapper.map(placeModel, Places.class);
        places.setStartday(placeModel.getStartday());
        places.setMapid(placeModel.getMapid());
        places.setStatus(false);// sau khi được duyệt sẽ chuyển thành true
        places.setPlacename(placeModel.getPlacename());
        places.setLat(placeModel.getLat());
        places.setLon((placeModel.getLon()));
        places.setCountry(placeModel.getCountry());
        places.setCity(placeModel.getCity());
        places.setDistrict(placeModel.getDistrict());
        places.setWard(placeModel.getWard());
        places.setDescription(placeModel.getDescription());
        places.setStar(placeModel.getStar());
        places.setRoad(placeModel.getRoad());
        places.setPhone(placeModel.getPhone());
        places.setBrowserday(placeModel.getBrowserday());
        //manyToOne
        places.setPlacetypeid(placeModel.getPlacetypeid());
        places.setUserid(placeModel.getUserid());

        placeRepository.save(places);


//        //handle list image
//        Collection<ImageModel> imageModels = placeModel.getImagesCollection();
//        for (ImageModel item: imageModels){
//            Images images = modelMapper.map(item, Images.class);
////            item.setImagesName(imageModels.);
//        }
        return "success";
    }

    public  boolean deletePlace(short id){
        placeRepository.deleteById(id);
        return true;
    }

}
