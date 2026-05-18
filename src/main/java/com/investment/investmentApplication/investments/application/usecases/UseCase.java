package com.investment.investmentApplication.investments.application.usecases;

/**
 * The Class UseCase
 *
 * @author Pedro Junho Silveira
 * @since 02/05/2026
 */
public interface UseCase<IN, OUT> {

    OUT execute(IN input);

}
