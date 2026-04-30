package com.investment.investmentApplication.investments.application.service;

import com.investment.investmentApplication.investments.domain.exception.BusinessException;
import com.investment.investmentApplication.investments.domain.investment.exception.InvestmentException;
import com.investment.investmentApplication.investments.domain.investment.exception.InvestmentException.InvestmentNotFoundException;
import com.investment.investmentApplication.investments.infraestructure.intvestment.persistence.InvestmentPostgresRepository;
import com.investment.investmentApplication.investments.domain.investment.Investment;
import com.investment.investmentApplication.investments.infraestructure.intvestment.persistence.InvestmentPostgresEntity;
import com.investment.investmentApplication.investments.application.service.interfaces.InvestmentService;
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

    private final InvestmentPostgresRepository investmentRepository;

    @Override
    public InvestmentPostgresEntity create(Investment investmentCreate) {
        try {
            InvestmentPostgresEntity investmentSchema = InvestmentPostgresEntity.generate(investmentCreate);

            return investmentRepository.save(investmentSchema);

        } catch (Exception ex) {
            log.error("Investment create failed: {}", ex.getMessage());
            throw new BusinessException("Investment create failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<InvestmentPostgresEntity> findAll() {
        try {
            return investmentRepository.findAll();
        } catch (Exception ex) {
            log.error("Find all investment failed: {}", ex.getMessage());
            throw new BusinessException("Find all investment failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public InvestmentPostgresEntity findById(UUID id) {
        try {
            return investmentRepository.findById(id).orElseThrow();
        }catch (Exception ex) {
            log.error("Find investment by id failed: {}", ex.getMessage());
            throw new BusinessException("Find investment by id failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public InvestmentPostgresEntity update(UUID id, Investment investmentUpdate) {
        try {
            InvestmentPostgresEntity investment = investmentRepository.findById(id).orElseThrow(InvestmentNotFoundException::new);

            investment.update(investmentUpdate);

            return investmentRepository.save(investment);
        }catch (Exception ex) {
            log.error("Investment update failed: {}", ex.getMessage());
            throw new BusinessException("Investment update failed.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void delete(UUID id) {
        try {
            InvestmentPostgresEntity investment = investmentRepository.findById(id).orElseThrow(InvestmentNotFoundException::new);

            investment.disable();

            investmentRepository.save(investment);
        }catch (Exception ex) {
            log.error("Investment delete failed: {}", ex.getMessage());
            throw new BusinessException("Investment delete failed.", HttpStatus.BAD_REQUEST);
        }
    }
}
