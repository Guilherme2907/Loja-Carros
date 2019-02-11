package com.guilherme.lojacarros.resources.exceptionHandler;

import com.guilherme.lojacarros.service.exceptions.DataIntegrityViolationExceptionCustom;
import com.guilherme.lojacarros.service.exceptions.ObjectNotFoundExceptionCustom;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
                "Not Found", e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(sem);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorMessage> getMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest req) {
        ValidationErrorMessage vem = new ValidationErrorMessage(System.currentTimeMillis(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(), "Unprocessable Entity", "Erro de validação", req.getRequestURI());

        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            vem.setErrors(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(vem);

    }

    @ExceptionHandler(DataIntegrityViolationExceptionCustom.class)
    public ResponseEntity<StandartErrorMessage> getDataIntegrityViolationExceptionCustom(DataIntegrityViolationExceptionCustom e, HttpServletRequest req) {
        StandartErrorMessage sem = new StandartErrorMessage(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Erro de integridade de dados", e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sem);
    }
}
