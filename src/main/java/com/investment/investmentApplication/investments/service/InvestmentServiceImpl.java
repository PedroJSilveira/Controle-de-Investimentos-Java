package com.investment.investmentApplication.investments.service;

import com.investment.investmentApplication.application.controls.exceptions.ExceptionHandler;
import com.investment.investmentApplication.investments.controls.InvestmentRepository;
import com.investment.investmentApplication.investments.controls.exceptions.InvestmentException.InvestmentNotFoundException;
import com.investment.investmentApplication.investments.entities.dtos.Investment;
import com.investment.investmentApplication.investments.entities.schemas.InvestmentSchema;
import com.investment.investmentApplication.investments.service.interfaces.InvestmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * The Class InvestmentService
 *
 * @author Pedro Junho Silveira
 * @since 29/10/2025
 */

@Component
@RequiredArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {

    private static final Logger log = LoggerFactory.getLogger(InvestmentServiceImpl.class);

    private final InvestmentRepository investmentRepository;

    @Override
    public InvestmentSchema create(Investment investmentCreate) {
        try {
            InvestmentSchema investmentSchema = InvestmentSchema.generate(investmentCreate);

            return investmentRepository.save(investmentSchema);

        } catch (Exception ex) {
            log.error("Investment create failed: {}", ex.getMessage());
            throw new ExceptionHandler("Investment create failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<InvestmentSchema> findAll() {
        try {
            return investmentRepository.findAll();
        } catch (Exception ex) {
            log.error("Find all investment failed: {}", ex.getMessage());
            throw new ExceptionHandler("Find all investment failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public InvestmentSchema findById(UUID id) {
        try {
            return investmentRepository.findById(id).orElseThrow();
        }catch (Exception ex) {
            log.error("Find investment by id failed: {}", ex.getMessage());
            throw new ExceptionHandler("Find investment by id failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public InvestmentSchema update(UUID id, Investment investmentUpdate) {
        try {
            InvestmentSchema investment = investmentRepository.findById(id).orElseThrow(InvestmentNotFoundException::new);

            investment.update(investmentUpdate);

            return investmentRepository.save(investment);
        }catch (Exception ex) {
            log.error("Investment update failed: {}", ex.getMessage());
            throw new ExceptionHandler("Investment update failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            InvestmentSchema investment = investmentRepository.findById(id).orElseThrow(InvestmentNotFoundException::new);

            investment.disable();

            investmentRepository.save(investment);
        }catch (Exception ex) {
            log.error("Investment delete failed: {}", ex.getMessage());
            throw new ExceptionHandler("Investment delete failed.", HttpStatus.BAD_REQUEST);
        }
    }
}
