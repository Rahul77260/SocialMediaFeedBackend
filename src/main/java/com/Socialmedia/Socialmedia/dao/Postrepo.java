package com.Socialmedia.Socialmedia.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.Socialmedia.Socialmedia.model.Post;

public interface Postrepo  extends JpaRepository<Post,Integer>{
     public  Post findById(int id);
}
