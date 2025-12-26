package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User registerUser(String name, String email, String password);
    boolean existsByEmail(String email);
}
