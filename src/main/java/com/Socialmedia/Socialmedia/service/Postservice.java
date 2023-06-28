package com.Socialmedia.Socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.Socialmedia.Socialmedia.dao.Postrepo;
import com.Socialmedia.Socialmedia.model.Post;
import java.util.*;


@Component
public class Postservice {



   @Autowired
  private Postrepo postrepo;


  public List<Post>getPosts(){
     List<Post>list=(List<Post>)this.postrepo.findAll();
        return list;

  }
   public Post getPostById(int id) {
        Post post=null;
        try{
          post=this.postrepo.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return post;
    }
               
    public Post addPost(Post post) {
    Post post_new= postrepo.save(post);
        return post_new;
    }
     public void deletePost(int id) {
        // list = list.stream().filter(user -> user.getId() != id).collect(Collectors.toList());
        postrepo.deleteById(id);
    }
   public void updatePost(Post post,int id){
    //  list= list.stream().map(r->{
    //    if(r.getId()==id){
    //     r.setName(user.getName());
    //     r.setCourse(user.getCourse());

    //    }
    //     return r;
    //   }).collect(Collectors.toList());
   post.setId(id);
    postrepo.save(post);
    }
    
}
