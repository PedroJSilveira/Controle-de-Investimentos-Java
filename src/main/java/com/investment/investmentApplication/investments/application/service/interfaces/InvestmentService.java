package com.investment.investmentApplication.investments.application.service.interfaces;

import com.investment.investmentApplication.investments.domain.investment.Investment;
import com.investment.investmentApplication.investments.infraestructure.intvestment.persistence.InvestmentPostgresEntity;
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
    InvestmentPostgresEntity create(Investment investmentCreate);

    List<InvestmentPostgresEntity> findAll();

    InvestmentPostgresEntity findById(UUID id);

    @Transactional(rollbackFor = Exception.class)
    InvestmentPostgresEntity update(UUID id, Investment investmentUpdate);

    @Transactional(rollbackFor = Exception.class)
    void delete(UUID id);
}
