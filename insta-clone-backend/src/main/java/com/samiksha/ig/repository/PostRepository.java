package com.samiksha.ig.repository;

import com.samiksha.ig.model.Post;
import com.samiksha.ig.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>
{
    List<Post> findByUserIn(List<User> users);
    List<Post> findByUser(User user);
}
