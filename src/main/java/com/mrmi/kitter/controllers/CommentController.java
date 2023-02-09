package com.mrmi.kitter.controllers;

import com.mrmi.kitter.objects.Comment;
import com.mrmi.kitter.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(path = "/{postId}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment uploadComment(@PathVariable (name = "postId") int postId, Comment comment) {
        return commentService.uploadComment(postId, comment);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment(@PathVariable (name = "id") int id) {
        return commentService.getComment(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<Comment> getCommentList() {
        return commentService.getCommentList();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Comment deleteComment(@PathVariable (name = "id") int id) {
        return commentService.deleteComment(id);
    }
}
