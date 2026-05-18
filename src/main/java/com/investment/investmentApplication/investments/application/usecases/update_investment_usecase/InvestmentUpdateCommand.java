package com.investment.investmentApplication.investments.application.usecases.update_investment_usecase;

import com.investment.investmentApplication.investments.application.dto.InvestmentUpdate;
import com.investment.investmentApplication.investments.domain.investment.InvestmentId;

import java.time.LocalDate;

public record InvestmentUpdateCommand(

        InvestmentId id,

        String name,

        String type,

        LocalDate date,

        Double value
) {

    public static InvestmentUpdateCommand convert(InvestmentId anInvestmentId, InvestmentUpdate anInvestment) {
        return new InvestmentUpdateCommand(
                anInvestmentId,
                anInvestment.name(),
                anInvestment.type(),
                anInvestment.investmentDate(),
                anInvestment.value()
        );
    }
}
