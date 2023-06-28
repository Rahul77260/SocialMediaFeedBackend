package com.Socialmedia.Socialmedia.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Socialmedia.Socialmedia.dao.Postrepo;
import com.Socialmedia.Socialmedia.dao.Commentrepo;
import com.Socialmedia.Socialmedia.dao.Reactionrepo;
import com.Socialmedia.Socialmedia.service.Postservice;
import com.Socialmedia.Socialmedia.model.Post;
import com.Socialmedia.Socialmedia.model.Comments;
import com.Socialmedia.Socialmedia.model.Reaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;

@Controller
public class PostController {
  
@Autowired
  private Postrepo postrepo;
    @Autowired
  private Commentrepo commentrepo;
  @Autowired
  private Reactionrepo reactionrepo;
  @Autowired
  private Postservice postservice;


    @GetMapping("/home")
    @ResponseBody
    public String home(){
       Instant timestamp = Instant.now();
        Post post=new Post();
        post.setUserName("Rahul");
        post.setDescription("I am playing");
        post.setTimestamp(timestamp);
        postrepo.save(post);
          Post post1=new Post();
          post1.setUserName("Suraj");
        post1.setDescription("Doing programming");
        post1.setTimestamp(timestamp);
        postrepo.save(post1);
        Comments comment=new Comments();
        comment.setComment_description("ok i am good");
        comment.setCommentedBy("Tenzin");
        comment.setTimestamp(timestamp);
        commentrepo.save(comment);
        Reaction reaction=new Reaction();
        reaction.setLikedDislikedBy("Suraj");
       reaction.setReactionType(Reaction.ReactionType.DISLIKE);
      // Get the current UTC timestamp
reaction.setTimestamp(timestamp);
reactionrepo.save(reaction);


        return "Welcome to thr Spring boot";
    }
     
   
    @GetMapping("/posts")
    public ResponseEntity<List<Post>>getPosts(){
        List<Post>list=postservice.getPosts();
        if(list.size()<=0){
          System.out.println("Hello");
          return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
     @GetMapping("/post/{id}")
      public ResponseEntity<Post> getPostById(@PathVariable("id") int id){
        Post post=postservice.getPostById(id);
        if(post==null)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(post));
      }
      @PostMapping("/post")
      public ResponseEntity<Post>addPost(@RequestBody Post post){
        Post post_new=null;
        try{
          post_new=this.postservice.addPost(post);
          return ResponseEntity.of(Optional.of(post_new));
        }
        catch(Exception e){
          e.printStackTrace();
return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
      }


      @DeleteMapping("/post/{id}")
      public ResponseEntity<Void>deletePost(@PathVariable("id") int id){
       try{
           postservice.deletePost(id);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch(Exception e){
           e.printStackTrace();
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
      }

       @PutMapping("/post/{id}")
       public ResponseEntity<Post>updatePost(@RequestBody Post post,@PathVariable("id") int id){
             try{
              this.postservice.updatePost(post,id);
        return ResponseEntity.ok().body(post);
             } 
             catch(Exception e){
              e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
             }    
       }
      
    
}
