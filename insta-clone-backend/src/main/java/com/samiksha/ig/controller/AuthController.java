package com.samiksha.ig.controller;

import com.samiksha.ig.dto.*;
import com.samiksha.ig.model.User;
import com.samiksha.ig.service.AuthService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    private final AuthService authService;
    public AuthController(AuthService authService)
    {
        this.authService=authService;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody SignupRequest r)
    {
        return authService.signup(r);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest r)
    {
        return authService.login(r);
    }
}
