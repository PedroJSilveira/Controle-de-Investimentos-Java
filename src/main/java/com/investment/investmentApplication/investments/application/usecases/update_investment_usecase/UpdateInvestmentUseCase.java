package com.investment.investmentApplication.investments.application.usecases.update_investment_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.domain.InvestmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateInvestmentUseCase implements UseCase<InvestmentUpdateCommand, Investment> {

    private final InvestmentGateway investmentGateway;

    @Override
    public Investment execute(InvestmentUpdateCommand anInput) {
        final var entity = investmentGateway.findById(anInput.id());
        final var entityTosave = entity.update(anInput);
        return investmentGateway.save(entityTosave);
    }

}
