package com.investment.investmentApplication.investments.domain.investment;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The Class InvestmentGateway
 *
 * @author Pedro Junho Silveira
 * @since 03/05/2026
 */

@Component
public interface InvestmentGateway {

    Investment save(Investment investment);

    List<Investment> findAll();

    Investment findById(InvestmentId investmentId);
}
