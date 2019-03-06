/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.repository;

import com.guilherme.lojacarros.domain.Car;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Guilherme
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT c FROM Car c WHERE c.brand IN :brands AND c.year IN :years AND c.vehicleType IN :vehicleTypes")
    Page<Car> SearchCars(@Param("brands") List<String> brands, @Param("years") List<String> years,
            @Param("vehicleTypes") List<String> vehicleTypes, Pageable pageable);

    @Query("SELECT c.brand FROM Car c")
    List<String> FindBrands();

    @Query("SELECT c.vehicleType FROM Car c")
    List<String> FindVehicleTypes();

    @Query("SELECT c.year FROM Car c")
    List<String> FindYears();
}
