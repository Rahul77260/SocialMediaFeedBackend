package com.Socialmedia.Socialmedia.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
   
    private String comment_description;
     private Instant timestamp;;
   
    private String commentedBy;


   
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
   
    public String getComment_description() {
        return comment_description;
    }
    public void setComment_description(String comment_description) {
        this.comment_description = comment_description;
    }
   
    public String getCommentedBy() {
        return commentedBy;
    }
    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
    public Instant getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
    

}
