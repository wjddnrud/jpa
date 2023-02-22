package com.example.jpa.common.exception;

import com.example.jpa.common.Constants;
import org.springframework.http.HttpStatus;

public class BoardException extends Exception{
    //기존에 만들어져있는 예외들에 상속시켜서 사용

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public BoardException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

//    public Constants.ExceptionClass getExceptionClass {
//        return exceptionClass;
//    }

    public int getHttpStatusCode() {return  httpStatus.value();}

    public String getHttpStatusType() {return httpStatus.getReasonPhrase();}

    public HttpStatus getHttpStatus() {return httpStatus;}

}