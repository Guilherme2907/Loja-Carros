/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.repository;

import com.guilherme.lojacarros.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Guilherme
 */
public interface CityRepository extends JpaRepository<City, Long>{
    
}
