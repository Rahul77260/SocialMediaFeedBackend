package com.Socialmedia.Socialmedia.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import  com.Socialmedia.Socialmedia.model.Reaction;
public interface Reactionrepo extends JpaRepository<Reaction,Integer>{
    
}
