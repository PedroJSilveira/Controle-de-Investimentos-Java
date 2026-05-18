package com.investment.investmentApplication.investments.infraestructure.investment.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * The Class InvestmentRepository
 *
 * @author Pedro Junho Silveira
 * @since 29/10/2025
 */


public interface InvestmentPostgresRepository extends JpaRepository<InvestmentPostgresEntity, UUID> {

    @Override
    @Query("""
          SELECT i FROM Investment i
          WHERE i.id = :id
          AND i.disabled = FALSE
    """)
    Optional<InvestmentPostgresEntity> findById(@Param("id") UUID id);

    @Override
    @Query("""
          SELECT i FROM Investment i
          WHERE i.disabled = FALSE
    """)
    List<InvestmentPostgresEntity> findAll();
}
