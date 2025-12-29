package com.example.demo.security;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

public class JwtTokenProvider {

    private final SecretKey key;

    public JwtTokenProvider() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }
}
