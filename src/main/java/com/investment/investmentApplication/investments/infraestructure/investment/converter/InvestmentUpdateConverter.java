package com.investment.investmentApplication.investments.infraestructure.investment.converter;

import com.investment.investmentApplication.investments.application.dto.InvestmentUpdate;
import com.investment.investmentApplication.investments.application.usecases.update_investment_usecase.InvestmentUpdateCommand;
import com.investment.investmentApplication.investments.domain.investment.InvestmentId;

import java.util.UUID;

public class InvestmentUpdateConverter {

    public InvestmentUpdateConverter() {}

    public static InvestmentUpdateCommand convert(UUID anInvestmentId, InvestmentUpdate anInvestmentUpdate) {
        return InvestmentUpdateCommand.convert(
                InvestmentId.from(anInvestmentId),
                anInvestmentUpdate
        );
    }
}
