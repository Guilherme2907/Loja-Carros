/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.resources;

import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.domain.dto.UserDTO;
import com.guilherme.lojacarros.domain.dto.UserNewDTO;
import com.guilherme.lojacarros.service.UserService;
import com.guilherme.lojacarros.service.validators.UserValidator;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author Guilherme
 */
@RestController
@RequestMapping("users")
public class UserResources {

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserValidator userValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(userValidator);
    }
    
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid UserNewDTO userDTO){
        User user = userService.save(userDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/email")
    public ResponseEntity<User> findByEmail(@RequestParam(value = "value") String email) {
        User user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> usersDTO = userService.findAll();
        return ResponseEntity.ok(usersDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody @Valid UserNewDTO userDTO){
        userService.update(userDTO, id);
        return ResponseEntity.noContent().build();
    }
}
