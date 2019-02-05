package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Car;
import com.guilherme.lojacarros.repository.CarRepository;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        if (car == null) {
            return null;
        }
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(()
                -> new ObjectNotFoundExceptionCustom("Objeto não encontrado para o id: " + id));
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Page<Car> findAllPage(int page, int elementsPerPage, String direction, String orderBy) {
        PageRequest pageRequest = PageRequest.of(page, elementsPerPage, Sort.Direction.valueOf(direction), orderBy);
        return carRepository.findAll(pageRequest);
    }
}
