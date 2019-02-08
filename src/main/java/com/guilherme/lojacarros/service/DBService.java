package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Address;
import com.guilherme.lojacarros.domain.Car;
import com.guilherme.lojacarros.domain.City;
import com.guilherme.lojacarros.domain.State;
import com.guilherme.lojacarros.domain.User;
import com.guilherme.lojacarros.repository.AddressRepository;
import com.guilherme.lojacarros.repository.CarRepository;
import com.guilherme.lojacarros.repository.CityRepository;
import com.guilherme.lojacarros.repository.StateRepository;
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

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void initializeTestDataBase() throws ParseException {
        State state1 = new State(null, "São Paulo");
        City city1 = new City(null, "São Paulo", state1);
        Address address1 = new Address(null, "Mirassol", "123", "ap 25", "Jd Mirasol", "12235-489", city1, null);

        User u1 = new User(null, "Guilherme", "guilherme@gmail.com", "456874689", address1);
        address1.setUser(u1);

        Car c1 = new Car(null, "Esportivo", "Audi", "Audi TT", "2016", 150000.00, u1);
        Car c2 = new Car(null, "Sedan", "Honda", "Honda Civic", "2015", 60000.00, u1);

        u1.getPhones().addAll(Arrays.asList("39894752"));

        stateRepository.save(state1);
        cityRepository.save(city1);
        addressRepository.save(address1);
        userRepository.save(u1);
        carRepository.saveAll(Arrays.asList(c1, c2));

    }
}
