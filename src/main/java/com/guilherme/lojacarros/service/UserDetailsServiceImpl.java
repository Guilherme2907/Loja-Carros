/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.repository.UserRepository;
import com.guilherme.lojacarros.security.UserDetailsApp;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        
        if (!user.isPresent()) {
            throw new ObjectNotFoundExceptionCustom("Usuário nao encontrado");
        }
        return new UserDetailsApp(user.get());
    }
}
