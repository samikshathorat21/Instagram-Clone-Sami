package com.samiksha.ig.repository;

import com.samiksha.ig.model.Comment;
import com.samiksha.ig.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> findByPost(Post post);
}
