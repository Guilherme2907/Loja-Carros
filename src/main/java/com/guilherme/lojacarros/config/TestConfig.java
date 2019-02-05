/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.config;

import com.guilherme.lojacarros.service.DBService;
import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author Guilherme
 */
@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dBService;

    @Bean
    public void inicializeDB() throws ParseException {
        dBService.initializeTestDataBase();
    }
}
