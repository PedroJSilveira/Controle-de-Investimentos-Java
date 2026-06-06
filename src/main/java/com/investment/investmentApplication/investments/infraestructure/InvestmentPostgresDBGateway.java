package com.investment.investmentApplication.investments.infraestructure;

import com.investment.investmentApplication.investments.domain.Investment;
import com.investment.investmentApplication.investments.domain.InvestmentGateway;
import com.investment.investmentApplication.investments.domain.InvestmentId;
import com.investment.investmentApplication.investments.domain.exception.InvestmentException.InvestmentNotFoundException;
import com.investment.investmentApplication.investments.infraestructure.persistence.InvestmentPostgresEntity;
import com.investment.investmentApplication.investments.infraestructure.persistence.InvestmentPostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class InvestmentPostgresDBGateway
 *
 * @author Pedro Junho Silveira
 * @since 30/04/2026
 */

@Repository
@RequiredArgsConstructor
public class InvestmentPostgresDBGateway implements InvestmentGateway {

    private final InvestmentPostgresRepository repository;

    @Override
    public Investment save(Investment anInvestment) {
        final var entity = InvestmentPostgresEntity.from(anInvestment);
        return repository.save(entity).toDomain();
    }

    @Override
    public List<Investment> findAll() {
        final var entities = repository.findAll();
        return entities.stream().map(InvestmentPostgresEntity::toDomain).toList();
    }

    @Override
    public Investment findById(InvestmentId anInvestmentId) {
        final var entity = repository.findById(anInvestmentId.getValue()).orElseThrow(InvestmentNotFoundException::new);
        return entity.toDomain();
    }

}
