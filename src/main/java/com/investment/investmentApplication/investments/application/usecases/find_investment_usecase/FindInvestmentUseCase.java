package com.investment.investmentApplication.investments.application.usecases.find_investment_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.domain.InvestmentGateway;
import com.investment.investmentApplication.investments.domain.InvestmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindInvestmentUseCase implements UseCase<InvestmentId, Investment> {

    private final InvestmentGateway investmentGateway;

    @Override
    public Investment execute(InvestmentId anInput) {
        return investmentGateway.findById(anInput);
    }

}
