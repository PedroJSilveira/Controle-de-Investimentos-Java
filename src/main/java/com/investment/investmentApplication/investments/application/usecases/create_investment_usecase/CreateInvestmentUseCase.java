package com.investment.investmentApplication.investments.application.usecases.create_investment_usecase;

import com.investment.investmentApplication.investments.application.dto.InvestmentCreate;
import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.domain.InvestmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * The Class CreateInvestmentUseCase
 *
 * @author Pedro Junho Silveira
 * @since 02/05/2026
 */

@Component
@RequiredArgsConstructor
public class CreateInvestmentUseCase implements UseCase<InvestmentCreate, Investment> {

    private final InvestmentGateway investmentGateway;

    @Override
    public Investment execute(InvestmentCreate anInvestmentCreate) {

        Investment investment = Investment.generate(anInvestmentCreate);

        return investmentGateway.save(investment);
    }

}
