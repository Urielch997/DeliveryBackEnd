package com.deliveryApp.Delivery.oauth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.deliveryApp.Delivery.exception.BadRequestException;
import com.deliveryApp.Delivery.oauth.response.ApiResponse;
import com.deliveryApp.Delivery.oauth.response.AuthResponse;
import com.deliveryApp.Delivery.oauth.response.LoginRequest;
import com.deliveryApp.Delivery.oauth.response.SignUpRequest;
import com.deliveryApp.Delivery.security.TokenProvider;
import com.deliveryApp.Delivery.sociale.types.AuthProvider;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        user User = new user();
        User.setUserName(signUpRequest.getName());
        User.setEmail(signUpRequest.getEmail());
        User.setPassword(signUpRequest.getPassword());
        User.setProvider(AuthProvider.local);

        User.setPassword(passwordEncoder.encode(User.getPassword()));

        user result = userRepository.save(User);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getIdUser()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}
