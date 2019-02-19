/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.resources;

import com.guilherme.lojacarros.dto.EmailDTO;
import com.guilherme.lojacarros.security.JWTUtil;
import com.guilherme.lojacarros.security.UserDetailsApp;
import com.guilherme.lojacarros.service.UserService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Guilherme
 */
@RestController
@RequestMapping("/auth")
public class AuthResources {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jWTUtil;

    @PostMapping("/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserDetailsApp user = userService.authenticated();
            String token = jWTUtil.generateToken(user.getUsername());
            response.addHeader("Authorization ", "Bearer " + token);
            response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/forgot")
    public ResponseEntity<Void> forgotPassword(@RequestBody EmailDTO emailDTO) {
        userService.sendNewPassword(emailDTO);
        return ResponseEntity.noContent().build();
    }
}
