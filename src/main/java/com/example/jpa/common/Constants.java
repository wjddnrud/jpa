package com.example.jpa.common;

public class Constants {

    public enum ExceptionClass {

//        예외를 캐치할 각 클래스들을 상단에 선언해준다.
        
        BOARD("Board");

        private String exceptionClass;

        ExceptionClass(String exceptionClass) { this.exceptionClass = exceptionClass;}

        public String getExceptionClass()  {return exceptionClass;}

        @Override
        public String toString() {
            return getExceptionClass() + " Exception : ";
        }
    }
}