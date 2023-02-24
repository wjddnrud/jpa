package com.example.jpa.common;

public class Constants {

    public enum ExceptionClass {

        BOARD("Board");

        private final String exceptionClass;

        ExceptionClass(String exceptionClass) { this.exceptionClass = exceptionClass;}

        public String getExceptionClass()  {return exceptionClass;}

        @Override
        public String toString() {
            return getExceptionClass() + " Exception : ";
        }
    }
}