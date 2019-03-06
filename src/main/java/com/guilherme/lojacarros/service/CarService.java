package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.Car;
import com.guilherme.lojacarros.repository.CarRepository;
import com.guilherme.lojacarros.service.exceptions.DataIntegrityViolationExceptionCustom;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import com.guilherme.lojacarros.service.util.URL;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        car.setId(null);
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

    public Page<Car> searchCars(int page, int elementsPerPage, String direction, String orderBy, String brand,
            String year, String vehicleType) {

        PageRequest pageRequest = PageRequest.of(page, elementsPerPage, Sort.Direction.valueOf(direction), orderBy);

        if (brand.isEmpty()) {
            brand = listBrands();
        }

        if (year.isEmpty()) {
            year = listYears();
        }

        if (vehicleType.isEmpty()) {
            vehicleType = listTypes();
        }

        List<String> years = URL.decodeList(year);
        List<String> brands = URL.decodeList(brand);
        List<String> vehicleTypes = URL.decodeList(vehicleType);

        return carRepository.SearchCars(brands, years, vehicleTypes, pageRequest);
    }

    public Car update(Car car) {
        if (!carRepository.findById(car.getId()).isPresent()) {
            throw new ObjectNotFoundExceptionCustom("Esse carro não pode ser atualizado porque o id não existe");
        }
        return carRepository.save(car);
    }

    public void deleteById(Long id) {
        try {
            carRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationExceptionCustom("Carro não pode ser deletado");
        }
    }

    public String listBrands() {
        String brands = "";
        List<String> FindBrand = carRepository.FindBrands();
        for (String s : FindBrand) {
            brands += "," + s;
        }
        return brands;
    }

    public String listYears() {
        String years = "";
        List<String> FindYear = carRepository.FindYears();
        for (String s : FindYear) {
            years += "," + s;
        }
        return years;
    }

    public String listTypes() {
        String types = "";
        List<String> FindVehicleType = carRepository.FindVehicleTypes();
        for (String s : FindVehicleType) {
            types += "," + s;
        }
        return types;
    }
}
