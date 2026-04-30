package com.investment.investmentApplication.investments.infraestructure.intvestment.persistence;

import com.investment.investmentApplication.investments.infraestructure.shared.persistence.BasePostgresEntity;
import com.investment.investmentApplication.investments.domain.investment.Investment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * The Class InvestmentSchema
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@Entity(name = "Investment")
@Table(name = "tb_investment")
public class InvestmentPostgresEntity extends BasePostgresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "investment_date")
    private LocalDate investmentDate;

    @Column(name = "value")
    private Double value;

    public InvestmentPostgresEntity() {
    }

    private InvestmentPostgresEntity(String name, String type, LocalDate investmentDate, Double value) {
        this.name = name;
        this.type = type;
        this.investmentDate = investmentDate;
        this.value = value;
    }

    public static InvestmentPostgresEntity generate(Investment investment){
        return new InvestmentPostgresEntity(
                investment.name(),
                investment.type(),
                investment.investmentDate(),
                investment.value()
        );
    }

    public void update(Investment investment) {
        if (investment.name() != null && !investment.name().isEmpty()) this.name = investment.name();
        if (investment.type() != null && !investment.type().isEmpty()) this.type = investment.type();
        if (investment.investmentDate() != null) this.investmentDate = investment.investmentDate();
        if (investment.value() != null) this.value = investment.value();
        this.setUpdatedDate(LocalDateTime.now());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(LocalDate investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvestmentPostgresEntity that = (InvestmentPostgresEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(investmentDate, that.investmentDate) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, investmentDate, value);
    }
}
