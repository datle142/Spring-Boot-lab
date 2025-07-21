package com.example.identity_server.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =Exception.class)
    ResponseEntity<String> handlingRuntimeException(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
