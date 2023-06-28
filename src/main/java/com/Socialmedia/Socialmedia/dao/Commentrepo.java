package com.Socialmedia.Socialmedia.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.Socialmedia.Socialmedia.model.Comments;

public interface Commentrepo extends JpaRepository<Comments,Integer>{
    
}
