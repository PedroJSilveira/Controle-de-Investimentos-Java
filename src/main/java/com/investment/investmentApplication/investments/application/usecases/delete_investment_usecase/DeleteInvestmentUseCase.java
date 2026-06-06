package com.investment.investmentApplication.investments.application.usecases.delete_investment_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.domain.InvestmentGateway;
import com.investment.investmentApplication.investments.domain.InvestmentId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteInvestmentUseCase implements UseCase<InvestmentId, Investment> {

    private final InvestmentGateway investmentGateway;

    @Override
    public Investment execute(InvestmentId anInvestmentId) {
        final var entity = investmentGateway.findById(anInvestmentId);
        entity.disable();
        return investmentGateway.save(entity);
    }
}
