package com.investment.investmentApplication.application.controls.exceptions;

import org.springframework.http.HttpStatus;

/**
 * The Class ExceptionHandler
 *
 * @author Pedro Junho Silveira
 * @since 30/10/2025
 */


public class ExceptionHandler extends RuntimeException{

    String message;

    HttpStatus status;

    public ExceptionHandler(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
