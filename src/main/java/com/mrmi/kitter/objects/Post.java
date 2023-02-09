package com.mrmi.kitter.objects;

import java.time.LocalDateTime;

public class Post {
    private String message;
    private LocalDateTime createdDateTime;

    private int id;

    private int likes;

    private int userId;

    public Post(String message) {
        this.message = message;
        this.createdDateTime = LocalDateTime.now();
        this.userId = 0; // testing
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void increaseLikes() {
        this.likes++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
