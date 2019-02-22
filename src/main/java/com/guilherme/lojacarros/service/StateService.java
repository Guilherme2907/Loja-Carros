/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service;

import com.guilherme.lojacarros.domain.City;
import com.guilherme.lojacarros.domain.State;
import com.guilherme.lojacarros.repository.CityRepository;
import com.guilherme.lojacarros.repository.StateRepository;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Guilherme
 */
@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    public State findById(Long id) {
        return stateRepository.findById(id).orElseThrow(() -> new ObjectNotFoundExceptionCustom("Estado não encontrado"));
    }

    public List<State> findAll() {
        return stateRepository.findAll();
    }

    public List<City> findCities(Long id) {
        State state = findById(id);
        return cityRepository.findByState(state).orElseThrow(() -> new ObjectNotFoundExceptionCustom("Cidades não encontradas para esse estado"));
    }
}
