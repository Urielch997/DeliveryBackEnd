package com.deliveryApp.Delivery.oauth.controller;

import com.deliveryApp.Delivery.exception.ResourceNotFoundException;
import com.deliveryApp.Delivery.security.CurrentUser;
import com.deliveryApp.Delivery.security.UserPrincipal;
import com.deliveryApp.Delivery.user.model.user;
import com.deliveryApp.Delivery.user.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsuarioRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public user getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
