package com.investment.investmentApplication.investments.repository;

import com.investment.investmentApplication.investments.entities.schemas.InvestmentSchema;
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
public interface InvestmentRepository extends JpaRepository<InvestmentSchema, UUID> {

    @Override
    @Query("""
          SELECT i FROM InvestmentSchema i
          WHERE i.id = :id
          AND i.disabled = FALSE
    """)
    Optional<InvestmentSchema> findById(@Param("id") UUID id);

    @Override
    @Query("""
          SELECT i FROM InvestmentSchema i
          WHERE i.disabled = FALSE 
    """)
    List<InvestmentSchema> findAll();
}
