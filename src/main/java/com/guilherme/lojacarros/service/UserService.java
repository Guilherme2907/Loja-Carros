/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.domain.dto.UserDTO;
import com.guilherme.lojacarros.repository.UserRepository;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExceptionCustom("Usuário não encontrado para o id: " + id));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundExceptionCustom("Usuário não encontrado para o email: " + email));
    }

    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDTO(user)).collect(Collectors.toList());
    }
}
