/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guilherme.lojacarros.resources.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guilherme
 */
public class ValidationErrorMessage extends StandartErrorMessage {

    private List<FieldError> errors = new ArrayList();

    public ValidationErrorMessage(Long timeStamp, Integer status, String error, String message, String path) {
        super(timeStamp, status, error, message, path);
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(String field, String message) {
        this.errors.add(new FieldError(field, message));
    }
}
