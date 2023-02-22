package com.example.jpa.common.exception;

import com.example.jpa.common.exception.BoardException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice  // 모든 @Controller or @RestController 즉 전역에서 발생할 수 있는 예외를 잡아 처리해주는 어노테이션
public class BoardExceptionHandler {

    @ExceptionHandler(value = BoardException.class)
    //지정한 예외 클래스르 받아서 해당 클래스 발생 시 특정 메서드를 실행해주는 어노테이션
    //@Controller, @RestController가 적용된 Bean내에서 발생하는 예외를 잡아서 하나의 메서드에서 처리해주는 기능
    public ResponseEntity<Map<String, Object>> ExceptionHandler(BoardException e) {
        HttpHeaders responseHeaders = new HttpHeaders();

        Map<String, Object> result = new HashMap<>();
        result.put("error type", e.getHttpStatusType());
        result.put("error code", e.getHttpStatusCode());
        result.put("message", e.getMessage());

        return new ResponseEntity<>(result, responseHeaders, e.getHttpStatus());
    }
}