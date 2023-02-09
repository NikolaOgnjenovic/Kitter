package com.mrmi.kitter.services;

import com.mrmi.kitter.exceptions.CommentException;
import com.mrmi.kitter.objects.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final PostService postService;
    private List<Comment> commentList; // TODO: store in database
    private static int id;

    public CommentService(PostService postService) {
        id = 0;
        commentList = new ArrayList<>();
        this.postService = postService;
    }

    public Comment uploadComment(int postId, Comment comment) {
        validateComment(postId, comment);
        commentList.add(comment);
        return comment;
    }

    private void validateComment(int postId, Comment comment) {
        if (comment.getMessage().isEmpty()) {
            throw new CommentException("Comment message cannot be empty");
        }

        postService.findPostById(postId);
        comment.setPostId(postId);
        comment.setId(id++);
    }

    private Comment findCommentById(int id) {
        for (Comment p : commentList) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new CommentException("Comment with id " + id + " not found.");
    }

    public Comment getComment(int id) {
        return findCommentById(id);
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public Comment deleteComment(int id) {
        Comment comment = findCommentById(id);
        commentList.remove(comment);
        return comment;
    }
}
