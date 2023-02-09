package com.mrmi.kitter.services;

import com.mrmi.kitter.exceptions.PostException;
import com.mrmi.kitter.objects.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> postList; // TODO: store in database
    private static int id;

    public PostService() {
        id = 0;
        postList = new ArrayList<>();
    }

    public Post uploadPost(Post post) {
        validatePost(post);
        postList.add(post);
        return post;
    }

    private void validatePost(Post post) {
        if (post.getMessage().isEmpty()) {
            throw new PostException("Post message cannot be empty");
        }

        post.setId(id++);
    }

    public Post findPostById(int id) {
        for (Post p : postList) {
            if (p.getId() == id) {
                return p;
            }
        }

        throw new PostException("Post with id " + id + " not found.");
    }

    public Post getPost(int id) {
        return findPostById(id);
    }

    public List<Post> getPostList() {
        return this.postList;
    }

    public Post deletePost(int id) {
        Post post = findPostById(id);
        postList.remove(post);
        return post;
    }
}
