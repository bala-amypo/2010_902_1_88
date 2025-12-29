package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Disable CSRF since this is a stateless REST API
            .csrf(csrf -> csrf.disable())

            // Disable default login page and HTTP Basic auth popup
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // Stateless session management: no session will be created or used by Spring Security
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            // Authorization rules
            .authorizeHttpRequests(auth -> auth
                // Allow unauthenticated access to auth endpoints
                .requestMatchers("/auth/**").permitAll()
                // Allow unauthenticated access to Swagger UI and API docs
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                // Require authentication for any other request
                .anyRequest().authenticated()
            );

        return http.build();
    }

    // Define the PasswordEncoder bean to be used in your services for password hashing
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
