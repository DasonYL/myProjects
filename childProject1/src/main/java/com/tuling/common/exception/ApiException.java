package com.tuling.common.exception;


public class ApiException extends RuntimeException {

    public ApiException(){
        super();
    }

    public ApiException(String message){
        super(message);
    }

    public ApiException(String message, Throwable throwable){
        super(message, throwable);
    }

    public ApiException(Throwable throwable){
        super(throwable);
    }
}
