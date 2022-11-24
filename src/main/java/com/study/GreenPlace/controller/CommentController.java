package com.study.GreenPlace.controller;

import com.study.GreenPlace.model.CommentsModel;
import com.study.GreenPlace.model.CriteriasModel;
import com.study.GreenPlace.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody CommentsModel commentsModel){
        return ResponseEntity.ok(commentService.addComment(commentsModel));
    }

    @PutMapping("/updateComment")
    public ResponseEntity<?> updateComment(@RequestBody CommentsModel commentsModel){
        return ResponseEntity.ok(commentService.updateComment(commentsModel));
    }

    @GetMapping("/getCommentByPlaceId/{id}")
    public ResponseEntity<?> findPlaceBySupplierId(@PathVariable(name = "id") short placeId) {
        return ok(commentService.getCommentByPlaceId(placeId));
    }


    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePlace(@PathVariable(value = "id") short id) {
        return ok(commentService.deleteComment(id));
    }
}
