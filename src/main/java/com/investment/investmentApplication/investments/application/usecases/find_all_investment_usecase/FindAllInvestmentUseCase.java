package com.investment.investmentApplication.investments.application.usecases.find_all_investment_usecase;

import com.investment.investmentApplication.shared.application.usecases.UnitUseCase;
import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.domain.InvestmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindAllInvestmentUseCase implements UnitUseCase {

    private final InvestmentGateway investmentGateway;

    @Override
    public List<Investment> execute() {
        return investmentGateway.findAll();
    }

}
