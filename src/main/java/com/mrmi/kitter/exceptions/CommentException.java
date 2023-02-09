package com.mrmi.kitter.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "Invalid parameters for a comment object"
)
public class CommentException extends RuntimeException{
    public CommentException(String message) {
        super(message);
    }
}
