package com.investment.investmentApplication.investments.controls.exceptions;

import com.investment.investmentApplication.application.controls.exceptions.ExceptionHandler;
import org.springframework.http.HttpStatus;

/**
 * The Class InvestmentException
 *
 * @author Pedro Junho Silveira
 * @since 31/10/2025
 */
public class InvestmentException {

    public static class InvestmentNotFoundException extends ExceptionHandler {
        public InvestmentNotFoundException() {
            super("Investment not found", HttpStatus.NOT_FOUND);
        }
    }

}
