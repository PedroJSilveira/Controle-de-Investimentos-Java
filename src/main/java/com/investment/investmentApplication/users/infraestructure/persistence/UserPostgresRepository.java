package com.investment.investmentApplication.users.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UserPostgresRepository extends JpaRepository<UserPostgresEntity, UUID> {


    @Override
    @Query("""
        SELECT u FROM User u
        WHERE u.id = :id
        AND u.disabled = FALSE
    """)
    Optional<UserPostgresEntity> findById(@Param("id") UUID id);
}
