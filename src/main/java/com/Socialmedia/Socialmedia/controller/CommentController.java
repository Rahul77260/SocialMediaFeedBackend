
package com.Socialmedia.Socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Socialmedia.Socialmedia.model.Comments;
import com.Socialmedia.Socialmedia.model.Post;
import com.Socialmedia.Socialmedia.dao.Commentrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.Socialmedia.Socialmedia.service.Commentservice;
import jakarta.persistence.EntityManager;


import java.time.Instant;
import java.util.*;

@RestController
public class CommentController{

   @Autowired
   private Commentrepo commentrepo;
   @Autowired
   private Commentservice commentservice;
    @Autowired
    private EntityManager entityManager;

    @GetMapping("/comm")
    public String comm(){
         Instant timestamp = Instant.now();
        Comments comments=new Comments();
        comments.setComment_description("visit new Delhi");
        comments.setCommentedBy("Rahul");
        comments.setTimestamp(timestamp);
        Post post = entityManager.find(Post.class, 1);
        comments.setPost(post);
        commentrepo.save(comments);
        return "Inside the comments sections";

    }
    @GetMapping("/comments")
    public ResponseEntity<List<Comments>>getComments(){
    List<Comments>list=commentservice.getComments();
      if(list.size()<=0){
        System.out.println("Hello");
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
      }
     return ResponseEntity.of(Optional.of(list));
    }

}