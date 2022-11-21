package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.model.CommentsModel;
import com.study.GreenPlace.repository.CommentRepository;
import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    public String addComment(CommentsModel commentsModel){
        ModelMapper modelMapper = new ModelMapper();
        Comments comments = modelMapper.map(commentsModel, Comments.class);
        comments.setPostdate(commentsModel.getPostdate());
        comments.setContent(commentsModel.getContent());
        comments.setPlaceid(placeRepository.findById(commentsModel.getPlaceModel().getPlaceid()).get());
        comments.setUseridfr(userRepository.findById(commentsModel.getUserModel().getUserid()).get());
        commentRepository.save(comments);
        return "sucess";
    }
}
