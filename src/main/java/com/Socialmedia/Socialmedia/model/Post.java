package com.Socialmedia.Socialmedia.model;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.time.Instant;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String userName;
    private String description;
     private Instant timestamp;

      
     @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="post")
    private List<Comments> comment=new ArrayList<>();
    // @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="post")
    // private List<Reaction> reaction=new ArrayList<>();
public int getId() {
    return id;
}
// public List<Comments> getComment() {
//     return comment;
// }
// public void setComment(List<Comments> comment) {
//     this.comment = comment;
// }
    


public Instant getTimestamp() {
    return timestamp;
}

@Override
public String toString() {
    return "Post [id=" + id + ", userName=" + userName + ", description=" + description + ", timestamp=" + timestamp
            + "]";
}



public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
}

public Post() {
}
public void setId(int id) {
    this.id = id;
}
public String getUserName() {
    return userName;
}
public void setUserName(String userName) {
    this.userName = userName;
}
public String getDescription() {
    return description;
}
public void setDescription(String description) {
    this.description = description;
}

    
    
   

}
