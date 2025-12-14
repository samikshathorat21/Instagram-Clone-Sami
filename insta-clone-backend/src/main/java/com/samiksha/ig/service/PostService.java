package com.samiksha.ig.service;

import com.samiksha.ig.dto.PostRequest;
import com.samiksha.ig.model.Post;
import com.samiksha.ig.model.User;
import com.samiksha.ig.repository.PostRepository;
import com.samiksha.ig.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository=postRepository;
        this.userRepository=userRepository;
    }

    public Post createPost(PostRequest request, User user){
        Post post=new Post();
        post.setUser(user);
        post.setCaption(request.getCaption());
        post.setImageUrl(request.getImageUrl());
        return postRepository.save(post);
    }

    public void likePost(Long postId, User user){
        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post not found"));
        post.getLikes().add(user);
        postRepository.save(post);
    }

    public void unlikePost(Long postId, User user){
        Post post=postRepository.findById(postId)
                .orElseThrow(()->new RuntimeException("Post not found"));
        post.getLikes().remove(user);
        postRepository.save(post);
    }

    public List<Post> getFeed(User user){
        List<User> following=user.getFollowing().stream().toList();
        return postRepository.findByUserIn(following)
                .stream().sorted((a,b)-> (int) b.getId())
                .collect(Collectors.toList());
    }

    public List<Post> getUserPosts(User user){
        return postRepository.findByUser(user);
    }
}
