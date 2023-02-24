package com.example.jpa.common.exception;

import com.example.jpa.common.Constants;
import org.springframework.http.HttpStatus;

public class BoardException extends Exception{

    private final HttpStatus httpStatus;

    public BoardException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatusCode() {return  httpStatus.value();}

    public String getHttpStatusType() {return httpStatus.getReasonPhrase();}

    public HttpStatus getHttpStatus() {return httpStatus;}

}