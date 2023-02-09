package com.mrmi.kitter.repositories;

import com.mrmi.kitter.objects.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    Optional<Comment> findById(int id);
}
