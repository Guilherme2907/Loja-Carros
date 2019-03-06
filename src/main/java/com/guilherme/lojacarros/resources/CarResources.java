/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.resources;

import com.guilherme.lojacarros.domain.Car;
import com.guilherme.lojacarros.service.CarService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("cars")
public class CarResources {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Car car) {
        car = carService.save(car);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(car.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        Car car = carService.findById(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAll() {
        List<Car> cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Car>> findAllPage(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "elementsPerPage", defaultValue = "24") int elementsPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "brand") String orderBy) {

        Page<Car> cars = carService.findAllPage(page, elementsPerPage, direction, orderBy);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Car>> searchCars(@RequestParam(value = "year", defaultValue = "") String year,
            @RequestParam(value = "vehicleType", defaultValue = "") String vehicleType,
            @RequestParam(value = "brand", defaultValue = "") String brand,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "elementsPerPage", defaultValue = "24") int elementsPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "brand") String orderBy) {

        Page<Car> cars = carService.searchCars(page, elementsPerPage, direction, orderBy, brand, year, vehicleType);
        return ResponseEntity.ok(cars);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        carService.update(car);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
