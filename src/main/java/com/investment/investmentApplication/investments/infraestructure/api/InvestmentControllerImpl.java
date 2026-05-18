package com.investment.investmentApplication.investments.infraestructure.api;

import com.investment.investmentApplication.investments.application.dto.InvestmentUpdate;
import com.investment.investmentApplication.investments.application.usecases.update_investment_usecase.UpdateInvestmentUseCase;
import com.investment.investmentApplication.investments.application.usecases.delete_investment_usecase.DeleteInvestmentUseCase;
import com.investment.investmentApplication.investments.application.dto.InvestmentCreate;
import com.investment.investmentApplication.investments.application.usecases.create_investment_usecase.CreateInvestmentUseCase;
import com.investment.investmentApplication.investments.application.usecases.find_all_investment_usecase.FindAllInvestmentUseCase;
import com.investment.investmentApplication.investments.application.usecases.find_investment_usecase.FindInvestmentUseCase;
import com.investment.investmentApplication.investments.domain.investment.Investment;
import com.investment.investmentApplication.investments.domain.investment.InvestmentId;
import com.investment.investmentApplication.investments.infraestructure.api.interfaces.InvestmentController;
import com.investment.investmentApplication.investments.infraestructure.investment.converter.InvestmentUpdateConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * The Class InvestmentControllerImpl
 *
 * @author Pedro Junho Silveira
 * @since 29/10/2025
 */

@RestController
@RequiredArgsConstructor
public class InvestmentControllerImpl implements InvestmentController {

    private final CreateInvestmentUseCase createInvestment;

    private final FindAllInvestmentUseCase findAllInvestment;

    private final FindInvestmentUseCase findInvestmentUseCase;

    private final UpdateInvestmentUseCase updateInvestmentUseCase;

    private final DeleteInvestmentUseCase deleteInvestmentUseCase;

    @Override
    public ResponseEntity<Investment> create(InvestmentCreate anInvestmentCreate) {
        final var investment = createInvestment.execute(anInvestmentCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(investment);
    }

    @Override
    public ResponseEntity<List<Investment>> findAll() {
        final var investments = findAllInvestment.execute();

        return ResponseEntity.status(HttpStatus.OK).body(investments);
    }

    @Override
    public ResponseEntity<Investment> findById(UUID anInvestmentId) {
        final var investment = findInvestmentUseCase.execute(InvestmentId.from(anInvestmentId));

        return ResponseEntity.status(HttpStatus.OK).body(investment);
    }

    @Override
    public ResponseEntity<Investment> update(UUID anInvestmentId, InvestmentUpdate anInvestmentUpdate) {
        final var investment = updateInvestmentUseCase.execute(InvestmentUpdateConverter.convert(anInvestmentId, anInvestmentUpdate));
        return ResponseEntity.status(HttpStatus.OK).body(investment);
    }

    @Override
    public ResponseEntity<Void> delete(UUID anInvestmentId) {
        deleteInvestmentUseCase.execute(InvestmentId.from(anInvestmentId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
