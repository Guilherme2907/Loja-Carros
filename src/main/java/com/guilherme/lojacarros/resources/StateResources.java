/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.resources;

import com.guilherme.lojacarros.domain.City;
import com.guilherme.lojacarros.domain.State;
import com.guilherme.lojacarros.service.StateService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Guilherme
 */
@RestController
@RequestMapping("/states")
public class StateResources {

    @Autowired
    private StateService stateService;

    @GetMapping
    public ResponseEntity<List<State>> findAll() {
        List<State> states = stateService.findAll();
        return ResponseEntity.ok(states);
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        State state = stateService.findById(id);
        return ResponseEntity.ok(state);
    }

    @GetMapping("/{id}/cities")
    public ResponseEntity<List<City>> findCitiesByState(@PathVariable Long id) {
        List<City> cities = stateService.findCities(id);
        return ResponseEntity.ok(cities);
    }
}
