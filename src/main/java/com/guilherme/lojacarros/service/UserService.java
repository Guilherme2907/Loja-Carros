package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Address;
import com.guilherme.lojacarros.domain.City;
import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.domain.dto.UserDTO;
import com.guilherme.lojacarros.domain.dto.UserNewDTO;
import com.guilherme.lojacarros.repository.AddressRepository;
import com.guilherme.lojacarros.repository.UserRepository;
import com.guilherme.lojacarros.service.exceptions.DataIntegrityViolationExceptionCustom;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private AddressRepository addressRepository;
    
    @Autowired 
    private BCryptPasswordEncoder encoder;

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

    @Transactional
    public void update(UserNewDTO userDTO, Long id) {
        User user = toUser(userDTO);
        user.setId(id);
        user.getAddress().setId(id);
        userRepository.save(user);
        addressRepository.save(user.getAddress());
    }

    public void delete(Long id) {
        User user = findById(id);
        try {
            userRepository.delete(user);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationExceptionCustom("Usuário não pode ser deletado");
        }
    }

    public User toUser(UserNewDTO userDTO) {
        User user = new User(null, userDTO.getName(), userDTO.getEmail(), userDTO.getCpf(), null,encoder.encode(userDTO.getPassword()));
        City city = new City(userDTO.getCityId(), null, null);
        Address address = new Address(null, userDTO.getStreet(), userDTO.getNumber(), userDTO.getComplement(), userDTO.getNeighborhood(),
                userDTO.getCep(), city, user);
        user.setAddress(address);
        user.getPhones().addAll(Arrays.asList(userDTO.getTelephone1(), userDTO.getTelephone2()));
        return user;
    }
}
