package com.samiksha.ig.service;

import com.samiksha.ig.dto.*;
import com.samiksha.ig.model.User;
import com.samiksha.ig.repository.UserRepository;
import com.samiksha.ig.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, JwtUtil jwtUtil)
    {
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    public User signup(SignupRequest r){
        User u=new User();
        u.setUsername(r.getUsername()); u.setEmail(r.getEmail());
        u.setPassword(passwordEncoder.encode(r.getPassword()));

        return userRepository.save(u);
    }

    public String login(LoginRequest r){
        User u=userRepository.findByEmail(r.getEmail()).orElseThrow(()->new RuntimeException("User not found"));
        if(!passwordEncoder.matches(r.getPassword(),u.getPassword())) throw new RuntimeException("Invalid password");

        return jwtUtil.generateToken(u.getEmail());
    }
}
