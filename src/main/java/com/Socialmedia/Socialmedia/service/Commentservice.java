package com.Socialmedia.Socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Socialmedia.Socialmedia.dao.Commentrepo;
import com.Socialmedia.Socialmedia.model.Comments;


import java.util.*;

@Component
public class Commentservice {

    @Autowired
    public Commentrepo commentrepo;

    public List<Comments>getComments(){
        List<Comments>list=(List<Comments>)this.commentrepo.findAll();
        return list;
    }
}
