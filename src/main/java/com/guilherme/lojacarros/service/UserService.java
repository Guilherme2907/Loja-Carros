/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Address;
import com.guilherme.lojacarros.domain.City;
import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.domain.dto.UserDTO;
import com.guilherme.lojacarros.domain.dto.UserNewDTO;
import com.guilherme.lojacarros.repository.AddressRepository;
import com.guilherme.lojacarros.repository.CityRepository;
import com.guilherme.lojacarros.repository.UserRepository;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
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

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public User save(UserNewDTO userDTO) {
        User user = toUser(userDTO);
        user = userRepository.save(user);
        addressRepository.save(user.getAddress());
        return user;
    }

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

    public void save(UserDTO userDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User toUser(UserNewDTO userDTO) {
        User user = new User(null, userDTO.getName(), userDTO.getEmail(), userDTO.getCpf(), null);
        City city = new City(userDTO.getCityId(), null, null);
        Address address = new Address(null, userDTO.getStreet(), userDTO.getNumber(), userDTO.getComplement(), userDTO.getNeighborhood(),
                userDTO.getCep(), city, user);
        user.setAddress(address);
        user.getPhones().addAll(Arrays.asList(userDTO.getTelephone1(), userDTO.getTelephone2()));
        return user;
    }
}
