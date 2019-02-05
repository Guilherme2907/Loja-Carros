package com.guilherme.lojacarros.resources.exceptionHandler;

import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author Guilherme
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundExceptionCustom.class)
    public ResponseEntity<StandartErrorMessage> getObjectNotFoundExceptionCustom(ObjectNotFoundExceptionCustom e, HttpServletRequest req) {
        StandartErrorMessage sem = new StandartErrorMessage(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "Não encontrado", e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sem);
    }
}
