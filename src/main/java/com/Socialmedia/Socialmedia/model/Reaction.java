package com.Socialmedia.Socialmedia.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String likedDislikedBy;
    private Instant timestamp;
    private ReactionType reactionType;

    // Constructor, getters, and setters
    @ManyToOne
    private Post post;
    public enum ReactionType {
        LIKE,
        DISLIKE
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLikedDislikedBy() {
        return likedDislikedBy;
    }

    public void setLikedDislikedBy(String likedDislikedBy) {
        this.likedDislikedBy = likedDislikedBy;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public ReactionType getReactionType() {
        return reactionType;
    }

    public void setReactionType(ReactionType reactionType) {
        this.reactionType = reactionType;
    }

  
}
