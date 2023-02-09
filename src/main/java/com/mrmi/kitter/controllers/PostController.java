package com.mrmi.kitter.controllers;

import com.mrmi.kitter.objects.Post;
import com.mrmi.kitter.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post uploadPost(Post post) {
        return postService.uploadPost(post);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable (name = "id") int id) {
        return postService.getPost(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Iterable<Post> getPostList() {
        return postService.getPostList();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Post deletePost(@PathVariable (name = "id") int id) {
        return postService.deletePost(id);
    }
}
