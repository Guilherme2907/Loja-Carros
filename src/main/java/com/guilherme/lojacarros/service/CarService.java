package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Car;
import com.guilherme.lojacarros.repository.CarRepository;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(()
                -> new ObjectNotFoundExceptionCustom("Objeto não encontrado para o id: " + id));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
