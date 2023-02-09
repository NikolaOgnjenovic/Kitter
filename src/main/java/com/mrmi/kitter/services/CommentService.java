package com.mrmi.kitter.services;

import com.mrmi.kitter.exceptions.CommentException;
import com.mrmi.kitter.objects.Comment;
import com.mrmi.kitter.repositories.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostService postService;

    public CommentService(CommentRepository commentRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public Comment uploadComment(int postId, Comment comment) {
        validateComment(postId, comment);
        commentRepository.save(comment);
        return comment;
    }

    private void validateComment(int postId, Comment comment) {
        if (comment.getMessage().isEmpty()) {
            throw new CommentException("Comment message cannot be empty");
        }

        postService.getPost(postId); // Throws an exception if the post doesn't exist
        comment.setPostId(postId);
    }

    public Comment getComment(int id) {
        return commentRepository.findById(id).orElseThrow(() -> new CommentException("Comment with id " + id + " not found."));
    }

    public Iterable<Comment> getCommentList() {
        return commentRepository.findAll();
    }

    public Comment deleteComment(int id) {
        Comment comment = getComment(id);
        commentRepository.delete(comment);
        return comment;
    }
}
