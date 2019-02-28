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
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void initializeTestDataBase() throws ParseException {
        State state1 = new State(null, "São Paulo");
        State state2 = new State(null, "Mina Gerais");
        City city1 = new City(null, "São Paulo", state1);
        City city2 = new City(null, "Belo Horizonte", state2);
        City city3 = new City(null, "São José dos Campos", state1);
        Address address1 = new Address(null, "Mirassol", "123", "ap 25", "Jd Mirasol", "12235-489", city1, null);

        User u1 = new User(null, "Guilherme", "guilherme.magalhaes2907@gmail.com", "43670534822", address1, encoder.encode("123"));
        address1.setUser(u1);

        Car c1 = new Car(null, "Esportivo", "Audi", "Audi Ireland", "2016", 150000.00, null, "https://imagizer.imageshack.com/img923/5825/h7z2Xz.jpg");
        Car c2 = new Car(null, "Sedan", "Honda", "Honda Civic", "2015", 60000.00, null, "https://imagizer.imageshack.com/img921/3852/aHaB3X.jpg");
        Car c3 = new Car(null, "Sedan", "Audi", "Audi A4", "2016", 80000.00, null, "https://imagizer.imageshack.com/img923/7933/vHNawf.jpg");

        u1.getPhones().addAll(Arrays.asList("39894752"));

        stateRepository.saveAll(Arrays.asList(state1, state2));
        cityRepository.saveAll(Arrays.asList(city1, city2, city3));
        addressRepository.save(address1);
        userRepository.save(u1);
        carRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
