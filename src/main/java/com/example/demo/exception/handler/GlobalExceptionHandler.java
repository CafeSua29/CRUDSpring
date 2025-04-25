package com.example.demo.exception.handler;

import com.example.demo.exception.custom.ProjectException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProjectException.class)
    public ResponseEntity<String> handleExceptionA(ProjectException pe) {
        return ResponseEntity.status(404).body(pe.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        e.printStackTrace();

        return ResponseEntity.status(500).body("Unknow error");
    }
}

