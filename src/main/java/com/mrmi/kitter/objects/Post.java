package com.mrmi.kitter.objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private int id;
    private String message;
    private LocalDateTime createdDateTime;
    private int likes;
    private int userId;

    public Post() {
        this.message = "";
        this.createdDateTime = LocalDateTime.now();
        this.userId = 0;
    }

    public void increaseLikes() {
        this.likes++;
    }
}
