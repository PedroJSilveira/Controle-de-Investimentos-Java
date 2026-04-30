package com.investment.investmentApplication.investments.infraestructure.api;

import com.investment.investmentApplication.investments.infraestructure.api.interfaces.InvestmentController;
import com.investment.investmentApplication.investments.domain.investment.Investment;
import com.investment.investmentApplication.investments.infraestructure.intvestment.persistence.InvestmentPostgresEntity;
import com.investment.investmentApplication.investments.application.service.InvestmentServiceImpl;
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

    private final InvestmentServiceImpl investmentService;

    @Override
    public ResponseEntity<InvestmentPostgresEntity> create(Investment investmentCreate) {
        InvestmentPostgresEntity investment = investmentService.create(investmentCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(investment);
    }

    @Override
    public ResponseEntity<List<InvestmentPostgresEntity>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(investmentService.findAll());
    }

    @Override
    public ResponseEntity<InvestmentPostgresEntity> findById(UUID id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(investmentService.findById(id));
    }

    @Override
    public ResponseEntity<InvestmentPostgresEntity> update(UUID id, Investment investmentUpdate) {
        InvestmentPostgresEntity investmentSaved = investmentService.update(id, investmentUpdate);
        return ResponseEntity.status(HttpStatus.OK).body(investmentSaved);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        investmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
