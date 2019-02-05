/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Car;
import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.repository.CarRepository;
import com.guilherme.lojacarros.repository.UserRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */

@Service
public class DBService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    public void initializeTestDataBase() throws ParseException {

        User u1 = new User("Guilherme", "guilherme@gmail.com", "456874689");
        Car c1 = new Car(null, "Esportivo", "Audi", "Audi TT", "2016", 150000.00, u1);
        Car c2 = new Car(null, "Sedan", "Honda", "Honda Civic", "2015", 60000.00, u1);

        userRepository.save(u1);
        carRepository.saveAll(Arrays.asList(c1, c2));
    }
}
