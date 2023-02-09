package com.mrmi.kitter.objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String message;
    private LocalDateTime createdDateTime;

    private int likes;

    private int userId;
    private int postId;

    public Comment() {
        this.message = "";
        this.createdDateTime = LocalDateTime.now();
    }
}
