package com.investment.investmentApplication.investments.service;

import com.investment.investmentApplication.investments.entities.dtos.Investment;
import com.investment.investmentApplication.investments.entities.schemas.InvestmentSchema;
import com.investment.investmentApplication.investments.repository.InvestmentRepository;
import com.investment.investmentApplication.investments.service.interfaces.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

/**
 * The Class InvestmentService
 *
 * @author Pedro Junho Silveira
 * @since 29/10/2025
 */

@Component
@RequiredArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Override
    public InvestmentSchema create(Investment investmentCreate) {
        try {
            InvestmentSchema investmentSchema = InvestmentSchema.generate(investmentCreate);

            return investmentRepository.save(investmentSchema);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<InvestmentSchema> findAll() {
        try {
            return investmentRepository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public InvestmentSchema findById(UUID id) {
        try {
            return investmentRepository.findById(id).orElseThrow();
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public InvestmentSchema update(UUID id, Investment investmentUpdate) {
        try {
            InvestmentSchema investment = investmentRepository.findById(id).orElseThrow();

            investment.update(investmentUpdate);

            return investmentRepository.save(investment);
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            InvestmentSchema investment = investmentRepository.findById(id).orElseThrow();

            investment.disable();

            investmentRepository.save(investment);
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
