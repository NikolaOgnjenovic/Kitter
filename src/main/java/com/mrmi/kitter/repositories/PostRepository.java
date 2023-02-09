package com.mrmi.kitter.repositories;

import com.mrmi.kitter.objects.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    Optional<Post> findById(int id);
}