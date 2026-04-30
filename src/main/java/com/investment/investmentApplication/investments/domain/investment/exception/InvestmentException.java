package com.investment.investmentApplication.investments.domain.investment.exception;

import com.investment.investmentApplication.investments.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

/**
 * The Class InvestmentException
 *
 * @author Pedro Junho Silveira
 * @since 31/10/2025
 */
public class InvestmentException {

    public static class InvestmentNotFoundException extends BusinessException {
        public InvestmentNotFoundException() {
            super("Investment not found", HttpStatus.NOT_FOUND);
        }
    }

}
