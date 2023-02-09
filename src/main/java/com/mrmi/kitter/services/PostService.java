package com.mrmi.kitter.services;

import com.mrmi.kitter.exceptions.PostException;
import com.mrmi.kitter.objects.Post;
import com.mrmi.kitter.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post uploadPost(Post post) {
        validatePost(post);
        postRepository.save(post);
        return post;
    }

    private void validatePost(Post post) {
        if (post.getMessage().isEmpty()) {
            throw new PostException("Post message cannot be empty");
        }
    }

    public Post getPost(int id) {
        return postRepository.findById(id).orElseThrow(() -> new PostException("Post with id " + id + " not found."));
    }

    public Iterable<Post> getPostList() {
        return postRepository.findAll();
    }

    public Post deletePost(int id) {
        Post post = getPost(id);
        postRepository.delete(post);
        return post;
    }
}
