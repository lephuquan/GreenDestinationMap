package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.CommentsModel;
import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody CommentsModel commentsModel){
        return ResponseEntity.ok(commentService.addComment(commentsModel));
    }
}
