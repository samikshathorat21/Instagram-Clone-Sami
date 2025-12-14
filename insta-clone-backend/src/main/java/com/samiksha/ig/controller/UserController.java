package com.samiksha.ig.controller;

import com.samiksha.ig.dto.FollowRequest;
import com.samiksha.ig.model.User;
import com.samiksha.ig.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){this.userService=userService;}

    @PostMapping("/follow")
    public void follow(@RequestParam Long currentUserId, @RequestParam Long targetUserId){
        User current=userService.getProfile(currentUserId);
        userService.follow(current,targetUserId);
    }

    @PostMapping("/unfollow")
    public void unfollow(@RequestParam Long currentUserId, @RequestParam Long targetUserId){
        User current=userService.getProfile(currentUserId);
        userService.unfollow(current,targetUserId);
    }

    @GetMapping("/{userId}")
    public User getProfile(@PathVariable Long userId){
        return userService.getProfile(userId);
    }
}
