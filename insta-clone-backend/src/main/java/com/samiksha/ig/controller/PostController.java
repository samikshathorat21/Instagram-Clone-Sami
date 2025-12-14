package com.samiksha.ig.controller;

import com.samiksha.ig.dto.PostRequest;
import com.samiksha.ig.model.Post;
import com.samiksha.ig.model.User;
import com.samiksha.ig.service.PostService;
import com.samiksha.ig.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService){
        this.postService=postService;
        this.userService=userService;
    }

    @PostMapping("/create")
    public Post createPost(@RequestBody PostRequest request, @RequestParam Long userId){
        User user=userService.getProfile(userId);
        return postService.createPost(request,user);
    }

    @PostMapping("/{postId}/like")
    public void likePost(@PathVariable Long postId, @RequestParam Long userId){
        User user=userService.getProfile(userId);
        postService.likePost(postId,user);
    }

    @PostMapping("/{postId}/unlike")
    public void unlikePost(@PathVariable Long postId, @RequestParam Long userId){
        User user=userService.getProfile(userId);
        postService.unlikePost(postId,user);
    }

    @GetMapping("/feed")
    public List<Post> getFeed(@RequestParam Long userId){
        User user=userService.getProfile(userId);
        return postService.getFeed(user);
    }

    @GetMapping("/user/{userId}")
    public List<Post> getUserPosts(@PathVariable Long userId){
        User user=userService.getProfile(userId);
        return postService.getUserPosts(user);
    }
}
