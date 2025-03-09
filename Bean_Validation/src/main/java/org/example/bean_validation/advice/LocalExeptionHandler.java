package org.example.bean_validation.advice;

import org.example.bean_validation.Dro.ResponceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class LocalExeptionHandler {
    public ResponseEntity<ResponceDto> handleException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ResponceDto responceDto = new ResponceDto(401, e.getMessage(), errors);
        return new ResponseEntity<>(responceDto, HttpStatus.BAD_REQUEST);
    }
}
