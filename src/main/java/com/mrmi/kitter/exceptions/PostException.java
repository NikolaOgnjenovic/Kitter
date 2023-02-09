package com.mrmi.kitter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Invalid parameters for a post object"
)
public class PostException extends RuntimeException{
    public PostException(String message) {
        super(message);
    }
}
