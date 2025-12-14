package com.samiksha.ig.service;

import com.samiksha.ig.model.User;
import com.samiksha.ig.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){this.userRepository=userRepository;}

    public void follow(User current, Long targetId){
        User target=userRepository.findById(targetId).orElseThrow(()->new RuntimeException("User not found"));
        current.getFollowing().add(target);
        target.getFollowers().add(current);
        userRepository.save(current);
        userRepository.save(target);
    }

    public void unfollow(User current, Long targetId){
        User target=userRepository.findById(targetId).orElseThrow(()->new RuntimeException("User not found"));
        current.getFollowing().remove(target);
        target.getFollowers().remove(current);
        userRepository.save(current);
        userRepository.save(target);
    }

    public User getProfile(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
    }
}
