package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody RegisterRequest request) {
        UserModel user = new UserModel();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return ResponseEntity.ok(userService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("Login handled via JWT (mock response)");
    }
}