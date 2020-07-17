package com.example.feign.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpStatusCodeException;

@ControllerAdvice
public class FeignExceptionHandler {
    @ResponseBody
    @ExceptionHandler(HttpStatusCodeException.class)
    public ResponseEntity<Void> handleHttpStatusException(HttpStatusCodeException e) {
        return ResponseEntity.status(e.getStatusCode()).build();
    }
}
