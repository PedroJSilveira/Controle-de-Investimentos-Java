package com.investment.investmentApplication.shared.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * The Class BusinessException
 *
 * @author Pedro Junho Silveira
 * @since 30/04/2026
 */

public class BusinessException extends  RuntimeException{
    String message;

    HttpStatus status;

    public BusinessException(String message, HttpStatus status){
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
