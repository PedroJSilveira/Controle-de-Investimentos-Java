package com.investment.investmentApplication.investments.service.interfaces;

import com.investment.investmentApplication.investments.entities.dtos.Investment;
import com.investment.investmentApplication.investments.entities.schemas.InvestmentSchema;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * The Class InvestmentService
 *
 * @author Pedro Junho Silveira
 * @since 29/10/2025
 */
public interface InvestmentService {

    @Transactional(rollbackFor = Exception.class)
    InvestmentSchema create(Investment investmentCreate);

    List<InvestmentSchema> findAll();

    InvestmentSchema findById(UUID id);

    @Transactional(rollbackFor = Exception.class)
    InvestmentSchema update(UUID id, Investment investmentUpdate);

    @Transactional(rollbackFor = Exception.class)
    void delete(UUID id);
}
