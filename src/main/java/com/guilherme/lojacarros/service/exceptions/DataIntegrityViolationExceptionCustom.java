/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.service.exceptions;

/**
 *
 * @author Guilherme
 */
public class DataIntegrityViolationExceptionCustom extends RuntimeException {

    public DataIntegrityViolationExceptionCustom(String message) {
        super(message);
    }

    public DataIntegrityViolationExceptionCustom(String message, Throwable cause) {
        super(message, cause);
    }
}
