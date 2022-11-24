package com.study.GreenPlace.service;

import com.study.GreenPlace.entity.Comments;
import com.study.GreenPlace.entity.Places;
import com.study.GreenPlace.entity.Users;
import com.study.GreenPlace.model.CommentsModel;
import com.study.GreenPlace.model.ImageModel;
import com.study.GreenPlace.model.PlaceModel;
import com.study.GreenPlace.model.UserModel;
import com.study.GreenPlace.repository.CommentRepository;
import com.study.GreenPlace.repository.PlaceRepository;
import com.study.GreenPlace.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public String updateComment(CommentsModel commentsModel){
        Comments comments = commentRepository.getReferenceById(commentsModel.getCommentid());
        comments.setContent(commentsModel.getContent());
        comments.setPlaceid(placeRepository.findById(commentsModel.getPlaceModel().getPlaceid()).get());
        comments.setUseridfr(userRepository.findById(commentsModel.getUserModel().getUserid()).get());
        commentRepository.save(comments);
        return "sucess";
    }

    public List<CommentsModel> getCommentByPlaceId(short placeId){
        ModelMapper modelMapper = new ModelMapper();
        List<CommentsModel> commentsModelList = new ArrayList<>();
        List<Comments> commentsList = commentRepository.getCommentByPlaceId(placeId);
        for(Comments item: commentsList){
            UserModel userModel = modelMapper.map(userRepository.findById(item.getUseridfr().getUserid()).get(), UserModel.class);
            CommentsModel commentsModel = modelMapper.map(item, CommentsModel.class);
            commentsModel.setUserModel(userModel);
            commentsModelList.add(commentsModel);
        }
        return commentsModelList;
    }



    public  boolean deleteComment(short id){
        commentRepository.deleteCommentById(id);
        return true;
    }
}
