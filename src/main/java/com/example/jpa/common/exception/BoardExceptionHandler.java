package com.example.jpa.common.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BoardExceptionHandler {

    @ExceptionHandler(value = BoardException.class)
    public ResponseEntity<Map<String, Object>> ExceptionHandler(BoardException e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        Map<String, Object> result = new HashMap<>();
        result.put("error type", e.getHttpStatusType());
        result.put("error code", e.getHttpStatusCode());
        result.put("message", e.getMessage());
        return new ResponseEntity<>(result, responseHeaders, e.getHttpStatus());
    }
}