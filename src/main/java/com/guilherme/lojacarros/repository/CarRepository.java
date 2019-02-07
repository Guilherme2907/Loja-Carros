/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.repository;

import com.guilherme.lojacarros.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Guilherme
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findByBrand(String brand,Pageable pageable);
}
