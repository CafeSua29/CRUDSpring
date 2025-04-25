package com.example.demo.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProjectException extends RuntimeException {
    private int code;
    private String message;
}
